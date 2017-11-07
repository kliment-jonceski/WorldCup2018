package jonceski.kliment.worldcup2018.services;

import jonceski.kliment.worldcup2018.services.networking.HttpServices;

/**
 * Class that holds all the services of the application.
 */

public class Services {
    private HttpServices httpServices;
    private static Services instance;

    private Services() {
        this.httpServices = new HttpServices();
    }

    public HttpServices getHttpServices() {
        return httpServices;
    }

    public static Services getInstance() {
        if (instance == null) {
            instance = new Services();
        }

        return instance;
    }
}
