package com.bikash.java.DepartmentService.repository;

import com.bikash.java.DepartmentService.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends  JpaRepository<Department, Integer> {
}
