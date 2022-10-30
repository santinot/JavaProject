package src.main.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.util.Date;

public abstract class Misurazione implements Serializable, Runnable {
    private final Date data;
    private Sensore sensore;

    public Misurazione() {
        this.data = new Date();
    }

    public Misurazione(Sensore sensore) {
        this();
        this.sensore = sensore;
    }

    public Date getData() {
        return data;
    }

    public Sensore getSensore() {
        return sensore;
    }

    @Override
    public void run() {
        try {
            DatagramSocket dSock = new DatagramSocket();
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
            ObjectOutputStream oos = new ObjectOutputStream(byteStream);

            oos.writeObject(this);
            DatagramPacket packet = new DatagramPacket(byteStream.toByteArray(), byteStream.toByteArray().length, InetAddress.getLocalHost(), 7788);
            dSock.send(packet);
            oos.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}