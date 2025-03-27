package com.grepp.greppcat.a_tcp;

import com.grepp.greppcat.a_tcp.http.request.HttpRequest;
import com.grepp.greppcat.a_tcp.http.request.RequestParser;
import com.grepp.greppcat.a_tcp.http.response.HttpResponse;
import com.grepp.greppcat.a_tcp.servlet.HandlerAdapter;
import com.grepp.greppcat.a_tcp.servlet.HandlerMapping;
import com.grepp.greppcat.a_tcp.servlet.Servlet;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    
    private final int port;
    private ServerSocket serverSocket;
    
    public TcpServer(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void start(){
        System.out.println("system : 서버 실행");
        HandlerMapping mapper = new HandlerMapping();
        HandlerAdapter adapter = new HandlerAdapter();
        
        // http server 특징 stateless
        // 클라이언트의 상태를 저장하지 않는다.
        while(true){
            try(
                // 클라이언트의 최초 요청이 도착하면
                // 클라이언트와 1:1 통신을 하기 위한 소켓을 생성
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            ){
            
                String startLine = reader.readLine();
                if(startLine == null) continue;
                
                HttpRequest request = new RequestParser().parse(startLine, reader);
                Servlet servlet = mapper.getHandler(request);
                HttpResponse response = adapter.handle(request, servlet);
                
                sendResponseHeader(response, writer);
                sendResponseBody(response, bos);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    private void sendResponseBody(HttpResponse response, BufferedOutputStream bos)
        throws IOException {
        bos.write(response.body().getBody());
        bos.flush();
    }
    
    private void sendResponseHeader(HttpResponse response, PrintWriter writer) {
        writer.print(response.startLine());
        writer.print(response.httpHeader());
        writer.flush();
    }
}
