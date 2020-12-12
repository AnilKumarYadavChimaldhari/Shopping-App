package com.example.shoping;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout textInputFirstName;
    private TextInputLayout textInputLastName;
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;
    RadioGroup rg;
    private TextInputEditText userFirstName,userLastName,UserEmail,UserPassword,UserConfirmPassword;
    CheckBox c1;
    Spinner spinner;
    ArrayList<String> al;
    int check=500;
    RadioButton r1,r2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(getString(R.string.sign_up));
        setContentView(R.layout.activity_main);
        spinner =  findViewById(R.id.age_shop);
        r1=findViewById(R.id.male);
        r2= findViewById(R.id.female);
        rg=findViewById(R.id.grp);
        al = new ArrayList<>();
        al.add("Select");
        for(int i=16; i<=32;i++)
            al.add(String.valueOf(i));

        textInputFirstName=findViewById(R.id.First_Name);
        textInputLastName=findViewById(R.id.last_name);
        textInputEmail=findViewById(R.id.Email);

        textInputPassword=findViewById(R.id.password);
        textInputConfirmPassword=findViewById(R.id.confirm_pass);
        userFirstName=findViewById(R.id.edit_user_first);
        userLastName=findViewById(R.id.edit_user_last);
        UserEmail=findViewById(R.id.edit_user_email);
        UserPassword=findViewById(R.id.edit_user_password);
        UserConfirmPassword=findViewById(R.id.edit_user_confirm_pass);

        ArrayAdapter<String> agead = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,al);
        spinner.setAdapter(agead);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {

                    check=500;
                    // Toast.makeText(getApplicationContext(),"Please Select age",Toast.LENGTH_SHORT).show();
                }
                else
                    check=20;


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                check=500;
                //Toast.makeText(getApplicationContext(),"Please Select age",Toast.LENGTH_SHORT).show();
            }
        });

        userFirstName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputFirstName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        userLastName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputLastName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        UserEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputEmail.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        UserPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputPassword.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        UserConfirmPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textInputConfirmPassword.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private  boolean validate_First_Name()
    {
        String first_Name=textInputFirstName.getEditText().getText().toString().trim();
        if(first_Name.isEmpty()) {
            textInputFirstName.setError(getString(R.string.First_name_err));
            return false;
        }
        else {
            textInputFirstName.setError(null);
            return true;
        }
    }
    private  boolean validate_Last_Name()
    {
        String Last_Name=textInputLastName.getEditText().getText().toString().trim();
        if(Last_Name.isEmpty()) {
            textInputLastName.setError(getString(R.string.Last_name_err));
            return false;
        }
        else {
            textInputLastName.setError(null);
            return true;
        }
    }
    private  boolean validate_Email()
    {
        String email=textInputEmail.getEditText().getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(!email.isEmpty() && email.matches(emailPattern)) {

            textInputEmail.setError(null);
            return true;
        }
        else if(email.isEmpty()){
            textInputEmail.setError(getString(R.string.Email_err));
            return false;
        }
        else
        {
            textInputEmail.setError(getString(R.string.Email_Validation_err));
            return false;
        }
    }


    private  boolean validate_Password()
    {
        String password=textInputPassword.getEditText().getText().toString().trim();
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern p1 = Pattern.compile("[a-z ]", Pattern.UNICODE_CASE);
        Pattern p3 = Pattern.compile("[A-Z ]", Pattern.UNICODE_CASE);
        Pattern p2 = Pattern.compile("[0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        Matcher m1 = p1.matcher(password);
        Matcher m2 = p2.matcher(password);
        Matcher m3 = p3.matcher(password);
        boolean check = m.find();
        boolean check1 = m1.find();
        boolean check2 = m2.find();
        boolean check3 = m3.find();
        if(password.length()<8) {
            textInputPassword.setError(getString(R.string.Password_8char_Less_err));
            return false;
        }
        else if(!(check && check1 && check2 &&check3)){
            textInputPassword.setError(getString(R.string.Password_err));
            return false;
        }
        else {
            textInputPassword.setError(null);
            return true;
        }



    }

    private  boolean validate_Confirm_Password()
    {
        String confirm_password=textInputConfirmPassword.getEditText().getText().toString().trim();
        String password=textInputPassword.getEditText().getText().toString().trim();
        if(!(confirm_password.equals(password))) {
            textInputConfirmPassword.setError(getString(R.string.Confirm_Password_err));
            return false;
        }
        else {
            textInputConfirmPassword.setError(null);
            return true;
        }
    }
    public void signup(View view) {
        c1=findViewById(R.id.accept);
        if(c1.isChecked())
        {
            if(!validate_First_Name()|!validate_Last_Name()|!validate_Email()|!validate_Password()|!validate_Confirm_Password())
                return;
            else
            {
                if(check!=500  && rg.getCheckedRadioButtonId()!=-1) {
                    Intent i = new Intent(MainActivity.this, page2.class);
                    i.putExtra("first", textInputFirstName.getEditText().getText().toString());
                    i.putExtra("last", textInputLastName.getEditText().getText().toString());
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_SHORT).show();
            }
        }

        else
        {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle(getString(R.string.Alert_Title));
            alert.setMessage(getString(R.string.Alert_Message));
            alert.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    c1.setChecked(true);
                    if(!validate_First_Name()|!validate_Last_Name()|!validate_Email()|!validate_Password()|!validate_Confirm_Password())
                        return;
                    else {



                        if(check!=500 && rg.getCheckedRadioButtonId()!=-1) {
                            Intent i = new Intent(MainActivity.this, page2.class);
                            i.putExtra("first", textInputFirstName.getEditText().getText().toString());
                            i.putExtra("last", textInputLastName.getEditText().getText().toString());
                            startActivity(i);
                        }
                        else
                            Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_SHORT).show();
                    }
                }
            });
            alert.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(),getString(R.string.Toast),Toast.LENGTH_SHORT).show();
                }
            });
            alert.create().show();
        }

    }


}
