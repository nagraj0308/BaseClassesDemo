package com.nagraj.baseclassesdemo.di;

import com.nagraj.baseclassesdemo.ui.home.HomeActivity;
import com.nagraj.baseclassesdemo.ui.login.LoginActivity;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = BaseClassesDemoModule.class) public interface BaseClassesDemoComponent {

    void inject(LoginActivity loginActivity);

    void inject(HomeActivity homeActivity);

}
