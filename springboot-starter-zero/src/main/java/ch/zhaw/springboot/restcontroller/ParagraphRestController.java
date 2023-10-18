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

import ch.zhaw.springboot.entities.Paragraph;
import ch.zhaw.springboot.repositories.ParagraphRepository;

@RestController
public class ParagraphRestController {
    
    @Autowired
    ParagraphRepository repository;

    @RequestMapping(value = "docs/contents/paragraphs", method = RequestMethod.GET)
    public ResponseEntity<List<Paragraph>> getParagraphs() {
        List<Paragraph> result = this.repository.findAll();
        return new ResponseEntity<List<Paragraph>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "docs/contents/paragraphs/{id}", method = RequestMethod.GET)
    public ResponseEntity<Paragraph> getParagraphById(@PathVariable("id") long id) {
        Optional<Paragraph> result = this.repository.findById(id);
        if (result.isEmpty()) {
            return new ResponseEntity<Paragraph>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Paragraph>(result.get(), HttpStatus.OK);
    }
}