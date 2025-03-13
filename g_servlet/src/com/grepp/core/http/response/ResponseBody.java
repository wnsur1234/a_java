package com.grepp.core.http.response;

public class ResponseBody {

    private byte[] bytes;

    public ResponseBody() {}

    public ResponseBody addBody(byte[] bytes){
        this.bytes = bytes;
        return this;
    }

    public byte[] getBody(){
        return this.bytes;
    }
}
