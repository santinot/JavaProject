package src.main.java;

import org.json.simple.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramServer {

    private static JSONObject createJson(Object o){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ID", ((Misurazione) o).getSensore().getId());
        jsonObject.put("Posizione", ((Misurazione) o).getSensore().getPosition());
        jsonObject.put("Data", ((Misurazione) o).getData().getTime());

        switch (((Misurazione) o).getSensore().getId() / 100) {
            case 1 -> jsonObject.put("Temperatura", ((MisurazioneTemperatura) o).getTemperatura());
            case 2 -> jsonObject.put("Aria", ((MisurazioneAria) o).getIqa());
            case 3 -> jsonObject.put("Acqua", ((MisurazioneAcqua) o).getRfc());
            default -> jsonObject.put("Errore", -1);
        }
        return jsonObject;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DatagramSocket dSock = new DatagramSocket(7788);
        byte[] recvBuf = new byte[5000];
        LettoreXML lettoreXML = new LettoreXML("src/main/java/MongoConfig.xml");
        GestoreDB gestoreDB = new GestoreDB(lettoreXML.getUsername(), lettoreXML.getPassword(), lettoreXML.getUrl(), lettoreXML.getName());



        while(true) {
            DatagramPacket packet = new DatagramPacket(recvBuf,recvBuf.length);
            dSock.receive(packet);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
            ObjectInputStream is = new ObjectInputStream(byteStream);
            Object o = is.readObject();

            gestoreDB.inserimento(createJson(o));
            byteStream.reset();
        }
    }
}
