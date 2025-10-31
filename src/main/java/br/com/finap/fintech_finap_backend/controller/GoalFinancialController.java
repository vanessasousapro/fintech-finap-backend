package br.com.finap.fintech_finap_backend.controller;

import br.com.finap.fintech_finap_backend.model.GoalFinancial;
import br.com.finap.fintech_finap_backend.service.GoalFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalFinancialController {

    @Autowired
    private GoalFinancialService service;

    @PostMapping
    public ResponseEntity<GoalFinancial> create(@RequestBody GoalFinancial goal) {
        GoalFinancial created = service.create(goal);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<GoalFinancial>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoalFinancial> findById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoalFinancial> update(@PathVariable Long id, @RequestBody GoalFinancial goal) {
        try {
            GoalFinancial updated = service.update(id, goal);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
