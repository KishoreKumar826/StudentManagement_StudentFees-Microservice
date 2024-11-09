package com.example.demo.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fees_data")
public class Studentfees {
    @Id
    private Integer student_Id;
    private Integer Grade;
    private String student_Name;
    private Integer fees;
    public Integer getStudent_Id() {
        return student_Id;
    }
    public void setStudent_Id(Integer student_Id) {
        this.student_Id = student_Id;
    }
    
    public Integer getGrade() {
        return Grade;
    }
    public void setGrade(Integer grade) {
        Grade = grade;
    }
    public String getStudent_Name() {
        return student_Name;
    }
    public void setStudent_Name(String student_Name) {
        this.student_Name = student_Name;
    }
    public Integer getFees() {
        return fees;
    }
    public void setFees(Integer fees) {
        this.fees = fees;
    }

}
