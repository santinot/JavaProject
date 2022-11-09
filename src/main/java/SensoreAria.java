//Classe per sensori della qualità dell'aria
package src.main.java;

import java.util.concurrent.ThreadLocalRandom;

public class SensoreAria extends Sensore{

    public SensoreAria() {}

    public SensoreAria(int id) {
        super(id);
    }

    //Metodo per generare misurazioni casuali
    @Override
    public Object generaDati() {
        return ThreadLocalRandom.current().nextInt(0, 150 + 1);
    }

    //Metodo per generare una misurazione
    @Override
    public Misurazione scriviDati(Object dato) {
        return new MisurazioneAria(this, (Integer) dato);
    }
}
