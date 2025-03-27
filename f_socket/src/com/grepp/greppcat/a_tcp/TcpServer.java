package com.grepp.greppcat.a_tcp;

import com.grepp.greppcat.a_tcp.domain.QrCode;
import com.grepp.greppcat.a_tcp.http.request.HttpRequest;
import com.grepp.greppcat.a_tcp.http.request.RequestParser;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
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
                
                if(request.startLine().url().equals("/favicon.ico")) {
                    writer.println("HTTP/1.1 200 OK");
                    writer.println("\n");
                    continue;
                }
                
                QrCode qrcode = new QrCode();
                qrcode.doGet(request);
                
                writer.print("HTTP/1.1 200 OK \n");
                writer.print("Content-Type: image/png \n");
                writer.print("\n");
                writer.flush();
                String filename = request.param().get("name").getFirst();
                
                try(FileInputStream fis = new FileInputStream(filename)){
                    bos.write(fis.readAllBytes());
                }
                
                bos.flush();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
