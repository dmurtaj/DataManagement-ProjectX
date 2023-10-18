package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
