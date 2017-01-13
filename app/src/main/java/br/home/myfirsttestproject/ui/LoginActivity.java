package br.home.myfirsttestproject.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.home.myfirsttestproject.R;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getCanonicalName();
    private Context mContext = this;

    /**
     * Change de null parameter in {@code setContentView()}
     * to a layout resource {@code R.layout.example}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: hit");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText editTextLogin = (EditText) findViewById(R.id.editText_login);
        EditText editTextSenha = (EditText) findViewById(R.id.editText_senha);
        Button btnLogin = (Button) findViewById(R.id.button_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                        .setMessage(R.string.validation_message)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                doLogin();
                                dialogInterface.dismiss();
                            }
                        })
                        .setCancelable(false);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    private void doLogin() {
        startActivity(new Intent(this, MainActivity.class));
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