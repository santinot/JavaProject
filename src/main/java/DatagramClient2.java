package src.main.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramClient2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        SensoreTemperatura st1 = new SensoreTemperatura(2);
        MisurazioneTemperatura mt1 = (MisurazioneTemperatura) st1.scriviDati(st1.generaDati());

        DatagramSocket dSock = new DatagramSocket(7787);
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
        ObjectOutputStream oos = new ObjectOutputStream(byteStream);

        while (true) {
            Thread.sleep(1000);
            oos.writeObject(mt1);
            DatagramPacket packet = new DatagramPacket(byteStream.toByteArray(), byteStream.toByteArray().length, InetAddress.getLocalHost(), 7788);
            dSock.send(packet);
            oos.flush();
            byteStream.flush();
        }
    }
}
