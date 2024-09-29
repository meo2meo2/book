package org.momar.chapter03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Artist {
    String name;
    Map<String, Song> songs = new HashMap<>();

    public Artist(String normalized) {
    name = normalized;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Artist) {
            Artist other = (Artist) obj;
            if(other.getName() == name){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Artist [name=" + name + ", songs=" + songs + "]";
    }
}
