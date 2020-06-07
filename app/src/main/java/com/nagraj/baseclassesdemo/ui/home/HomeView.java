package com.nagraj.baseclassesdemo.ui.home;

import com.nagraj.base.BaseView;
import com.nagraj.localdb.User;
import java.util.List;

public interface HomeView  extends BaseView {

        void setInsertResult(boolean isAdded);

        void setDeleteResult(boolean isDeleted);

        void setSearchByNameResult(List<User> users);

        void setReloadResult(List<User> users);

        void setSearchByIdResult(List<User> users);

}
