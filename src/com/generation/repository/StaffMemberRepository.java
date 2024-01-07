package com.generation.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.generation.entities.StaffMember;
import com.generation.library.List;

public class StaffMemberRepository {
    
    private Connection con;

    public StaffMemberRepository(Connection con) {
        
        this.con=con;
    }

    public List<StaffMember> readAll() throws Exception {
        
        List <StaffMember> staffMembers = new List <StaffMember>();

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("READ * FROM StaffMember;");
        
        while(rs.next()) {
            staffMembers.add(_rsToStaffMember(rs));
        }

        s.close();
        return staffMembers;
    }

    public StaffMember readById(int id) throws Exception {
        
        StaffMember sM = new StaffMember();

        Statement s = con.createStatement();
        ResultSet rs = s.executeQuery("READ * FROM StaffMember WHERE id = "+id);

        if(rs.next()){
            sM = _rsToStaffMember(rs);
            s.close();
        }

        s.close();
        return null;
    }

     private StaffMember _rsToStaffMember(ResultSet rs) throws Exception {
        
        StaffMember sM = new StaffMember();
        sM.setId(rs.getInt("id"));
        sM.setName(rs.getString("name"));
        sM.setDob(rs.getString("dob"));
        sM.setMonthSalary(rs.getInt("monthSalary"));
        sM.setnMonths(rs.getInt("nMonths"));
        sM.setRole(rs.getString("role"));
        sM.setEmail(rs.getString("email"));
        sM.setDeparment(rs.getString("deparment"));
        
        return sM;
    }

    private void insert(StaffMember staff) throws Exception {

        Statement s = con.createStatement();
        s.execute(staff.toInsertQuery());
        s.close();
    }
    
    private void update(StaffMember staff) throws Exception {

        Statement s = con.createStatement();
        s.execute(staff.toUpdateQuery());
        s.close();
    }

    private void delete(StaffMember staff) throws Exception {

        Statement s = con.createStatement();
        s.execute(staff.toDeleteQuery());
        s.close();
    }
}
