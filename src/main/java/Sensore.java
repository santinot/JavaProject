package src.main.java;
import com.github.javafaker.Faker;

import java.io.Serializable;

public abstract class Sensore implements Serializable, Runnable {
    private int id;
    private String position;

    public Sensore() {
    }

    public Sensore(int id) {
        this.id = id;
        this.position = (new Faker()).address().streetAddress();
    }

    public abstract Object generaDati();

    public abstract Misurazione scriviDati(Object dato);

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void run() {
        this.scriviDati(this.generaDati());
    }
}
