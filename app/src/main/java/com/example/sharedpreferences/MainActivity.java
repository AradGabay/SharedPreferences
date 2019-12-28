package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * @version 1
 * @author Arad Gabay
 */

public class MainActivity extends AppCompatActivity {
    EditText edt;
    TextView tv;
    int i;
    String st;
    SharedPreferences data;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv);
        edt = (EditText)findViewById(R.id.edt);
        data = getSharedPreferences("info",MODE_PRIVATE);
        editor = data.edit();
        i = data.getInt("counter",-1);
        st = data.getString("name","12414ddd1");
        tv.setText(i+"");
        edt.setText(st);





    }
    //This method activated the next activitiy
    public boolean onOptionsItemSelected (MenuItem item){
        Intent t1 = new Intent(this,creditsActivity.class);
        startActivity(t1);
        return true;
    }


    //This method creates the options menu.
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add("Credits");
        return true;
    }
    //adds to the counter
    public void add(View view) {
        i++;
        tv.setText(i+"");
    }

    //resets the counter
    public void resetcounter(View view) {
        i=0;
        tv.setText(i+"");
    }

    //exits the app and saving the name and counter
    public void exitapp(View view) {
        editor.putString("name",edt.getText().toString());
        editor.putInt("counter",i);
        editor.commit();
        finish();

    }

}
