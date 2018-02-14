package com.bunjlabs.jecue.entities;

import java.util.ArrayList;
import java.util.List;

public class CueFileInfo {

    private String fileName;
    private String fileType;

    private List<CueTrackInfo> tracks;

    public CueFileInfo() {
        this.tracks = new ArrayList<>();
    }

    public CueFileInfo(String fileName, String fileType, List<CueTrackInfo> tracks) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.tracks = tracks;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public List<CueTrackInfo> getTracks() {
        return tracks;
    }

    public void setTracks(List<CueTrackInfo> tracks) {
        this.tracks = tracks;
    }

}
