package org.se.lab.objects;

import java.util.ArrayList;
import java.util.List;

public class MMMArtist {

    private String name;
    private List<MMMAlbum> albums = new ArrayList<>();

    public MMMArtist(String name) {
        this.name = name;
    }

    public void addAlbum(MMMAlbum al) {
        albums.add(al);
    }

    public List<MMMAlbum> getAlbums() {
        return albums;
    }

    public String getName() {
        return name;
    }
}
