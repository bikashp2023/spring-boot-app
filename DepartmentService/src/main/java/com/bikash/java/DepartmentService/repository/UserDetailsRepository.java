package com.bikash.java.DepartmentService.repository;

import com.bikash.java.DepartmentService.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {

    List<UserDetails> findByEmail(String email);
}
