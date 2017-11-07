package jonceski.kliment.worldcup2018.utils;



import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;

/**
 * Created by kliment on 8/9/2017.
 */

public class XmlUtils {
    public static NewsModel parseConfigXml(File xmlFile) {

        NewsModel newsModel = null;
        try {
            Serializer ser = new Persister();
            newsModel = ser.read(NewsModel.class, xmlFile);
        } catch (Exception xEx) {
            xEx.printStackTrace();
            return null;
        }

        return newsModel;
    }
}
