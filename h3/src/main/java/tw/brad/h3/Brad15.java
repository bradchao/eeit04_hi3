package tw.brad.h3;

import java.util.List;
import java.util.Scanner;

import tw.brad.dao.SCDao;
import tw.brad.model.Course;
import tw.brad.model.Student;

public class Brad15 {
	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1 = dao.getById(1);
		if (s1 != null) {
			System.out.printf("Welcome, %s\n", s1.getSname());
			
			List<Course> courses = dao.getAllCourse();
			for (Course course : courses) {
				System.out.printf("%d. %s\n", course.getId(), course.getCname());
			}
			
			Scanner scanner = new Scanner(System.in);
			System.out.print("Which course? ");
			int cid = scanner.nextInt();
			s1.addCourse(dao.getCourseById(cid));
			
			dao.update(s1);
			
			
		}else {
			System.out.println("Student NOT FOUND");
		}
	}
}
