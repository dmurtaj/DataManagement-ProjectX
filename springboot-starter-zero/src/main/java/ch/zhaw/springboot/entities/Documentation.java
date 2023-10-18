package ch.zhaw.springboot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Documentation {

    @Id
    private long id;

    private String publication;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Content content;

    public Documentation(String publication) {
        this.publication = publication;
    }

    public Documentation() {
    }

    public long getId() {
        return id;
    }

    public String getPublication() {
        return publication;
    }

    public Product getProduct() {
        return product;
    }

    public Content getContent() {
        return content;
    }

}
