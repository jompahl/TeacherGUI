package model;

public class Result {
	
	private double result;
	private String letterGrade;
	private Student student;
	private WrittenExam writtenExam;
	
	//Constructor
	public Result(double result, Student student, WrittenExam writtenExam) {
		this.result = result;
		this.letterGrade = calculateLetterGrade(result);
		this.student = student;
		this.writtenExam = writtenExam;
	}
	public Result() {
	}
	
	//Getters and Setters
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public WrittenExam getWritteExam() {
		return writtenExam;
	}
	public void setWritteExam(WrittenExam writteExam) {
		this.writtenExam = writteExam;
	}
	public String getLetterGrade() {
		return letterGrade;
	}
	public void setLetterGrade(String letterGrade) {
		this.letterGrade = letterGrade;
	}
	
	//Methods
	public String calculateLetterGrade(double result) {
		String grade = "Not valid score";
		
		if(result < 50 && result >= 0) {
			grade = "Fail";
		} else if(result >= 50 && result <55) {
			grade = "E";
		} else if(result >= 55 && result <65) {
			grade = "D";
		} else if(result >= 65 && result <75) {
			grade = "C";
		} else if(result >= 75 && result < 85) {
			grade = "B";
		} else if(result >= 85 && result <= 100) {
			grade= "A";
		}
		return grade;
	}
}
