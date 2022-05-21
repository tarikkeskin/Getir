package com.example.getirdesign.data;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.getirdesign.data.model.LoggedInUser;
import com.example.getirdesign.ui.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource extends LoginActivity {

    private FirebaseAuth firebaseAuth;

    public Result<LoggedInUser> login(String username, String password) {
        try {
            // TODO: handle loggedInUser authentication

            firebaseAuth = FirebaseAuth.getInstance();

            firebaseAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Log.e("Product","OnsuccesscreateuserwithEmail");
                    }else{
                        Log.e("Product","FAIL OnsuccesscreateuserwithEmail");
                    }
                }
            });
            FirebaseUser user = firebaseAuth.getCurrentUser();
            String uid = user.getUid();
            String userDisplayName = user.getDisplayName();
            return new Result.Success<>(new LoggedInUser(uid,userDisplayName));

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        finish();
    }
}