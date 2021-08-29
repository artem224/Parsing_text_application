package com.epam.hadler.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Paragraph implements Component{

    String value;
    private List<Component> sentencesList = new ArrayList<>();

    public Paragraph(String value, List<Component> sentencesList) {
        this.value = value;
        this.sentencesList = sentencesList;
    }

    public Paragraph(String value) {
        this.value = value;
    }

    public Paragraph(List<Component> sentencesList) {
        this.sentencesList = sentencesList;
    }

    public Paragraph() {
    }

    @Override
    public void printComponent() {
        sentencesList.forEach(Component::printComponent);
    }

    @Override
    public int getSize() {
        return sentencesList.size();
    }

    @Override
    public Component getComponent(int i) {
        return sentencesList.get(i);
    }

    @Override
    public List<Component> getComponents() {
        return sentencesList;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public List<Component> getSentencesList() {
        return sentencesList;
    }

    public Component setSentencesList(List<Component> sentencesList) {
        this.sentencesList = sentencesList;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paragraph paragraph = (Paragraph) o;
        return value.equals(paragraph.value) && sentencesList.equals(paragraph.sentencesList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, sentencesList);
    }

    @Override
    public String toString() {
        return "Paragraph{" +
                "value='" + value + '\'' +
                ", sentencesList=" + sentencesList +
                '}' + "\n";
    }
}
