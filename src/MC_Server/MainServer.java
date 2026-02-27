package MC_Server;

public class MainServer {
    public static void main(String[] args) {
        Server server = new Server(25565);
        server.attendi();
        while (true) {
            server.leggi();
            server.scrivi();
        }
        //server.chiudi();
    }
}