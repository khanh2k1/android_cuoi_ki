package com.example.thi_cuoi_ki;


// use api


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thi_cuoi_ki.database.APIClient;
import com.example.thi_cuoi_ki.apiService.APIService;
import com.example.thi_cuoi_ki.models.Exam;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private APIService apiService = APIClient.getClient().create(APIService.class);

    private TextView editTextUsername;
    private TextView editTextPassword;
    private Button buttonLogin;

    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setControl();
        setEvent();

    }

    private void setControl() {

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
    }

    private void setEvent() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                System.out.println("on click btnLogin");

                username = editTextUsername.getText().toString();
                password = editTextPassword.getText().toString();
                System.out.println(username+ " " + password);
                login(username, password);
            }
        });

    }

    private void login (String username, String password) {
        // Đăng nhập
        Call<Void> loginCall = apiService.login(username, password);

        loginCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Xử lý đăng nhập thành công
                    System.out.println("dang nhap thanh cong");
                    showSuccessDialog();


                } else {
                    // Xử lý đăng nhập thất bại
                    System.out.println("dang nhap that bai");
                    showFailureDialog("Thông báo", "Wrong username or password");

                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // Xử lý lỗi đăng nhập
                System.out.println("on failure: " + t);
            }
        });
    }
    private void getExams() {
        // Đăng nhập
        Call<List<Exam>> getExams = apiService.getExams();
        getExams.enqueue(new Callback<List<Exam>>() {
            @Override
            public void onResponse(Call<List<Exam>> call, Response<List<Exam>> response) {

            }

            @Override
            public void onFailure(Call<List<Exam>> call, Throwable t) {

            }


        });
    }
    public void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Đăng nhập thành công")
                .setMessage("Xin chào! Bạn đã đăng nhập thành công")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void showFailureDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}