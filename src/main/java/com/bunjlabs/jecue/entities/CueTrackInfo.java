package com.bunjlabs.jecue.entities;

import java.util.HashMap;
import java.util.Map;

public class CueTrackInfo extends CueBaseInfo {

    private int number;
    private Map<Integer, CueTrackIndex> indexes;

    public CueTrackInfo() {
        super();
        this.indexes = new HashMap<>();
    }

    public CueTrackInfo(int number, String fileName, String fileType, Map<Integer, CueTrackIndex> indexes, String title, String performer, String songwriter) {
        super(title, performer, songwriter);
        this.number = number;
        this.indexes = indexes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Map<Integer, CueTrackIndex> getIndexes() {
        return indexes;
    }

    public void setIndexes(Map<Integer, CueTrackIndex> indexes) {
        this.indexes = indexes;
    }

}
