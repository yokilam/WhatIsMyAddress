package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Map;

public class RecyclerActivity extends AppCompatActivity{

    private SharedPreferences email;
    private ArrayList<Email> emailList= new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        email = getApplicationContext().getSharedPreferences(intent.getStringExtra("sharedpref"), MODE_PRIVATE);

        for(Map.Entry<String, ?> entry: email.getAll().entrySet()) {
            Log.d("ENTRY", entry.getValue() + "" + "Key: " + entry.getKey());
            Log.d("ENTRY", entry.getValue() + "" + "size: " + email.getAll().entrySet().size());
            emailList.add(new Email(""+entry.getValue()));
            Log.d("email", ""+emailList.size()+emailList);
        }


        RecyclerView emailRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        emailRecyclerView.setLayoutManager(layoutManager);
        EmailAdapter adapter = new EmailAdapter(emailList);
        emailRecyclerView.setAdapter(adapter);


    }
}
