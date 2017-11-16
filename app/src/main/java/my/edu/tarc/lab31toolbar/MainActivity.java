package my.edu.tarc.lab31toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textViewMessage;
    private float size, max = 36, min = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //show main UI to user
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking the UI to program
        textViewMessage = (TextView)findViewById(R.id.textViewMessage);
        //TODO get the default font size
        size = textViewMessage.getTextSize()/getScreenDensity();


        //handle toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Handle Floating icon
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        else if(id == R.id.action_increase){
            //TODO increase the font size
            if(size >= max){
                //getApplicationContext() = this, Toast to make text appear for awhile
                Toast.makeText(getApplicationContext(),"This is the meximum font size.",Toast.LENGTH_SHORT).show();
            }
            else{
                size ++;
                textViewMessage.setTextSize(size);
            }
        }
        else if(id == R.id.action_decrease){
            //TODO decrease the font size
            if(size <= min){
                Toast.makeText(getApplicationContext(), "This is the minimum font size.",Toast.LENGTH_SHORT).show();
            }
            else{
                size--;
                textViewMessage.setTextSize(size);
            }
        }
        else if(id == R.id.action_about){
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    public float getScreenDensity(){
        float sizeDensity=0;

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        sizeDensity = metrics.density;

        return sizeDensity;
    }



}
