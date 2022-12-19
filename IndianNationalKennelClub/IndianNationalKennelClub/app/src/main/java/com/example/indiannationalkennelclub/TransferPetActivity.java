package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.google.android.material.appbar.AppBarLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TransferPetActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private LinearLayout main_ui;
    private LinearLayout linear4;
    private LinearLayout linear6;

    EditText tranferid;
    Button submittranfer;
    ProgressDialog progressDialog;
    AppConfig appConfig;
    String TranferURL = "https://test181120221003.inkc.in/api/dog/transfer_registration";
    String SecondOwnerUrl = "https://test181120221003.inkc.in/api/user/get_second_owner_id";

    TextView tranfernameset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_pet);
        initialize(savedInstanceState);
        initializeLogic();
    }
    private void initialize(Bundle _savedInstanceState) {
        _app_bar = findViewById(R.id._app_bar);
        _coordinator = findViewById(R.id._coordinator);
        _toolbar = findViewById(R.id._toolbar);
        setSupportActionBar(_toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        _toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                onBackPressed();
            }
        });
        main_ui = findViewById(R.id.main_ui);
        linear4 = findViewById(R.id.linear4);
        linear6 = findViewById(R.id.linear6);

        tranferid = findViewById(R.id.tranferid);
        submittranfer = findViewById(R.id.submittranfer);
        tranfernameset = findViewById(R.id.tranfernameset);

        tranferid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(TransferPetActivity.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                String secondeName = tranferid.getText().toString().trim();

                StringRequest request = new StringRequest(Request.Method.POST, SecondOwnerUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    String data = jsonObject.getString("data");
                                    tranfernameset.setText(data);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TransferPetActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap headers = new HashMap();
                        headers.put("Userid", userId);
                        headers.put("Usertoken",token);
                        return headers;
                    }

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("second_owner_id", secondeName);
                        return  params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(TransferPetActivity.this);
                requestQueue.add(request);
            }
        });

        submittranfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(TransferPetActivity.this);
                final View customLayout = getLayoutInflater().inflate(R.layout.dialog_pet_tranfer, null);
                alertDialog.setView(customLayout);

                String name = getIntent().getStringExtra("name");
                String reg  = getIntent().getStringExtra("reg");

                TextView petname = customLayout.findViewById(R.id.petname);
                TextView registernumber = customLayout.findViewById(R.id.registernumber);
                TextView ownername = customLayout.findViewById(R.id.ownername);

                String set = tranfernameset.getText().toString().trim();
                ownername.setText(set);
                petname.setText(name);
                registernumber.setText(reg);

                alertDialog.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });

                alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tranfer = tranferid.getText().toString().trim();

                        if(tranfer.isEmpty()){
                            tranferid.requestFocus();
                            tranferid.setError("INKC Number of the new Owner");
                            return;
                        }
                        else {

                            progressDialog = new ProgressDialog(TransferPetActivity.this);
                            progressDialog.setMessage("Loading Please ...");
                            progressDialog.show();

                            appConfig = new AppConfig(TransferPetActivity.this);
                            String token = appConfig.getuser_token();
                            String userId = appConfig.getInkcRegis();

                            String petid = getIntent().getStringExtra("Id");

                            StringRequest request = new StringRequest(Request.Method.POST, TranferURL,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try {
                                                JSONObject jsonObject = new JSONObject(response);

                                                String message = jsonObject.getString("message");
                                                Toast.makeText(TransferPetActivity.this, message, Toast.LENGTH_SHORT).show();

                                                progressDialog.dismiss();
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }

                                        }
                                    }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(TransferPetActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }){
                                @Override
                                public Map<String, String> getHeaders() throws AuthFailureError {
                                    HashMap headers = new HashMap();
                                    headers.put("Userid", userId);
                                    headers.put("Usertoken",token);
                                    return headers;
                                }

                                @Nullable
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    Map<String,String> params = new HashMap<String,String>();
                                    params.put("transfer_to_id", tranfer);
                                    params.put("transfer_pet_id", petid);

                                    return  params;
                                }
                            };
                            RequestQueue requestQueue = Volley.newRequestQueue(TransferPetActivity.this);
                            requestQueue.add(request);

                        }
                    }
                });

                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(false);
                alert.show();

            }
        });

//        submittranfer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String tranfer = tranferid.getText().toString().trim();
//
//                if(tranfer.isEmpty()){
//                    tranferid.requestFocus();
//                    tranferid.setError("INKC Number of the new Owner");
//                    return;
//                }
//                else {
//
//                    progressDialog = new ProgressDialog(TransferPetActivity.this);
//                    progressDialog.setMessage("Loading Please ...");
//                    progressDialog.show();
//
//                    appConfig = new AppConfig(TransferPetActivity.this);
//                    String token = appConfig.getuser_token();
//                    String userId = appConfig.getInkcRegis();
//
//                    String petid = getIntent().getStringExtra("Id");
//
//                    StringRequest request = new StringRequest(Request.Method.POST, TranferURL,
//                            new Response.Listener<String>() {
//                                @Override
//                                public void onResponse(String response) {
//
//                                }
//                            }, new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(TransferPetActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    }){
//                        @Override
//                        public Map<String, String> getHeaders() throws AuthFailureError {
//                            HashMap headers = new HashMap();
//                            headers.put("Userid", userId);
//                            headers.put("Usertoken",token);
//                            return headers;
//                        }
//
//                        @Nullable
//                        @Override
//                        protected Map<String, String> getParams() throws AuthFailureError {
//                            Map<String,String> params = new HashMap<String,String>();
//                            params.put("transfer_to_id", tranfer);
//                            params.put("transfer_pet_id", petid);
//
//                            return  params;
//                        }
//                    };
//                    RequestQueue requestQueue = Volley.newRequestQueue(TransferPetActivity.this);
//                    requestQueue.add(request);
//
//                }
//
//                }
//        });

    }

    private void initializeLogic() {
        {
            android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
            int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
            SketchUi.setColor(0xFFfaa916);SketchUi.setCornerRadii(new float[]{
                d*0,d*0,d*0 ,d*0,d*0,d*0 ,d*103,d*103});
            main_ui.setElevation(d*3);
            android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
            main_ui.setBackground(SketchUiRD);
            main_ui.setClickable(true);
        }

    }

    public void _radius(final View _view, final double _radius, final double _shadow, final String _color) {
        android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();

        ab.setColor(Color.parseColor(_color));
        ab.setCornerRadius((float) _radius);
        _view.setElevation((float) _shadow);
        _view.setBackground(ab);
    }


    @Deprecated
    public void showMessage(String _s) {
        Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
    }

    @Deprecated
    public int getLocationX(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[0];
    }

    @Deprecated
    public int getLocationY(View _v) {
        int _location[] = new int[2];
        _v.getLocationInWindow(_location);
        return _location[1];
    }

    @Deprecated
    public int getRandom(int _min, int _max) {
        Random random = new Random();
        return random.nextInt(_max - _min + 1) + _min;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
        ArrayList<Double> _result = new ArrayList<Double>();
        SparseBooleanArray _arr = _list.getCheckedItemPositions();
        for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
            if (_arr.valueAt(_iIdx))
                _result.add((double)_arr.keyAt(_iIdx));
        }
        return _result;
    }

    @Deprecated
    public float getDip(int _input) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}