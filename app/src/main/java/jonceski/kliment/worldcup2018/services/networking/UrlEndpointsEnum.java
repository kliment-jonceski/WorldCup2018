package jonceski.kliment.worldcup2018.services.networking;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static jonceski.kliment.worldcup2018.services.networking.HttpServices.FIFA_NEWS_ENDPOINT;
/**
 * Enum for identifying all the endpionts in the application.
 */

public enum UrlEndpointsEnum {
    NEWS_ENDPOINT(FIFA_NEWS_ENDPOINT + "worldcup/news/rss.xml");

    private static final Map<String, UrlEndpointsEnum> ENDPOINTS_MAP;


    static {
        HashMap<String, UrlEndpointsEnum> map = new HashMap<String, UrlEndpointsEnum>();

        for (UrlEndpointsEnum sideMenuItemEnum : UrlEndpointsEnum.values()) {
            map.put(sideMenuItemEnum.name(), sideMenuItemEnum);
        }

        ENDPOINTS_MAP = Collections.unmodifiableMap(map);
    }

    private String endpointUrl;

    UrlEndpointsEnum(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }
}
