package com.generation.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.generation.entities.Doctor;
import com.generation.library.List;


public class DoctorRepository {

    public Connection con;


    public DoctorRepository(Connection con)
    {
        this.con=con;
    }
    
    public List<Doctor> readAll()throws Exception
    {
        List<Doctor> res = new List<Doctor>();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Doctor");

        while(rs.next())
            res.add(_rsToDoctor(rs));
        
        s.close();
        return res;
    }

    public Doctor readById(int id) throws Exception
    {
        Doctor res = new Doctor();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Doctor WHERE id = "+id);

        if(rs.next()){
            res = _rsToDoctor(rs);
            s.close();
            return res;
        }
        s.close();
        return null;
    }

     public Doctor _rsToDoctor(ResultSet rs) throws Exception
    {
        Doctor d = new Doctor();
        d.setId(rs.getInt("id"));
        d.setName(rs.getString("name"));
        d.setSurname(rs.getString("surname"));
        d.setDob(rs.getString("dob"));
        d.setMonthSalary(rs.getInt("monthSalary"));
        d.setnMonths(rs.getInt("nMonths"));
        d.setSalaryBonus(rs.getInt("salaryBonus"));
        d.setSpecializations(rs.getString("specializations"));

        return d;

    }

    public void insert(Doctor d) throws Exception {
        
        Statement s = con.createStatement();
        s.execute(d.toInsertQuery());
        s.close();
    }

    public void update(Doctor d) throws Exception {
        
        Statement s = con.createStatement();
        s.execute(d.toUpdateQuery());
        s.close();
    }

    public void delete(Doctor d) throws Exception{
        
        Statement s = con.createStatement();
        s.execute(d.toDeleteQuery());
        s.close();

    }
    

}
