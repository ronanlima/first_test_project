package br.home.myfirsttestproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AppCompatActivityTemplate extends AppCompatActivity {

    private static final String TAG = AppCompatActivityTemplate.class.getCanonicalName();

    /**
     * Change de null parameter in {@code setContentView()}
     * to a layout resource {@code R.layout.example}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(null);
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: hit");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: hit");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy: hit");
        super.onDestroy();
    }
}