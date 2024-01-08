package spiegazione;

import com.generation.entities.Doctor;
import com.generation.entities.Employee;
import com.generation.entities.Person;

public class Spiegazione2 
{
    public static void main(String[] args) 
    {
        //IL COSTRUTTORE DETERMINA CHE TIPO DI OGGETTO ABBIAMO IN MEMORIA
        //QUEL TIPO NON POTRÀ MAIIIIIII!!1111!!!!111 CAMBIARE

        Doctor d = new Doctor();//in memoria ho un Doctor
        //IL TIPO DELL'OGGETTO IN MEMORIA, quello che viene determinato dal costruttore viene detto
        //TIPO CONCRETO
        //ma A DECIDERE quali proprietà e quali metodi posso richiamare su quell'oggetto NON è IL TIPO CONCRETO
        //ma è il TIPO DELLA VARIABILE collegata a quell'oggetto
        //il TIPO DELLA VARIABILE collegata a un oggetto viene detto TIPO FORMALE
        //ed è il modo in cui JAVA INTERPRETA un oggetto in memoria
        d.setId(1);
        d.getId();
        //Posso chiamare loro 2 perchè Doctor EXTENDS Employee EXTENDS Person
        //questi 2 metodi sono stati dichiarati in Person
        //Employee li ha ereditati
        //Doctor li ha ereditati
        d.setnMonths(13);
        d.getnMonths();
        //questi 2 metodi sono stati dichiarati in Employee
        //Doctor li ha ereditati
        d.setSalaryBonus(10000);
        d.getSalaryBonus();
        //questi 2 metodi sono stati dichiarati in Doctor

        //Ora faccio un UP-CASTING
        //cambio il modo in cui vedo l'oggetto
        Employee e =d;
        //e è collegato allo stesso dottore in memoria a cui è collegato d
        //ma non lo guarda e non lo interpreta come se fosse un dottore
        //ma come un impiegato

        //CASTING significa CAMBIARE IL TIPO FORMALE, cambiare come Java interpreta un oggetto
        //UP-CASTING perchè salgo verso l'alto nell'albero GENEALOGICO, lo vedo come qualcosa di più GENERICO
        e.setId(1);
        e.getId();
        //setId e getId sono stati dichiarati in Person, un Employee ha tutto quello che ha una Person
        //li posso usare

        e.setnMonths(13);
        e.getnMonths();
        //setnMonths e getnMonths sono dichiarati in Employee, ovviamente li posso usare
       
        
        e.setSalaryBonus(10000);
        e.getSalaryBonus();
        //setSalaryBonus e getSalaryBonus sono stati dichiarati in Doctor
        //un Doctor è un EMPLOYEE, ma un EMPLOYEE non è un Doctor
        //la Classe Employee non ha la minima idea dell'esistenza di questi metodi
        //non li ha ne dichiarati ne li ha ereditati

        //DOWN-CASTING
        //SCENDERE VERSO IL BASSO
        Doctor downCastato = (Doctor) e;
        //Sto vedendo l'oggetto collegato alla variabile e non più come un Employee ma di nuovo come un Doctor
        //Ottengo la possibilità di chiamare tutto quello che è stato dichiarato in Doctor
        downCastato.setSalaryBonus(10000);
        downCastato.getSalaryBonus();

        //Posso SEMPRE VEDERE UN Doctor COME UN Employee
        //Ma NON posso sempre vedere un Employee come un Doctor

        //TIPO FORMALE: tipo della variabile, determina quello che posso fare
        //TIPO CONCRETO: tipo dell'oggetto in memoria, determinato dal costruttore e immutabile
        //CASTING: cambio di tipo FORMALE
        //IL TIPO FORMALE CHE POSSO COLLEGARE AD UN DETERMINATO TIPO CONCRETO
        //è il TIPO CONCRETO STESSO o un qualsiasi suo SUPERTIPO
        Object      o1 =  new Doctor();
        Person      p1 =  new Doctor();
        Employee    e1 =  new Doctor();
        Doctor      d1 =  new Doctor();

        Object oCast = d1;//UPCASTING
        Doctor dCast = (Doctor) o1;//DOWNCASTING

        //PRINCIPIO DI SOSTITUZIONE DI LISKOV

    }
}
