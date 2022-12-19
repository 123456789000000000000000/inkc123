package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    Button registration,login;
    TextView forgot;
    EditText phone,password;

    String loginurl = "https://test181120221003.inkc.in/api/login";

    ProgressDialog progressDialog;
    public boolean isRememberUserLogin = true;
    private AppConfig appConfig;

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        appConfig = new AppConfig(this);
        if(appConfig.isUserLogin())
        {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);

        registration = findViewById(R.id.register);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });

        forgot = findViewById(R.id.forgot);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),ForgotActivity.class));
            }
        });

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),OTPVerificationActivity.class));
//                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                Login();
            }
        });
    }

    private void Login() {
        String username1 = phone.getText().toString().trim();
        String password1 = password.getText().toString().trim();

        if (TextUtils.isEmpty(username1)) {
            phone.setError("Enter Number");
            Toast.makeText(LoginActivity.this, "Enter Number", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(password1)) {
            password.setError("Enter Password");

            Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        } else {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Loading Please Wait");
            progressDialog.show();

            StringRequest request =new StringRequest(Request.Method.POST, loginurl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonObject = new JSONObject(response);

                                String message = jsonObject.getString("message");
                                String code = jsonObject.getString("code");

                                if(code.equals("200")) {
//                                String user_token = jsonObject.getString("user_token");

//                                String code = jsonObject.getString("code");
//                                String status = jsonObject.getString("status");
//                                Toast.makeText(LoginActivity.this, message+"/"+code+"/"+status, Toast.LENGTH_SHORT).show();

                                    String data = jsonObject.getString("data");
                                    JSONObject jsonObject1 = new JSONObject(data);
                                    String user_token = jsonObject.getString("user_token");

                                    String user_id = jsonObject1.getString("user_id");
                                    String user_employee_type = jsonObject1.getString("user_employee_type");
                                    String user_full_name = jsonObject1.getString("user_full_name");
                                    String first_name = jsonObject1.getString("first_name");
                                    String middle_name = jsonObject1.getString("middle_name");
                                    String last_name = jsonObject1.getString("last_name");
                                    String user_profile_image = jsonObject1.getString("user_profile_image");
                                    String gender = jsonObject1.getString("gender");
                                    String user_birth_date = jsonObject1.getString("user_birth_date");
                                    String user_email_id = jsonObject1.getString("user_email_id");
                                    String user_phone_number = jsonObject1.getString("user_phone_number");
                                    String alternet_contact_number = jsonObject1.getString("alternet_contact_number");
                                    String user_address = jsonObject1.getString("user_address");
                                    String user_address_2 = jsonObject1.getString("user_address_2");
                                    String user_local = jsonObject1.getString("user_local");
                                    String user_district = jsonObject1.getString("user_district");
                                    String user_state = jsonObject1.getString("user_state");
                                    String user_pincode = jsonObject1.getString("user_pincode");
                                    String user_otp = jsonObject1.getString("user_otp");
                                    String user_otp_tried = jsonObject1.getString("user_otp_tried");
                                    String is_verified = jsonObject1.getString("is_verified");
                                    String user_status = jsonObject1.getString("user_status");
                                    String member_status = jsonObject1.getString("member_status");
                                    String member_status_id = jsonObject1.getString("member_status_id");
                                    String kennel_club_name = jsonObject1.getString("kennel_club_name");
                                    String kennel_club_comment = jsonObject1.getString("kennel_club_comment");
                                    String kennel_club_status = jsonObject1.getString("kennel_club_status");
                                    String is_kennel_club_paid = jsonObject1.getString("is_kennel_club_paid");
                                    String user_updated_on = jsonObject1.getString("user_updated_on");
                                    String user_created_on = jsonObject1.getString("user_created_on");
                                    String emp_type_id = jsonObject1.getString("emp_type_id");


                                    if (isRememberUserLogin) {
                                        appConfig.updateUserLoginStatus(true);
                                        appConfig.SaveImagesession(user_profile_image);
                                        appConfig.SaveNamesession(first_name + " " + last_name);
                                        appConfig.SaveAddresssesion(user_address);
                                        appConfig.SaveContactsession(user_phone_number);
                                        appConfig.SaveInkcRegis(user_id);
                                        appConfig.SaveMemberShip(kennel_club_name);
                                        appConfig.Saveuser_token(user_token);
                                        appConfig.Saveuser_id(user_id);


                                    }
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

//                                Toast.makeText(LoginActivity.this, user_id, Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }
                                else
                                {
                                    Toast.makeText(LoginActivity.this, "Phone Number and Password is Wrong", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("user_phone_number", username1);
                    params.put("user_password", password1);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
            requestQueue.add(request);
        }
    }
}