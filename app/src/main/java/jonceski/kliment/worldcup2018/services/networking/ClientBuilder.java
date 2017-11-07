package jonceski.kliment.worldcup2018.services.networking;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by kliment on 8/8/2017.
 */

public class ClientBuilder {

    public static PublicDataClient getPublicDataClient(String apiEndpoint) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(apiEndpoint)
                        .addConverterFactory(SimpleXmlConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        PublicDataClient client = retrofit.create(PublicDataClient.class);

        return client;
    }
}
