package com.example.thi_cuoi_ki.apiService;

import com.example.thi_cuoi_ki.models.Exam;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ExamApiService {

    @GET("/exams")
    Call<List<Exam>> getExams();
}
