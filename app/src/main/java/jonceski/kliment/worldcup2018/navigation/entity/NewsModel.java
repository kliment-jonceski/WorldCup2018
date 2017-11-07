package jonceski.kliment.worldcup2018.navigation.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by kliment on 8/8/2017.
 */

@Root(name = "rss")
public class NewsModel {
    @Attribute (name = "version", required = false)
    private String version;

    @Element(name = "channel", required = false)
    private Channel channel;

    public NewsModel() {
    }

    public Channel getChannel() {
        return channel;
    }

    public String getVersion() {
        return version;
    }
}