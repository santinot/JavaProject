package src.main.java;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public class SensoreTemperatura extends Sensore implements Serializable {

    public SensoreTemperatura() {
        super();
    }

    public SensoreTemperatura(int id) {
        super(id);
    }

    @Override
    public Object generaDati() {
        return ThreadLocalRandom.current().nextInt(15, 25 + 1);
    }

    @Override
    public Misurazione scriviDati(Object dato) {
        return new MisurazioneTemperatura(this, (Integer) dato);
    }
}
