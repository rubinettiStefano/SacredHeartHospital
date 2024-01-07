package com.generation.entities;

import com.generation.library.List;
import static com.generation.util.DbUtil.*;

public class Doctor extends Employee {
     
     private List<String> specializations = new List<String>();
     private int salaryBonus;
     
     public List<String> getSpecializations() {
          return specializations;
     }

     public void setSpecializations(List<String> specializations) {
          this.specializations = specializations;
     }

     public void setSpecializations (String specializations){
          String[] parts = specializations.split(",");
          for(int i = 0; i<parts.length; i++)
               this.specializations.add(parts[i]);
     }

     public int getSalaryBonus() {
          return salaryBonus;
     }

     public void setSalaryBonus(int salaryBonus) {
          this.salaryBonus = salaryBonus;
     }

     private String _listToString() {
          String res = "";
          for(int i = 0; i<specializations.size();i++){
               res += specializations.get(i) + ((i == specializations.size()-1) ? "" : ",");
          }
          return res;
     }

     @Override
     public int getAnnualSalary() {
          return super.getAnnualSalary() + salaryBonus;
     }

     @Override
     public boolean isValid() {
          return super.isValid() && specializations != null && salaryBonus>0;
     }

     @Override
     public String toString() {
          return super.toString() + "Doctor [specializations=" + specializations + ", salaryBonus=" + salaryBonus + "]";
     }

     public String toInsertQuery() {
          return "INSERT INTO Doctor (name, surname, dob, monthSalary, nMonths, salaryBonus, specializations)" + 
          "VALUES ("+ toQuote(name) + "," + toQuote(surname) + ", '"+dob +"'," + 
          monthSalary + "," + nMonths + "," + salaryBonus + "," + toQuote(_listToString() +");");
     }

    public String toUpdateQuery() {
        return "UPDATE Doctor SET name= "+ toQuote(name) + ", surname=" + toQuote(surname) + ", dob='"+dob +"'," + 
          "monthSalary=" + monthSalary + ", nMonths=" + nMonths + ",salaryBonus=" + salaryBonus + ",specializations=" + toQuote(_listToString()+");");
    }

    public String toDeleteQuery(){
          return "DELETE from doctor where id="+this.id;
     
     }
     
}
