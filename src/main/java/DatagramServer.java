package src.main.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramSocket dSock = new DatagramSocket(7788);

        byte[] recvBuf = new byte[5000];
        DatagramPacket packet = new DatagramPacket(recvBuf,recvBuf.length);

        while(true) {
            dSock.receive(packet);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
            ObjectInputStream is = new ObjectInputStream(byteStream);
            Object o = is.readObject();

            System.out.println(((MisurazioneTemperatura)o).getSensore().getId());
            System.out.println(((MisurazioneTemperatura)o).getSensore().getPosition());
            System.out.println(((MisurazioneTemperatura)o).getData());
            System.out.println(((MisurazioneTemperatura)o).getTemperatura());
            byteStream.reset();
        }
    }
}
