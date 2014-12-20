package edu.uta.teamargus.lynxblackjack;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LynxApp extends Activity {

    private Button stay, hit, bet, splash;
    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lynx_app);
        stay = (Button) findViewById(R.id.stay_button);
        hit = (Button) findViewById(R.id.hit_button);
        bet = (Button) findViewById(R.id.bet_button);
        splash = (Button) findViewById(R.id.splash_button);
        log = (TextView) findViewById(R.id.LogBox);
        log.setMovementMethod(new ScrollingMovementMethod());
        listenForButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.lynx_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void listenForButton() {
        splash.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(getApplicationContext(), GLSplashWait.class);
                startActivity(i);
            }
        });

        stay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
            }
        });

        hit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
            }
        });

        bet.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // get prompts.xml view
                LayoutInflater layoutInflater = LayoutInflater
                        .from(LynxApp.this);
                View promptView = layoutInflater.inflate(R.layout.input_dialog,
                        null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        LynxApp.this);
                alertDialogBuilder.setView(promptView);
                final EditText editText = (EditText) promptView
                        .findViewById(R.id.edittext);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                // setup a dialog window
                alertDialogBuilder
                        .setTitle("Enter bet amount:")
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        String currentText = log.getText().toString();
                                        log.setText(currentText + "You have bet: "
                                                + editText.getText()+"\n");
                                        final int scrollAmount = log.getLayout().getLineTop(log.getLineCount()) - log.getHeight();
                                        // if there is no need to scroll, scrollAmount will be <=0
                                        if (scrollAmount > 0)
                                            log.scrollTo(0, scrollAmount);
                                        else
                                            log.scrollTo(0, 0);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });

                // create an alert dialog
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }
        });
    }

}
