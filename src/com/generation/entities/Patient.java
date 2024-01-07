package com.generation.entities;

import static com.generation.util.DbUtil.toQuote;

import com.generation.library.List;

public class Patient extends Person {
    
    private List<String> diagnoses = new List<String>();
    private boolean insured;

    
    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setDiagnoses(String diagnoses){
        String[] parts = diagnoses.split(",");
        for(int i = 0; i<parts.length;i++){
            this.diagnoses.add(parts[i]);
        }
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public boolean isHealthy(){
        return diagnoses.isEmpty();
    }

    @Override
    public boolean isValid() {
        return super.isValid() && diagnoses!=null;
    }

    @Override
    public String toString() {
        return super.toString() + "Patient [diagnoses=" + diagnoses + ", insured=" + insured + "]";
    }

    public String toInsertQuery() {
        return "INSERT INTO Patient (name, surname, dob, insured, diagnoses)"+
        "VALUES (" + toQuote(name) + ", " + toQuote(surname) + ", " + toQuote(dob+"") +
        ", " + insured + ", " + toQuote(_listToString())+");";
    }

    public String toUpdateQuery() {
        return "UPDATE patient set name = " + toQuote(name) + ",surname =" + toQuote(surname) + ", dob =" + toQuote(dob+"") +
        ", insured =" + insured + ", diagoses = " + toQuote(_listToString())+");";
    }

    private String _listToString () {
        
        String res = "";
        for(int i = 0;i<diagnoses.size();i++){
            res += diagnoses.get(i) + ((i == diagnoses.size()-1) ? "" : ",");
        }

        return res;
    }

    public String toDeleteQUery() {
        
        return "DELETE from patient where id = "+ this.id;

    }


}
