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

public class TextParser {

    private static final Logger logger = LogManager.getLogger(TextParser.class);
    private static final String SENTENCE_SPLITERATOR = "(\\s*[^.!?]*[.!?])";
    private static final Pattern REGEX_SENTENCE = Pattern.compile(SENTENCE_SPLITERATOR);
    private final String MESSAGE_START_PARSING = "Starting parsing text by sentences";
    private final String MESSAGE_PARSING_FINISH = "Parsing is finished";
    private final List<Component> elements = new LinkedList<>();
    private final Text parsedText = new Text();
    private final SentenceParser sentenceParser = new SentenceParser();

    public Text parse(String text) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        int end = 0;
        Matcher matcher = REGEX_SENTENCE.matcher(text);
        logger.info(MESSAGE_START_PARSING);
        while (matcher.find()){
            end = matcher.end();
            str = matcher.group(0).trim();
            sb.append(str);
            elements.add(new LeafSentence(str).setWordList(sentenceParser.parse(str)));
            parsedText.setSentenceList(elements);
        }
        parsedText.setValue(sb.toString());
        parsedText.printComponent();
        logger.info(MESSAGE_PARSING_FINISH);
        return parsedText;
    }

}
