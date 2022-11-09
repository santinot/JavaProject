//Classe Client UDP
package src.main.java;

public class DatagramClient {
    public static void main(String[] args){
        SensoreTemperatura st1 = new SensoreTemperatura(100);
        SensoreAria sa1 = new SensoreAria(200);
        SensoreAcqua sq1 = new SensoreAcqua(300);

        //Creazione dei thread per ogni sensore
        Thread sensore1 = new Thread(st1);
        Thread sensore2 = new Thread(sa1);
        Thread sensore3 = new Thread(sq1);

        //Avvio dei thread
        sensore1.start();
        sensore2.start();
        sensore3.start();
    }
}


