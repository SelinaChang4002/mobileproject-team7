package com.example.plannerapp.repository;

import com.example.plannerapp.model.ToDoItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;  // Iterator를 위한 import
import com.example.plannerapp.model.ToDoItem;  // ToDo 클래스를 위한 import (경로는 실제 ToDo 클래스 위치에 따라 다를 수 있습니다)


// 할 일 데이터를 관리하는 Repository 클래스
public class ToDoRepository {
    private final List<ToDoItem> toDoList = new ArrayList<>(); // 임시 저장소

    // 할 일 추가
    public void addToDo(ToDoItem toDo) {
        toDoList.add(toDo);
    }

    // 특정 날짜의 할 일 가져오기
    public List<ToDoItem> getToDosForDate(long date) {
        List<ToDoItem> filteredList = new ArrayList<>();
        for (ToDoItem item : toDoList) {
            if (item.getDate() == date) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    // 할 일 수정
    public void updateToDo(ToDoItem toDo) {
        for (int i = 0; i < toDoList.size(); i++) {
            if (toDoList.get(i).getId() == toDo.getId()) {
                toDoList.set(i, toDo);
                break;
            }
        }
    }

    // 할 일 삭제
    public void deleteToDo(int id) {
    // 수정된 코드
    Iterator<ToDoItem> iterator = toDoList.iterator();
    while (iterator.hasNext()) {
        if (iterator.next().getId() == id) {
            iterator.remove();
            break;
    }
}
    }

    // 총 시간 계산
    public int getTotalTimeSpent() {
        int totalTime = 0;
        for (ToDoItem item : toDoList) {
            totalTime += item.getTimeSpent();
        }
        return totalTime;
    }
}
