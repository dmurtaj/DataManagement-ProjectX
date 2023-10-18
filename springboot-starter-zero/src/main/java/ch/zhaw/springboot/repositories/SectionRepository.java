package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
    
}
