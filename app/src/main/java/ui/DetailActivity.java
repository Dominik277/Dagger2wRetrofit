package ui;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

import DI.component.ApplicationComponent;
import DI.component.DetailActivityComponent;
import DI.qualifier.ApplicationContext;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import pojo.Film;
import retrofit.APIIinterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    DetailActivityComponent detailActivityComponent;

    @Inject
    public APIIinterface apiIinterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView = findViewById(R.id.textView);
        String url = getIntent().getStringExtra("url");

        ApplicationComponent applicationComponent = MyApplication.get(this)
                .getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .build();

        detailActivityComponent.inject(this);

        apiIinterface.getFilmData(url, "json").enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                Film films = response.body();
                String text = "Film name: \n" + films.title
                        + "\nDirector:\n" + films.director;
                textView.setText(text);
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {

            }
        });

    }
}
