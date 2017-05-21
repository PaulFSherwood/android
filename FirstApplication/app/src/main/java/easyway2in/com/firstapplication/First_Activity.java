package easyway2in.com.firstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class First_Activity extends AppCompatActivity {
    TextView textView;
    EditText message_text;
    public final static String MESSAGE_KEY = "easyway2in.com.firstapplication.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        textView = (TextView)findViewById(R.id.greetings_text_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void showGreetings(View view) {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("Open First Activity")) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        } else if (button_text.equals("Open Second Activity")) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
        } else if (button_text.equals("Open Third Activity")) {
            Intent intent = new Intent(this, ThirdActivity.class);
            startActivity(intent);
        }
    }

    public void sendMessage(View view) {
        message_text = (EditText)findViewById(R.id.message_text);
        String message = message_text.getText().toString();
        Intent intent = new Intent(this, ForthActivity.class);
        intent.putExtra(MESSAGE_KEY, message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
