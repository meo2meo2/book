package org.momar.chapter03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Song implements Comparable<Song>{
    private String name;
    private int votes;

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return String.format("Song [name=%s]", getName());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(obj instanceof Song) {
            Song other = (Song) obj;
            return Objects.equals(getName(), other.getName());
        }
        return false;
    }



    @Override
    public int compareTo(Song o) {
        int value = Integer.compare(getVotes(), ((Song) o).getVotes());
        if (value == 0) {

            value = getName().compareTo(((Song) o).getName());
        }

        return value;
    }
}
