package com.example.plannerapp.repository;

import com.example.plannerapp.model.DiaryEntry;
import java.util.ArrayList;
import java.util.List;

// 일기 데이터를 관리하는 Repository 클래스
public class DiaryRepository {
    private final List<DiaryEntry> diaryEntries = new ArrayList<>(); // 임시 저장소

    // 일기 추가
    public void addDiaryEntry(DiaryEntry entry) {
        diaryEntries.add(entry);
    }

    // 특정 날짜의 일기 가져오기
    public DiaryEntry getDiaryForDate(long date) {
        for (DiaryEntry entry : diaryEntries) {
            if (entry.getDate() == date) {
                return entry;
            }
        }
        return null; // 해당 날짜의 일기가 없으면 null 반환
    }

    // 일기 수정
    public void updateDiaryEntry(DiaryEntry entry) {
        for (int i = 0; i < diaryEntries.size(); i++) {
            if (diaryEntries.get(i).getDate() == entry.getDate()) {
                diaryEntries.set(i, entry);

                break;
            }
        }
    }
}
