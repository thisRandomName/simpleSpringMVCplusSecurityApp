/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj.crudspringmvcplussecurity.controllers;


import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proj.crudspringmvcplussecurity.model.Course;
import proj.crudspringmvcplussecurity.service.CourseService;


@Controller
@RequestMapping("/")
public class CourseController {
        @Autowired
	CourseService service;
	
	@Autowired
	MessageSource messageSource;

	/*
	 * List all existing courses
	 */
	@RequestMapping(value = { "/teacher/courselist" }, method = RequestMethod.GET)
	public String listCourses(ModelMap model) {

		List<Course> courses = service.findAllCourses();
		model.addAttribute("courses", courses);
		return "courselist";
	}
        
        /*
	 * List all existing courses
	 */
	@RequestMapping(value = { "/home/listofcourses" }, method = RequestMethod.GET)
	public String listofCourses(ModelMap model) {

		List<Course> courses = service.findAllCourses();
		model.addAttribute("courses", courses);
		return "listofcourses";
	}

	/*
	 * Add a new course.
	 */
	@RequestMapping(value = { "/newcourse" }, method = RequestMethod.GET)
	public String newCourse(ModelMap model) {
		Course course = new Course();
		model.addAttribute("course",course);
		model.addAttribute("edit", false);
		return "registercourse";
	}

	/*
	 * Handling POST request for validating the user input and saving course in database.
	 */
	@RequestMapping(value = { "/newcourse" }, method = RequestMethod.POST)
	public String saveCourse(@Valid Course course, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registercourse";
		}
		

		
		service.saveCourse(course);

		model.addAttribute("success", "Course " + course.getCourse() + " registered successfully");
		return "success";
	}


	/*
	 * Provide the existing course for updating.
	 */
	@RequestMapping(value = { "/edit-{id}-course" }, method = RequestMethod.GET)
	public String editCourse(@PathVariable int id, ModelMap model) {
		Course course = service.findCourseById(id);
		model.addAttribute("course",course);
		model.addAttribute("edit", true);
		return "registercourse";
	}
	
	/*
	 * Handling POST request for validating the user input and updating course in database.
	 */
	@RequestMapping(value = { "/edit-{id}-course" }, method = RequestMethod.POST)
	public String updateCourse(@Valid Course course, BindingResult result,
			ModelMap model, @PathVariable int id) {

		if (result.hasErrors()) {
			return "registercourse";
		}

		

		service.updateCourse(course);

		model.addAttribute("success", "Course " + course.getCourse()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * Delete a course by it's id value.
	 */
	@RequestMapping(value = { "/delete-{id}-course" }, method = RequestMethod.GET)
	public String deleteCourse(@PathVariable int id) {
		service.deleteCourseById(id);
		return "redirect:/teacher/courselist";
	}

    
    
}
