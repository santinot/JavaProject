package src.main.java;
import com.github.javafaker.Faker;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public abstract class Sensore implements Serializable, Runnable {
    private int id;
    private String position;

    public Sensore() {
    }

    public Sensore(int id) {
        this.id = id;
        this.position = (new Faker()).address().streetAddress();
    }

    public abstract Object generaDati();

    public abstract Misurazione scriviDati(Object dato);

    public int getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public void run() {
        try {
            DatagramSocket dSock = new DatagramSocket();
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
            ObjectOutputStream oos;
            while (true) {
                oos  = new ObjectOutputStream(byteStream);
                oos.writeObject(this.scriviDati(this.generaDati()));
                DatagramPacket packet = new DatagramPacket(byteStream.toByteArray(), byteStream.toByteArray().length, InetAddress.getLocalHost(), 7788);
                dSock.send(packet);
                byteStream.reset();
                oos.close();
                Thread.sleep(5000);
            }
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
