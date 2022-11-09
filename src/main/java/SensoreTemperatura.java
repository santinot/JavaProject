//Classe per sensori della temperatura
package src.main.java;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class SensoreTemperatura extends Sensore implements Serializable, Runnable {

    public SensoreTemperatura() {}

    public SensoreTemperatura(int id) {
        super(id);
    }

    //Metodo per generare misurazioni casuali
    @Override
    public Object generaDati() {
        return ThreadLocalRandom.current().nextInt(15, 25 + 1);
    }

    //Metodo per generare una misurazione
    @Override
    public Misurazione scriviDati(Object dato) {
        return new MisurazioneTemperatura(this, (Integer) dato);
    }

}
