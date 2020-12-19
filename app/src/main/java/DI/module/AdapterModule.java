package DI.module;

import DI.scopes.ActivityScope;
import adapter.RecyclerViewAdapter;
import dagger.Module;
import dagger.Provides;
import ui.MainActivity;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleList(RecyclerViewAdapter.ClickListener clickListener){
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickLitener(MainActivity mainActivity){
        return mainActivity;
    }

}
