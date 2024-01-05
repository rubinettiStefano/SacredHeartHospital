package com.generation.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import com.generation.entities.Doctor;




public class DoctorRepository {

    private Connection con;

   
    public DoctorRepository(Connection con)
    {
        this.con=con;
    }
    
    public List<Doctor> readAll()throws Exception
    {
        return null; 
    }

    public Doctor readById(int id) throws Exception
    {
        return null;
    }

     private Doctor _rsToDoctor(ResultSet rs) throws Exception
    {
        return null;
    }

    private void insert(Doctor d)
    {

    }
    private void update(Doctor d)
    {

    }

    private void delete(int id)
    {

    }

   


}
