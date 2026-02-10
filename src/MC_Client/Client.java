package MC_Client;

import java.io.*;
import java.net.Socket;

public class Client {
    private String nome;
    private String colore;
    private Socket socket;

    public Client(String nome){
        this.nome = nome;
    }

    public int connetti (String nomeServer, int portaServer){
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("Client " +nome+ ": client connesso");
        } catch (IOException e) {
            System.err.println("OiBho");
        }
        return 1;
    }

    public Client(String nome, String colore){

    }

    public void scrivi(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            String messaggino;
            printWriter.print("ciao");
            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
