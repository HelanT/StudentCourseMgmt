package com.takeo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.takeo.entity.Student;
import com.takeo.repo.StudentRepository;

public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    @Override
    public Student getUserById(Integer studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        return optionalStudent.get();
    }

    @Override
   public List<Student> getAllStudnet() {

        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(@NotNull Student student) {
    	
        Student existingStudent = studentRepository.findById(student.getSno()).get();
        existingStudent.setSname(student.getSname());
        existingStudent.setSadd(student.getSadd());
        existingStudent.setEmail(student.getEmail());
        
        Student updatedStudent = studentRepository.save(existingStudent);
        return updatedStudent;
    }

    @Override
    public void deleteStudent(Integer studentId) {

        studentRepository.deleteById(studentId);
    }

}
