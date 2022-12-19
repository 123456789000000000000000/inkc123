package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class ForgotActivity extends AppCompatActivity {

    EditText number,pass,cpass;
    TextView error;
    Button submit;
    String Forgoturl = "https://mployis.com/inkc1/api/login/forgotpassword";
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        number = findViewById(R.id.number);
        pass  = findViewById(R.id.pass);
        cpass = findViewById(R.id.cpass);
        error = findViewById(R.id.error);
        cpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(pass.getText().toString().equals(cpass.getText().toString())){
                    error.setText("PassWord Matched");
                    error.setTextColor(Color.parseColor("#22de18"));
                }
                else{
                    error.setText("PassWord Is Not Matched");
                    error.setTextColor(Color.parseColor("#de1c18"));

                }
            }
        });

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Forgot();
            }
        });

    }

    private void Forgot() {


        String phone = number.getText().toString();
        String password = pass.getText().toString();
        String cpassword = cpass.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            number.setError("Enter Number");
            Toast.makeText(ForgotActivity.this, "Enter Number", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(password)) {
            pass.setError("Enter Password");

            Toast.makeText(ForgotActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (TextUtils.isEmpty(cpassword)) {
            cpass.setError("Enter Password");

            Toast.makeText(ForgotActivity.this, "Enter Confirm Password", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            if (error.getText().toString().equals("PassWord Matched")) {
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Loading Please Wait");
                progressDialog.show();

                StringRequest request = new StringRequest(Request.Method.POST, Forgoturl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String message = jsonObject.getString("message");
                                    if (message.equals("Please verify user")) {

                                        String data = jsonObject.getString("data");
                                        JSONObject jsonObject1 = new JSONObject(data);

                                        String user_id = jsonObject1.getString("user_id");
                                        Intent intent = new Intent(getApplicationContext(), OTPVerificationActivity.class);
                                        intent.putExtra("UserID", user_id);
                                        startActivity(intent);
                                    } else {
                                        Toast.makeText(ForgotActivity.this, "Mobile Number is Not Exits", Toast.LENGTH_SHORT).show();
                                        progressDialog.dismiss();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ForgotActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("user_phone_number", phone);
                        params.put("user_password", password);
                        params.put("confirm_password", cpassword);
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(ForgotActivity.this);
                requestQueue.add(request);
            }
            else
            {
                Toast.makeText(this, "Confirm password is not matched", Toast.LENGTH_SHORT).show();
            }
        }
    }
}