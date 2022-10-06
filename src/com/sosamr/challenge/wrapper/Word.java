package com.sosamr.challenge.wrapper;

public class Word {
    public static final char END_OF_LINE = '\n';
    private static final char HYPHEN_CHAR = '-';
    private char[] text;

    public Word(final char[] text) {
        this.text = text;
    }

    public static Word endOfLine() {
        return new Word(new char[]{END_OF_LINE});
    }

    public int getLength() {
        if(isEndOfLine()) {
            return 0;
        } else {
            return text.length;
        }
    }

    public boolean isEndOfLine() {
        return text.length == 1 && text[0] == END_OF_LINE;
    }

    public boolean hasEndOfLine() {
        return text.length > 0 && text[text.length -1] == END_OF_LINE;
    }

    public Word removeEndOfLine() {
        if (hasEndOfLine()) {
            char[] chars = new char[text.length - 1];
            for (int pos = 0; pos < chars.length; pos++) {
                chars[pos] = text[pos];
            }
            return new Word(chars);
        } else {
            return this;
        }
    }

    public Word trimLeft() {
        //finds first char position if any
        int firstCharPos = 0;
        boolean firstCharFound = false;
        for (int pos = 0; pos < text.length && !firstCharFound; pos++) {
            if (text[pos] != ' ') {
                firstCharPos = pos;
                firstCharFound = true;
            }
        }

        if (!firstCharFound) {
            return new Word(new char[0]);
        }

        if(firstCharPos == 0) {
            return this;
        }

        char[] chars = new char[text.length - firstCharPos];
        for (int pos = 0; pos < chars.length; pos++) {
            chars[pos] = text[pos + firstCharPos];
        }
        return new Word(chars);
    }

    public Word trimRight() {
        //finds last char position if any
        int lastCharPos = text.length - 1;
        boolean lastCharFound = false;
        for (int pos = text.length - 1; pos >= 0 && !lastCharFound; pos--) {
            if (text[pos] != ' ') {
                lastCharPos = pos;
                lastCharFound = true;
            }
        }

        //build the word until the lastCharPos
        if (lastCharFound) {
            char[] chars = new char[lastCharPos + 1];
            for (int pos = 0; pos <= lastCharPos; pos++) {
                chars[pos] = text[pos];
            }
            return new Word(chars);
        } else {
            return this;
        }
    }

    public Word trim() {
        return trimLeft().trimRight();
    }

    public Word hyphen(int totalLength) {
        if (totalLength > getLength() + 1) {
            totalLength = getLength() + 1;
        }
        char[] chars = new char[totalLength];
        for (int pos = 0; pos < totalLength - 1; pos++) {
            chars[pos] = text[pos];
        }
        chars[totalLength -1] = HYPHEN_CHAR;
        return new Word(chars);
    }

    public Word afterHyphen(int startPos) {
        char[] chars = new char[getLength() - startPos];
        for (int pos = 0; pos < chars.length; pos++) {
            chars[pos] = text[pos + startPos];
        }
        return new Word(chars);
    }

    @Override
    public String toString() {
        return String.valueOf(text);
    }

}
