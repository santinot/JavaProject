//Classe per la misurazione della qualità dell'acqua
package src.main.java;

public class MisurazioneAcqua extends Misurazione{
    private final int rfc;

    public MisurazioneAcqua(int rfc) {
        this.rfc = rfc;
    }

    public MisurazioneAcqua(Sensore sensore, int rfc) {
        super(sensore);
        this.rfc = rfc;
    }

    public int getRfc() {
        return rfc;
    }

    //Metodo per formattazione stampa a video delle misurazioni
    @Override
    public String toString() {
        return super.toString() + "Residuo Fisso Calcolato Acqua : " + getRfc() + " mg/l" + '\n';
    }

}
