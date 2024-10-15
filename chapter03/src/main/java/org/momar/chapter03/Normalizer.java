package org.momar.chapter03;

public interface Normalizer {
    default String normalize(String input) {
        return  input.trim();
    }
}
