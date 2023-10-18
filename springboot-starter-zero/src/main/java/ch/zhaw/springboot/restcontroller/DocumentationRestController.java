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

import ch.zhaw.springboot.entities.Documentation;
import ch.zhaw.springboot.repositories.DocumentationRepository;

@RestController
public class DocumentationRestController {
    
    @Autowired
    DocumentationRepository repository;

    @RequestMapping(value = "docs/documentations", method = RequestMethod.GET)
    public ResponseEntity<List<Documentation>> getDocumentations() {
        List<Documentation> result = this.repository.findAll();
        return new ResponseEntity<List<Documentation>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "docs/documentations/{id}", method = RequestMethod.GET)
    public ResponseEntity<Documentation> getDocumentationById(@PathVariable("id") long id) {
        Optional<Documentation> result = this.repository.findById(id);
        if (result.isEmpty()) {
            return new ResponseEntity<Documentation>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Documentation>(result.get(), HttpStatus.OK);
    }
}
