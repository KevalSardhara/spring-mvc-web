package com.spring_mvc_springbootweb.springbootweb.dto;

import java.time.LocalDate;

// ALway use the wraper class in the <Used in DTO/API> file because of this provide the null
//🏆 3. INDUSTRY STANDARD RULES
//✅ Rule 1: DTO → ALWAYS use Wrapper Classes
//
//Because:
//
//API may not send field
//Partial updates (PATCH)
//Null = "not provided"
//
//        ✔ Example:
//
//private Integer age;   // ✅ correct

//this is the POJO class -> Plain Old Java Object

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean isActive;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateOfJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateOfJoining = dateOfJoining;
        this.isActive = isActive;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return getEmail();
    }
}


