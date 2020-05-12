package com.nendrasys.Dao;

import com.nendrasys.Model.Studentinfo;

import java.util.List;

public interface StdDao {
    List<Studentinfo> getStudentdetails();
    Studentinfo getStudentdetailsbyid(int id);
    public int saveStudentData(Studentinfo reg);
    public int updatestudentdetails(Studentinfo update);
    public int deleteStudentDetails(int id);
}
