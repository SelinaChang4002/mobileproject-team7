package com.example.integratecode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TaskView extends LinearLayout {

    public TaskView(Context context, Task task) {
        super(context);
        initialize(context, task);
    }

    public TaskView(Context context) {
        super(context);
    }

    public TaskView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initialize(Context context, Task task) {
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.task_view, this, true); // task_view.xml 레이아웃 사용

        TextView taskTitleView = findViewById(R.id.task_title);
        TextView taskDescriptionView = findViewById(R.id.task_description);
        TextView taskTimeView = findViewById(R.id.task_time);
        TextView taskStatusView = findViewById(R.id.task_status);

        taskTitleView.setText(task.getTitle());
        taskDescriptionView.setText(task.getDescription());
        taskTimeView.setText(task.getTime());
        taskStatusView.setText(task.getStatus());
    }
}
