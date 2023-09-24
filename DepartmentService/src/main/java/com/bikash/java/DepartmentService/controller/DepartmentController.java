package com.bikash.java.DepartmentService.controller;

import com.bikash.java.DepartmentService.authentication.AuthRequest;
import com.bikash.java.DepartmentService.model.Department;
import com.bikash.java.DepartmentService.model.UserInfo;
import com.bikash.java.DepartmentService.service.DepartmentService;
import com.bikash.java.DepartmentService.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class DepartmentController {

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private DepartmentService service;


    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/health")
    public ResponseEntity<String> testRoute() {
       return new ResponseEntity<String>("Hello from Department Service", HttpStatus.OK);
    }

    @GetMapping("/signup")
    public ResponseEntity<String> signUp() {
        return new ResponseEntity<String>("Hello from Department Service", HttpStatus.OK);
    }


    @PostMapping("/department")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department departmentAdded = departmentService.addDepartment(department);
        return new ResponseEntity<Department>(departmentAdded, HttpStatus.CREATED);
    }

    @DeleteMapping("/department/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") int id) {
        Department departmentAdded = departmentService.findByDepartmentId(id);
        departmentService.deleteDepartment(id);
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }

    @GetMapping("/department")
    public ResponseEntity<List<Department>> getAllDepartment(@RequestBody Department department) {
        List<Department> departments = departmentService.findAllDepartments();
        return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
    }

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return service.addUser(userInfo);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }

}
