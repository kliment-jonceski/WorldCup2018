package jonceski.kliment.worldcup2018.navigation.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by kliment on 8/9/2017.
 */

@Element (name = "channel")
public class Channel {
    @ElementList(entry = "title", type = String.class, inline = true, required = false)
    private List<String> titles;
    @ElementList(entry = "link", type = String.class, inline = true, required = false)
    private List<String> links;
    @ElementList(entry = "description", type = String.class, inline = true, required = false)
    private List<String> descriptions;
    @Element (name = "language", required = false)
    private String language;
    @Element (name = "copyright", required = false)
    private String copyright;
    @Element (name = "pubDate", required = false)
    private String pubdate;
    @Element (name = "lastBuildDate", required = false)
    private String lastbuilddate;
    @Element (name = "category", required = false)
    private String category;
    @Element (name = "image", required = false)
    private String img;
    @Element (name = "url", required = false)
    private String url;
    @Element (name = "width", required = false)
    private String width;
    @Element (name = "height", required = false)
    private String height;

    @ElementList(entry = "item", type = NewsItem.class, inline = true, required = false)
    private List<NewsItem> newsItems;

    public Channel(){
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getLinks() {
        return links;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public String getLanguage() {
        return language;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getPubdate() {
        return pubdate;
    }

    public String getLastbuilddate() {
        return lastbuilddate;
    }

    public String getCategory() {
        return category;
    }

    public String getImg() {
        return img;
    }

    public String getUrl() {
        return url;
    }

    public String getWidth() {
        return width;
    }

    public String getHeight() {
        return height;
    }

    public List<NewsItem> getNewsItem() {
        return newsItems;
    }
}
