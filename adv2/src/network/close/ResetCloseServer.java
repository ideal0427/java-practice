package network.close;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ResetCloseServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        log("소캣 연결: " + socket);

        socket.close();
        serverSocket.close();
        log("소캣 종료");
    }

    // 서버는 소켓이 연결되면 단순히 연결 종료

}
