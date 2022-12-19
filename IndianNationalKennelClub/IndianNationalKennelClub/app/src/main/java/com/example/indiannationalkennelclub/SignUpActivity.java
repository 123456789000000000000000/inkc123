package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    //Gender
    RadioGroup radioGroup;
    RadioButton radiobutton1;
    static String male= "1";

    //Date
    ImageView date1;
    TextView date;

    //Normal Variable
    EditText first1,last1,phone1,email1,password1;
    TextView loginpage,numbercheck;
    Button submit;

    String Signupurl = "https://mployis.com/inkc1/api/login/signup";
    String MobilenumberURl = "https://mployis.com/inkc1/api/login/is_mobile_exist";

    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        progressDialog = new ProgressDialog(this);

        // Normal Variable
        first1 = findViewById(R.id.first);
        last1 = findViewById(R.id.last);

        numbercheck = findViewById(R.id.numbercheck);

        phone1 = findViewById(R.id.phone);
        phone1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(phone1.getText().toString().length()==10){
                    numbercheck.setText(" ");

                    String check = phone1.getText().toString();

                    progressDialog.setMessage("Checking Phone Number");
                    progressDialog.show();
                    StringRequest request = new StringRequest(Request.Method.POST, MobilenumberURl,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        String message = jsonObject.getString("message");
                                        if(message.equals("Your phone number allready exist")){

                                            numbercheck.setText("Your phone number allready exist");
                                            numbercheck.setTextColor(Color.parseColor("#183dde"));
                                            progressDialog.dismiss();
                                        }
                                        else
                                        {
                                            numbercheck.setText("Available phone number  ");
                                            numbercheck.setTextColor(Color.parseColor("#1fde18"));                                        }
                                            progressDialog.dismiss();

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(SignUpActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("user_phone_number", check);
                            return params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);
                    requestQueue.add(request);
                }
                else
                {

                    numbercheck.setText("Phone Number Must be 10");
                    numbercheck.setTextColor(Color.parseColor("#de4318"));
                }
            }
        });
        email1 = findViewById(R.id.email);
        password1 = findViewById(R.id.password);
        loginpage = findViewById(R.id.loginpage);
        loginpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp();
            }
        });



        // Gender
        radioGroup = findViewById(R.id.radiogroupgender);
        radiobutton1 = radioGroup.findViewById(R.id.radiobutton1);
        radiobutton1.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(SignUpActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        Toast.makeText(SignUpActivity.this, "1", Toast.LENGTH_SHORT).show();
                        male = "1";
                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this, "0", Toast.LENGTH_SHORT).show();
                        male = "0";
                    }

                }
            }
        });

         // Date
        date = findViewById(R.id.date);
        date1 = findViewById(R.id.date1);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        SignUpActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });
        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.
                        SignUpActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // on below line we are setting date to our text view.
                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);
                // at last we are calling show to
                // display our date picker dialog.
                datePickerDialog.show();
            }
        });

    }

    private void SignUp() {

        String first = first1.getText().toString().trim();
        String last = last1.getText().toString().trim();
        String date1 = date.getText().toString();
        String gender = male;
        String phone  = phone1.getText().toString();
        String email = email1.getText().toString().trim();
        String password = password1.getText().toString().trim();


        if(first.isEmpty()){
            first1.requestFocus();
            first1.setError("Please enter your first name");
            return;
        }
        else if(last.isEmpty()){
            last1.requestFocus();
            last1.setError("Please enter your last name");
            return;
        }

        else if(date1.isEmpty()){
            date.requestFocus();
            date.setError("Please enter your date");
            return;
        }

        else if(phone.isEmpty()){
            phone1.requestFocus();
            phone1.setError("Please enter your number");
            return;
        }
        else if(email.isEmpty()){
            email1.requestFocus();
            email1.setError("Please enter your email");
            return;
        }
        else  if(password.isEmpty()){
            password1.requestFocus();
            password1.setError("Please enter your password");
            return;
        }
        else
        {
            ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait!");
            progressDialog.show();

            StringRequest request = new StringRequest(Request.Method.POST, Signupurl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response);
                                String message = jsonObject.getString("message");
                                if(message.equals("Please verify user")){

                                    String data = jsonObject.getString("data");
                                    JSONObject jsonObject1 = new JSONObject(data);
                                    String user_id = jsonObject1.getString("user_id");
                                    String first_name = jsonObject1.getString("first_name");
                                    String last_name = jsonObject1.getString("last_name");
                                    String user_profile_image = jsonObject1.getString("user_profile_image");
                                    String user_address = jsonObject1.getString("user_address");
                                    String user_phone_number = jsonObject1.getString("user_phone_number");
                                    String kennel_club_name = jsonObject1.getString("kennel_club_name");



                                    Intent intent = new Intent(getApplicationContext(),OTPVerificationActivity.class);
                                    intent.putExtra("UserID",user_id);
                                    intent.putExtra("first_name",first_name);
                                    intent.putExtra("last_name",last_name);
                                    intent.putExtra("user_profile_image",user_profile_image);
                                    intent.putExtra("user_address",user_address);
                                    intent.putExtra("user_phone_number",user_phone_number);
                                    intent.putExtra("kennel_club_name",kennel_club_name);

                                    startActivity(intent);
                                    //startActivity(new Intent(getApplicationContext(),Verficaion.class));

                                }else
                                {
                                    Toast.makeText(SignUpActivity.this, "Phone Number Is Must Be Unique", Toast.LENGTH_SHORT).show();
//                                    edittext5.requestFocus();
//                                    edittext5.setError("Phone Number Is Must Be Unique");
                                    progressDialog.dismiss();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            //
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            })
            {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("user_password", password);
                    params.put("first_name", first);
                    params.put("user_phone_number", phone);
                    params.put("last_name", last);
                    params.put("user_birth_date", date1);
                    params.put("gender", gender);
                    params.put("user_email_id",email );
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(SignUpActivity.this);
            requestQueue.add(request);
        }
    }

}