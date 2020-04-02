package fabs.util;

import org.jdom.Element;

import java.util.ArrayList;

public interface SerializableOptions {
    public Element serialize();

    public void deserialize(Element element);
}
