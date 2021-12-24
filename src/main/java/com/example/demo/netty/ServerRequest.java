package com.example.demo.netty;

/**
 * @Author: peiyanzhao
 * @DateTime: 2021/7/1 15:06
 * @Description: 服务端请求
 */
public class ServerRequest {

    private String command;

    private Object content;

    private long id;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        System.out.println("command:"+command+","+"id:"+id+","+"content:"+content);
        return super.toString();
    }
}
