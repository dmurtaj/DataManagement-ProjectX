package ch.zhaw.springboot.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.springboot.entities.Product;
import ch.zhaw.springboot.repositories.ProductRepository;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepository repository;

    @RequestMapping(value = "docs/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> result = this.repository.findAll();
        return new ResponseEntity<List<Product>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "docs/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable("id") long id) {
        Optional<Product> result = this.repository.findById(id);
        if (result.isEmpty()) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(result.get(), HttpStatus.OK);
    }
    
}
