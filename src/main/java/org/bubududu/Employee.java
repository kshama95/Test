package org.bubududu;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
@Entity
public class Employee {
    @Id
    @GeneratedValue
    int EmployeeID;
    String employeeName;
    Date EmploymentStartDate;
    String jobStatusCode;
    Employee(int EmployeeID, String employeeName, Date EmploymentStartDate, String jobStatusCode){
        this.EmployeeID=EmployeeID;
        this.employeeName= employeeName;
        this.EmploymentStartDate=EmploymentStartDate;
        this.jobStatusCode= jobStatusCode;

    }

public int getEmployeeID() {
    return EmployeeID;
}
public String getEmployeeName() {
    return employeeName;
}
public Date getEmploymentStartDate() {
    return EmploymentStartDate;
}
public String getJobStatusCode() {
    return jobStatusCode;
    }
    public Employee(){

    }
}