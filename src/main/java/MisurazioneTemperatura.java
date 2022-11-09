//Classe per la misurazione della temperatura
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

    //Metodo per formattazione stampa a video delle misurazioni
    @Override
    public String toString() {
        return super.toString() + "Temperatura: " + this.getTemperatura() + " °C" + '\n' ;
    }
}
