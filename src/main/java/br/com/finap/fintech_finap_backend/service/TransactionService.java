package br.com.finap.fintech_finap_backend.service;

import br.com.finap.fintech_finap_backend.model.Transaction;
import br.com.finap.fintech_finap_backend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepositpry;

    public Transaction create(Transaction transaction) {
        return transactionRepositpry.save(transaction);
    }

    public Transaction update(Long id, Transaction transaction) {
        Transaction existingtransaction = transactionRepositpry.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));

        existingtransaction.setUser(transaction.getUser());
        existingtransaction.setGoalId(transaction.getGoalId());
        existingtransaction.setValue(transaction.getValue());
        existingtransaction.setType(transaction.getType());
        existingtransaction.setBank(transaction.getBank());
        existingtransaction.setCreatedAt(transaction.getCreatedAt());

        return transactionRepositpry.save(existingtransaction);
    }

    public List<Transaction> findAll() {
        return (List<Transaction>) transactionRepositpry.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepositpry.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public void delete(Long id) {
        transactionRepositpry.deleteById(id);
    }
}
