package co.simplon.threading.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class ThreadingApiApplication {

    public static void main(String[] args) {
    SpringApplication.run(ThreadingApiApplication.class,
        args);
    }
    private int naive = 0;

    @GetMapping("/run")
    synchronized String get() {
    	 threadInfo("Entering method...");
    	naive++;
   
    	SmartSingleton smart = SmartSingleton.instance;
    String str = smart.whoAmI();
    threadInfo("Returning method...");
    return str;
    }

    private void threadInfo(String info) {
    Thread current = Thread.currentThread();
    String name = current.getName();
    String msg = String.format("[%s] - %s", name, info);
    System.out.println(msg);
    }

}