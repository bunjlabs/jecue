package com.bunjlabs.jecue.entities;

public class CueBaseInfo {

    private String title;
    private String performer;
    private String songwriter;

    public CueBaseInfo() {
    }

    public CueBaseInfo(String title, String performer, String songwriter) {
        this.title = title;
        this.performer = performer;
        this.songwriter = songwriter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getSongwriter() {
        return songwriter;
    }

    public void setSongwriter(String songwriter) {
        this.songwriter = songwriter;
    }

}
