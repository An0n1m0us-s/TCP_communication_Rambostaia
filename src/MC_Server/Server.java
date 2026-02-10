package MC_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        while (true){
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Server ha accettato");
            } catch (IOException e) {
                System.err.println("OyBho");
            } finally {
                connessioni++;
                if (connessioni==5) {
                    return clientSocket;
                }
            }
        }
    }

    public void scrivi(){

    }

    public void leggi(){
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("CLIENT: "+testo);
        } catch (IOException e) {
            System.err.println("Non riesco a leggere il messaggio");
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
