package com.example.user.profitandloss;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private EditText user;
    private EditText pass;
    private Button submit;
    private Button signo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        user = (EditText) findViewById(R.id.UserName);
        pass = (EditText) findViewById(R.id.password);

        signo = (Button) findViewById(R.id.signuo);
        final Intent ma3 = new Intent(this,Main3Activity.class);
        signo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ma3);
            }
        });
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uName = user.getText().toString();
                String pWord = pass.getText().toString();
                if(!check(uName,pWord)) {
                    signIn(uName,pWord);
                }
            }
        });

    }

    private void signIn(final String email,final String password) {
        progressDialog.setMessage("Signing In, please wait.....");
        progressDialog.show();
        final Intent hello = new Intent(this,Main2Activity.class);

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            startActivity(hello);
                            Toast.makeText(MainActivity.this,"Login Successful ! Welcome "+email,Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this,"Login Failed/Invalid User",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    public boolean check(String email,String password) {

        boolean cancel = false;
        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            user.setError(getString(R.string.fRequired));
            cancel = true;
        } else if (!isEmailValid(email)) {
            user.setError(getString(R.string.eInvalid));
            cancel = true;
        }

        // Check for valid Password
        if (TextUtils.isEmpty(password)) {
            pass.setError(getString(R.string.fRequired));
            cancel = true;
        }
        if (!isPasswordValid(password)) {
            pass.setError(getString(R.string.pInvalid));
            cancel = true;
        }
        return cancel;
    }
}
