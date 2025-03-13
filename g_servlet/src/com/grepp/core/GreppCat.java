package com.grepp.core;


import com.grepp.core.http.error.ServletException;
import com.grepp.core.http.request.HttpRequest;
import com.grepp.core.http.response.HttpResponse;
import com.grepp.core.servlet.HandlerAdapter;
import com.grepp.core.servlet.HandlerMapper;
import com.grepp.core.servlet.RequestParser;
import com.grepp.core.servlet.Servlet;
import com.grepp.core.servlet.config.Config;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreppCat {

    private ServerSocket serverSocket;
    private HandlerMapper handlerMapper;

    public GreppCat(HandlerMapper handlerMapper) {
        try {
            serverSocket = new ServerSocket(Config.PORT);
            this.handlerMapper = handlerMapper;
            System.out.println("server start(port : " + Config.PORT + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {

        RequestParser requestParser = new RequestParser();
        HandlerAdapter handlerAdapter = new HandlerAdapter();

        while (true) {
            try (
                Socket client = serverSocket.accept();
                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
                PrintWriter writer = new PrintWriter(client.getOutputStream());
                BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
            ) {

                String line = reader.readLine();
                if (line == null) {
                    continue;
                }

                HttpRequest request = requestParser.parseRequest(line, reader);
                Servlet servlet = handlerMapper.getHandler(request.startLine().url());

                if (servlet == null) {
                    writer.print("http/1.1 404 Not Found \n");
                    writer.flush();
                    continue;
                }

                HttpResponse response = handlerAdapter.handle(servlet, request);

                writer.print(response.startLine());
                writer.print(response.header());
                writer.flush();
                bos.write(response.body().getBody());
                bos.flush();
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}