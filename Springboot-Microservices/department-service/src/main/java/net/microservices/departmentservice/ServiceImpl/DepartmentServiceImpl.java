package net.microservices.departmentservice.ServiceImpl;

import lombok.AllArgsConstructor;
import net.microservices.departmentservice.dto.DepartmentDto;
import net.microservices.departmentservice.entity.Department;
import net.microservices.departmentservice.mapper.DepartmentMapper;
import net.microservices.departmentservice.repository.DepartmentRepository;
import net.microservices.departmentservice.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //convert dto to entity
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        //entity to dto
        DepartmentDto savedDepartmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.MAPPER.mapToDepartmentDto(department);

        return departmentDto;
    }
}
