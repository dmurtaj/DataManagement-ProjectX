package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Paragraph;

public interface ParagraphRepository extends JpaRepository<Paragraph, Long> {
    
}
