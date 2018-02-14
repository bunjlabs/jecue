package com.bunjlabs.jecue.entities;

import java.util.ArrayList;
import java.util.List;

public class CueSheet {

    private CueDiskInfo diskInfo;
    private List<CueFileInfo> files;

    public CueSheet() {
        this.diskInfo = new CueDiskInfo();
        this.files = new ArrayList<>();
    }

    public CueSheet(CueDiskInfo diskInfo, List<CueFileInfo> files) {
        this.diskInfo = diskInfo;
        this.files = files;
    }

    public CueDiskInfo getDiskInfo() {
        return diskInfo;
    }

    public void setDiskInfo(CueDiskInfo diskInfo) {
        this.diskInfo = diskInfo;
    }

    public List<CueFileInfo> getFiles() {
        return files;
    }

    public void setFiles(List<CueFileInfo> files) {
        this.files = files;
    }

}
