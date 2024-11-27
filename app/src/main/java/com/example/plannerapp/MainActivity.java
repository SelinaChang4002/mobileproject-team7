package com.example.plannerapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.plannerapp.repository.ToDoRepository;
import com.example.plannerapp.model.ToDoItem;

public class MainActivity extends AppCompatActivity {

    private ToDoRepository toDoRepository; // ToDoRepository 인스턴스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ToDoRepository 초기화
        toDoRepository = new ToDoRepository();

        // 예제 데이터 추가
        addSampleData();

        // 저장된 데이터를 출력
        printToDoList();
    }

    // 예제 데이터를 추가하는 메서드
    private void addSampleData() {
        toDoRepository.addToDo(new ToDoItem(1, "운동하기", "건강", "성공", 60, "매일 하기", System.currentTimeMillis()));
        toDoRepository.addToDo(new ToDoItem(2, "공부하기", "학습", "실패", 120, "시험 준비", System.currentTimeMillis()));
    }

    // 저장된 데이터를 출력하는 메서드
    private void printToDoList() {
        for (ToDoItem item : toDoRepository.getToDosForDate(System.currentTimeMillis())) {
            System.out.println("ID: " + item.getId() + ", Title: " + item.getTitle() + ", Status: " + item.getStatus());
        }
    }
}
