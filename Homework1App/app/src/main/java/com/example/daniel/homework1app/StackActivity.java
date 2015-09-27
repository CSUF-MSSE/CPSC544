package com.example.daniel.homework1app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.daniel.homework1app.Stack;

import java.util.Arrays;

public class StackActivity extends AppCompatActivity {

        public final static String EXTRA_MESSAGE = "com.example.daniel.homework1app.MESSAGE";

        Stack stackArray;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);
        stackArray = new Stack();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stack, menu);
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

    //This function is responsible for pushing an element onto the stack and displaying a message
    //corresponds with with push button in the view
    //If number is between 0-9 push onto stack if not full
    //If number is different, then fail to push onto stack

    public void pushInteger(View view)
    {
        //Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String firstvalue = editText.getText().toString();
        TextView textView = (TextView) findViewById(R.id.text_message);
        AlertDialog.Builder build = new AlertDialog.Builder(this);

        int value = -1;
        if (isInteger(firstvalue))
            value = Integer.parseInt(firstvalue);

        //makes sure number is between 0-9
        if(value <= 9 && value >= 0) {
            //allow push if stackArray.isFull() == false
            if (!stackArray.isFull()) {
                stackArray.push(value);

                System.out.println(value + " was pushed");

                textView.setTextSize(12);
                textView.setText(value + " was pushed " + Arrays.toString(stackArray.stackArray));
            // do not allow to push onto stack
            } else {
                System.out.println("Stack is full");
                textView.setTextSize(12);
                textView.setText("Stack is full " + Arrays.toString(stackArray.stackArray));
            }
        }
        //case that number is different than 0-9
        else
        {
            //Here it dispalys a dialog box if the number is not between 0-9

            System.out.println("The value must be between 0-9 try again");
            build.setTitle("Must be an integer between 0-9");
            build.setMessage("Would You like to input another number?");

            //dismisses dialog box if yes is chosen
            build.setPositiveButton("YES", new DialogInterface.OnClickListener(){

                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();
                }

            });
            //exits the application if "NO" is chosen
            build.setNegativeButton("NO", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    finish();
                    System.exit(0);
                }
            });

            AlertDialog alerter = build.create();
            alerter.show();


        }

    }

    //function responsible for popping elements from the stack
    //corresponds with pop button in the view
    //if the stack is not empty allow pop
    //else do not allow pop and display that stack is empty

    public void popInteger(View view)
    {

        int value;
        TextView textView = (TextView) findViewById(R.id.text_message);

        if(!stackArray.isEmpty())
        {
            value = stackArray.pop();

            System.out.println(value + " was popped");
            textView.setTextSize(12);

            if(stackArray.stackSize >= 1) {
                textView.setText(value + " was popped " + Arrays.toString(stackArray.stackArray));
            }
            else
            {
                textView.setText(value + " was popped " + " Stack is Empty");
            }

        }

        else
        {
            System.out.println("Stack is Empty");
            textView.setTextSize(12);
            textView.setText("Stack is Empty");
        }

    }
    //function that corresponds with the exit button in the view
    public void exitApp(View view) {
        AlertDialog.Builder build = new AlertDialog.Builder(this);

        build.setTitle("Exit App");
        build.setMessage("Are you sure that you want to exit?");

        build.setPositiveButton("YES", new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();
                finish();
                System.exit(0);
            }

        });

        build.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alerter = build.create();
        alerter.show();
    }

    // isInteger(): helper function to sanitize user input.
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }


}


