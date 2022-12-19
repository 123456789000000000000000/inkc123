package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
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
import com.bumptech.glide.Glide;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.google.android.material.appbar.AppBarLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NonInkcDogDetails extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;
    private LinearLayout main_ui;
    ImageView circleimageview1;

    TextView dogname,dogdob,dogsex,dogregisternumber,dogbreed,dogcolor,dogcheck,dogsire,dogdam;
    TextView setdogid;
    TextView microdetail,deathreport,noteadd;
    AppConfig appConfig;
    ProgressDialog progressDialog;
    String DogDetailsURL = "https://test181120221003.inkc.in/api/dog/dog_details";
    String ImageUrl  = "https://test181120221003.inkc.in/";

    private  LinearLayout dogfuntion,ediprofile;
    static int check = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_inkc_dog_details);
        initialize(savedInstanceState);
        initializeLogic();
    }

    private void initialize(Bundle savedInstanceState) {
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
        dogname = findViewById(R.id.dogname);
        dogdob = findViewById(R.id.dogdob);
        dogsex = findViewById(R.id.dogsex);
        dogregisternumber = findViewById(R.id.dogregisternumber);
        dogbreed = findViewById(R.id.dogbreed);
        dogcolor = findViewById(R.id.dogcolor);

        circleimageview1 = findViewById(R.id.circleimageview1);
        String img =  getIntent().getStringExtra("images");
        if(img.equals(""))
        {
            Glide.with(NonInkcDogDetails.this).load(R.drawable.user).into(circleimageview1);

        }else {
            Glide.with(NonInkcDogDetails.this).load(ImageUrl + img).into(circleimageview1);
        }

//        dogcheck = findViewById(R.id.dogcheck);
//        dogsire  = findViewById(R.id.dogsire);
//        dogdam   = findViewById(R.id.dogdam);

        setdogid = findViewById(R.id.setdogid);

        microdetail = findViewById(R.id.microdetail);
        deathreport = findViewById(R.id.deathreport);
        noteadd     = findViewById(R.id.noteadd);

        fetchdata();

        microdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = dogname.getText().toString();
                String reg  = dogregisternumber.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MicroChipdetailsActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("reg",reg);
                startActivity(intent);
            }
        });

        ediprofile = findViewById(R.id.ediprofile);
        dogfuntion = findViewById(R.id.dogfuntion);

        ediprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check == 1) {
                    dogfuntion.setVisibility(View.VISIBLE);
                    check = 0;

                }
                else
                {
                    dogfuntion.setVisibility(View.GONE);
                    check = 1;

                }
            }
        });

        noteadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = setdogid.getText().toString().trim();
                appConfig = new AppConfig(NonInkcDogDetails.this);
                appConfig.SavePet_id(id);
                Intent intent  = new Intent(getApplicationContext(),NoteActivity.class);
                intent.putExtra("Id",id);
                startActivity(intent);

//                Toast.makeText(NonInkcDogDetails.this, id, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void fetchdata() {

        progressDialog  = new ProgressDialog(NonInkcDogDetails.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        appConfig = new AppConfig(NonInkcDogDetails.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        String petId = getIntent().getStringExtra("UserId");

        StringRequest request = new StringRequest(Request.Method.POST, DogDetailsURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);

                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject object = jsonArray.getJSONObject(i);
                                String pet_id = object.getString("pet_id");
                                String pet_name = object.getString("pet_name");
                                String birth_date = object.getString("birth_date");
                                String pet_gender = object.getString("pet_gender");
                                if(pet_gender.equals("1"))
                                {
                                    dogsex.setText("MALE");
                                }else
                                {
                                    dogsex.setText("FEMALE");
                                }
                                String pet_registration_number = object.getString("pet_registration_number");
                                String sub_category_name = object.getString("sub_category_name");
                                String color_marking = object.getString("color_marking");
                                String pet_checked = object.getString("pet_checked");
                                String sire_reg_number = object.getString("sire_reg_number");

                                dogname.setText(pet_name);
                                dogdob.setText(birth_date);
                                dogregisternumber.setText(pet_registration_number);
                                dogbreed.setText(sub_category_name);
                                if(color_marking.equals("null")){
                                    dogcolor.setText(" - ");
                                }else {
                                    dogcolor.setText(color_marking);
                                }
//                                dogcheck.setText(pet_checked);
//                                dogsire.setText(sire_reg_number);
//                                dogdam.setText(sire_reg_number);
                                setdogid.setText(pet_id);
                                progressDialog.dismiss();



                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NonInkcDogDetails.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                params.put("dog_id", petId);
                return  params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(NonInkcDogDetails.this);
        requestQueue.add(request);

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