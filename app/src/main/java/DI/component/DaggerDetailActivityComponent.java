package DI.component;

import DI.scopes.ActivityScope;
import dagger.Component;
import ui.DetailActivity;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DaggerDetailActivityComponent {

    void inject(DetailActivity detailActivity);

}
