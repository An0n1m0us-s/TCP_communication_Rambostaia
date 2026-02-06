package MC_Server;

import java.net.ServerSocket;

public class MainServer{
    public static void main (String[] args){
        Server server = new Server(25565);
        server.attendi();
    }
}