package com.takeo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.entity.Course;

import com.takeo.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository cRepo;
	
	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		 Course saveEnt = cRepo.save(course);
			
			if(saveEnt!=null)
				return saveEnt;
			else
			return null;
		
	}

	@Override
	public Course viewCourse(Integer id) {
		// TODO Auto-generated method stub
    Optional<Course> findById =	cRepo.findById(id);
		
		Course c= findById.get();
	
	if(c!=null)
		return c;
	else
		return null;
		
	}

	@Override
	public List<Course> viewAllCourses() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
        Optional<Course> findById = cRepo.findById(course.getCid());
		
	    Course c = findById.get();
		if(c!=null)
		c=cRepo.save(c);
		
		return c;
		
		
	}

	@Override
	public boolean deleteCourse(Integer id) {
		// TODO Auto-generated method stub
		Optional<Course> findById = cRepo.findById(id);
		boolean flag=false;
		Course c = findById.get();
		if(c!=null)
		{
			cRepo.delete(c);
			return true;
		}
	      return false;
	
	}

	public Course getCourseById(Integer courseId) {
		// TODO Auto-generated method stub
		 Optional<Course> optionalCourse =cRepo.findById(courseId);
	        return optionalCourse.get();
	}

	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

}
