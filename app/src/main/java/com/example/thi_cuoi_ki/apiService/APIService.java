package com.example.thi_cuoi_ki.apiService;

import com.example.thi_cuoi_ki.models.Exam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIService {

    @FormUrlEncoded
    @POST("/auth/login")
    Call<Void> login(
            @Field("username") String username,
            @Field("password") String password
    );

    // Đăng ký người dùng mới
    @FormUrlEncoded
    @GET("/auth/register/")
    Call<Void> register(
            @Field("username") String username,
            @Field("password") String password
    );

    @FormUrlEncoded
    @GET("/exam")
    Call<List<Exam>> getExams();


    @FormUrlEncoded
    @GET("/exam/{id}")
    Call<Exam> getExamById(@Path("id") int examId);

}
