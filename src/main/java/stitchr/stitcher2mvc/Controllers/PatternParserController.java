package stitchr.stitcher2mvc.Controllers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import org.jsoup.Jsoup;


@Controller
@RequestMapping("patterns")
public class PatternParserController {

    private HashSet<String> links;

    public PatternParserController() {
        links = new HashSet<String>();
    }

    public void getPatterns(String URL) {
        new PatternParserController().getPatterns("https://www.allfreeknitting.com/tag/Full-Patterns");

        if (!links.contains(URL)) {
            try {
                if (links.add(URL)) {
                    System.out.println(URL);
                }

                Document document = Jsoup.connect(URL).get();

                Elements linksOnPage = document.select("a[href]");

                for (Element page : linksOnPage) {
                    getPatterns(page.attr("abs:href"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
