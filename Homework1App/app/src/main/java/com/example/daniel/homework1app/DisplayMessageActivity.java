package com.example.daniel.homework1app;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        String message = intent.getStringExtra(StackActivity.EXTRA_MESSAGE);

        TextView textView = new TextView(this);

        textView.setTextSize(40);
        textView.setText(message);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
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
    /*
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment(){ }

        @Override
        public View OnCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_display_message,
                    container, false);
                return rootView;

        }

    }
    */

}
