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

import ch.zhaw.springboot.entities.Content;
import ch.zhaw.springboot.repositories.ContentRepository;

@RestController
public class ContentRestController {
    
    @Autowired // Verbindung zum Repository, sodass die Methoden verfügbar sind.
    ContentRepository repository;

    @RequestMapping(value = "docs/contents", method = RequestMethod.GET) // Requestmethode wird definiert (hier GET).
    public ResponseEntity<List<Content>> getContents() {
        List<Content> result = this.repository.findAll(); // Methode aus dem ContentRepository (JPA)
        return new ResponseEntity<List<Content>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "docs/contents/{id}", method = RequestMethod.GET) // Requestmethode wird definiert (hier GET).
    public ResponseEntity<Content> getContentsById(@PathVariable("id") long id) { // Liest ID aus der URL und speichert es in long id ab.
        // Optional: Wert entweder vorhanden oder eben nicht.
        Optional<Content> result = this.repository.findById(id); // Methode aus dem ContentRepository (JPA)
        if (result.isEmpty()) {
            return new ResponseEntity<Content>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Content>(result.get(), HttpStatus.OK);
    }
}
