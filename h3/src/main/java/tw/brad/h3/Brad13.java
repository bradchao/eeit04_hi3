package tw.brad.h3;

import tw.brad.dao.SCDao;
import tw.brad.model.Student;

public class Brad13 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1 = new Student("Brad");
		Student s2 = new Student("Andy");
		Student s3 = new Student("Eric");
		Student s4 = new Student("Mark");
		Student s5 = new Student("John");
		
		dao.add(s1);dao.add(s2);
		dao.add(s3);dao.add(s4);
		dao.add(s5);
		
		
		
		
		
	}

}
