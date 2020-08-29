package com.activity.tracker.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "target")
public class Target implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "no_of_targets")
    private Integer noOfTargets;

    @Column(name = "target_amount")
    private Double targetAmount;

    @Column(name = "target_date")
    private Date targetDate;

    @Column(name = "start_date")
    private Date startDate;


    @Column(name = "end_date")
    private Date endDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id", referencedColumnName = "id", nullable = true)
    private Team team;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = true)
    private Employee employee;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getNoOfTargets() {
        return noOfTargets;
    }

    public void setNoOfTargets(Integer noOfTargets) {
        this.noOfTargets = noOfTargets;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }
}
