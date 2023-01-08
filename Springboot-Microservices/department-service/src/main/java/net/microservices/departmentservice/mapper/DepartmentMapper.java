package net.microservices.departmentservice.mapper;

import net.microservices.departmentservice.dto.DepartmentDto;
import net.microservices.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper  {

    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);

}
