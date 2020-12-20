package DI.module;

import DI.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit.APIIinterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//@Module --> s ovom anotacijom se oznacavaju sve klase koje se nalaze unutar object graph-a
@Module
public class RetrofitModule {

    //@Provide --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @Module klasa
    @Provides
    @ApplicationScope
    APIIinterface getApiInterface(Retrofit retroFit){
        return retroFit.create(APIIinterface.class);
    }

    //@Provide --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @Module klasa
    @Provides
    @ApplicationScope
    Retrofit getRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    //@Provide --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @Module klasa
    @Provides
    @ApplicationScope
    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    //@Provide --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @Module klasa
    @Provides
    @ApplicationScope
    HttpLoggingInterceptor getHttpLoggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

}
