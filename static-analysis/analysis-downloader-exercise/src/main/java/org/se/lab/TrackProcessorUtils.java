package org.se.lab;

public class TrackProcessorUtils {
    public static String fixFilename(String filename) {
        filename = filename
                .replace('\\', '-')
                .replace('/', '-')
                .replace(":", "")
                .replace("?", "")
                .replace("\"", "")
                .replace("*","x")
                .replace("|", "-")
                .replace("<","[")
                .replace(">","]")
        //.replace("'","")
        ////.replace("[","(")
        //.replace("]",")")
        //.replace("&","+")
        ;
        return filename.substring(0,Math.min(filename.length(),100));
    }
}
