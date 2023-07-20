package com.takeo.service;

import java.util.List;

import com.takeo.entity.Course;

public interface CourseService {
	
	public 	Course saveCourse(Course course);
	
	public Course viewCourse(Integer id);
	
	public List<Course> viewAllCourses();
	
	public Course updateCourse(Course course);
	
	public boolean deleteCourse(Integer id);
	
	

}
