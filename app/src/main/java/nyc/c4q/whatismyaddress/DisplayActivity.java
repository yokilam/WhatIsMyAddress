package nyc.c4q.whatismyaddress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2);

        TextView textView01 = (TextView) findViewById(R.id.text1);
        TextView textView02 = (TextView) findViewById(R.id.text2);

        Intent intent= getIntent();
        String getString= intent.getStringExtras("email");
        textView01.setText(getString);


    }
}
