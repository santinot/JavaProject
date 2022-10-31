package src.main.java;


public class DatagramClient {
    public static void main(String[] args){
        SensoreTemperatura st1 = new SensoreTemperatura(100);
        SensoreAria sa1 = new SensoreAria(200);


        Thread myThread = new Thread(st1);
        Thread yourThread = new Thread(sa1);

        myThread.start();
        yourThread.start();
    }
}


