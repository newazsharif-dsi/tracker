package com.activity.tracker.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "activity")
public class Activity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "branch")
    private String branch;

    @Column(name = "no_of_achievements")
    private Integer noOfAchievements;

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
    @JoinColumn(name = "product_type_id", referencedColumnName = "id", nullable = true)
    private ProductType productType;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "activity_date")
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private Date activityDate;

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

    public Integer getNoOfAchievements() {
        return noOfAchievements;
    }

    public void setNoOfAchievements(Integer noOfAchievements) {
        this.noOfAchievements = noOfAchievements;
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

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }
}

