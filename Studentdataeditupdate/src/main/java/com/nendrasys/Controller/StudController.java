package com.nendrasys.Controller;
import com.nendrasys.Model.StudentList;
import com.nendrasys.Service.StudService;
import org.springframework.beans.factory.annotation.Autowired;
import com.nendrasys.Model.Studentinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller("studController")
@RequestMapping("/")
public class StudController {
    @Autowired
    StudService studService;


    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String showHome(Model model) {
        Studentinfo reg = new Studentinfo();
      /* reg.setId(1001);
        reg.setName("Ashwini");
        reg.setAge(25);*/
        model.addAttribute("reg", reg);
        return "register";
    }

    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public String saveStudentData(@ModelAttribute("reg") Studentinfo reg, Model model) {
        String resultMsg = null;
        resultMsg = studService.saveStudentData(reg);
        model.addAttribute("result", resultMsg);
        return "show";
    }

    @RequestMapping(value = "/update1/{id}", method = RequestMethod.GET)
    public String updatestudentsform(Model model, @PathVariable(value = "id") String id) {
        Integer stdid = Integer.parseInt(id);
        Studentinfo update = studService.getStudentdetailsbyid(stdid);
        model.addAttribute("update", update);
        return "updatestudents";
    }

    @RequestMapping("/updatedata")
    public String updateStudentData(@ModelAttribute("update") Studentinfo update, Model model) {
        String updatedetailsmsg = studService.updatestudentdetails(update);
        System.out.println(updatedetailsmsg);
        model.addAttribute("result1", updatedetailsmsg);
        return "updateresult";
    }
   /* @ResponseBody
    @RequestMapping(value = "/disp",produces = {"application/json"})
    public String displayall(Map<String, Object> map) throws JsonProcessingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(studService.studentdetails1());
    }*/

    @RequestMapping(value = "/disp")
    public String displaydetails(Model model) {
        List<Studentinfo> students = studService.studentdetails1();
        model.addAttribute("studentData", students);
        return "dispStudents";
    }

    @RequestMapping(value = "/display/{id}")
    public String displaydetailsbyid(Model model, @PathVariable(value = "id") String id) {
        Integer currentId = Integer.parseInt(id);
        Studentinfo students1 = (Studentinfo) studService.getStudentdetailsbyid(currentId);
        students1.getAge();
        model.addAttribute("studentinform", students1);
        return "showStudent";
    }

    @RequestMapping(value = "delete/{id}")
    public String deletestddatabyeid(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("deletebyeid", studService.deleteStudentDetails(id));
        return "deletestddata";
    }

    @ModelAttribute("countriesList")
    public List<String> countries() {
        List<String> list = new ArrayList<>();
        list.add("India");
        list.add("China");
        list.add("japan");
        list.add("italy");
        return list;
    }
    //marshling  student by id
    @RequestMapping(value = "/getXml/{id}" , produces = {"application/xml"})
    @ResponseBody
    public String getStudentXmlById(@PathVariable("id") int id) throws IOException, JAXBException {
        return studService.convertObjectToxml1(id);
    }
    // un marshalling student by id
    @RequestMapping(value = "getObj/{id}")
    @ResponseBody
    public Studentinfo getStudentObjById(@PathVariable("id") int id) throws IOException {
        String xml=studService.convertObjectToxml1(id);
        Studentinfo studentinfo=studService.converXmlToObject1(xml);
        return studentinfo;
    }
    // marshalling students list
    @RequestMapping(value = "/getStudentlist", produces = {"application/xml"})
    @ResponseBody
    public String getAllStudentsInXml() throws IOException {
        return studService.stdListInXml();
    }

// un marshaling Student list
    @RequestMapping(value = "/getStdObj")
    @ResponseBody
    public StudentList getStdListObj() throws IOException {
        String xml=studService.stdListInXml();
        StudentList studentList=studService.stdListInObj(xml);
        return studentList;
    }
}
