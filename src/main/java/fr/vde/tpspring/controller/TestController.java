package fr.vde.tpspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "test")
public class TestController {

    @RequestMapping(path ="string")
    public String getString() {
        return "tout va bien";
    }
}
