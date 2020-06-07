package com.nagraj.baseclassesdemo.ui.login;

import android.content.Intent;
import android.view.View;
import com.nagraj.base.BaseActivity;
import com.nagraj.baseclassesdemo.App;
import com.nagraj.baseclassesdemo.databinding.ActivityLoginBinding;
import com.nagraj.baseclassesdemo.ui.home.HomeActivity;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity implements LoginView{
    ActivityLoginBinding binding;
    @Inject LoginPresenter presenter;

    @Override
    protected void initDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    protected void initViews() {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        presenter.attachView(this);
        binding.btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getMessage("Blue");
            }
        });
        binding.btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getMessage("Red");
                    startActivity( new Intent(getApplicationContext(), HomeActivity.class));
            }
        });
    }

    @Override
    protected void onReady() {
    }

    @Override
    public void setMessage(String message) {
        showToast(message);
    }
}