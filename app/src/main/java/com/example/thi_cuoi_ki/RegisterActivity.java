package com.example.thi_cuoi_ki;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.thi_cuoi_ki.database.APIClient;
import com.example.thi_cuoi_ki.apiService.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private APIService apiService = APIClient.getClient().create(APIService.class);

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonRegister;
    private String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setControl();
        setEvent();

        // Xử lý sự kiện khi nhấn nút Register
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Thực hiện các xử lý đăng kí tài khoản ở đây
                // Ví dụ: gửi thông tin lên server, lưu vào cơ sở dữ liệu, vv.

                // Hiển thị thông báo đăng kí thành công


                Toast.makeText(RegisterActivity.this, "Đăng kí thành công!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void setControl() {
        // Ánh xạ các thành phần trong layout
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
    }

    public void setEvent() {
        // Lấy giá trị của username và password từ EditText
        username = editTextUsername.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();
    }

    public void register() {
        // Đăng nhập
        Call<Void> registerCall = apiService.login(username, password);

        registerCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // Xử lý đăng nhập thành công
                    System.out.println("dang ki thanh cong");
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
