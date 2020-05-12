package com.nendrasys.Dao;

import com.nendrasys.Model.Studentinfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class StdDaoimpl implements StdDao {
    private static final Logger LOGGER = Logger.getLogger(StdDaoimpl.class.getName());
    private JdbcTemplate template;
    private static final String QUERY1 = "SELECT * FROM student1 WHERE id = ?";
    public JdbcTemplate getTemplate()
    {
        return template;
    }
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    @Override
    public List<Studentinfo> getStudentdetails() {
        List<Studentinfo> studentinfoArrayList = template.query("select * from student1 ", new RowMapper<Studentinfo>() {
            @Override
            public Studentinfo mapRow(ResultSet rs, int i) throws SQLException {
                Studentinfo s = new Studentinfo();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setCountry(rs.getString("country"));
                return s;
            }
        });
        return studentinfoArrayList;
    }
    @Override
    public Studentinfo getStudentdetailsbyid(int id) {
        Studentinfo studentinfo = (Studentinfo) template.queryForObject(QUERY1, new BeanPropertyRowMapper(Studentinfo.class), id);
        //System.out.println("from dao: "+studentinfo);
        return  studentinfo;
    }

    @Override
    public int saveStudentData(Studentinfo reg) {
        String query = "insert into student1(id,name,age,country) values('"+reg.getId()+"','"+reg.getName()+"','"+reg.getAge()+"','"+reg.getCountry()+"')";
        LOGGER.info(" "+query);
        return template.update(query);
    }

    @Override
    public int updatestudentdetails(Studentinfo update) {
        String query1="update student1 set name='"+update.getName()+"',age='"+update.getAge()+"',country='"+update.getCountry()+"' where id='"+update.getId()+"'";
        System.out.println(query1);
        return  template.update(query1);
    }

    @Override
    public int deleteStudentDetails(int id) {
        String querydel="delete from student1 where id="+id+"";
        return template.update(querydel);
    }

}


