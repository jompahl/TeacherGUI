package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Course {

	private StringProperty courseCode;
	private StringProperty name;
	private IntegerProperty credits;
	private ArrayList<WrittenExam> writtenExams = new ArrayList<WrittenExam>();

	//Constructor
	public Course(String courseCode, String name, int credits) {
		this.courseCode = new SimpleStringProperty(courseCode);
		this.name = new SimpleStringProperty(name);
		this.credits = new SimpleIntegerProperty(credits);
	}

	//Setters and getters
	public String getCourseCode() {
		return courseCode.get();
	}

	public StringProperty courseCodeProperty() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode.set(courseCode);
	}

	public String getName() {
		return name.get();
	}

	public StringProperty nameProperty() {
		return name;
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public int getCredits() {
		return credits.get();
	}

	public IntegerProperty creditsProperty() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits.set(credits);
	}

	public ArrayList<WrittenExam> getWrittenExams() {
		return writtenExams;
	}

	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}

	//Methods
	public void addWrittenExam(WrittenExam exam) {
		writtenExams.add(exam);
	}
	public WrittenExam removeWrittenExam(WrittenExam exam) {
		writtenExams.remove(exam);
		return exam;
	}

	/*Constructor
	public Course (String courseCode, String name, int credits) {
		this.courseCode = courseCode;
		this.name = name;
		this.credits = credits;
	}
	public Course () {

	}
	//Getters and setters
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public ArrayList<WrittenExam> getWrittenExams() {
		return writtenExams;
	}
	public void setWrittenExams(ArrayList<WrittenExam> writtenExams) {
		this.writtenExams = writtenExams;
	}*/
}
