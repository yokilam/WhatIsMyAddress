package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "address_shared_preferences";
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText emailEditText= (EditText) findViewById(R.id.edit_text);
        Button save= (Button) findViewById(R.id.button01);
        Button buttonTwo= (Button) findViewById(R.id.button02);


        final SharedPreferences sharedpref = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor = sharedpref.edit();
                if (emailEditText.getText()!=null && emailEditText.getText().toString().contains("@")){
                    editor.putString("email" + emailEditText.getText().toString(), emailEditText.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, ""+emailEditText.getText().toString() + " is saved.", Toast.LENGTH_SHORT).show();
                    emailEditText.setText("");
                }
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra("sharedpref", SHARED_PREFS_KEY);
                startActivity(intent);
            }
        });


    }

}
