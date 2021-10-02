package org.se.lab;

public class MainConfig {
	private String cache_orig;
	private String cache_converted;
	private String ffmpeg;
	private String sd_path;
	
	public MainConfig() {

		//redacted: read config

	}
	
	private static MainConfig instance = null;
	public static MainConfig instance() {
		if (instance == null)
			instance = new MainConfig();
		return instance;			
	}

	public String getCacheOrig() {
		return cache_orig;
	}
	
	public String getCacheConverted() {
		return cache_converted;
	}
	
	public String getFfmpegExecutable() {
		return ffmpeg;
	}
	
	public String getSdPath() {
		return sd_path;
	}

	public long getDelayBetweenArtists() {
		return 500;
	}

	public long getDelayBetweenAlbums() {
		return 50;
	}
}