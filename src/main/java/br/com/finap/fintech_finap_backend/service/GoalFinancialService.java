package br.com.finap.fintech_finap_backend.service;

import br.com.finap.fintech_finap_backend.model.GoalFinancial;
import br.com.finap.fintech_finap_backend.repository.GoalFinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GoalFinancialService {

    @Autowired
    private GoalFinancialRepository repository;

    public GoalFinancial create(GoalFinancial goal) {
        return repository.save(goal);
    }

    public List<GoalFinancial> findAll() {
        Iterable<GoalFinancial> iterable = repository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }

    public Optional<GoalFinancial> findById(Long id) {
        return repository.findById(id);
    }

    public GoalFinancial update(Long id, GoalFinancial updatedGoal) {
        return repository.findById(id).map(existingGoal -> {
            existingGoal.setGoalName(updatedGoal.getGoalName());
            existingGoal.setValueTarget(updatedGoal.getValueTarget());
            existingGoal.setDateGoal(updatedGoal.getDateGoal());
            existingGoal.setCreatedAt(updatedGoal.getCreatedAt());
            existingGoal.setUser(updatedGoal.getUser());
            return repository.save(existingGoal);
        }).orElseThrow(() -> new RuntimeException("Goal not found with id " + id));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
