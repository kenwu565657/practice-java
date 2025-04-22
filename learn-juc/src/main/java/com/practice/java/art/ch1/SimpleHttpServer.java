package com.practice.java.art.ch1;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Copy from The Art of Java Concurrency Programming Second Edition
 *
 */
public class SimpleHttpServer {
    //static ThreadP<HttpRequestHandler> threadPool = new DefaultTh;

    static class HttpRequestHandler implements Runnable {
        private Socket socket;
        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;

            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (Exception ex) {
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            } finally {
                close(br, reader, out, in, socket);
            }
        }

        private static void close(Closeable... closeables) {
            if (closeables != null) {
                for (Closeable closeable : closeables) {
                    try {
                        closeable.close();
                    } catch (Exception ex) {}
                }
            }
        }
    }
}
