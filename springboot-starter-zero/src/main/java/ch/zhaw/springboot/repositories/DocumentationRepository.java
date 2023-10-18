package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Documentation;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {
    
}
