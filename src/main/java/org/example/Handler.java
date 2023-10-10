package org.example;

import java.util.logging.LogRecord;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;

 public interface Handler {
     void handle(Request request, BufferedOutputStream outputStream) throws IOException;

 }


