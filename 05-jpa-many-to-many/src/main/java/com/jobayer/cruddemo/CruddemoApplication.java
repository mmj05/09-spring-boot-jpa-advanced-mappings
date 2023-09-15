package com.jobayer.cruddemo;

import com.jobayer.cruddemo.dao.AppDAO;
import com.jobayer.cruddemo.entity.Course;
import com.jobayer.cruddemo.entity.Instructor;
import com.jobayer.cruddemo.entity.InstructorDetail;
import com.jobayer.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			
			createCourseAndStudents(appDAO);
		};
	}

	private void createCourseAndStudents(AppDAO appDAO) {
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		appDAO.deleteCourseById(theId);
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		// get the course and reviews
		int theId = 10;

		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);

		System.out.println(tempCourse.getReviews());

		// print the course

		// print the reviews
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course tempCourse = new Course("Art of Living");

		tempCourse.addReview(new Review("Great Course"));
		tempCourse.addReview(new Review("Could be better"));
		tempCourse.addReview(new Review("Thanks for this course"));

		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		appDAO.deleteCourseById(theId);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		Course tempCourse = appDAO.findCourseById(theId);

		tempCourse.setTitle("Enjoy Java");

		appDAO.update(tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		tempInstructor.setLastName("Tester");

		appDAO.update(tempInstructor);

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 1;

		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println(tempInstructor);

		System.out.println(tempInstructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		//System.out.println("Finding instructor id: " + theId);

		//Instructor tempInstructor = appDAO.findInstructorById(theId);

		//System.out.println(tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//tempInstructor.setCourses(courses);

		///System.out.println(tempInstructor.getCourses());

		System.out.println(courses);


	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv2code.com/youtube", "Luv 2 code!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Java - The Ultimate Guide");
		Course tempCourse2 = new Course("Python - The Ultimate Guide");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 5;

		appDAO.deleteInstructorDetailById(theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;

		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println(tempInstructorDetail);
		System.out.println(tempInstructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println(tempInstructor);
		System.out.println(tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("luv2code.com/youtube", "Luv 2 code!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		appDAO.save(tempInstructor);
	}

}
