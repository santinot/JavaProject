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

        while(true) {
            DatagramPacket packet = new DatagramPacket(recvBuf,recvBuf.length);
            dSock.receive(packet);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
            ObjectInputStream is = new ObjectInputStream(byteStream);
            Object o = is.readObject();

            System.out.println(o);
            byteStream.reset();
        }
    }
}
