package net.microservices.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.microservices.departmentservice.dto.DepartmentDto;
import net.microservices.departmentservice.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("departmentCode") String departmentCode){
      DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
      return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }

}
