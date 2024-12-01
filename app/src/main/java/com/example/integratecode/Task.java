package com.example.integratecode;

public class Task {
    private final String title; // 작업 제목
    private final String description; // 작업 설명
    private final String time; // 작업 시간
    private final String status; // 작업 상태

    // 생성자
    public Task(String title, String description, String time, String status) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.status = status;
    }

    // 제목을 반환하는 메서드
    public String getTitle() {
        return title;
    }

    // 설명을 반환하는 메서드
    public String getDescription() {
        return description;
    }

    // 시간을 반환하는 메서드
    public String getTime() {
        return time;
    }

    // 상태를 반환하는 메서드
    public String getStatus() {
        return status;
    }
}
