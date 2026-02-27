package MC_Server;

import java.io.*;
import java.net.Socket;

public class ThreadClientSocket implements Runnable {
    private Socket client;
    private BufferedReader in;
    private ClientList clientList;
    private String clientName;

    public ThreadClientSocket (Socket client, ClientList clientList) throws IOException {
        this.client = client;
        this.clientList = clientList;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }
    public void run(){}
}
