/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebCrawling;

import ContentDataContract.CrawlData;
import MonogDB.InsertDocuments;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import java.awt.TextArea;
import java.util.regex.Pattern;

/**
 *
 * @author Ehsan
 */
public class Crawling extends WebCrawler {

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg"
                                                           + "|png|mp3|mp3|zip|gz))$");
    private InsertDocuments insert = new InsertDocuments();
    public static  String subDomain;
    public static TextArea logger;

     @Override
     public boolean shouldVisit(Page referringPage, WebURL url) {
         String href = url.getURL().toLowerCase();
         return !FILTERS.matcher(href).matches()
                && href.startsWith(subDomain);
     }

     /**
      * This function is called when a page is fetched and ready
      * to be processed by your program.
      */
     @Override
     public void visit(Page page) {
         String url = page.getWebURL().getURL();
         System.out.println("URL: " + url);
         logger.append("URL: " + url + "\n");

         if (page.getParseData() instanceof HtmlParseData) {
             HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
             String text = htmlParseData.getText();
             String html = htmlParseData.getHtml();
             String title = "";
             String author = "";
             for (String key : htmlParseData.getMetaTags().keySet()){
                 if(key.contains("title"))
                     title = htmlParseData.getMetaTags().get(key);
                 if(key.contains("author"))
                     author = htmlParseData.getMetaTags().get(key);
             }
             CrawlData data = new CrawlData();
             data.setAuthor(author);
             data.setHeadline(title);
             data.setText(text);
             data.setUrl(url);             
             insert.Add(data);
         }
    }
     
     
}