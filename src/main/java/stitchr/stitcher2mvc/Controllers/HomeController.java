package stitchr.stitcher2mvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    @RequestMapping(value = "")
    public String home(Model model) {

        model.addAttribute("title", "Welcome to Stitchr!");

        return "index";

    }
}
