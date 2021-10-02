package org.se.lab;

import com.sun.istack.internal.NotNull;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.data.library.GetUsersSavedTracksRequest;
import com.wrapper.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsTracksRequest;
import org.se.lab.objects.MMMPlaylist;
import org.se.lab.objects.MMMTrack;
import org.se.lab.objects.MMMTrackFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TrackProviderPlaylist extends TrackProvider{
	

    private final List<MMMPlaylist> mmmPlaylists = new ArrayList<>();

	public TrackProviderPlaylist(SpotifyApi api) {
		super(api);
	}

	public void queryAllPlaylists() throws IOException, SpotifyWebApiException {
		addAllPlaylists();
	}



	private void addAllPlaylists() throws IOException, SpotifyWebApiException {

		List<PlaylistSimplified> userPlaylists = new ArrayList<>();
		int total = 0;
		do {
			GetListOfCurrentUsersPlaylistsRequest request = new GetListOfCurrentUsersPlaylistsRequest.Builder(getApi().getAccessToken()).limit(50).build();

			Paging<PlaylistSimplified> page = request.execute();
			if (total == 0)
				total =page.getTotal();

			for (PlaylistSimplified p : page.getItems()) {
				System.out.println("PL: NAME=\"" + p.getName() + "\" URL= " + p.getOwner().getUri());
				userPlaylists.add(p);
			}

			System.out.println("read " + userPlaylists.size() + " of "  + total);
		} while (userPlaylists.size() < total);

		int playlistCounter = 0;
		for (PlaylistSimplified playlist: userPlaylists) {
			playlistCounter++;
			System.out.println("PL["+String.format("%03d", playlistCounter) + "," + String.format("%03d", userPlaylists.size()) + "]" + playlist.getName());
			MMMPlaylist pl = new MMMPlaylist(playlist.getName(), readAllTracksFromPlaylist(playlist.getId()));
			mmmPlaylists.add(pl);
		}
	}

	private List<MMMTrack> readAllTracksFromPlaylist(String playlistId) throws IOException, SpotifyWebApiException {

		int totalNumberOfTracks = 0;


		List<PlaylistTrack> savedTracks = new ArrayList<>();

		do {
			GetPlaylistsTracksRequest req = new GetPlaylistsTracksRequest.Builder(getApi().getAccessToken())
					.playlist_id(playlistId)
					.offset(savedTracks.size())
					.limit(50)
					.build();
			
			Paging<PlaylistTrack> page = req.execute();
			if (totalNumberOfTracks == 0)
				totalNumberOfTracks = page.getTotal();
			

			savedTracks.addAll(Arrays.asList(page.getItems()));
			
			System.out.println("read " + savedTracks.size() + " of "  + totalNumberOfTracks);
		} while (savedTracks.size() < totalNumberOfTracks);

		return savedTracks.stream().map(PlaylistTrack::getTrack).map(MMMTrackFactory::create).collect(Collectors.toList());
	}


	public List<String> getAllTrackIds()
    {
    	List<String> trackIds = new ArrayList<>();
		for (MMMPlaylist p : mmmPlaylists)
		for (MMMTrack t : p.getTracks()) {
			if (t.getId() == null || t.getId().equals("null")) {
				System.out.println("TRACKID for track " + t.getName() + " is null");
			} else {
				trackIds.add(t.getId());
			}
		}
		return trackIds;
	}

	public void processTracks(TrackProcessor trackProcessor){
		int playlistCounter = 1;
		for (MMMPlaylist playlist : mmmPlaylists) {
			int trackCounter = 1;
			for (MMMTrack mmmTrack : playlist.getTracks()) {
				System.out.println("MSG_PROCESSING " 
						+ "Playlist("+String.format("%03d", playlistCounter)+":"+String.format("%03d", mmmPlaylists.size())+ ")=" + playlist.getName() + "   "
						+ "Track("   +String.format("%03d", trackCounter)+   ":"+String.format("%03d", playlist.getTracks().size())+")= " + mmmTrack.getName());

				String trackPrefix = String.format("%03d ", trackCounter);
				String filename = String.format("%s%s - %s", TrackProcessorUtils.fixFilename(trackPrefix), TrackProcessorUtils.fixFilename(mmmTrack.getName()), TrackProcessorUtils.fixFilename(mmmTrack.getFirstArtist()));
				String directory = "Playlists" + File.separator + TrackProcessorUtils.fixFilename(playlist.getName());

				trackProcessor.processTrack(mmmTrack, directory,filename);
				trackCounter++;
			}
			playlistCounter++;
		}
	}

	//redacted: lots of additional functionality


}
