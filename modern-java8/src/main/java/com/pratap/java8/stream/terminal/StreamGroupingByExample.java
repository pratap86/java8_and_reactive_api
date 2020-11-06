package com.pratap.java8.stream.terminal;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.pratap.java8.beans.Student;
import com.pratap.java8.data.StudentDataBase;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;

import java.util.LinkedHashMap;

public class StreamGroupingByExample {

	// use case - 1: group the students based on their gender

	public static List<Student> students = StudentDataBase.getAllStudents();

	public static Map<String, List<Student>> groupStudentsByGender() {
		return students.stream().collect(groupingBy(Student::getGender));
	}

	// use case - 2:if the gpa is 3.8 or greater than it, categorized as outstanding
	// student otherwise average student.

	public static Map<String, List<Student>> customizedGroupingBy() {
		return students.stream().collect(groupingBy(student -> student.getGpa() >= 3.8 ? "OUSTANDING" : "AVERAGE"));
	}

	// use case -3 Two level grouping.

	public static void twoLevelGroupingBy_1() {

		Map<Integer, Map<String, List<Student>>> studentMap = students.stream().collect(groupingBy(Student::getGradeLevel,
				groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE")));
		
		System.out.println(studentMap);
	}

	public static void twoLevelGroupingBy_2() {

		Map<String, Integer> StudentNoteBooksMap = students.stream().collect(groupingBy(Student::getName,
				summingInt(Student::getNoteBooks)));
		
		System.out.println(StudentNoteBooksMap);
	}
	// use case - 3
	public static void threeArgumentGroupBy() {
		
		LinkedHashMap<String, Set<Student>> studentLinkedHM = students.stream()
					.collect(groupingBy(Student::getName, LinkedHashMap::new, toSet()));
		
		System.out.println(studentLinkedHM);
	}
	public static void main(String[] args) {

		System.out.println(groupStudentsByGender());

		System.out.println(customizedGroupingBy());
		
		twoLevelGroupingBy_1();
		twoLevelGroupingBy_2();
		threeArgumentGroupBy();
	}

}
