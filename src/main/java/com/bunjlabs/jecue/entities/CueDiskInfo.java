package com.bunjlabs.jecue.entities;

import java.util.HashMap;
import java.util.Map;

public class CueDiskInfo extends CueBaseInfo {

    private String catalog;
    private String isrc;
    private String cdTextFile;
    private Map<String, String> remarks;

    public CueDiskInfo() {
        super();
        this.remarks = new HashMap<>();
    }

    public CueDiskInfo(String catalog, String isrc, String cdTextFile, Map<String, String> remarks, String title, String performer, String songwriter) {
        super(title, performer, songwriter);
        this.catalog = catalog;
        this.isrc = isrc;
        this.cdTextFile = cdTextFile;
        this.remarks = remarks;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getIsrc() {
        return isrc;
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public String getCdTextFile() {
        return cdTextFile;
    }

    public void setCdTextFile(String cdTextFile) {
        this.cdTextFile = cdTextFile;
    }

    public Map<String, String> getRemarks() {
        return remarks;
    }

    public void setRemarks(Map<String, String> remarks) {
        this.remarks = remarks;
    }

}
