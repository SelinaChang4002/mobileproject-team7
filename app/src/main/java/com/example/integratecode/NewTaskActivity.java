package com.example.integratecode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewTaskActivity extends AppCompatActivity {

    private EditText taskTitleInput;
    private EditText taskDescriptionInput;
    private EditText taskDateInput;
    private EditText taskTimeInput;
    private EditText taskEventInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task); // 새로운 XML 파일 사용

        // UI 요소 초기화
        taskTitleInput = findViewById(R.id.addTaskTitle);
        taskDescriptionInput = findViewById(R.id.addTaskDescription);
        taskDateInput = findViewById(R.id.taskDate);
        taskTimeInput = findViewById(R.id.taskTime);
        taskEventInput = findViewById(R.id.taskEvent);
        Button doneButton = findViewById(R.id.addTask);
        Button cancelButton = findViewById(R.id.cancel_button); // Cancel 버튼도 추가

        // 완료 버튼 클릭 리스너
        doneButton.setOnClickListener(v -> {
            String title = taskTitleInput.getText().toString().trim();
            String description = taskDescriptionInput.getText().toString().trim();
            String date = taskDateInput.getText().toString().trim();
            String time = taskTimeInput.getText().toString().trim();
            String event = taskEventInput.getText().toString().trim();

            if (title.isEmpty() || description.isEmpty()|| date.isEmpty() || time.isEmpty()) {
                Toast.makeText(NewTaskActivity.this, "제목과 설명을 입력하세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra("taskTitle", title);
            resultIntent.putExtra("taskDescription", description);
            resultIntent.putExtra("taskDate", date);
            resultIntent.putExtra("taskTime", time);
            resultIntent.putExtra("taskEvent", event);
            setResult(Activity.RESULT_OK, resultIntent);
            finish(); // Activity 종료
        });

        // 취소 버튼 클릭 리스너
        cancelButton.setOnClickListener(v -> finish());
    }
}