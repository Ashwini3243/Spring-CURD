package com.nendrasys.Service;

import com.nendrasys.Model.StudentList;
import com.nendrasys.Model.Studentinfo;

import java.io.IOException;
import java.util.List;

public interface StudService {
    List<Studentinfo> studentdetails1();
    Studentinfo getStudentdetailsbyid(int id);
    String saveStudentData(Studentinfo reg);
    public String updatestudentdetails(Studentinfo update);
    public int deleteStudentDetails(int id);
    public String convertObjectToxml1(int id) throws IOException;
    public Studentinfo converXmlToObject1(String id) throws  IOException;
    public String stdListInXml() throws IOException;
    public StudentList stdListInObj(String xml) throws IOException;
}
