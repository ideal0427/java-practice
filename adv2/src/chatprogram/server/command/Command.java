package chatprogram.server.command;

import chatprogram.server.Session;

import java.io.IOException;

public interface Command {

    void execute(String[] args, Session session) throws IOException;

}
