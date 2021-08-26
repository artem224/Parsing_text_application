package com.epam.hadler;

import com.epam.hadler.entity.Component;
import com.epam.hadler.entity.LeafSentence;
import com.epam.hadler.entity.Text;
import com.epam.hadler.entity.Word;
import com.epam.hadler.logic.TextEditor;
import com.epam.hadler.parser.TextParser;
import com.epam.hadler.reader.FileTextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final String PATH = "./src/main/resources/text";
    private static final String MESSAGE_TEXT_IS_PARSED = "Text is parsed: ";
    private static final String MESSAGE_RECOVERED_TEXT = "Recovered text: ";

    public static void main(String[] args) throws Exception {

        FileTextReader fileTextReader = new FileTextReader(PATH);
        TextParser textParser = new TextParser();
        Text parsedText;
        parsedText = textParser.parse(fileTextReader.readFileAsString());
        logger.info(MESSAGE_TEXT_IS_PARSED + parsedText);
        parsedText.printComponent();


        TextEditor textEditor = new TextEditor();
        textEditor.loadText(parsedText);
        logger.info( MESSAGE_RECOVERED_TEXT + textEditor.recoverText() );

        List<Component> wordList = new ArrayList<>();
        Component word1 = new Word("LALA");
        Component word2 = new Word("Pala");
        Component word3 = new Word("kak");
        wordList.add(word1);
        wordList.add(word2);
        wordList.add(word3);
        LeafSentence sentence = new LeafSentence();
        sentence.setWordList(wordList);


        logger.info("Tasks: ");

        textEditor.displayAllSentencesInOrderOfWords();

        textEditor.swapFirstWordWithLast();

        textEditor.replaceWithSubstring(sentence ,"fwqfew",4);


    }
}
