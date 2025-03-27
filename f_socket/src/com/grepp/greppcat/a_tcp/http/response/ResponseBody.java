package com.grepp.greppcat.a_tcp.http.response;

public class ResponseBody {

    private byte[] body;
    
    public ResponseBody() {
        this.body = new byte[0];
    }
    
    public void addBody(byte[] bytes){
        this.body = bytes;
    }
    
    public byte[] getBody() {
        return body;
    }
}
