package MC_Server;

import java.io.*;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    protected ServerSocket serverSocket;

    protected Socket clientSocket;

    protected int porta;

    public Server(int porta){
        this.porta = porta;

        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Server in ascolto");
        }catch (BindException bindException){
            System.err.println("Porta in uso");
        }catch (IOException e) {
            System.err.println("OiBuh");
        }
    }

    int connessioni=0;

    public Socket attendi () {
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Server ha accettato");
            } catch (IOException e) {
                System.err.println("OyBho");
            }
            return clientSocket;
    }

    String messaggio;

    public void scrivi(){
        try (BufferedReader wr = new BufferedReader(new InputStreamReader(System.in))) {
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            messaggio = wr.readLine();
            printWriter.print(messaggio+"\n");
            printWriter.flush();
        }catch (IOException e){
            System.err.println("Non leggo il messaggio");
            e.printStackTrace();
        }
        System.out.println("TU (Server): "+messaggio);
    }

    public String leggi(){
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("CLIENT: "+testo);
            return testo;
        } catch (IOException e) {
            System.err.println("Non riesco a leggere il messaggio");
            return "basta";
        }
    }

    public void chiudi(){
        try {
            clientSocket.close();
            System.out.println("Connesione chiusa");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void termina(){

    }
}
