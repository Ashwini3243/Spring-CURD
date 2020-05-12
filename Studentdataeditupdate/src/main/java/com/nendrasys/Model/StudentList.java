package com.nendrasys.Model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

public class StudentList implements Serializable {

    public List<Studentinfo> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Studentinfo> studentList) {
        this.studentList = studentList;
    }

    private List<Studentinfo> studentList;


}
