package com.bunjlabs.jecue.entities;

import java.util.HashMap;
import java.util.Map;

public class CueTrackInfo extends CueBaseInfo {

    private int number;
    private String fileName;
    private String fileType;
    private Map<Integer, CueTrackIndex> indexes;

    public CueTrackInfo() {
        super();
        this.indexes = new HashMap<>();
    }

    public CueTrackInfo(int number, String fileName, String fileType, Map<Integer, CueTrackIndex> indexes, String title, String performer, String songwriter) {
        super(title, performer, songwriter);
        this.number = number;
        this.fileName = fileName;
        this.fileType = fileType;
        this.indexes = indexes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public Map<Integer, CueTrackIndex> getIndexes() {
        return indexes;
    }

    public void setIndexes(Map<Integer, CueTrackIndex> indexes) {
        this.indexes = indexes;
    }

}
