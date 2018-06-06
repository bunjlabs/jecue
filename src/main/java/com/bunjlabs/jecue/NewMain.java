package com.bunjlabs.jecue;

import com.bunjlabs.jecue.entities.CueSheet;
import java.io.File;
import java.io.FileNotFoundException;

public class NewMain {

    public static void main(String[] args) throws FileNotFoundException {
        CueLoader cueLoader = new CueLoader(new File("meta.cue"));

        CueSheet load = cueLoader.load();

        System.out.println(load);
    }

}
