package com.epam.hadler.entity;

import java.util.List;
import java.util.Objects;

public  class Text implements Component {

    private String value;
    private List<Component> sentenceList;

    public Text() {
    }

    public Text(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setSentenceList(List<Component> sentenceList) {
        this.sentenceList = sentenceList;
    }

    public List<Component> getSentenceList() {
        return sentenceList;
    }

    @Override
    public void printComponent() {
        sentenceList.forEach(Component::printComponent);
    }

    @Override
    public int getSize() {
        return sentenceList.size();
    }

    @Override
    public Component getComponent(int i) {
        return sentenceList.get(i);
    }

    @Override
    public List<Component> getComponents() {
        return sentenceList;
    }

    @Override
    public String toString() {
        return "Text{" +
                "value='" + value + '\'' + "\n" +
                ", sentenceList=" + sentenceList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(value, text.value) && Objects.equals(sentenceList, text.sentenceList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, sentenceList);
    }

}

