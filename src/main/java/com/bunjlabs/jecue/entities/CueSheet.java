package com.bunjlabs.jecue.entities;

import java.util.LinkedList;
import java.util.List;

public class CueSheet {

    private CueDiskInfo diskInfo;
    private List<CueTrackInfo> tracks;

    public CueSheet() {
        this.diskInfo = new CueDiskInfo();
        this.tracks = new LinkedList<>();
    }

    public CueSheet(CueDiskInfo diskInfo, List<CueTrackInfo> tracks) {
        this.diskInfo = diskInfo;
        this.tracks = tracks;
    }

    public CueDiskInfo getDiskInfo() {
        return diskInfo;
    }

    public void setDiskInfo(CueDiskInfo diskInfo) {
        this.diskInfo = diskInfo;
    }

    public List<CueTrackInfo> getTracks() {
        return tracks;
    }

    public void setTracks(List<CueTrackInfo> tracks) {
        this.tracks = tracks;
    }

}
