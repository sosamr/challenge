package com.sosamr.challenge.wrapper;


public class SourceText {

    private char[] text;
    private int currentPosition; //where to start reading next...

    public SourceText(final String text) {
        this.text = text.toCharArray();
        this.currentPosition = 0;
    }

    public boolean hasNext() {
        return currentPosition < text.length -1;
    }

    /**
     * Returns the text starting at currentPosition
     * and ending where a space is found after a char.
     */
    public Word nextWord() {
        int startingPosition = currentPosition;
        boolean endFound = false;
        boolean foundChar = false;
        while(!endFound && currentPosition < text.length) {
            if (!foundChar) {
                foundChar = text[currentPosition] != ' ' && text[currentPosition] != Word.END_OF_LINE;
            } else {
                endFound = text[currentPosition] == ' ' || text[currentPosition] == Word.END_OF_LINE;
            }
            currentPosition++;
        }
        char[] chars = new char[currentPosition - startingPosition];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = text[currentPosition -chars.length + i];
        }
        return new Word(chars);
    }

}
