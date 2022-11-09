//Classe base per le misurazioni effettuate da un sensore
package src.main.java;

import java.io.Serializable;
import java.util.Date;


public abstract class Misurazione implements Serializable {
    private final Date data;
    private Sensore sensore;

    public Misurazione() {
        this.data = new Date();
    }

    public Misurazione(Sensore sensore) {
        this();
        this.sensore = sensore;
    }

    public Date getData() {
        return data;
    }

    public Sensore getSensore() {
        return sensore;
    }

    //Metodo per formattazione stampa a video delle misurazioni
    @Override
    public String toString() {
        return "ID: " + getSensore().getId() + '\n' + "Position: " + getSensore().getPosition() + '\n' + "Time: " + this.getData() + "\n";
    }
}