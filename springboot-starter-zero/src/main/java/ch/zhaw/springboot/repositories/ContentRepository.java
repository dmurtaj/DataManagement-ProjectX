package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Content;

// JPA generiert Methoden, die den Zugriff auf die Daten in der DB ermöglichen (Diese werden im RestController verwendet).
public interface ContentRepository extends JpaRepository<Content, Long>{ // Content = Entitätsobjekt, Long = ID
    // Derived Queries würden hier stehen.
    // Derived Queries kann man einfach über den Methodenamen aufrufen.
    // Man kann aber auch über JPQL eigene Queries im SQL Stil erstellen.
}
