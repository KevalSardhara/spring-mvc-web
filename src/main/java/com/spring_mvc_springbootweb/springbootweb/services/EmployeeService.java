package com.spring_mvc_springbootweb.springbootweb.services;

import com.spring_mvc_springbootweb.springbootweb.dto.EmployeeDTO;
import com.spring_mvc_springbootweb.springbootweb.entities.EmployeeEntity;
import com.spring_mvc_springbootweb.springbootweb.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployees(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

//    ✔ Best Practice (Industry Standard)
//    public EmployeeDTO updateEmployeeData(Long employeeId, EmployeeDTO employeeDTO) {
//
//        EmployeeEntity existingEmployee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        // Update fields manually (recommended)
//        existingEmployee.setName(employeeDTO.getName());
//        existingEmployee.setEmail(employeeDTO.getEmail());
//        existingEmployee.setAge(employeeDTO.getAge());
//        existingEmployee.setDateOfJoining(employeeDTO.getDateOfJoining());
//        existingEmployee.setIsActive(employeeDTO.getIsActive());
//
//        EmployeeEntity savedEmployee = employeeRepository.save(existingEmployee);
//
//        return modelMapper.map(savedEmployee, EmployeeDTO.class);
//    }

    /*
        One Extra Tip
        Since you're using @GeneratedValue(strategy = GenerationType.AUTO), calling save() with an existing ID will trigger an UPDATE (not INSERT) because JPA checks — if the ID already exists in the DB, it merges/updates. This is the correct behaviour for an update operation, so you're good.
    */
    public EmployeeDTO updateEmployeeData(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        employeeEntity.setId(employeeId);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public String deleteEmployee(Long employeeId) {
        try{
            employeeRepository.deleteById(employeeId);
            return "Employee with id " + employeeId + " deleted";
        } catch (Exception err) {
            return "Employee with id " + employeeId + " not deleted" + err;

        }
    }
}
