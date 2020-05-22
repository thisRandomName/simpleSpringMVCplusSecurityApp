package proj.crudspringmvcplussecurity.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import proj.crudspringmvcplussecurity.dao.CourseDao;
import proj.crudspringmvcplussecurity.model.Course;


@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao dao;
	
	public Course findById(int id) {
		return dao.findById(id);
	}

	public void saveCourse(Course course) {
		dao.saveCourse(course);
	}
	
	public void updateCourse(Course course) {
		Course entity = dao.findById(course.getId());
		if(entity!=null){
			entity.setCourse(course.getCourse());
			entity.setCourseLevel(course.getCourseLevel());
			
			//dao.saveOrUpdate(course);
		}
	}

	public void deleteCourseById(int id) {
		dao.deleteCourseById(id);
	}
	
	public List<Course> findAllCourses() {
		return dao.findAllCourses();
	}

	public Course findCourseById(int id) {
		return dao.findCourseById(id);
	}

	
    
    
}
