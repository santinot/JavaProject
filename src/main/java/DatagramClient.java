package src.main.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        SensoreTemperatura st1 = new SensoreTemperatura(1);
        MisurazioneTemperatura mt1 = (MisurazioneTemperatura) st1.scriviDati(st1.generaDati());

        SensoreTemperatura st2 = new SensoreTemperatura(2);
        MisurazioneTemperatura mt2 = (MisurazioneTemperatura) st2.scriviDati(st2.generaDati());

        while(true){

            mt1.run();

            Thread.sleep(1000);
            }
        }
    }


