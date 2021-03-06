package br.com.bandtec.restwithspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GrettingController {

    private static  final String template = "Hello, %s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Gretting greeting(@RequestParam(value="name", defaultValue = "World")String name){
        return new Gretting(counter.incrementAndGet(), String.format(template,name));
    }
}
