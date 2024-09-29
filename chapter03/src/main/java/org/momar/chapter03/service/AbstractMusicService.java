package org.momar.chapter03.service;

import org.momar.chapter03.Resettable;
import org.momar.chapter03.model.Artist;
import org.momar.chapter03.model.Song;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class AbstractMusicService implements MusicService, Resettable {
    private final Map<String, Artist> bands = new HashMap<String, Artist>();


    protected String transformArtist(String input) {
        return input;
    }

    protected String transformSong(String input) {
        return input;
    }

    @Override
    public void reset() {
        bands.clear();
    }

    private Artist getArtist(String name) {
        String normalized = transformArtist(name);
        return bands.computeIfAbsent(normalized, s -> new Artist(normalized));
    }


    @Override
    public Song getSong(String artistName, String name) {
        Artist artist = getArtist(artistName);
        String normalized = transformSong(name);
        return artist.getSongs().computeIfAbsent(normalized, Song::new);
    }

    @Override
    public List<Song> getSongsForArtist(String artistName) {
        List<Song> songs = new ArrayList<Song>(
                getArtist(artistName).getSongs().values()
        );
        songs.sort(Song::compareTo);
        return songs;
    }

    @Override
    public List<String> getMatchingSongNamesForArtist(String artist, String prefix) {
        String normalizedPrefix = transformSong(prefix).toLowerCase();
        return getArtist(artist).getSongs().keySet().stream()
                .map(this::transformSong).filter(name -> name.toLowerCase().startsWith(normalizedPrefix))
                .sorted(Comparator.comparing(Function.identity()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getMatchingArtisNames(String prefix) {
        String normalizedPrefix = transformSong(prefix).toLowerCase();
        return bands.keySet().stream()
                .filter( name -> name.toLowerCase().startsWith(normalizedPrefix))
                .sorted(Comparator.comparing(Function.identity())).collect(Collectors.toList());
    }

    @Override
    public Song voteForSong(String artist, String name) {
        Song song = getSong(artist, name);
        song.setVotes( song.getVotes() + 1);
        return song;

    }
}
