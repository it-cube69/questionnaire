package ru.itcube.questionnaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ru.itcube.questionnaire.model.Test;

public class TestsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        listView = findViewById(R.id.tests);

        List<Test> tests = DataUtils.getInstance().getTests();
        ArrayAdapter<Test> adapter = new ArrayAdapter<Test>(this, android.R.layout.simple_list_item_1, tests);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
                startActivity(intent);
            }
        });
    }
}