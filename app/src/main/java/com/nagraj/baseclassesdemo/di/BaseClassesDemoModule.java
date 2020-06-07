package com.nagraj.baseclassesdemo.di;

import android.content.Context;
import androidx.room.Room;
import com.nagraj.localdb.UserDatabase;
import com.nagraj.model.Model;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class BaseClassesDemoModule {
    private final Context context;

    public BaseClassesDemoModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Model provideModel(UserDatabase userDatabase) {
        return new Model(userDatabase);
    }

    @Provides
    UserDatabase provideUserDatabase() {
        return Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, "app_database")
                .allowMainThreadQueries()
                .build();
    }

}




