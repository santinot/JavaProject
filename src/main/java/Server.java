package src.main.java;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(7788);
        Socket client = server.accept();

        ObjectInputStream os = new ObjectInputStream(client.getInputStream());
        Object x = os.readObject();

        System.out.println(((MisurazioneTemperatura)x).getSensore().getId());
        System.out.println(((MisurazioneTemperatura)x).getSensore().getPosition());
        System.out.println(((MisurazioneTemperatura)x).getTemperatura());
        System.out.println(((MisurazioneTemperatura)x).getData());
    }
}
