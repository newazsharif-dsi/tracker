package com.activity.tracker.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "activity")
public class Activity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "branch")
    private String branch;

    @Column(name = "no_of_achievements")
    private Integer noOfAchievement;

    @Column(name = "achievement_amount")
    private Double achievementAmount;

    @Column(name = "total_achievement")
    private Double totalAchievement;

    @Column(name = "referral_id")
    private String referralId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = true)
    private Employee employee;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "activity_type_id", referencedColumnName = "id", nullable = true)
    private ActivityType activityType;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loan_type_id", referencedColumnName = "id", nullable = true)
    private LoanType loanType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sales_type_id", referencedColumnName = "id", nullable = true)
    private SalesType salesType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Integer getNoOfAchievement() {
        return noOfAchievement;
    }

    public void setNoOfAchievement(Integer noOfAchievement) {
        this.noOfAchievement = noOfAchievement;
    }

    public Double getAchievementAmount() {
        return achievementAmount;
    }

    public void setAchievementAmount(Double achievementAmount) {
        this.achievementAmount = achievementAmount;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public SalesType getSalesType() {
        return salesType;
    }

    public void setSalesType(SalesType salesType) {
        this.salesType = salesType;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getTotalAchievement() {
        return totalAchievement;
    }

    public void setTotalAchievement(Double totalAchievement) {
        this.totalAchievement = totalAchievement;
    }
}

