package com.example.josecarlos.swapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.FacebookSdk;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        EditText passwordView = (EditText) findViewById(R.id.passwordBox);

        passwordView.setOnKeyListener(new View.OnKeyListener() {

            public boolean onKey(View view, int keyCode, KeyEvent ke) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    runLogin();
                    return true;
                } else return false;
            }


        });

        TextView forgotPassword = (TextView) findViewById(R.id.forgotPass);

        forgotPassword.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                runForgotPassword();
            }
        });

        TextView emailSignUp = (TextView) findViewById(R.id.emailSignUp);

        emailSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                runEmailSignUp();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //ToDo: add email sign up
    protected void runEmailSignUp() {

        final Button signUpButton = new Button(this);

        signUpButton.setText("Usted se quiere registrar, comasela");

        FrameLayout tutiLayout = (FrameLayout) findViewById(R.id.frameLayout);

        tutiLayout.addView(signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                signUpButton.setVisibility(View.GONE);
            }
        });

    }


    //ToDo: add forgotten password handling
    protected void runForgotPassword() {

        final Button forgotPassButton = new Button(this);

        forgotPassButton.setText("Esta tratando de hacer caca usted?");

        FrameLayout tutiLayout = (FrameLayout) findViewById(R.id.frameLayout);

        tutiLayout.addView(forgotPassButton);

        forgotPassButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                forgotPassButton.setVisibility(View.GONE);
            }
        });

    }

    //ToDo: authenticate login
    protected void runLogin() {
        if (authenticateLogin()) initializeApp();
        else {
            final Button wrongInfoButton = new Button(this);

            wrongInfoButton.setText("Ha cometido un error ingresando su contraseña o su email, por favor intente de nuevo");

            FrameLayout tutiLayout = (FrameLayout) findViewById(R.id.frameLayout);

            tutiLayout.addView(wrongInfoButton);

            wrongInfoButton.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                   wrongInfoButton.setVisibility(View.GONE);
                }
            });

            }
        }


    //ToDo: finish method
    public boolean authenticateLogin(){

        EditText emailBox = (EditText) findViewById(R.id.emailBox);
        EditText passwordBox = (EditText) findViewById(R.id.passwordBox);

        return emailBox.getText().toString().equals("admin") && passwordBox.getText().toString().equals("admin");

    }

    public void initializeApp() {

        Intent intent = new Intent(this, MainScreenActivity.class);

        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
