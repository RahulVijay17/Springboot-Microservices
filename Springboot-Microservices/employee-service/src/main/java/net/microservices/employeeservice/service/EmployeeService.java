package net.microservices.employeeservice.service;

import net.microservices.employeeservice.dto.ApiResponseDto;
import net.microservices.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeeById(Long employeeId);


}
