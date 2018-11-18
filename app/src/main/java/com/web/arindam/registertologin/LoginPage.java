package com.web.arindam.registertologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {
    EditText e_gmail,e_password;
    TextView login,txt1;
    String gmail="",pass="",email="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        e_gmail=findViewById(R.id.e_gmail);
        e_password=findViewById(R.id.e_password);
        login=findViewById(R.id.login);
        txt1=findViewById(R.id.txt1);


        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            gmail=bundle.getString("g");
            pass=bundle.getString("p");

        }
        e_gmail.setText(gmail);
        e_password.setText(pass);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String a=edt_gmail.getText().toString().trim();
//                String b=edt_gmail.getText().toString().trim();
//                if(gmail.equals(a)&&pass.equals(b)) {
                if(valid())
                {
                    Intent intent = new Intent(LoginPage.this, LoginSuccessfull.class);
                    startActivity(intent);
                }


//                else {
//                    Toast.makeText(LoginPage.this,"Invalid email id & password",Toast.LENGTH_LONG).show();
//                }
            }
        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(LoginPage.this,RegisterToLogin.class);
                startActivity(in);
            }
        });

    }

    private boolean valid() {
        boolean isvalid=true;
        if (e_gmail.getText().toString().isEmpty())
        {
            isvalid=false;
            Toast.makeText(LoginPage.this,"Enter valid email adress",Toast.LENGTH_SHORT).show();
            e_gmail.requestFocus();
            return isvalid;
        }
        if (e_password.getText().toString().isEmpty())
        {
            isvalid=false;
            Toast.makeText(LoginPage.this,"Enter password",Toast.LENGTH_SHORT).show();
            e_password.requestFocus();
            return isvalid;
        }
        return isvalid;
    }
}
