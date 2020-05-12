package com.nendrasys.Service;

import com.nendrasys.Dao.StdDaoimpl;
import com.nendrasys.Model.StudentList;
import com.nendrasys.Model.Studentinfo;

import java.io.IOException;
import java.util.List;

public class StudServiceImpl implements StudService {

    public OxmServices getOxmServices() {
        return oxmServices;
    }

    public void setOxmServices(OxmServices oxmServices) {
        this.oxmServices = oxmServices;
    }

    OxmServices oxmServices;

    StdDaoimpl stdDaoimpl;

    public StdDaoimpl getStdDaoimpl() {
        return stdDaoimpl;
    }

    public void setStdDaoimpl(StdDaoimpl stdDaoimpl) {
        this.stdDaoimpl = stdDaoimpl;
    }


    @Override
    public List<Studentinfo> studentdetails1() {
    return stdDaoimpl.getStudentdetails();
    }

    @Override
    public Studentinfo getStudentdetailsbyid(int id) {
        return stdDaoimpl.getStudentdetailsbyid(id);
    }

    @Override
    public String saveStudentData(Studentinfo reg) {
        int count = 0;
        count= stdDaoimpl.saveStudentData(reg);
        if(count==1){
            return "Data is Inserted successfully";
        }
        else{
            return "Data is not Inserted";
        }
    }

    @Override
    public String updatestudentdetails(Studentinfo update) {
        int count = 0;
      count= stdDaoimpl.updatestudentdetails(update);
        System.out.println(count);
        if(count==1){
            return "Data is updated successfully";
        }
        else{
            return "Data is not updated";
        }
    }

    @Override
    public int deleteStudentDetails(int id) {
        return stdDaoimpl.deleteStudentDetails(id);
    }

    //marshalling by id
    @Override
    public String convertObjectToxml1(int id) throws IOException {
        Studentinfo  s1=stdDaoimpl.getStudentdetailsbyid(id);
        return oxmServices.convertObjectToxml(s1);
    }

    //unmarshaling by id
    @Override
    public Studentinfo converXmlToObject1(String xml) throws IOException {
        return oxmServices.convertXmlToObject(xml);
    }
    // marshalling Studentlist
    @Override
    public String stdListInXml() throws IOException {
       StudentList studentList=new StudentList() ;
       studentList.setStudentList(stdDaoimpl.getStudentdetails());
        return oxmServices.studentinfoListInXml(studentList);
    }

    @Override
    public StudentList stdListInObj(String xml) throws IOException {
        return  (StudentList) oxmServices.stdListInObj(xml);
    }

}
