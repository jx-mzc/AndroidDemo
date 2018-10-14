package com.example.administrator.uichat;

public class Msg {
    public static final int TYPE_RECEIVED = 0; //表示收到的消息
    public static final int TYPE_SENT = 1;  //表示发出的消息
    private String content;  //消息内容
    private int type;   //消息类型
    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
