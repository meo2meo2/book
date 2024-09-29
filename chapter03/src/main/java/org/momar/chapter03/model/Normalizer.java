package org.momar.chapter03.model;

public interface Normalizer {
    default String transform(String input) {
        return input.trim();

    }
}
