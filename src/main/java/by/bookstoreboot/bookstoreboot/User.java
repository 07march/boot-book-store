package by.bookstoreboot.bookstoreboot;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.*;
import java.util.concurrent.Executors;

public class User implements Cloneable {
    private volatile int age;
    private static final int name;

    static {
        name = 22;
        Test.nn();
    }

//    public User(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }

    @SneakyThrows
    private void vb(){
        System.out.println("a");
        try{
            throw new IOException();
        } catch (IOException e){

        } finally {
            throw new IOException();
        }
    }

    private static class Abc extends User{
//        @Override
//        public void vb() {
//            super.vb();
//        }
    }

    @Override
    public String toString() {

        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
