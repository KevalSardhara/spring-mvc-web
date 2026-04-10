package com.spring_mvc_springbootweb.springbootweb.controllers;

import com.spring_mvc_springbootweb.springbootweb.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/v1/employees")
public class EmployeeController {

    @GetMapping(path = "/message")
    public String getEmployeeMessage() {
        return "This is the your unique ID: 999222";
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId", required = false) Long id) {
        return new EmployeeDTO(
                id,
                "KEVAL JAMANBHAI SARDHARA",
                "kevalsardhara9@gmail.com",
                24,
                LocalDate.of(2026, 4, 10),
                true
        );
    }


    @GetMapping(path = "")
    public String getAllEmployees(@RequestParam(name = "age", defaultValue = "24", required = false) Integer inputAge,
                                  @RequestParam(required = false) Integer page_sort) {
        return new String("HI age is " + inputAge + " - " + page_sort);
    }

    @PostMapping(path = "/create")
    public EmployeeDTO createEmployees(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO);
        employeeDTO.setId(120L);
        return employeeDTO;
    }
}
