package DI.component;

import android.content.Context;

import DI.module.ContextModule;
import DI.module.RetrofitModule;
import DI.qualifier.ApplicationContext;
import DI.scopes.ApplicationScope;
import dagger.Component;
import retrofit.APIIinterface;
import ui.MyApplication;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    public APIIinterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);

}
