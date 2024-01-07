package com.generation.entities;

public abstract class Employee extends Person {
    
    protected int monthSalary;
    protected int nMonths;
    
    public int getMonthSalary() {
        return monthSalary;
    }
    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }
    public int getnMonths() {
        return nMonths;
    }
    public void setnMonths(int nMonths) {
        this.nMonths = nMonths;
    }

    public int getAnnualSalary() {
        return monthSalary*nMonths;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Employee [monthSalary=" + monthSalary + ", nMonths=" + nMonths + "]";
    }

    @Override
    public boolean isValid(){
        return super.isValid() && monthSalary > 0 && nMonths > 0;
    }
    
}
