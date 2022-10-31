package src.main.java;

import java.util.concurrent.ThreadLocalRandom;

public class SensoreAcqua extends Sensore{

    public SensoreAcqua() {
    }

    public SensoreAcqua(int id) {
        super(id);
    }

    @Override
    public Object generaDati() {
        return ThreadLocalRandom.current().nextInt(0, 1500 + 1);
    }

    @Override
    public Misurazione scriviDati(Object dato) {
        return new MisurazioneAcqua(this, (Integer) dato);
    }
}
