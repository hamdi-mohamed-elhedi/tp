package com.tp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  
@GetMapping("/")
public String message() {
    return """
        <html>
            <body>
                <h1 style='color:green; text-align:center'>
                    Demo Mercredi ✅
                </h1>
            </body>
        </html>
        """;
}

}
