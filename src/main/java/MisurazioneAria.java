//Classe per la misurazione della qualità dell'aria
package src.main.java;

public class MisurazioneAria extends Misurazione{
    private final int iqa;

    public MisurazioneAria(int iqa) {
        this.iqa = iqa;
    }

    public MisurazioneAria(Sensore sensore, int iqa) {
        super(sensore);
        this.iqa = iqa;
    }

    public int getIqa() {
        return iqa;
    }

    //Metodo per formattazione stampa a video delle misurazioni
    @Override
    public String toString() {
        return super.toString() + "Indice Qualità dell'Aria: " + getIqa() + '\n';
    }
}