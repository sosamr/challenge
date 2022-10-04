package com.sosamr.challenge;

public class TextWrapper {

    public String wrap(final String string, final int length) {
        int textPos = 0;
        String newLine = "";
        String wrappedText = "";

        String nextWord = nextWord(string, textPos);
        while (nextWord.length() > 0) {
            //when a word is longer than the length then we need to use hyphenation
            if (trim(nextWord).length() > length) {
                char[] chars = nextWord.toCharArray();
                int remainingLength = length - newLine.length() - 1; //1 char reserved for the hyphen

                if (remainingLength > 1) { //if we have remaining space on the line
                    String remainingText = "";
                    for (int i = 0; i < remainingLength; i++) {
                        remainingText = remainingText + chars[i];
                    }
                    nextWord = remainingText;

                    //avoids adding just spaces
                    if (trimRight(remainingText).length() > 0) {
                        newLine = newLine + trimRight(remainingText) + "-" + "\n";
                        wrappedText = wrappedText + newLine;
                        newLine = "";
                    }
                } else {  //processing a new line since no remaining space on the line
                    wrappedText = wrappedText + trimRight(newLine) + "\n";
                    newLine = "";
                    String hyphenedText = "";
                    for (int i = 0; i < length - 1; i++) {
                        hyphenedText = hyphenedText + chars[i];
                    }
                    nextWord = hyphenedText;

                    //avoid adding just spaces
                    if (trimRight(hyphenedText).length() > 0) {
                        newLine = trim(hyphenedText) + "-" + "\n";
                        wrappedText = wrappedText + newLine;
                        newLine = "";
                    }
                }
            } else {
                //if we are at end of line, then we find the reason
                boolean lineWithAdditionLength = newLine.length() > 0 && (newLine.length() + trimRight(nextWord).length()) >= length;
                boolean justAdditionLength = newLine.length() == 0 && trim(nextWord).length() >= length;

                if (lineWithAdditionLength) {
                    newLine = trimRight(newLine) + "\n";
                    wrappedText = wrappedText + newLine;
                    newLine = trimLeft(nextWord);
                } else if (justAdditionLength) {
                    newLine = trimLeft(nextWord);
                } else {
                    newLine = trimLeft(newLine) + nextWord;
                }
            }
            textPos = textPos + nextWord.length();
            nextWord = nextWord(string, textPos);
        }
        //flush newLine contents if any
        if (newLine.length() > 0) {
            wrappedText = wrappedText + trimRight(newLine) + "\n";
        }
        return wrappedText;
    }

    /**
     * Returns the text starting at position startAt
     * and ending where a space is found after a char.
     */
    private String nextWord(final String text, final int startAt) {
        char[] chars = text.toCharArray();

        String word = "";
        boolean endFound = false;
        boolean foundChar = false;
        for (int pos = startAt; !endFound && pos < chars.length; pos++) {
            word = word + chars[pos];
            if (!foundChar) {
                foundChar = chars[pos] != ' ';
            } else {
                endFound = chars[pos] == ' ';
            }
        }
        return word;
    }

    private String trimLeft(String text) {
        char[] chars = text.toCharArray();
        String word = "";
        boolean trimming = true;
        for (int pos = 0; pos < chars.length; pos++) {
            if (chars[pos] != ' ') {
                trimming = false;
            }
            if (!trimming) {
                word = word + chars[pos];
            }
        }
        return word;
    }

    private String trimRight(final String text) {
        char[] chars = text.toCharArray();
        String word = "";

        //finds last char position if any
        int lastCharPos = chars.length - 1;
        boolean lastCharFound = false;
        for (int pos = chars.length - 1; pos >= 0 && !lastCharFound; pos--) {
            if (chars[pos] != ' ') {
                lastCharPos = pos;
                lastCharFound = true;
            }
        }

        //build the word until the lastCharPos
        if (lastCharFound) {
            for (int pos = 0; pos <= lastCharPos; pos++) {
                word = word + chars[pos];
            }
        }
        return word;
    }

    /**
     * Removes leading and trailing spaces from a text.
     */
    private String trim(final String text) {
        return trimRight(trimLeft(text));
    }

    /**
     * Convenience method that prints a ruler
     * and the wrapped text below.
     * Just for testing purposes.
     *
     * @param text   to reformat and wrap.
     * @param length maximum length for a line.
     */
    private void visualTest(String text, int length) {
        System.out.println(String.format("Trying: '%s' [%d]", text, length));
        for (int i = 1; i <= length; i++) {
            System.out.print(i % 10);
        }
        System.out.println();
        System.out.println(wrap(text, length));
    }

    public static void main(String[] args) {
        TextWrapper wrapper = new TextWrapper();
        String text = "This is extremely simple          text for automatically testing purposes.   ";
        wrapper.visualTest(text, 4);
        wrapper.visualTest(text, 8);
        wrapper.visualTest(text, 12);
        wrapper.visualTest(text, 16);
        wrapper.visualTest(text, 24);
        wrapper.visualTest(text, 32);
        wrapper.visualTest(text, 40);
        wrapper.visualTest(text, 100);
    }
}
