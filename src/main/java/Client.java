package src.main.java;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        SensoreTemperatura st1 = new SensoreTemperatura(1);
        MisurazioneTemperatura mt1 = (MisurazioneTemperatura) st1.scriviDati(st1.generaDati());

        try {
            Socket client = new Socket("localhost",7788);
            ObjectOutputStream x = new ObjectOutputStream(client.getOutputStream());
            x.writeObject(mt1);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}