package com.example.qthjen.customdialog;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSignIn = (TextView) findViewById(R.id.tvSignIn);

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogCustom();
            }
        });
    }

    public void dialogCustom() {

        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_custom);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

        // ánh xạ
        final EditText etUser = (EditText) dialog.findViewById(R.id.etUser);
        final EditText etPass = (EditText) dialog.findViewById(R.id.etPass);
        Button btConfirm = (Button) dialog.findViewById(R.id.btConfirm);
        Button btExit = (Button) dialog.findViewById(R.id.btExit);

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etUser.getText().toString();
                String pass = etPass.getText().toString();
                if ( user.equals("thjenxxxno6") && pass.equals("thjenit98")) {
                    Toast.makeText(MainActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Sign in unsuccessfully", Toast.LENGTH_SHORT).show();
//                    etUser.requestFocus();
//                    etPass.requestFocus(); // giống java swing
                }
            }
        });

        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialog.cancel();
                dialog.dismiss();
            }
        });

    }

}
