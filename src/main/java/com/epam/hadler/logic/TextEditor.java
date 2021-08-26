package com.epam.hadler.logic;


import com.epam.hadler.entity.Component;
import com.epam.hadler.entity.LeafSentence;
import com.epam.hadler.entity.Text;
import com.epam.hadler.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class TextEditor {

    private static final Logger logger = LogManager.getLogger(TextEditor.class);
    private static final String MESSAGE_SENTENCES_IS_ASCENDING = "Sentences in ascending order of words";
    private Text text = new Text();
    private Component sentence = new LeafSentence();
    private List<Component> elements = new ArrayList<>();
    private final List<Word> wordList = new LinkedList<>();
    private List<Component> sentences = new ArrayList<>();

    public TextEditor() {
    }

    public void loadText(Text text) {
        this.text = text;
        loadElements();
    }

    private void loadElements() {
        elements.addAll(text.getSentenceList());
        sentences.addAll(text.getSentenceList());
    }

    // variant 2
    public void displayAllSentencesInOrderOfWords() {
        elements.sort(Comparator.comparingInt(Component::getSize));
        logger.info(MESSAGE_SENTENCES_IS_ASCENDING);
        elements.forEach(logger::info);
    }

    // variant 5
    public void swapFirstWordWithLast() {
        for (Component component : sentences) {
            List<Component> words = component.getComponents();
            Component temp = words.get(0);
            words.set(0, words.get(words.size() - 1));
            words.set(words.size() - 1, temp);
        }
        logger.info("Sentences with swap words - :\n");
        logger.info(sentences.toString());
    }

    // variant 16
    public void replaceWithSubstring(Component sentence,String str, int lengthWord) {
        for (int i = 0; i < sentence.getSize(); i++){
            Component word = sentence.getComponents().get(i);
            if (word.getSize() == lengthWord) {
                word.setValue(str);
            }
        }
        logger.info("Modified Substring Sentence: \n" + sentence.toString());
    }


    public String recoverText() {
        return text.getValue();
    }
}
