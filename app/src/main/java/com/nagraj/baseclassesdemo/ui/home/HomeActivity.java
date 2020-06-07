package com.nagraj.baseclassesdemo.ui.home;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nagraj.base.BaseActivity;
import com.nagraj.baseclassesdemo.App;
import com.nagraj.baseclassesdemo.R;
import com.nagraj.localdb.User;
import java.util.List;
import javax.inject.Inject;
import static java.lang.Integer.parseInt;

public class HomeActivity extends BaseActivity implements HomeView {
    @Inject
    HomePresenter presenter;
    Button insert, selectAll, delete, selectById, selectByName;
    EditText firstName, lastName, id, age;
    RecyclerView recyclerView;

    @Override
    protected void initDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        presenter.attachView(this);
        insert = findViewById(R.id.insert);
        selectAll = findViewById(R.id.selectAll);
        delete = findViewById(R.id.delete);
        selectById = findViewById(R.id.selectById);
        selectByName = findViewById(R.id.selectByName);
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        id = findViewById(R.id.id);
        age = findViewById(R.id.age);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    protected void onReady() {
        insertSection();
        selectAllSection();
        deleteSection();
        selectByNameSection();
        selectByIdSection();
        reload();
    }

    public void insertSection() {
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.insertUser(firstName.getText().toString().trim(), lastName.getText().toString().trim(),
                        parseInt(id.getText().toString()), parseInt(age.getText().toString()));
            }
        });
    }

    public void selectAllSection() {
        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reload();

            }
        });
    }

    public void deleteSection() {
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.deleteId(parseInt(id.getText().toString()));
            }
        });
    }

    @Override
    public void setInsertResult(boolean isAdded) {
        if (isAdded) showToast("Inserted Successfully!!");
        else showToast("Not inserted");
        reload();
    }

    @Override
    public void setDeleteResult(boolean isDeleted) {
        if (isDeleted) showToast("Deleted Successfully!!");
        else showToast("Not deleted");
        reload();
    }

    @Override
    public void setSearchByNameResult(List<User> users) {
        recyclerView.setAdapter(new Recycle(users));
    }

    @Override
    public void setReloadResult(List<User> users) {
        recyclerView.setAdapter(new Recycle(users));
    }

    @Override
    public void setSearchByIdResult(List<User> users) {
        recyclerView.setAdapter(new Recycle(users));
    }

    public void selectByNameSection() {
        selectByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.searchByName(firstName.getText().toString(), lastName.getText().toString());
            }
        });

    }

    public void selectByIdSection() {
        selectById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.searchById(parseInt(id.getText().toString()));
            }
        });
    }

    public void reload() {
        presenter.reload();
    }

}
