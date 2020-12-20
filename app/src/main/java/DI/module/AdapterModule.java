package DI.module;

import DI.scopes.ActivityScope;
import adapter.RecyclerViewAdapter;
import dagger.Module;
import dagger.Provides;
import ui.MainActivity;

//Dagger upravalja dependency graph-om sa klasama koje u sebi imaju anotacije @inject i @Provides
//Dagger ne moze instacirati ili "inject" klase koje nemaju @inject ili @Provide anotaciju
//klase koje sadrze @inject ili @Provides anotacije se nalaze unutar dependency graph-a
//@module --> s ovom anotacijom se oznacava ona klasa koja ce se nalaziti u object graph-u
@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    //@Provides --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @module klase
    //              Dagger koristi providere kako bi kreirano instance zeljenih objekata
    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleList(RecyclerViewAdapter.ClickListener clickListener){
        return new RecyclerViewAdapter(clickListener);
    }

    //@Provides --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @module klase
    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickLitener(MainActivity mainActivity){
        return mainActivity;
    }

}
