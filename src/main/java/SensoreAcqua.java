//Classe per sensori della qualità dell'acqua
package src.main.java;

import java.util.concurrent.ThreadLocalRandom;

public class SensoreAcqua extends Sensore{

    public SensoreAcqua() {}

    public SensoreAcqua(int id) {
        super(id);
    }

    //Metodo per generare misurazioni casuali
    @Override
    public Object generaDati() {
        return ThreadLocalRandom.current().nextInt(0, 1500 + 1);
    }

    //Metodo per generare una misurazione
    @Override
    public Misurazione scriviDati(Object dato) {
        return new MisurazioneAcqua(this, (Integer) dato);
    }
}
