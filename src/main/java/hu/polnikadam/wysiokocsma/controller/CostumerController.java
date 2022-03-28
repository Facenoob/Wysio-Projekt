package hu.polnikadam.wysiokocsma.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import hu.polnikadam.wysiokocsma.model.Costumer;
import hu.polnikadam.wysiokocsma.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class CostumerController {
    @Autowired
    CostumerRepository costumerRepository;

    @GetMapping("/costumers")
    public ResponseEntity<List<Costumer>> getAllCostumer(@RequestParam(required = false) String name) {
        try {
            List<Costumer> costumers = new ArrayList<Costumer>();
            if (name == null)
                costumerRepository.findAll().forEach(costumers::add);

            if (costumers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(costumers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/costumers/{id}")
    public ResponseEntity<Costumer> getCostumerById(@PathVariable("id") long id) {
        Optional<Costumer> costumerData = costumerRepository.findById(id);
        if (costumerData.isPresent()) {
            return new ResponseEntity<>(costumerData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/costumers")
    public ResponseEntity<Costumer> createCostumer(@RequestBody Costumer costumer) {
        try {
            Costumer _costumer = costumerRepository
                    .save(new Costumer(costumer.getName(), costumer.getLiverStrength(), costumer.getBicepsSize()));
            return new ResponseEntity<>(_costumer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/costumers/{id}")
    public ResponseEntity<Costumer> updateCostumer(@PathVariable("id") long id, @RequestBody Costumer costumer) {
        Optional<Costumer> costumerData = costumerRepository.findById(id);
        if (costumerData.isPresent()) {
            Costumer _costumer = costumerData.get();
            _costumer.setName(costumer.getName());
            _costumer.setLiverStrength(costumer.getLiverStrength());
            _costumer.setBicepsSize(costumer.getBicepsSize());
            return new ResponseEntity<>(costumerRepository.save(_costumer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/costumers/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            costumerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/costumers")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            costumerRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
