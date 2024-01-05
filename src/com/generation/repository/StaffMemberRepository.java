package com.generation.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.generation.entities.Patient;
import com.generation.entities.StaffMember;

public class StaffMemberRepository {
    private Connection con;

   
    public StaffMemberRepository(Connection con)
    {
        this.con=con;
    }
    public List<StaffMember> readAll()throws Exception
    {
        return null;
    }

    public StaffMember readById(int id) throws Exception
    {
        return null;
    }

     private StaffMember _rsToStaffMember(ResultSet rs) throws Exception
    {
        return null;
    }

    private void insert(StaffMember staff)
    {

    }
    private void update(StaffMember staff)
    {

    }

    private void delete(int id)
    {

    }
}
