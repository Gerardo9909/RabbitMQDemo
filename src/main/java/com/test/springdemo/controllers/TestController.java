package com.test.springdemo.controllers;

import com.test.springdemo.dto.Message;
import com.test.springdemo.services.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@RestController()
@RequestMapping("/test")
public class TestController {

    TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    static char aux;

    public static void main(String[] args) {

        String s = "([{}])[]{}";
        System.out.println("El array está " + (correct(s) ? "ordenado" : "desordenado"));




/*        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el numero a multiplicar : ");
        int number = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " * " + i + " = " + number * i);
        }*/
    }

    public static boolean correct(String s) {
        List<Character> opens = new ArrayList<>();
        List<Character> closes = new ArrayList<>();
        char charArray[] = s.toCharArray();
        boolean result = true;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ' && charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
                if (correlate(charArray[i], charArray[i + 1])) {
                    charArray[i + 1] = ' ';
                    System.out.println("Ordenado");
                } else {
                    opens.add(charArray[i]);
                }
            } else {
                if (charArray[i] != ' ') {
                    closes.add(charArray[i]);
                }
            }
        }

        String aux = "";
        opens.addAll(closes);
        for (int i = 0; i < opens.size(); i++) {
            aux += opens.get(i);
        }

        if (!opens.isEmpty() && opens.size() % 2 == 0){
            correct(aux);
        }else {
            return false;
        }

        return result;
    }

    public static boolean correlate(char s, char p) {
        switch (s) {
            case '(':
                return p == ')' ? true : false;
            case '[':
                return p == ']' ? true : false;
            case '{':
                return p == '}' ? true : false;
        }
        return false;
    }

    @GetMapping("/hello-world")
    public ResponseEntity<String> getPeople(@RequestParam String name) {

        return ResponseEntity.ok("Hello " + name);
    }

    @GetMapping("/rabbit-test")
    public ResponseEntity<Message> rabbitTest(@RequestBody Message message) {
        testService.sendToRabbit(message);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/rest-template")
    public ResponseEntity<String> restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "https://catfact.ninja/fact";
        return restTemplate.getForEntity(fooResourceUrl, String.class);
    }
}
