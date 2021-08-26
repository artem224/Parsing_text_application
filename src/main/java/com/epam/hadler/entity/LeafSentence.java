package com.epam.hadler.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeafSentence implements Component {

    private String value;
    private List<Component> wordList = new ArrayList<>();

    public LeafSentence() {
    }

    public LeafSentence(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }


    public void addWord(Component component) {
        wordList.add(component);
    }

    public void removeWord(Component component) {
        wordList.remove(component);
    }

    public List<Component> getWordList() {
        return wordList;
    }

    public int getSizeWordList() {
        return wordList.size();
    }

    public Component setWordList(List<Component> wordList) {
        this.wordList = wordList;
        return this;
    }

    @Override
    public void printComponent() {
        wordList.forEach(Component::printComponent);
    }

    @Override
    public int getSize() {
        return wordList.size();
    }

    @Override
    public Component getComponent(int i) {
        return wordList.get(i);
    }

    @Override
    public List<Component> getComponents() {
        return wordList;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LeafSentence{" +
                "value='" + value + '\'' +
                ", wordList=" + wordList.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeafSentence that = (LeafSentence) o;
        return value.equals(that.value) && wordList.equals(that.wordList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, wordList);
    }

}
