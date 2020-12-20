package DI.module;

import android.content.Context;

import DI.qualifier.ActivityContext;
import DI.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;
import ui.MainActivity;

//@Module --> s ovom anotacijom se oznacavaju klase koje se nalaze unutar object graph-a
@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    //@Provides --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @Module klasa
    @Provides
    @ActivityScope
    public MainActivity providesMainActivity(){
        return mainActivity;
    }

    //@Provides --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @Module klase
    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext(){
        return context;
    }
}
