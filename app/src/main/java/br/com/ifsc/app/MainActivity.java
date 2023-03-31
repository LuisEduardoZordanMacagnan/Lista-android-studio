package br.com.ifsc.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> listaPalavras;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPalavras=new ArrayList<>();
        listaPalavras.add("Sugoma");
        listaPalavras.add("Amogus");

        listView = findViewById(R.id.lista);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                listaPalavras);
        listView.setAdapter(adapter);
    }
}