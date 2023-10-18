package ch.zhaw.springboot.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("section")
public class Section extends Content {

    private double chapter;

    @OneToMany(mappedBy = "section") // Gibt an, dass section die umgekehrte Seite der Beziehung darstellt.
    @JsonManagedReference // Content ist hier das untergeordnete Objekt
    private List<Content> contents = new ArrayList<>();

    public Section(String topic, double chapter) {
        super(topic);
        this.chapter = chapter;
    }

    public Section() {

    }

    public double getChapter() {
        return chapter;
    }

    public List<Content> getContents() {
        return contents;
    }

    public String getType() {
        return "section";
    }
}
