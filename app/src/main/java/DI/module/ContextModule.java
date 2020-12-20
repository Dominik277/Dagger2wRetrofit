package DI.module;

import android.content.Context;

import DI.qualifier.ApplicationContext;
import DI.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

//Dagger upravalja dependency graph-om sa klasama koje u sebi imaju anotacije @inject i @Provides
//Dagger ne moze instacirati ili "inject" klase koje nemaju @inject ili @Provide anotaciju
//@Module --> s ovom anotacijom se oznacavaju klase koje ce se nalaziti unutar object graph-
@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    //@Provides --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @Module klasa
    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext(){
        return context;
    }
}
