package org.se.lab;

import com.wrapper.spotify.SpotifyApi;

import java.util.List;

public abstract class TrackProvider {
    private final SpotifyApi api;

    public TrackProvider(SpotifyApi api) {
        this.api = api;
    }

    public SpotifyApi getApi() {
        return api;
    }

    public abstract List<String> getAllTrackIds();
    public abstract void processTracks(TrackProcessor trackProcessor);
}
