package MC_Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientList {
    private ArrayList<Socket> socketList;
    public ClientList () {
        socketList = new ArrayList<Socket>();
    }

    public synchronized void addClient(Socket c) throws IOException {
        socketList.add(c);
    }

    public synchronized void removeClient (int i) throws IOException {
        socketList.get(i).close();
        socketList.remove(i);
    }

    public synchronized void sendAll(String message, Socket client) throws IOException{
        for (Socket socket: socketList){
            if (socket!=client) {
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(message);
                out.flush();
            }
        }
    }
}
