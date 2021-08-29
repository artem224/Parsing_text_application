package com.epam.hadler.parser;

import com.epam.hadler.entity.Component;
import com.epam.hadler.entity.LeafSentence;
import com.epam.hadler.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static final Logger logger = LogManager.getLogger(Parser.class);
    private static final String SENTENCE_SPLITERATOR = "(\\s*[^.!?]*[.!?])";
    private static final Pattern REGEX_SENTENCE = Pattern.compile(SENTENCE_SPLITERATOR);


    private final SentenceParser sentenceParser = new SentenceParser();

    public List<Component> parse(String text) {
        List<Component> elements = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String str = "";
        Matcher matcher = REGEX_SENTENCE.matcher(text);
        while (matcher.find()) {
            str = matcher.group(0).trim();
            sb.append(str);
            elements.add(new LeafSentence(str).setWordList(sentenceParser.parse(str)));

        }
        return elements;
    }

}
