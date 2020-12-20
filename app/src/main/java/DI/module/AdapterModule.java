package DI.module;

import DI.scopes.ActivityScope;
import adapter.RecyclerViewAdapter;
import dagger.Module;
import dagger.Provides;
import ui.MainActivity;

//@module --> s ovom anotacijom se oznacava ona klasa koja ce se nalaziti u object graph-u
//
@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    //@Provides --> s ovom anotacijom se oznacavaju metode koje se nalaze unutar @module klase
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
