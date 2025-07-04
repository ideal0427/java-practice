package chatprogram;

import chatprogram.server.CommandManager;
import chatprogram.server.Server;
import chatprogram.server.SessionManager;

import java.io.IOException;

public class ServerMain {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommandManager commandManager = new CommandManager(sessionManager);

        Server server = new Server(PORT, commandManager, sessionManager);
        server.start();
    }

}
