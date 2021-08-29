package com.epam.hadler.entity;

import java.util.List;
import java.util.Objects;

public  class Text implements Component {

    private String value;
    private List<Component> paragraphList;

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

    public void setParagraphList(List<Component> paragraphList) {
        this.paragraphList = paragraphList;
    }

    public List<Component> getParagraphList() {
        return paragraphList;
    }

    @Override
    public void printComponent() {
        paragraphList.forEach(Component::printComponent);
    }

    @Override
    public int getSize() {
        return paragraphList.size();
    }

    @Override
    public Component getComponent(int i) {
        return paragraphList.get(i);
    }

    @Override
    public List<Component> getComponents() {
        return paragraphList;
    }

    @Override
    public String toString() {
        return "Text{" +
                "value='" + value + '\'' + "\n" +
                ", sentenceList=" + paragraphList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(value, text.value) && Objects.equals(paragraphList, text.paragraphList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, paragraphList);
    }

}

