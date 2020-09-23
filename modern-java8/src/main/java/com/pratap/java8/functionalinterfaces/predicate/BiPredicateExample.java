package com.pratap.java8.functionalinterfaces.predicate;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;

import com.pratap.java8.beans.Student;
import com.pratap.java8.data.StudentDataBase;

public class BiPredicateExample {

	BiPredicate<Integer, Double> biPredicate = (gradeLevel, gpa) -> gradeLevel >= 3 && gpa >= 3.9;
	
	BiConsumer<String, List<String>> nameAndActivitiesConsumer = 
			(name, activities) -> System.out.println(name+":"+activities);
			
			List<Student> students = StudentDataBase.getAllStudents();
			
			// print name and activities of students whose gradelevel is greater or equal to 3
			
			public void printNameAndActivitiesUsingCondition() {
				students.forEach(student -> {
					if(biPredicate.test(student.getGradeLevel(), student.getGpa())) {
						nameAndActivitiesConsumer.accept(student.getName(), student.getActivities());
					}
				});
			}
	public static void main(String[] args) {

		new BiPredicateExample().printNameAndActivitiesUsingCondition();
	}

}