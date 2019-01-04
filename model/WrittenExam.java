package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;
import java.util.ArrayList;

public class WrittenExam {
	
	private StringProperty examID;
	private LocalDate date;
	private StringProperty location;
	private StringProperty time;
	final private int MAXPOINTS = 100;
	private Course course;
	private StringProperty visibleCourse;
	private ArrayList<Student> students = new ArrayList<Student>();
	private ArrayList<Result> results = new ArrayList<Result>();

	//Constructors
	public WrittenExam(String examID,String location, LocalDate date,  String time, Course course) {
		this.examID = new SimpleStringProperty(examID);
		this.date = date;
		this.location = new SimpleStringProperty(location);
		this.time = new SimpleStringProperty(time);
		this.course = course;
		this.visibleCourse = new SimpleStringProperty(course.getName() + " " + course.getCourseCode());
	}

	//Getters and setters
	public String getExamID() {
		return examID.get();
	}

	public StringProperty examIDProperty() {
		return examID;
	}

	public void setExamID(String examID) {
		this.examID.set(examID);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getLocation() {
		return location.get();
	}

	public StringProperty locationProperty() {
		return location;
	}

	public void setLocation(String location) {
		this.location.set(location);
	}

	public String getTime() {
		return time.get();
	}

	public StringProperty timeProperty() {
		return time;
	}

	public void setTime(String time) {
		this.time.set(time);
	}

	public int getMAXPOINTS() {
		return MAXPOINTS;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getVisibleCourse() {
		return visibleCourse.get();
	}

	public StringProperty visibleCourseProperty() {
		return visibleCourse;
	}

	public void setVisibleCourse(String visibleCourse) {
		this.visibleCourse.set(visibleCourse);
	}
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Result> getResults() {
		return results;
	}

	public void setResults(ArrayList<Result> results) {
		this.results = results;
	}

	//Methods
	public void addStudent(Student student) {
		students.add(student);
	}
	public Student removeStudent(Student student) {
		students.remove(student);
		return student;
	}

}
