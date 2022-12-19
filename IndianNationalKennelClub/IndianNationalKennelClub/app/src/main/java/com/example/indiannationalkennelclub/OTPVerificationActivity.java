package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class OTPVerificationActivity extends AppCompatActivity {

    EditText otp;
    Button submit;
    String otpurl = "https://mployis.com/inkc1/api/login/verification";
    AppConfig appConfig;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        otp = findViewById(R.id.otp);
        submit = findViewById(R.id.submitotp);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OTP();
            }
        });

    }

    private void OTP() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Please Wait");
        progressDialog.show();

        appConfig = new AppConfig(OTPVerificationActivity.this);
        String UserID = getIntent().getStringExtra("UserID");

        String otpid  = otp.getText().toString();






        if (TextUtils.isEmpty(otpid)) {
            otp.setError("Enter Number");
            Toast.makeText(OTPVerificationActivity.this, "Enter OTP Number", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            StringRequest request = new StringRequest(Request.Method.POST, otpurl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String message = jsonObject.getString("message");
                                if(message.equals("OTP verified successfully")){
//
                                    String user_token = jsonObject.getString("user_token");
                                    appConfig.Saveuser_token(user_token);

                                    // Create the object of AlertDialog Builder class
                                    AlertDialog.Builder builder = new AlertDialog.Builder(OTPVerificationActivity.this);

                                    // Set the message show for the Alert time
                                    builder.setMessage("SuccessFull Completed");

                                    // Set Alert Title
                                    //builder.setTitle("Change Password !");

                                    // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                                    builder.setCancelable(false);

                                    // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                                    builder.setPositiveButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
                                        // When the user click yes button then app will close
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                        finish();
                                    });


                                    // Create the Alert dialog
                                    AlertDialog alertDialog = builder.create();
                                    // Show the Alert Dialog box
                                    alertDialog.show();
//                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                                    String data = jsonObject.getString("data");
//                                    JSONObject jsonObject1 = new JSONObject(data);
//
//                                    String user_id = jsonObject1.getString("user_id");
//                                    Intent intent = new Intent(getApplicationContext(),OTPVerificationActivity.class);
//                                    intent.putExtra("UserID",user_id);
//                                    startActivity(intent);
                                }
                                else
                                {
                                    Toast.makeText(OTPVerificationActivity.this, "Mobile Number is Not Exits", Toast.LENGTH_SHORT).show();
                                    progressDialog.dismiss();
                                }

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(OTPVerificationActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("user_id", UserID);
                    params.put("user_otp", otpid);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(OTPVerificationActivity.this);
            requestQueue.add(request);
        }
    }

}