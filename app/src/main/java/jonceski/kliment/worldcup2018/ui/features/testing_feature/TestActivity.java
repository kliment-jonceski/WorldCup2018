package jonceski.kliment.worldcup2018.ui.features.testing_feature;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import jonceski.kliment.worldcup2018.App;
import jonceski.kliment.worldcup2018.R;
import jonceski.kliment.worldcup2018.navigation.entity.NewsModel;
import jonceski.kliment.worldcup2018.services.networking.ClientBuilder;
import jonceski.kliment.worldcup2018.services.networking.PublicDataClient;
import jonceski.kliment.worldcup2018.utils.XmlUtils;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kliment on 8/8/2017.
 */

public class TestActivity extends AppCompatActivity {
    @BindView(R.id.test_result)
    TextView tvResult;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        ButterKnife.bind(this);

        testRequest();
        testRequestFromHttpStach();
    }

    private void testRequestFromHttpStach() {
        App.getInstance().getServices().getHttpServices();
    }

    private void testRequest() {
        // Create a very simple REST adapter which points the GitHub API endpoint.
        PublicDataClient client = ClientBuilder.getPublicDataClient("http://www.fifa.com/");

        // Fetch a list of the Github repositories.
        Call<ResponseBody> call =
                client.reposForUser();

        // Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it

                File requestFile = new File(getCacheDir(), "test");
                try {
                    FileOutputStream fos = new FileOutputStream(requestFile);
                    fos.write(response.body().bytes());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                NewsModel newsModel = XmlUtils.parseConfigXml(requestFile);
                tvResult.setText(newsModel.getVersion());

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
                t.printStackTrace();
            }
        });
    }
}
