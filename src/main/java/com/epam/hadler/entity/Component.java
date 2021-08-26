package com.epam.hadler.entity;

import java.util.List;

public interface Component {
    void printComponent();

    int getSize();

    Component getComponent(int i);

    List<Component> getComponents();

    void setValue(String value);

}
