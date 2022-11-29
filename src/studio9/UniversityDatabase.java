package studio9;

import assignment7.Student;

import java.util.HashMap;
import java.util.Map;

public class UniversityDatabase {
	//TODO: Complete this class according to the studio instructions

	private final Map<String,Student> map;

	public UniversityDatabase() {
		this.map = new HashMap<String, Student>();
	}


	public void addStudent(String accountName, Student student) {
		map.put(accountName, student);
	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		Student stud = map.get(accountName);
		if (stud== null) {
			return null;
		}
		else {
			return stud.getFullName();
		}
	}

	public double getTotalBearBucks() {
		int tot = 0;

		for(Student stu:map.values()) {
			tot += stu.getBearBucksBalance();
		}
		return tot;
	}

}
