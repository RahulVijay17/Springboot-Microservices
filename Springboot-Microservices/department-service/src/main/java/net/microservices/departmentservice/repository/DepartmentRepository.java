package net.microservices.departmentservice.repository;

import net.microservices.departmentservice.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

    Department findByDepartmentCode (String departmentCode);
}
