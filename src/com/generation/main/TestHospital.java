package com.generation.main;

import java.io.Console;

public class TestHospital {
    public static void main(String[] args) 
    {
        
        boolean goOn;
        String cmd ="";

        do
        {
            Console.print("Scrivi un commando da eseguire");
            cmd = Console.readString();
          

            switch(cmd) 
            {
                case "aggiungi paziente":     
                    Console.print(addParola());          
                break;                     

                case "stampa dottori":  
                    printAll();
                break;
                case "elimina paziente":
                    Console.print(removeOne());
                break;
                default:
                    Console.print("non abbiamo trovato il comando richiesto");
                break;
            }

            Console.print("Scrivi quit se vuoi uscire dal programma o premi invio per continuare");
            goOn = !Console.readString().equals("quit");


        }while(goOn);
    }

}
