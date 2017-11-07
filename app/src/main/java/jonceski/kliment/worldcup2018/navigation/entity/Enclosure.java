package jonceski.kliment.worldcup2018.navigation.entity;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by kliment on 8/9/2017.
 */

public class Enclosure {
    @Attribute (name = "length", required = false)
    private int length;
    @Attribute (name = "url", required = false)
    private String url;
    @Attribute (name = "type", required = false)
    private String type;
}
