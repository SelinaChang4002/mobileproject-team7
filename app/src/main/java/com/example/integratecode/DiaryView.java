package com.example.integratecode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

@SuppressLint("ViewConstructor")
public class DiaryView extends LinearLayout {

    // 생성자
    public DiaryView(@NonNull Context context, DiaryEntry diaryEntry) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.diary_item, this, true);

        // 날짜를 표시하는 TextView
        TextView entryDate = findViewById(R.id.entry_date);
        // 내용을 표시하는 TextView
        TextView entryContent = findViewById(R.id.entry_content);

        // 일기 정보를 설정
        entryDate.setText(diaryEntry.getDate());
        entryContent.setText(diaryEntry.getContent());
    }
}

