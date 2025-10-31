package br.com.finap.fintech_finap_backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_GOAL_FINANCIAL")
public class GoalFinancial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_GOAL")
    @SequenceGenerator(name = "SQ_GOAL", sequenceName = "SQ_GOAL", allocationSize = 1)
    @Column(name = "GOAL_ID")
    private Long goalId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @Column(name = "GOAL_NAME", length = 100, nullable = false)
    private String goalName;

    @Column(name = "VALUE_TARGET", precision = 10, scale = 2, nullable = false)
    private Double valueTarget;

    @Column(name = "DATE_GOAL")
    private LocalDate dateGoal;

    @Column(name = "CREATED_AT")
    private LocalDate createdAt;

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Double getValueTarget() {
        return valueTarget;
    }

    public void setValueTarget(Double valueTarget) {
        this.valueTarget = valueTarget;
    }

    public LocalDate getDateGoal() {
        return dateGoal;
    }

    public void setDateGoal(LocalDate dateGoal) {
        this.dateGoal = dateGoal;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
