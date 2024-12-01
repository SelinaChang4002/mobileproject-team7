package com.example.integratecode;

public class DiaryEntry {
    private final String date; // 일기 날짜
    private final String content; // 일기 내용

    // 생성자
    public DiaryEntry(String date, String content) {
        this.date = date;
        this.content = content;
    }

    // 날짜를 반환하는 메서드
    public String getDate() {
        return date;
    }

    // 내용을 반환하는 메서드
    public String getContent() {
        return content;
    }
}
