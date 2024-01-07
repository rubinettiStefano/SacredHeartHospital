package com.generation.repository;

import java.sql.Connection;

import com.generation.entities.Doctor;
import com.generation.entities.Patient;
import com.generation.library.List;

public class DataBase
 {
    private DoctorRepository dRepo;
    private PatientRepository pRepo;
    private StaffMemberRepository staffRepo;
    

    public DataBase(Connection con)
    {
        this.dRepo = new DoctorRepository(con);
        this.pRepo = new PatientRepository(con);
        this.staffRepo = new StaffMemberRepository(con);
    }

    public void addPatient(Patient p) throws Exception{
        pRepo.insert(p);
    }

    public List<Doctor> printAllDoc() throws Exception {
        List<Doctor> allDocs = dRepo.readAll();
        return allDocs;
    }

    public void removeDoc(int id) throws Exception {
        pRepo.delete(pRepo.readById(id));
    }
}
