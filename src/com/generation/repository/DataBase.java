package com.generation.repository;

import java.sql.Connection;
import java.util.List;

public class DataBase
 {
    private DoctorRepository dRepo;
    private PatientRepository pRepo;
    private StaffMemberRepository staffRepo;
    

    public Database(Connection con)
    {
        this.dRepo = new DoctorRepository(con);
        this.pRepo = new PatientRepository(con);
        this.staffRepo = new StaffMemberRepository(con);
    }

    
   

}
