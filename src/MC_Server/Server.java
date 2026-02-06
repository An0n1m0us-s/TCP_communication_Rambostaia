package MC_Server;

import java.io.IOException;
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

    public Socket attendi(){
        try {
            clientSocket  = serverSocket.accept();
            System.out.println("Server ha accettato");
        } catch (IOException e) {
            System.err.println("OyBho");
        }finally {
            return clientSocket;
        }
    }

    public void scrivi(){

    }

    public void leggi(){

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
