package DI.component;

import android.content.Context;

import DI.module.AdapterModule;
import DI.qualifier.ActivityContext;
import DI.scopes.ApplicationScope;
import dagger.Component;
import ui.MainActivity;

@ApplicationScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);

}
