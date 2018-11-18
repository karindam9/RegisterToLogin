package com.web.arindam.registertologin;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginSuccessfull extends AppCompatActivity {
    SharedPreferences sh;
    TextView txt1,txt2,txt3,logout,txt4;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successfull);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        logout=findViewById(R.id.logout);
        txt4=findViewById(R.id.txt4);

        sh=getSharedPreferences("user", Context.MODE_PRIVATE);
        editor=sh.edit();

        txt1.setText(sh.getString("name",""));
        txt2.setText(sh.getString("email",""));
        txt3.setText(sh.getString("password",""));
        txt4.setText(sh.getString("country",""));


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogBox();
//                Intent in=new Intent(LoginSuccessfull.this,LoginPage.class);
//                startActivity(in);
            }
        });
    }

    private void DialogBox() {
        final Dialog dialog=new Dialog(LoginSuccessfull.this);
        dialog.setContentView(R.layout.dialog_logout);
        TextView yes1=dialog.findViewById(R.id.yes1);
        TextView no1=dialog.findViewById(R.id.no1);

        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent in=new Intent(LoginSuccessfull.this,LoginPage.class);
               startActivity(in);
               editor.clear();
               editor.commit();
               finish();
               }
        });
        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.show();

    }
}
