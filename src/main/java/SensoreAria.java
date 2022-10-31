package src.main.java;

import java.util.concurrent.ThreadLocalRandom;

public class SensoreAria extends Sensore{
    public SensoreAria() {
    }

    public SensoreAria(int id) {
        super(id);
    }

    @Override
    public Object generaDati() {
        return ThreadLocalRandom.current().nextInt(0, 150 + 1);
    }

    @Override
    public Misurazione scriviDati(Object dato) {
        return new MisurazioneAria(this, (Integer) dato);
    }
}
