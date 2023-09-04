package dev.flynnpark.springcoreadvanced.app.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController // 스프링은 @Controller, @RestController가 있어야 스프링 컨트롤러로 인식한다.
public interface OrderControllerV1 {

    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}

