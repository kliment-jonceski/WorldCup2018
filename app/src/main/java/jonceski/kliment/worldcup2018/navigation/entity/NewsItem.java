package jonceski.kliment.worldcup2018.navigation.entity;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by kliment on 8/8/2017.
 */

@Element (name = "item")
public class NewsItem {
    @Element (name = "title", required = false)
    private String title;
    @Element (name = "link", required = false)
    private String link;
    @Element (name = "description", required = false)
    private String description;

    @Element (name = "enclosure", required = false)
    Enclosure enclosure;

    @Element (name = "pubDate", required = false)
    private String pubDate;
    @ElementList(entry = "category", type = String.class, inline = true, required = false)
    private List<String> category;

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
