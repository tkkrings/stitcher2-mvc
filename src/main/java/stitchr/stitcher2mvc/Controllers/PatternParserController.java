package stitchr.stitcher2mvc.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stitchr.stitcher2mvc.models.PatternCrawler;
import stitchr.stitcher2mvc.models.data.PatternDao;

import java.io.IOException;


@Controller
public class PatternParserController {

    @Autowired
    private PatternDao patternDao;

    @GetMapping("patterns")
    public String displaypatterns(Model model) throws IOException {
        model.addAttribute("title", "patterns");
        new PatternCrawler().getPatterns("https://www.yarnplaza.com/patterns/knitting-patterns", 0);
        model.addAttribute("patterns", "patterns");
        model.addAttribute("links", PatternCrawler.getLinks());
        return "stitchr/patterns/displaypatterns";
    }

}