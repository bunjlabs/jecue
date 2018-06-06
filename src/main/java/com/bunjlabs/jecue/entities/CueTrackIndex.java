package com.bunjlabs.jecue.entities;

public class CueTrackIndex {

    private int minutes;
    private int seconds;
    private int frames;

    public CueTrackIndex() {
    }

    public CueTrackIndex(float seconds) {
        this.minutes = (int) (seconds / 60);
        this.seconds = (int) (seconds % 60);
        this.frames = (int) ((seconds - (this.minutes * 60) - this.seconds) * 75);
    }

    public CueTrackIndex(int minutes, int seconds, int frames) {
        this.minutes = minutes;
        this.seconds = seconds;
        this.frames = frames;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getFrames() {
        return frames;
    }

    public void setFrames(int frames) {
        this.frames = frames;
    }

    public int getFramesFull() {
        return frames + seconds * 75 + minutes * 60 * 75;
    }

    public int getSecondsDurationTo(CueTrackIndex to) {
        return Math.abs((this.minutes * 60 + this.seconds) - (to.minutes * 60 + to.seconds));
    }
}
