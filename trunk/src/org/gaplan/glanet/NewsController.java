package org.gaplan.glanet;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

import org.gnu.stealthp.rsslib.RSSChannel;
import org.gnu.stealthp.rsslib.RSSHandler;
import org.gnu.stealthp.rsslib.RSSItem;
import org.gnu.stealthp.rsslib.RSSParser;

@SuppressWarnings("unchecked")
public class NewsController {
    public static ArrayList<BlogItem> fetchAll(String newsUrl, String fullName, String headUrl) {
        ArrayList<BlogItem> allNews = new ArrayList<BlogItem>();
        RSSHandler hand = new RSSHandler();
        try {
            URL u = new URL(newsUrl);
            RSSParser.parseXmlFile(u, hand, false);
        } catch(Exception e) {
            e.printStackTrace();
        }
        RSSChannel ch = hand.getRSSChannel();

        String channelDescription = ch.getDescription();
        String channelUrl = ch.getLink();
        String channelTitle = ch.getTitle();

        LinkedList<RSSItem> lst = (LinkedList<RSSItem>) hand.getRSSChannel().getItems();

        for(int i = 0; i < lst.size(); i++) {
            RSSItem itm = lst.get(i);
            BlogItem news = new BlogItem();
            news.setChannelDescription(channelDescription);
            news.setChannelTitle(channelTitle);
            news.setChannelUrl(channelUrl);
            news.setAuthor(fullName);
            news.setTitle(itm.getTitle());
            news.setDate(itm.getPubDate());
            news.setDescription(itm.getDescription());
            news.setLink(itm.getLink());
            news.setContent(itm.toString());
            news.setHeadUrl(headUrl);
            allNews.add(news);
        }
        return allNews;
    }
}
