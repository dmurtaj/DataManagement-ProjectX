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

import ch.zhaw.springboot.entities.Section;
import ch.zhaw.springboot.repositories.SectionRepository;

@RestController
public class SectionRestController {
    
    @Autowired
    SectionRepository repository;

    @RequestMapping(value = "docs/contents/sections", method = RequestMethod.GET)
    public ResponseEntity<List<Section>> getSections() {
        List<Section> result = this.repository.findAll();
        return new ResponseEntity<List<Section>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "docs/contents/sections/{id}", method = RequestMethod.GET)
    public ResponseEntity<Section> getSectionById(@PathVariable("id") long id) {
        Optional<Section> result = this.repository.findById(id);
        if (result.isEmpty()) {
            return new ResponseEntity<Section>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Section>(result.get(), HttpStatus.OK);
    }
}
