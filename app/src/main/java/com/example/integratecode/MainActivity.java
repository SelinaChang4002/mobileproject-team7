package com.example.integratecode;

import static com.example.integratecode.R.id.container;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private LinearLayout taskContainer;
    private LinearLayout diaryContainer;
    private EditText diaryEntryInput;
    private final ArrayList<Task> taskList = new ArrayList<>();
    private final ArrayList<DiaryEntry> diaryEntries = new ArrayList<>();
    private ActivityResultLauncher<Intent> taskLauncher;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI 요소 초기화
        taskContainer = findViewById(container);
        diaryContainer = findViewById(R.id.diary_entry_container);
        Button addButton = findViewById(R.id.add);
        Button saveDiaryButton = findViewById(R.id.save_diary_button);
        diaryEntryInput = findViewById(R.id.diary_entry_input);

        // ActivityResultLauncher 초기화
        taskLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            String taskTitle = data.getStringExtra("taskTitle");
                            String taskDescription = data.getStringExtra("taskDescription");
                            String taskTime = data.getStringExtra("taskTime");
                            String taskStatus = data.getStringExtra("taskStatus");

                            // 새로운 작업 객체 생성
                            Task newTask = new Task(taskTitle, taskDescription, taskTime, taskStatus);
                            taskList.add(newTask);
                            displayTasks();
                        }
                    }
                }
        );

        // 버튼 클릭 리스너 등록
        addButton.setOnClickListener(this::onClick);
        saveDiaryButton.setOnClickListener(v -> saveDiaryEntry());
    }

    // 작업을 화면에 표시하는 메서드
    private void displayTasks() {
        taskContainer.removeAllViews(); // 기존 작업 제거
        for (Task task : taskList) {
            // 각 작업에 대한 카드 생성
            CardView taskCard = new CardView(this);
            taskCard.setCardBackgroundColor(getResources().getColor(android.R.color.white)); // 카드 배경색
            taskCard.setRadius(12f);
            taskCard.setCardElevation(6f);

            // 카드에 작업 뷰 추가
            taskCard.addView(new TaskView(this, task));
            taskContainer.addView(taskCard);
        }
    }

    // 일기 저장 메서드
    private void saveDiaryEntry() {
        String entryContent = diaryEntryInput.getText().toString().trim();
        if (entryContent.isEmpty()) {
            Toast.makeText(this, "일기를 작성하세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        // 현재 날짜 가져오기
        @SuppressLint("SimpleDateFormat") String currentDate = new SimpleDateFormat("EEEE, MMM dd").format(new Date());
        DiaryEntry newEntry = new DiaryEntry(currentDate, entryContent);
        diaryEntries.add(newEntry);

        // 일기 표시
        displayDiaryEntries();

        // 입력 필드 초기화
        diaryEntryInput.setText("");
    }

    // 일기를 화면에 표시하는 메서드
    private void displayDiaryEntries() {
        diaryContainer.removeAllViews(); // 기존 일기 제거
        for (DiaryEntry entry : diaryEntries) {
            // 각 일기에 대한 카드 생성
            CardView diaryCard = new CardView(this);
            diaryCard.setCardBackgroundColor(getResources().getColor(android.R.color.white)); // 카드 배경색
            diaryCard.setRadius(12f);
            diaryCard.setCardElevation(6f);

            // 카드에 일기 뷰 추가
            diaryCard.addView(new DiaryView(this, entry));
            diaryContainer.addView(diaryCard);
        }
    }

    // 새 작업 추가 버튼 클릭 리스너
    private void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, NewTaskActivity.class);
        taskLauncher.launch(intent); // ActivityResultLauncher 통해 새 Activity 실행
    }
}

