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

    String messaggio;

    public void scrivi(){
        try (BufferedReader wr = new BufferedReader(new InputStreamReader(System.in))){
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            messaggio = wr.readLine();
            printWriter.print(messaggio+"\n");
            printWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("TU (Client): "+messaggio);
    }

    public String leggi() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("SERVER: "+testo);
            return testo;
        } catch (IOException e) {
            System.err.println("Non riesco a leggere il messaggio");
            return "basta";
        }
    }


}
