package org.momar.chapter03.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Artist {
    private String name;
    private Map<String, Song> songs = new HashMap<String, Song>();

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        return Objects.equals(getName(), ((Artist) obj).getName());
    }


    @Override
    public String toString() {
        return String.format("Artist [name=%s, songs=%s]", name, songs);
    }
}




