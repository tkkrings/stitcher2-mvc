package stitchr.stitcher2mvc.models;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.HashSet;


public class PatternCrawler {

    private static final int MAX_DEPTH = 2;
    private static HashSet<String> links;

    public PatternCrawler() {

        links = new HashSet<>();
    }

    public static void getPatterns(String URL, int depth) {
        if ((!links.contains(URL) && (depth < MAX_DEPTH))) {
            System.out.println(">> Depth: " + depth + " [" + URL + "]" );
            try {
                links.add(URL);

                Document document = Jsoup.connect(URL).get();
                Elements linksOnPage = document.select("h2 a href");

                depth++;
                for (Element link : linksOnPage) getPatterns(link.attr("a href"), depth);
            } catch (IOException e) {
                System.err.println("For '" + URL + "': " + e.getMessage());
            }
        }
    }

}
