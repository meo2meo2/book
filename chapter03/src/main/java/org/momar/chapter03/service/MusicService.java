package org.momar.chapter03.service;

import org.momar.chapter03.model.Song;

import java.util.List;

public interface MusicService {
    List<Song> getSongsForArtist(String artist);
    List<String> getMatchingSongNamesForArtist(String artist, String prefix);
    List<String> getMatchingArtisNames(String prefix);
    Song getSong(String artist, String name);
    Song voteForSong(String artist, String name);
}
