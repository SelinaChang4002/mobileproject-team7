package com.example.plannerapp.model;

// 한 줄 일기 데이터를 정의하는 데이터 클래스
public class DiaryEntry {
    private long date;        // 일기의 날짜 (타임스탬프)
    private String content;   // 일기 내용 (한 줄)

    // 생성자
    public DiaryEntry(long date, String content) {
        this.date = date;
        this.content = content;
    }

    // Getter 및 Setter 메서드
    public long getDate() { return date; }
    public void setDate(long date) { this.date = date; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
