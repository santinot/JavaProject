package src.main.java;
import com.github.javafaker.Faker;

import java.io.Serializable;

public abstract class Sensore implements Serializable {
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
}
