package com.example.plannerapp.model;

// 할 일 데이터를 정의하는 데이터 클래스
public class ToDoItem {
    private int id;           // 고유 ID
    private String title;     // 할 일 제목
    private String category;  // 할 일 분류 (예: 공부, 운동 등)
    private String status;    // 할 일 상태 (성공, 실패, 애매)
    private int timeSpent;    // 할당된 시간 (분 단위)
    private String memo;      // 할 일 메모 (선택 사항)
    private long date;        // 할 일이 지정된 날짜 (타임스탬프)

    // 생성자
    public ToDoItem(int id, String title, String category, String status, int timeSpent, String memo, long date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.status = status;
        this.timeSpent = timeSpent;
        this.memo = memo;
        this.date = date;
    }

    // Getter 및 Setter 메서드
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getTimeSpent() { return timeSpent; }
    public void setTimeSpent(int timeSpent) { this.timeSpent = timeSpent; }

    public String getMemo() { return memo; }
    public void setMemo(String memo) { this.memo = memo; }

    public long getDate() { return date; }
    public void setDate(long date) { this.date = date; }
}
