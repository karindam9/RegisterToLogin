package com.web.arindam.registertologin;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterToLogin extends AppCompatActivity {
    EditText edt_name,edt_email,edt_pass,edt_confirm;
    TextView bt_signup,bt_login;
    SharedPreferences sh;
    SharedPreferences.Editor editor;
    Spinner spinner;
    String[] res=null;
    List<String> arraylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_to_login);
        edt_name=findViewById(R.id.edt_name);
        edt_email=findViewById(R.id.edt_email);
        edt_pass=findViewById(R.id.edt_pass);
        edt_confirm=findViewById(R.id.edt_confirm);
        bt_signup=findViewById(R.id.bt_signup);
        bt_login=findViewById(R.id.bt_login);

        spinner=findViewById(R.id.spinner);
        res=getResources().getStringArray(R.array.Country);
        arraylist= Arrays.asList(res);

        sh=getSharedPreferences("user", Context.MODE_PRIVATE);
        editor=sh.edit();

        ArrayAdapter arrayAdapter=new ArrayAdapter(RegisterToLogin.this,android.R.layout.simple_spinner_item,arraylist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text=parent.getItemAtPosition(position).toString();
                editor.putString("country",text);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("name",edt_name.getText().toString().trim());
                editor.putString("email",edt_email.getText().toString().trim());
                editor.putString("password",edt_pass.getText().toString().trim());
                editor.commit();

                if (valid())
                {
                    DialogBoxCreate();

//                    String a=edt_pass.getText().toString().trim();
//                    String b=edt_confirm.getText().toString().trim();
//                    if(a.equals(b)) {
//                        Intent in = new Intent(RegisterToLogin.this, LoginPage.class);
//                        in.putExtra("g",edt_email.getText().toString().trim());
//                        in.putExtra("p",a);
//
//                        startActivity(in);
//                    }
//                    else {
//                        Toast.makeText(RegisterToLogin.this,"Password mismatch",Toast.LENGTH_LONG).show();
//                        edt_pass.requestFocus();
//                    }
                }


            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(RegisterToLogin.this,LoginPage.class);
                startActivity(in);
            }
        });

    }

    private void DialogBoxCreate() {
        final Dialog dialog=new Dialog(RegisterToLogin.this);
        dialog.setContentView(R.layout.dialogbox);


        TextView yes1=dialog.findViewById(R.id.yes1);
        TextView no1=dialog.findViewById(R.id.no1);
        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

//                ArrayAdapter arrayAdapter=new ArrayAdapter(RegisterToLogin.this,android.R.layout.simple_spinner_item,arraylist);
//                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                spinner.setAdapter(arrayAdapter);

                String a=edt_pass.getText().toString().trim();
                String b=edt_confirm.getText().toString().trim();
                if(a.equals(b)) {
                    Intent in = new Intent(RegisterToLogin.this, LoginPage.class);
                    in.putExtra("g",edt_email.getText().toString().trim());
                    in.putExtra("p",a);

                    startActivity(in);
                }
                else {
                    Toast.makeText(RegisterToLogin.this,"Password mismatch",Toast.LENGTH_LONG).show();
                    edt_pass.requestFocus();
                }
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


    private boolean valid() {
        boolean isvalid=true;
        if(edt_name.getText().toString().trim().isEmpty())
        {
            isvalid=false;
            Toast.makeText(RegisterToLogin.this,"Enter username",Toast.LENGTH_SHORT).show();
            edt_name.requestFocus();
            return isvalid;
        }
        if(edt_email.getText().toString().trim().isEmpty())
        {
            isvalid=false;
            Toast.makeText(RegisterToLogin.this,"Enter email id",Toast.LENGTH_SHORT).show();
            edt_email.requestFocus();
            return isvalid;
        }
        if(edt_pass.getText().toString().trim().isEmpty())
        {
            isvalid=false;
            Toast.makeText(RegisterToLogin.this,"Enter password",Toast.LENGTH_SHORT).show();
            edt_pass.requestFocus();
            return isvalid;
        }
        if(edt_confirm.getText().toString().trim().isEmpty())
        {
            isvalid=false;
            Toast.makeText(RegisterToLogin.this,"Enter confirmed password",Toast.LENGTH_SHORT).show();
            edt_confirm.requestFocus();
            return isvalid;
        }
        return isvalid;
    }
}
