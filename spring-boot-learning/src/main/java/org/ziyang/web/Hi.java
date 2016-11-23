package org.ziyang.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ziyang.spring.exc.JsonException;
import org.ziyang.spring.exc.WebException;

@Controller
public class Hi {
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/e1")
    String e1() {
		throw new WebException(500, "web error");
    }
	
	@RequestMapping("/e2")
    String e2() {
		throw new JsonException(500);
    }
	
	@RequestMapping("/e3")
    String e3() throws Exception {
		throw new Exception("e3");
    }
	
	@RequestMapping("/home")
    String homepage() {
        return "homepage";
    }
}
