package net.microservices.employeeservice.serviceImpl;

import lombok.AllArgsConstructor;
import net.microservices.employeeservice.dto.ApiResponseDto;
import net.microservices.employeeservice.dto.DepartmentDto;
import net.microservices.employeeservice.dto.EmployeeDto;
import net.microservices.employeeservice.entity.Employee;
import net.microservices.employeeservice.exception.ResourceNotFoundException;
import net.microservices.employeeservice.mapper.EmployeeMapper;
import net.microservices.employeeservice.repository.EmployeeRepository;
import net.microservices.employeeservice.service.ApiClient;
import net.microservices.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    //private RestTemplate restTemplate;
    //private WebClient webClient;
    private ApiClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //convert dto to entity
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);

        //entity to dto
        EmployeeDto savedDEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);


        return savedDEmployeeDto;
    }

    @Override
    public ApiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("Employee","id",employeeId));

   // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/department/" + employee.getDepartmentCode(), DepartmentDto.class);

    //  DepartmentDto departmentDto = responseEntity.getBody();

      /*DepartmentDto departmentDto =  webClient.get()
                .uri("http://localhost:8080/api/department/"+employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();*/

      DepartmentDto departmentDto =  apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        ApiResponseDto apiResponseDto = new ApiResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
