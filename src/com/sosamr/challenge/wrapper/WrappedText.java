package com.sosamr.challenge.wrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WrappedText {
    private List<Line> lines;
    private int lineMaxLength;

    public WrappedText(int lineMaxLength) {
        if(lineMaxLength < 2) {
            throw new IllegalArgumentException("Max line length should take into account the '-' used for hyphenation. Therefore the lineMaxLength should be >= 2]");
        }
        this.lineMaxLength = lineMaxLength;
        lines = new ArrayList<>();
    }

    public void add(Word word) {
        boolean addEndOfLine = word.hasEndOfLine();
        word = word.removeEndOfLine();

        Optional<Word> remaining = Optional.of(word);
        while (remaining.isPresent()) {
            Line line = currentLineOrCreate();
            remaining = line.add(remaining.get());
        }
        if (addEndOfLine) {
            Line line = currentLineOrCreate();
            line.finish();
        }
    }

    private Line currentLineOrCreate() {
        if (lines.isEmpty() || lines.get(lines.size() -1).isFinished()) {
            lines.add(new Line(lineMaxLength));
        }
        return lines.get(lines.size() -1);
    }

    @Override
    public String toString() {
        String asText = "";
        for (Line l : lines) {
            asText = asText + l.toString();
        }
        return asText;
    }

}
