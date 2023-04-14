package br.com.ifsc.app;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> listaApps;
    PackageManager pm;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaApps = new ArrayList<>();

        listView = findViewById(R.id.lista);

        pm = getPackageManager();

        List<ApplicationInfo> apps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo app: apps) {
            listaApps.add(app.loadLabel(pm).toString());
        }
        //Padrao
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                listaApps);

        //Personalizado
        AplicativosAdapter adapter2 = new AplicativosAdapter(
            this,
                R.layout.lista,
                apps
        );

        //Setando
        listView.setAdapter(adapter2);
    }
}