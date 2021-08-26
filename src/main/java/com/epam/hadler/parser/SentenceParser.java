package com.epam.hadler.parser;


import com.epam.hadler.entity.Component;
import com.epam.hadler.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser {

    private static final Logger logger = LogManager.getLogger(SentenceParser.class);
    private static final String WORD_SPLITERATOR = "\\w+";
    private static final Pattern REGEX_WORD = Pattern.compile(WORD_SPLITERATOR);
    private final String MESSAGE_START_PARSING_BY_WORDS = "Starting parsing sentences by words";
    private final String MESSAGE_CREATING_LIST_WORDS = "New created List of Words - ";

    public List<Component> parse(String text) {
        List<Component> elements = new LinkedList<>();
        String str = "";
        Matcher matcher = REGEX_WORD.matcher(text);
        logger.info(MESSAGE_START_PARSING_BY_WORDS);
        while(matcher.find()){
            str = matcher.group(0).trim();
            elements.add(new Word(str));
        }
        logger.info(MESSAGE_CREATING_LIST_WORDS + elements.toString());
        return elements;
    }
}
