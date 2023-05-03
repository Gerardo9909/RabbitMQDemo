package com.test.springdemo.controllers;

import java.io.IOException;

public class Test2 {

    class AirPlane {
        public AirPlane() throws IOException {
            System.out.println("Airplane");
            throw new IOException();
        }
    }

    class AirJett extends AirPlane {
        public AirJett() throws IOException{
            System.out.println("Airjet");
        }
    }
}
