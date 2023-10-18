package ch.zhaw.springboot.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("paragraph")
public class Paragraph extends Content {

    private int line;

    public Paragraph(String topic, int line) {
        super(topic);
        this.line = line;
    }

    public Paragraph() {

    }

    public int getLine() {
        return line;
    }

    public String getType() {
        return "paragraph";
    }

}
