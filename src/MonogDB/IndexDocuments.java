/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MonogDB;

import WebCrawling.Crawling;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import java.awt.TextArea;

/**
 *
 * @author Ehsan
 */
public class IndexDocuments {
    
    private String url;
    private String subDomain;
    private TextArea logger;

    public IndexDocuments(String url, String subDomain) {
        this.url = url;
        this.subDomain = subDomain;
    } 
    
    public IndexDocuments(String url, String subDomain, TextArea logger) {
        this.url = url;
        this.subDomain = subDomain;
        this.logger = logger;
    }
    
    public void Index(){
        String crawlStorageFolder = "../data/";
            int numberOfCrawlers = 7;

            CrawlConfig config = new CrawlConfig();
            config.setCrawlStorageFolder(crawlStorageFolder);

            /*
             * Instantiate the controller for this crawl.
             */
            PageFetcher pageFetcher = new PageFetcher(config);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            try{
                CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
                Crawling.subDomain = subDomain;
                Crawling.logger = logger;
                controller.addSeed(url);

                controller.start(Crawling.class, numberOfCrawlers);
            }catch(Exception ex){
                System.out.println(ex);
            }
    }
}
