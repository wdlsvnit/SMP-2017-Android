package com.example.user.profitandloss;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseUser;

public class Main3Activity extends AppCompatActivity {

    private EditText id;
    private EditText pass1;
    private EditText pass2;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                id = (EditText) findViewById(R.id.uname);
                pass1 = (EditText) findViewById(R.id.pass1);
                pass2 = (EditText) findViewById(R.id.pass2);

                String user = id.getText().toString();
                String pass = pass1.getText().toString();
                String cpass = pass2.getText().toString();

                if(checkDetails(user,pass,cpass)) {
                    registerUser(user,pass,cpass);
                }

            }
        });
    }

    private void registerUser(String emailID, String password, String Name) {
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();
        // Creating New User
        firebaseAuth.createUserWithEmailAndPassword(emailID,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // Check if Status Succesfull
                if(task.isSuccessful()) {
                    Toast.makeText(Main3Activity.this,"Signup Successful",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Main3Activity.this,"Sign Up Failed/Account Already Exist !",Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }
        });
    }

    private boolean checkDetails(String em,String pa,String repa) {
        boolean cancel = true;

        // Check for a password
        if (TextUtils.isEmpty(pa)) {
            pass1.setError("Field Empty");
            cancel = false;
        }
        if (!isPasswordValid(pa)) {
            pass1.setError("Minimum 8 Characters");
            cancel = false;
        }

        // Check for password retype
        if(!pa.equals(repa)) {
            pass2.setError("Password Does not match");
            cancel = false;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(em)) {
            id.setError("Field Empty");
            cancel = false;
        } else if (!isEmailValid(em)) {
            id.setError("Invalid Email");
            cancel = false;
        }
        return cancel;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }
}
