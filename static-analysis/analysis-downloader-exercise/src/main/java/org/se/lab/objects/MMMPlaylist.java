package org.se.lab.objects;

import java.util.List;

public class MMMPlaylist {

	private List <MMMTrack> tracks;
	private String name;


	public MMMPlaylist(String name, List<MMMTrack> tracks) {
		this.tracks = tracks;
		this.name = name;
	}

	public List <MMMTrack> getTracks() {
		return tracks;
	}

	public void setTracks(List <MMMTrack> tracks) {
		this.tracks = tracks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
