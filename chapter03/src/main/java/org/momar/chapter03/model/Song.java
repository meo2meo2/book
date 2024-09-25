package org.momar.chapter03.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.StringJoiner;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Song implements Comparable<Song> {

    private int votes;
    private String name;


    @Override
    public int compareTo(Song o) {
        int value = Integer.compare(o.getVotes(),votes);
        if (value == 0) {
            value = getName().compareTo(o.getName());
        }
        return value;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Song.class.getSimpleName() + "[","]")
                .add("name='" + name + "'").add("votes='" + votes + "'").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return votes == song.votes && Objects.equals(name, song.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(votes, name);
    }
}
