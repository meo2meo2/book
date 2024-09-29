package org.momar.chapter03.service;

import org.momar.chapter03.Resettable;
import org.momar.chapter03.model.Artist;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMusicService implements MusicService , Resettable {
    private Map<String, Artist> bands = new HashMap<String, Artist>();


}
