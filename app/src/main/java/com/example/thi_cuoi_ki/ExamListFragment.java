package com.example.thi_cuoi_ki;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExamListFragment extends Fragment {

    private RecyclerView recyclerView;
    private ExamAdapter examAdapter;
    private List<String> examList;

    public ExamListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exam_list, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        examList = new ArrayList<>();
        examList.add("Bài thi số 1");
        examList.add("Bài thi số 2");
        examList.add("Bài thi số 3");

        examAdapter = new ExamAdapter(examList);
        recyclerView.setAdapter(examAdapter);

        examAdapter.setOnItemClickListener(new ExamAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String selectedExam = examList.get(position);
                Toast.makeText(getActivity(), "Bạn đã chọn bài thi: " + selectedExam, Toast.LENGTH_SHORT).show();

                // TODO: Mở màn hình mới với thông tin chi tiết về bài thi được chọn
            }
        });

        return view;
    }

    // Adapter for RecyclerView
    private static class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder> {

        private List<String> examList;
        private OnItemClickListener listener;

        public interface OnItemClickListener {
            void onItemClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }

        public ExamAdapter(List<String> examList) {
            this.examList = examList;
        }

        @NonNull
        @Override
        public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exam, parent, false);
            return new ExamViewHolder(view, listener);
        }

        @Override
        public void onBindViewHolder(@NonNull ExamViewHolder holder, int position) {
            String exam = examList.get(position);
            holder.titleTextView.setText(exam);
        }

        @Override
        public int getItemCount() {
            return examList.size();
        }

        public void addExam(String exam) {
            examList.add(exam);
            notifyItemInserted(examList.size() - 1);
        }
        public static class ExamViewHolder extends RecyclerView.ViewHolder {

            public TextView titleTextView;

            public ExamViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
                super(itemView);
                titleTextView = itemView.findViewById(R.id.text_title);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null) {
                            int position = getAdapterPosition();
                            if (position != RecyclerView.NO_POSITION) {
                                listener.onItemClick(position);
                            }
                        }
                    }
                });
            }
        }
    }
}
