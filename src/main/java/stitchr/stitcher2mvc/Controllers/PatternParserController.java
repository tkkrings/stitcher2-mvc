package stitchr.stitcher2mvc.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stitchr.stitcher2mvc.models.PatternCrawler;

import java.io.IOException;


@Controller
public class PatternParserController {

    @GetMapping("patterns")
    public String displaypatterns(Model model) throws IOException {
        model.addAttribute("title", "Patterns");
        new PatternCrawler().getPatterns("http://www.allfreeknitting.com/tag/Full-Patterns", 0);

        return "redirect:/patterns";
    }

}