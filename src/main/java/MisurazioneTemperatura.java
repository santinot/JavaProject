package src.main.java;


public class MisurazioneTemperatura extends Misurazione{
    private final int temperatura;

    public MisurazioneTemperatura(int t) {
        super();
        this.temperatura = t;
    }

    public MisurazioneTemperatura(Sensore sensore, int t) {
        super(sensore);
        this.temperatura = t;
    }

    public int getTemperatura() {
        return temperatura;
    }
}
