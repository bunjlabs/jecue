package com.bunjlabs.jecue;

import com.bunjlabs.jecue.entities.CueFileInfo;
import com.bunjlabs.jecue.entities.CueSheet;
import com.bunjlabs.jecue.entities.CueTrackIndex;
import com.bunjlabs.jecue.entities.CueTrackInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CueLoader {

    private static enum CommandType {
        TITLE, PERFORMER, FILE, TRACK, INDEX, PREGAP, POSTGAP, SONGWRITER, CATALOG, ISRC, FLAGS, REM, CDTEXTFILE
    }

    private static class Command {

        private CommandType type;
        private String[] args;

        public Command(CommandType type, String[] args) {
            this.type = type;
            this.args = args;
        }
    }

    private final CueSheet cueSheet = new CueSheet();
    private final Reader reader;

    private CueFileInfo currentFileInfo = null;
    private CueTrackInfo currentTrackInfo = null;

    public CueLoader(String input) {
        this.reader = new StringReader(input);
    }

    public CueLoader(InputStream is) {
        this.reader = new InputStreamReader(is);
    }

    public CueLoader(File file) throws FileNotFoundException {
        this.reader = new FileReader(file);
    }

    public CueSheet load() {
        try (BufferedReader br = new BufferedReader(reader)) {

            for (String line; (line = br.readLine()) != null;) {
                line = line.trim();

                if (line.isEmpty()) continue;

                Command command = parseCommand(line);

                if (command == null) continue;

                processCommand(command);
            }
        } catch (IOException ex) {
        }

        return cueSheet;
    }

    private void processCommand(Command command) {
        switch (command.type) {
            case TITLE: {
                if (currentTrackInfo == null) {
                    cueSheet.getDiskInfo().setTitle(command.args[0]);
                } else {
                    currentTrackInfo.setTitle(command.args[0]);
                }
                break;
            }
            case PERFORMER: {
                if (currentTrackInfo == null) {
                    cueSheet.getDiskInfo().setPerformer(command.args[0]);
                } else {
                    currentTrackInfo.setPerformer(command.args[0]);
                }
                break;
            }
            case SONGWRITER: {
                if (currentTrackInfo == null) {
                    cueSheet.getDiskInfo().setSongwriter(command.args[0]);
                } else {
                    currentTrackInfo.setSongwriter(command.args[0]);
                }
                break;
            }
            case CATALOG: {
                cueSheet.getDiskInfo().setCatalog(command.args[0]);
                break;
            }
            case ISRC: {
                cueSheet.getDiskInfo().setIsrc(command.args[0]);
                break;
            }
            case REM: {
                cueSheet.getDiskInfo().getRemarks().put(command.args[0], command.args[1]);
                break;
            }
            case FILE: {
                currentFileInfo = new CueFileInfo();
                currentFileInfo.setFileName(command.args[0]);
                currentFileInfo.setFileType(command.args[1]);

                cueSheet.getFiles().add(currentFileInfo);
                break;
            }
            case TRACK: {
                if (currentFileInfo == null || currentFileInfo == null) break;

                currentTrackInfo = new CueTrackInfo();
                currentTrackInfo.setNumber(Integer.parseInt(command.args[0]));

                currentFileInfo.getTracks().add(currentTrackInfo);
                break;
            }
            case INDEX: {
                if (currentTrackInfo == null || currentFileInfo == null) break;
                currentTrackInfo.getIndexes().put(Integer.parseInt(command.args[0]), parseIndex(command.args[1]));
                break;
            }
            case POSTGAP:
            case PREGAP:
            case FLAGS:
                break;
            default:
                break;
        }
    }

    private Command parseCommand(String input) {
        for (CommandType type : CommandType.values()) {
            if (input.startsWith(type.name())) {
                List<String> list = new ArrayList<String>();

                Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(input.substring(type.name().length() + 1));

                while (m.find()) list.add(m.group(1).replace("\"", ""));

                Command command = new Command(type, list.toArray(new String[list.size()]));

                return command;
            }
        }

        return null;
    }

    private CueTrackIndex parseIndex(String index) {
        String[] split = index.split(":");

        if (split.length < 3) return null;

        return new CueTrackIndex(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1]),
                Integer.parseInt(split[2])
        );
    }

}
