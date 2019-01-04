package model;

import java.util.ArrayList;

public class WrittenExamRegister {

    private int writtenExamNumber = 10000;
    private ArrayList<WrittenExam> writtenExamRegister = new ArrayList<>();

    public int getWrittenExamNumber() {
        return writtenExamNumber;
    }

    public void setWrittenExamNumber(int writtenExamNumber) {
        this.writtenExamNumber = writtenExamNumber;
    }

    public ArrayList<WrittenExam> getWrittenExamRegister() {
        return writtenExamRegister;
    }

    public void setWrittenExamRegister(ArrayList<WrittenExam> writtenExamRegister) {
        this.writtenExamRegister = writtenExamRegister;
    }
    public int getWrittenExamNumberAndAddOne() {
        return writtenExamNumber++;
    }
    public void add(WrittenExam writtenExam) {
        writtenExamRegister.add(writtenExam);
    }

}
