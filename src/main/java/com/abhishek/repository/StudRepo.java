package com.abhishek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhishek.entity.Student;
@Repository

public interface StudRepo extends JpaRepository<Student, Integer> {

}
