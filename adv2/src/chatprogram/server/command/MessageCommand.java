package chatprogram.server.command;

import chatprogram.server.Session;
import chatprogram.server.SessionManager;

public class MessageCommand implements Command {

    private final SessionManager sessionManager;

    public MessageCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) {
        String message = args[1];
        sessionManager.sendAll("[" + session.getUsername() + "] " + message);
    }

}
