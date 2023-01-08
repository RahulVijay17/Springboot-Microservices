package net.microservices.employeeservice.service;

import net.microservices.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080",value = "DEPARTMENT-SERVICE")
public interface ApiClient {

    @GetMapping("api/department/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable("departmentCode") String departmentCode);

    }