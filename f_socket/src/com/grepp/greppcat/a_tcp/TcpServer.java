package com.grepp.greppcat.a_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    
    private final int port;
    
    public TcpServer(int port) {
        this.port = port;
    }
    
    public void start(){
        System.out.println("system : 서버 실행");
        
        while(true){
            
            try(ServerSocket serverSocket = new ServerSocket(port);
                // 클라이언트의 최초 요청이 도착하면
                // 클라이언트와 1:1 통신을 하기 위한 소켓을 생성
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
            ){
            
                String request = reader.readLine();
                System.out.println(request);
            
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            
            
        }
        
    }
    
}
