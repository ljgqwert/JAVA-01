/**
 * 
 */
package com.ling.http;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @Author: ljg 2021年1月22日 下午9:16:09
 * 
 * @Desc: <p>
 * </p>
 */
public class HttpServer01 {

    /**
     * @Author ljg 2021年1月22日 下午9:16:09
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8088);
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(() -> {
                service(socket);
            }).start();

        }

    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(20);
            PrintWriter print = new PrintWriter(socket.getOutputStream(), true);
            print.println("HTTP/1.1 200 OK");
            print.println("Content-Type:text/html;charset=utf-8");
            String body = "hello.nio";
            print.println("Content-Length:" + body.getBytes().length);
            print.println();
            print.write(body);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
