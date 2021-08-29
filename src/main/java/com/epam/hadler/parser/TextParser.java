package com.epam.hadler.parser;

import com.epam.hadler.entity.Component;
import com.epam.hadler.entity.Paragraph;
import com.epam.hadler.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser {
    private static final String PARAGRAPH_SPLITERATOR = "[^\\n]+\\n?";
    private static final Logger logger = LogManager.getLogger(TextParser.class);
    private static final Pattern REGEX_PARAGRAPH = Pattern.compile(PARAGRAPH_SPLITERATOR);
    private final String MESSAGE_START_PARSING = "Starting parsing text by sentences";
    private final String MESSAGE_PARSING_FINISH = "Parsing is finished";
    private final List<Component> elements = new LinkedList<>();
    private ParagraphParser paragraphParser = new ParagraphParser();
    private final Text parsedText = new Text();

    public Text parse(String text) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        Matcher matcher = REGEX_PARAGRAPH.matcher(text);
        logger.info(MESSAGE_START_PARSING);
        while (matcher.find()) {
            str = matcher.group().trim();
            sb.append(str);
            Paragraph paragraph = new Paragraph(str);
            paragraph.setSentencesList(paragraphParser.parse(str));
            elements.add(paragraph);

            parsedText.setParagraphList(elements);
        }
        parsedText.setValue(sb.toString());
        logger.info(MESSAGE_PARSING_FINISH);
        logger.info("FINAL - " + elements.toString());
        return parsedText;
    }
}
