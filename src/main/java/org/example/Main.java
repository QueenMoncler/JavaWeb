package org.example;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    final static int PORT = 9999;
    final static int POOl_THREAD = 64;

    public static void main(String[] args) throws IOException {
        Server server = new Server(PORT, POOl_THREAD);
        // код инициализации сервера (из вашего предыдущего ДЗ)

        // добавление хендлеров (обработчиков)
        server.addHandler("GET", "/messages", (request, responseStream) -> {
            try {
                server.handle(responseStream, "404", "Not Found");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        server.addHandler("POST", "/messages", (request, responseStream) -> server.handle(responseStream, "503", "Service Unavailable"));

        server.addHandler("GET", "/", ((request, outputStream) -> server.defaultHandler(outputStream, "index.html")));


        server.start();
    }
}