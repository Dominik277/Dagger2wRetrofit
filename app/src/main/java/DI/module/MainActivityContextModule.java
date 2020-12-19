package DI.module;

import android.content.Context;

import DI.qualifier.ActivityContext;
import DI.scopes.ActivityScope;
import dagger.Module;
import dagger.Provides;
import ui.MainActivity;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity(){
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext(){
        return context;
    }
}
