package com.generation.main;

import static com.generation.library.Console.*;

import java.sql.Connection;

import com.generation.entities.Doctor;
import com.generation.entities.Patient;
import com.generation.repository.DataBase;
import com.generation.util.DbUtil;

public class TestHospital {
    
    public static void main(String[] args) throws Exception 
    {
        Connection con = DbUtil.connectToDB("SacredHeartHospital");
        DataBase db = new DataBase(con);

        boolean goOn;
        String cmd ="";

        do
        {
            print("Scrivi un commando da eseguire");
            cmd = readString();
            String toPrint = "";

            switch(cmd) 
            {
                case "aggiungi paziente":     
                    db.addPatient(askPatient());
                    toPrint = "Paziente agguinto con successo!";
                break;                     

                case "stampa dottori":  
                    for(Doctor d : db.printAllDoc())
                        print(d);
                break;

                case "elimina paziente":
                    print("Inserisci l'id del paziente che vuoi eliminare: ");
                    removeOne(db,readInt());
                    toPrint = "Paziente eliminato con successo!";
                break;
                default:
                    print("non abbiamo trovato il comando richiesto");
                break;
            }

            print(toPrint);
            print("Scrivi quit se vuoi uscire dal programma o premi invio per continuare");
            goOn = !readString().equals("quit");


        }while(goOn);
    }

    private static Patient askPatient() {
        
        Patient p = new Patient();
        print("Digita il nome del paziente che vuoi aggiungere: ");
        p.setName(readString());
        print("Digita il cognome del paziente che vuoi aggiungere: ");
        p.setSurname(readString());
        print("Digita la data di nascita del paziente che vuoi aggiungere: ");
        p.setDob(readString());
        print("Il paziente è assicurato? Y/N");
        p.setInsured(false);
        // if(readString().toUpperCase()=="Y")
        //      p.setInsured(true);
        switch(readString().toUpperCase()) {
            case "Y":
                p.setInsured(true);
            break;
            case "N":
                p.setInsured(false);
            break;
            default:
                print("Per favore, inserisci un valore valido ('y' o 'n')");
            break;
        }
        boolean goOn = true;
        
        do {
            
            print("Vuoi agguingere una diagnosi? (Y/N)");
            switch (readString().toUpperCase()) {
                
                case "Y":
                    print("Che diagnosi vuoi aggiungere?");
                    p.setDiagnoses(readString()+",");
                break;

                case "N":
                    print("Termino l'operazione");
                    goOn = false;
                break;
                
                default:
                    print("Per favore, inserisci un valore valido ('y' o 'n')");
                break;
            }
            
        } while(goOn);

        return p;
    }

    private static void removeOne(DataBase db, int id) throws Exception {
        db.removeDoc(id);
    }

}
