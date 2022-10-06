package com.sosamr.challenge.wrapper;

public class TextWrapper {

    public String wrap(String string, int length) {
        SourceText sourceText = new SourceText(string);
        WrappedText wrappedText = new WrappedText(length);
        while(sourceText.hasNext()) {
            Word word = sourceText.nextWord();
            wrappedText.add(word);
        }
        return wrappedText.toString();
    }


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
        String text = "This is extremely simple          text.\nJust for automatically testing purposes.   ";
        wrapper.visualTest(text, 2);
        wrapper.visualTest(text, 4);
        wrapper.visualTest(text, 8);
        wrapper.visualTest(text, 12);
        wrapper.visualTest(text, 16);
        wrapper.visualTest(text, 24);
        wrapper.visualTest(text, 32);
        wrapper.visualTest(text, 40);
        wrapper.visualTest(text, 100);
        wrapper.visualTest("test\nTesting", 4);
        wrapper.visualTest("test\nTesting", 5);
        wrapper.visualTest("test\nTesting", 50);
    }
}
