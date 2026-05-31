package com.spring_mvc_springbootweb.springbootweb.controllers;

import com.spring_mvc_springbootweb.springbootweb.dto.EmployeeDTO;
import com.spring_mvc_springbootweb.springbootweb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/employees")
public class EmployeeController {
// Commented code here
    /*private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/message")
    public String getEmployeeMessage() {
        return "This is the your unique ID: 999222";
    }

//    @GetMapping(path = "/{employeeId}")
//    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId", required = false) Long id) {
//        return new EmployeeDTO(
//                id,
//                "KEVAL JAMANBHAI SARDHARA",
//                "kevalsardhara9@gmail.com",
//                24,
//                LocalDate.of(2026, 4, 10),
//                true
//        );
//    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId", required = false) Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

//    @GetMapping(path = "")
//    public String getAllEmployees(@RequestParam(name = "age", defaultValue = "24", required = false) Integer inputAge,
//                                  @RequestParam(required = false) Integer page_sort) {
//        return new String("HI age is " + inputAge + " - " + page_sort);
//    }
//
//    @PostMapping(path = "/create")
//    public EmployeeDTO createEmployees(@RequestBody EmployeeDTO employeeDTO) {
//        System.out.println(employeeDTO);
//        employeeDTO.setId(120L);
//        return employeeDTO;
//    }

    @GetMapping(path = "")
    public List<EmployeeEntity> getAllEmployees(@RequestParam(name = "age", defaultValue = "24", required = false) Integer inputAge,
                                                @RequestParam(required = false) Integer page_sort) {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/create")
    public EmployeeEntity createEmployees(@RequestBody EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }*/

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/message")
    public String getEmployeeMessage() {
        return "This is the your unique ID: 999222";
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId", required = false) Long id) {
        return employeeService.getEmployeeById(id);
    }

    public String postData(@RequestBody(required = true) String data) {
        return "Post Data";
    }

    @GetMapping(path = "/")
    public List<EmployeeDTO> getAllEmployees(@RequestParam(name = "age", defaultValue = "24", required = false) Integer inputAge,
                                             @RequestParam(required = false) Integer page_sort) {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/create")
    public EmployeeDTO createEmployees(@RequestBody @Valid EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployees(inputEmployee);
    }

//    All data update that'swhy use the put mapping
    @PutMapping(path = "{employeeId}")
    public EmployeeDTO updateEmployeeData(@RequestBody EmployeeDTO employeeDTO,
                                          @PathVariable Long employeeId) {
        return employeeService.updateEmployeeData(employeeId, employeeDTO);
    }

    @DeleteMapping
    public String deleteEmployee(@PathVariable Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
