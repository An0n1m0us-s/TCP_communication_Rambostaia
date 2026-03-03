package MC_Client;

public class MainClient {
    public static void main(String[] args){
        Client client = new Client("BRIAN");
        client.connetti("localhost", 25565);
        while (true) {
            client.scrivi();
            String msgServer = client.leggi();
            if (msgServer.equalsIgnoreCase("basta")) {
                break;
            }
        }
        client.chiudi();
    }
}