package com.epam.hadler.entity;

import java.util.List;
import java.util.Objects;

public class Word  implements Component {

    private String value;

    public Word(String value) {
        this.value = value;
    }

    public Word() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void printComponent() {
        System.out.println(value);
    }

    @Override
    public int getSize() {
        return value.length();
    }

    @Override
    public Component getComponent(int i) {
        return null;
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null ||
                getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Word word = (Word) o;
        return value.equals(word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}
