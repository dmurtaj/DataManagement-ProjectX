package ch.zhaw.springboot.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;

@Entity // Java Persistence API (JPA) Annotion 
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Alle Subklassen sind in einer Tabelle. Tabelle enthält Contents, Sections oder Paragraphs.
@DiscriminatorColumn(name = "type")
public class Content {
    @Id
    private long id;

    private String topic;

    @ManyToOne
    @JsonBackReference // Vermeidet Endlosschleifen. Gibt ein leeres JSON aus.
    private Section section;

    public Content(String topic) {
        this.topic = topic;
    }

    public Content() { // Default Konstruktor, um eine Instanz ohne Parameter zu erstellen.
    }

    public long getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

}
