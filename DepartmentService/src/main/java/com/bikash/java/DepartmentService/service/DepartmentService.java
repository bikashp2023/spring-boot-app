package com.bikash.java.DepartmentService.service;

import com.bikash.java.DepartmentService.exception.DepartmentNotFoundException;
import com.bikash.java.DepartmentService.model.Department;
import com.bikash.java.DepartmentService.model.UserInfo;
import com.bikash.java.DepartmentService.repository.DepartmentRepository;
import com.bikash.java.DepartmentService.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    private UserInfoRepository repository;

    private PasswordEncoder passwordEncoder;

    DepartmentService(DepartmentRepository departmentRepository,UserInfoRepository repository, PasswordEncoder passwordEncoder) {
        this.departmentRepository = departmentRepository;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Department> findAllDepartments() {
        return  departmentRepository.findAll();
    }

    public Department findByDepartmentId(Integer id) {
        return  departmentRepository.findById(id).orElse(null);
    }

    public  Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public  void deleteDepartment(int id) {
        Department search = departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException("Department Not found","NOT_FOUND"));
        departmentRepository.delete(search);
    }

    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
    }
}
