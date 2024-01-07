package com.generation.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.generation.entities.Patient;
import com.generation.library.List;

public class PatientRepository {
    public Connection con;

   
    public PatientRepository(Connection con)
    {
        this.con=con;
    }
    public List<Patient> readAll() throws Exception {
        
        List<Patient> res = new List<Patient>();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Patient");
        
        while(rs.next()){
            res.add(_rsToPatient(rs));
       }
       s.close();
       return res;
    }

    public Patient readById(int id) throws Exception {
        
        Patient res = new Patient();
        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("SELECT * from Patient WHERE id = "+id);

        if(rs.next()){

            res = _rsToPatient(rs);
            s.close();
            return res;
        }
        s.close();
        return null;
    }

     public Patient _rsToPatient(ResultSet rs) throws Exception {
        
        Patient p = new Patient();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setSurname(rs.getString("surname"));
        p.setDob(rs.getString("dob"));
        p.setInsured(rs.getBoolean("insured"));
        p.setDiagnoses(rs.getString("diagnoses"));

        return p;

    }

    public void insert(Patient p) throws Exception {
        
        Statement s = con.createStatement();
        s.execute(p.toInsertQuery());
        s.close();
    }

    public void update(Patient p) throws Exception {
        
        Statement s = con.createStatement();
        s.execute(p.toUpdateQuery());
        s.close();
    }

    public void delete(Patient p) throws Exception {

        Statement s = con.createStatement();
        s.execute(p.toDeleteQUery());
        s.close();

    }

}
