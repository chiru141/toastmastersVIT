package com.chiru141.toastmastervit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by chiru141 on 21-Mar-16.
 */
public class LaunchActivity extends AppCompatActivity implements View.OnClickListener {

    Button yes,no;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launch);

        yes=(Button)findViewById(R.id.option_yes);
        no=(Button)findViewById(R.id.option_no);
        setinit();

    }

    private void setinit() {
          yes.setOnClickListener(this);
         no.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.option_yes:
                goToLoginActivity();
                break;
            case R.id.option_no:
                goToMainActivity();
                break;
        }
    }

    private void goToMainActivity() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToLoginActivity() {
        Intent intent1 = new Intent(this,LoginActivity.class);
        startActivity(intent1);
        finish();

    }
}
