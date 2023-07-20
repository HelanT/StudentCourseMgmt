package com.takeo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.takeo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
