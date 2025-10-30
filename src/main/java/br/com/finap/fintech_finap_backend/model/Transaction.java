package br.com.finap.fintech_finap_backend.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "T_TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "GOAL_ID")
    private Long goalId;

    @Column(name = "VALUE", nullable = false)
    private BigDecimal value;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "BANK")
    private String bank;

    @Column(name = "CREATED_AT")
    private LocalDate createdAt;

    public Transaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", user=" + user +
                ", goalId=" + goalId +
                ", value=" + value +
                ", type='" + type + '\'' +
                ", bank='" + bank + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
