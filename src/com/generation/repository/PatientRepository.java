package com.generation.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.generation.entities.Doctor;
import com.generation.entities.Patient;

public class PatientRepository {
    private Connection con;

   
    public PatientRepository(Connection con)
    {
        this.con=con;
    }
    public List<Patient> readAll()throws Exception
    {
       return null;
    }

    public Patient readById(int id) throws Exception
    {
        return null;
    }

     private Patient _rsToPatient(ResultSet rs) throws Exception
    {
       return null;
    }

    private void insert(Patient p)
    {

    }
    private void update(Patient p)
    {

    }

    private void delete(int id)
    {

    }

}
