package com.nendrasys.Service;

import com.nendrasys.Dao.StdDaoimpl;
import com.nendrasys.Model.StudentList;
import com.nendrasys.Model.Studentinfo;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

public class OxmServices {

    private Marshaller marshaller;
    StdDaoimpl stdDaoimpl;

    public Unmarshaller getUnmarshaller() {
        return unmarshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    private Unmarshaller unmarshaller;

    public StdDaoimpl getStdDaoimpl() {
        return stdDaoimpl;
    }

    public void setStdDaoimpl(StdDaoimpl stdDaoimpl) {
        this.stdDaoimpl = stdDaoimpl;
    }

    public Marshaller getMarshaller() {
        return marshaller;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public String convertObjectToxml(Studentinfo studentinfo) throws IOException {
        StringWriter stringWriter = new StringWriter();
        getMarshaller().marshal(studentinfo, new StreamResult(stringWriter));
        System.out.println("from obj to xml::"+stringWriter);
        return stringWriter.toString();
    }

    public Studentinfo convertXmlToObject(String xml) throws IOException {
        StringReader stringReader=new StringReader(xml);
        Studentinfo unmarsh= (Studentinfo) getUnmarshaller().unmarshal(new StreamSource(stringReader));
        System.out.println("from xml to obj::"+unmarsh);
        return unmarsh;
    }
    public String studentinfoListInXml(StudentList studentinfos) throws IOException {
         StringWriter stringWriter=new StringWriter();
         getMarshaller().marshal(studentinfos,new StreamResult(stringWriter));
         System.out.println("list ofobj to xml::"+stringWriter);
         return stringWriter.toString();
    }

    public StudentList stdListInObj(String xml) throws IOException {

        System.out.println(xml);
        StringReader stringReader = new StringReader(xml);
        StudentList stdunmarshal = (StudentList) getUnmarshaller().unmarshal(new StreamSource(stringReader));
       /* for (Studentinfo stud: stdunmarshal.getStudentList()) {
            System.out.println(stud.getAge());
            System.out.println(stud.getCountry());
            System.out.println(stud.getCountry());
            System.out.println(stud.getName());
        }*/
        System.out.println("student list un marshal::" + stdunmarshal);
        return stdunmarshal;
    }
}

