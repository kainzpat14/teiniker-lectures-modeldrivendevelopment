package org.se.lab;

import com.mpatric.mp3agic.*;
import org.se.lab.objects.MMMTrack;
import org.tritonus.share.sampled.file.TAudioFileFormat;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


public class MP3TrackProcessor extends TrackProcessor {
	
	public void processTrack(final MMMTrack mmmTrack, String directory, String filename) {
		try {
			directory = directory.trim();
			File mp3Source = new File(MainConfig.instance().getCacheConverted() + File.separator + mmmTrack.getId() + ".mp3");

			if (!mp3Source.exists()) {

				File alternativesFile = new File(MainConfig.instance().getCacheOrig() + File.separator + "alternatives.dat");
				if (alternativesFile.exists()) {
					BufferedReader r = new BufferedReader(new FileReader(alternativesFile));
					while (true) {
						String line = r.readLine();
						if (line == null)
							break;

						String[] line_splitted = line.split("\\|");

						if (line_splitted[0].equals(mmmTrack.getId())) {
							mp3Source = new File(MainConfig.instance().getCacheConverted() + File.separator + line_splitted[1] + ".mp3");
							break;
						}
					}
					r.close();
				}
			}

			if (!mp3Source.exists())
				return;

			File out_dir = new File(MainConfig.instance().getSdPath() + File.separator + directory);

			if (!out_dir.exists())
				out_dir.mkdirs();

			String outFilename = out_dir.getAbsolutePath() + File.separator + filename + ".mp3";
			File outFile = new File(outFilename);
			if (outFile.exists())
				return;

			writeFileWithMp3Tags(mmmTrack, mp3Source, outFilename);
			validateDurationAfterConversion(mp3Source, outFile);

		} catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}

	}

	private void validateDurationAfterConversion(File mp3Source, File outFile) throws UnsupportedAudioFileException, IOException {
		Long outDuration = getDurationWithMp3Spi(outFile);
		Long srcDuration = getDurationWithMp3Spi(mp3Source);

		if (outDuration - srcDuration != 0)
			System.err.println("ERROR_DURATION_MISSMATCH " +
					"SRC=" + formatDuration(srcDuration) + " " +
					"DST=" + formatDuration(outDuration) + " " +
					"DELTA=" + formatDuration(outDuration-srcDuration)
			);
	}

	private static String formatDuration(Long microseconds) {
        int mili = (int) (microseconds / 1000);
        int sec = (mili / 1000) % 60;
        int min = (mili / 1000) / 60;
        //System.out.println("time = " + min + ":" + sec);
        return min + ":" + String.format("%02d", sec);
	}
	
	private static Long getDurationWithMp3Spi(File file) throws UnsupportedAudioFileException, IOException {

	    AudioFileFormat fileFormat = AudioSystem.getAudioFileFormat(file);
	    if (fileFormat instanceof TAudioFileFormat) {
	        Map<?, ?> properties = fileFormat.properties();
	        String key = "duration";
	        Long microseconds = (Long) properties.get(key);
	        return microseconds;
	        //int mili = (int) (microseconds / 1000);
	        //int sec = (mili / 1000) % 60;
	        //int min = (mili / 1000) / 60;
	        //System.out.println("time = " + min + ":" + sec);
	    } else {
	        throw new UnsupportedAudioFileException();
	    }

	}
	
	private static void writeFileWithMp3Tags(final MMMTrack t, File mp3Source, String outFilename)
			throws IOException, UnsupportedTagException, InvalidDataException, NotSupportedException 
	{
		Mp3File mp3file = new Mp3File(mp3Source);
		
		ID3v2 id3v2Tag;
		if (mp3file.hasId3v2Tag()) {
		  id3v2Tag =  mp3file.getId3v2Tag();
		} else {
		  // mp3 does not have an ID3v1 tag, let's create one..
		  id3v2Tag = new ID3v23Tag();
		  mp3file.setId3v1Tag(id3v2Tag);
		}
		
		id3v2Tag.setTrack(Integer.toString(t.getTrackNumber()));
		id3v2Tag.setArtist(t.getArtists());
		id3v2Tag.setTitle(t.getName());
		id3v2Tag.setAlbum(t.getAlbumName());
		//id3v2Tag.setYear(Integer.toString(t.get));
		id3v2Tag.setEncoder("mmm");
		id3v2Tag.setComment("spotify://" + t.getId());
		//id3v1Tag.setGenre(12);
		
		mp3file.save(outFilename);
	}
}
