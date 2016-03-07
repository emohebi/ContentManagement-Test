/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contentmanagement;

import MonogDB.SearchDocuments;
import UI.MainFrame;
import WebCrawling.Crawling;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
/**
 *
 * @author Ehsan
 */
public class ContentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);     
    }
    
}
