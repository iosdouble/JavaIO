package com.nihui.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName SocketServerTest
 * @Description TODO
 * @Author nihui-ds
 * @Date 2020/6/20 21:34
 * @Version 1.1
 **/
public class SocketServerTest {
    public static String _pattern = "yyyy-MM-dd HH:mm:ss SSS";
    public static SimpleDateFormat format = new SimpleDateFormat(_pattern);

    public static void main(String[] args) {
        try {
            //监听指定的端口
            ServerSocket server = new ServerSocket(9999);
            System.out.println("服务端启动");
            //建立连接
            Socket soket = server.accept();
            System.out.println(format.format(new Date()));
            System.out.println("建立了链接\n");
            //接收客户端消息(从socket中获取输入流，并建立缓冲区进行读取)
            InputStream din = soket.getInputStream();
            System.out.println("客户端ip地址是：" + soket.getInetAddress());
            System.out.println("客户端端口号是：" + soket.getPort());
            System.out.println("本地端口号是：" + soket.getLocalPort());
            byte[] outPut = new byte[4096];
            while (din.read(outPut) > 0) {
                //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
                String result = new String(outPut);
                System.out.println("客户端的消息是：" + result);
            }
            while (true) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
