package org.se.lab.objects;

import com.wrapper.spotify.model_objects.specification.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MMMTrackFactory {
    public static MMMTrack create(Track track) {
        return new MMMTrack() {

            @Override
            public String getId() {
                return track.getId();
            }

            @Override
            public String getName() {
                return track.getName();
            }

            @Override
            public String getFirstArtist() {
                return Arrays.stream(track.getArtists()).findFirst().map(ArtistSimplified::getName).orElse("Unknown Artist");
            }

            @Override
            public String getAlbumName() {
                return track.getAlbum().getName();
            }

            @Override
            public String getArtists() {
                StringBuilder data = new StringBuilder();
                boolean first = true;

                for (ArtistSimplified x : track.getArtists()) {
                    if (!first)
                        data.append(", ");

                    data.append(x.getName());
                    first = false;
                }

                return data.toString();
            }

            @Override
            public int getTrackNumber() {
                return track.getTrackNumber();
            }
        };
    }

    private static MMMTrack create(TrackSimplified track, String albumName) {
        return new MMMTrack() {
            @Override
            public String getId() {
                return track.getId();
            }

            @Override
            public String getName() {
                return track.getName();
            }

            @Override
            public String getFirstArtist() {
                return Arrays.stream(track.getArtists()).findFirst().map(ArtistSimplified::getName).orElse("Unknown Artist");
            }

            @Override
            public String getArtists() {
                StringBuilder data = new StringBuilder();
                Boolean first = true;

                for (ArtistSimplified x : track.getArtists()) {
                    if (!first)
                        data.append(", ");

                    data.append(x.getName());
                    first = false;
                }

                return data.toString();
            }

            @Override
            public String getAlbumName() {
                return albumName;
            }

            @Override
            public int getTrackNumber() {
                return track.getTrackNumber();
            }
        };
    }

    public static List<MMMTrack> createListFromSimpleTracks(List<TrackSimplified> simpleTracks, AlbumSimplified albumSimplified) {
        return simpleTracks.stream().map(simpleTrack -> MMMTrackFactory.create(simpleTrack, albumSimplified.getName())).collect(Collectors.toList());
    }

    public static List<MMMTrack> createListFromSimpleTracks(List<TrackSimplified> simpleTracks, Album album) {
        return simpleTracks.stream().map(simpleTrack -> MMMTrackFactory.create(simpleTrack, album.getName())).collect(Collectors.toList());
    }
}
