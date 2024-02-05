package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ch.qos.logback.core.model.Model;

@Controller
public class BookController {


        @RequestMapping(value = "/index", method = RequestMethod.GET)
        public String ShowIndex(Model model) {
            System.out.println("Index endpoint");
            return "index";
        }


}
