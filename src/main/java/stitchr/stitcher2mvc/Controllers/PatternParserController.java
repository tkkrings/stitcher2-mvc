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
        model.addAttribute("title", "Patterns");

        PatternCrawler patterns = new PatternCrawler();
        patterns.getPatterns("https://www.ravelry.com/patterns/search#craft=knitting", 3);
        model.addAttribute("links", patterns.getLinks());

        patternDao.save(patterns);

        return "stitchr/patterns/displaypatterns";
    }

}