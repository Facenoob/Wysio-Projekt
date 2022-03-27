package hu.polnikadam.wysiokocsma.controller;

import java.util.ArrayList;
import java.util.List;

import hu.polnikadam.wysiokocsma.model.Costumer;
import hu.polnikadam.wysiokocsma.repository.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
