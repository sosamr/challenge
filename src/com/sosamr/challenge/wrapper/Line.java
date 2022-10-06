package com.sosamr.challenge.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Line {
    private int maxLength;
    private List<Word> words;

    public Line(int maxLength) {
        this.maxLength = maxLength;
        words = new ArrayList<>();
    }

    /**
     * Adds the Word to this Line.
     * It could add the whole word or just a part.
     * Returns the part of the Word that was not added.
     * The caller should call this method again, but on a new Line to add that part.
     *
     */
    public Optional<Word> add(final Word word) {
        if (fits(word)) {
            addWord(word);
            return Optional.empty();
        }

        Word rightTrimmed = word.trimRight();
        if (fits(rightTrimmed)) {
            addWord(rightTrimmed);
            return Optional.empty();
        }

        Word leftTrimmed = word.trimLeft();
        if (fitsInEmptyLine(leftTrimmed)) {
            finish();
            return Optional.of(leftTrimmed);
        }

        Word allTrimmed = word.trim();
        if (fitsInEmptyLine(allTrimmed)) {
            finish();
            return Optional.of(allTrimmed);
        }

        //at this point word is larger than the max length line
        //so hyphenation must be applied
        int remainingLength = getRemainingLength();
        if (remainingLength <= 1) {
            finish();
            return Optional.of(word);
        }

        Word wordForHyphen = word;
        if (remainingLength == maxLength) {
            wordForHyphen = word.trimLeft();
        }
        Word partThatFits = wordForHyphen.hyphen(remainingLength);
        Word partNotAdded = wordForHyphen.afterHyphen(remainingLength -1);
        addWord(partThatFits);
        finish();
        return Optional.of(partNotAdded);
    }

    public boolean fits(Word word) {
        return word.getLength() <= (maxLength - getLength());
    }

    public boolean fitsInEmptyLine(Word word) {
        return word.getLength() <= maxLength;
    }

    public int getLength() {
        int length = 0;
        for (Word w : words) {
            length = length + w.getLength();
        }
        return length;
    }

    public int getRemainingLength() {
        if (isFinished()) {
            return 0;
        }
        return maxLength - getLength();
    }

    public void finish() {
        if(!words.isEmpty()) {
            words.get(words.size() -1).trimRight();
        }
        words.add(Word.endOfLine());
    }

    public boolean isFinished() {
        return !words.isEmpty() && words.get(words.size() -1).isEndOfLine();
    }

    private void addWord(final Word word) {
        if (isFinished()) {
            throw new IllegalStateException("Cannot add a word to a finished line.");
        }
        if (words.isEmpty()) {
            word.trimLeft();
        }
        words.add(word);
    }

    @Override
    public String toString() {
        String asText = "";
        for (Word w : words) {
            asText = asText + w.toString();
        }
        return asText;
    }
}
