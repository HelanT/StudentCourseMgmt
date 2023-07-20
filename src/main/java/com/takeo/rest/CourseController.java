package com.takeo.rest;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.entity.Course;
import com.takeo.entity.Student;
import com.takeo.service.CourseServiceImpl;
import com.takeo.service.StudentServiceImpl;

@RestController
@RequestMapping("api/course")
public class CourseController {
	
	@Autowired
	private CourseServiceImpl service;
	
	@Autowired
    private StudentServiceImpl studentService;

    // build create User REST API
    @PostMapping("/save")
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        Course savedCourse = service.saveCourse(course);
        return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("/getByID/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer courseId){
        Course course = service.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users/list
    @GetMapping("/list")
    public ResponseEntity<List<Course>> getAllUsers(){
        List<Course>course = service.getAllCourse();
        return new ResponseEntity<>(course,HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("/update/{id}")
    // http://localhost:8080/api/users/update/1
    public ResponseEntity<Course> updateUser(@PathVariable("id") Integer courseId,
                                              @RequestBody Course course){
        course.setCid(courseId);
        Course updatedCourse = service.updateCourse(course);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Integer courseId) {
        service.deleteCourse(courseId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
    @PostMapping("/student/{cid}")
    public ResponseEntity<String> addStudentToCourse( @Valid @PathVariable Integer cid, @RequestBody Student student)
    {   //course find by id
         Course course=service.getCourseById(cid);

                if (course!=null) {
                    //insert course into student
                    student.setCourse(course);

                    course.getStudent().add(student);

                    studentService.createStudent(student);
                    return ResponseEntity.ok("Student added to the course.");
                }
                return ResponseEntity.notFound().build();
            }
	

}
