package com.example.mail;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Declare Variables
    private ListView list;
    private ListViewAdapter adapter;
    private SearchView editsearch;
     public static ArrayList<ContactNames> namesArrayList = new ArrayList<ContactNames>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        namesArrayList.add(new ContactNames( "osman aydeniz", "1:00","title 1","desctiption",233, R.drawable.thumb1));
        namesArrayList.add(new ContactNames("zzz aydeniz", "1:00","title 2","desctiption",233, R.drawable.thumb1));
        namesArrayList.add(new ContactNames( "xxx aydeniz", "1:00","title 3","desctiption",233, R.drawable.thumb1));

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}