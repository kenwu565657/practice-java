package com.practice.java.number5;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * copy from effective java
 */
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        Objects.requireNonNull(dictionary);
        this.dictionary = dictionary;
    }

    public SpellChecker(Supplier<Lexicon> dictionary) {
        Objects.requireNonNull(dictionary.get());
        this.dictionary = dictionary.get();
    }

    public boolean isValid(String word) {
        return true;
    }
}
