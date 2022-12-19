package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.indiannationalkennelclub.RealPath.RealPathUtil;
import com.example.indiannationalkennelclub.ResponseModel.PedigreeFromResponse;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.example.indiannationalkennelclub.Spinner.ColorAndMakingSpinner;
import com.google.android.material.appbar.AppBarLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PedigreeFromActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private ArrayList<String> list = new ArrayList<>();

    private ScrollView vscroll1;
    private LinearLayout linear1;
    private TextView textview3;
    private TextView textview15;
    private TextView textview4;
    private EditText sire;
    private TextView textview5;
    private EditText dam;
    private LinearLayout linear7;
    private TextView textview17;
    private EditText dogname;
    private TextView textview6;
    private LinearLayout linear6;
    private TextView textview19;
    private TextView coloandmaking;
    private LinearLayout linear4;
    private TextView textview7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private TextView textview8;
    private LinearLayout linear3;
    private Button submit;
    private TextView textview16;
    private RadioButton radiobutton9;
    private RadioButton radiobutton10;
    private EditText edittext3;
    private ImageView imageview1;
    private TextView textview9;
    private RadioButton radiobutton6;
    private RadioButton radiobutton5;
    private Button selectimage;
    private TextView textview18;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview5;
    private RadioButton radiobutton3;
    private RadioButton radiobutton4;



    //Gender
    RadioGroup radioGroup;
    RadioButton radiobutton1;
    static String male= "1";

    //seconde owner
    RadioGroup radioGroup1;
    RadioButton radiobutton11,radiobutton22;
    static String owner= "0";

    // micro
    RadioButton required;
    RadioGroup microgrop;
    static String micro = "1";


    //Date
    ImageView date1;
    TextView date;

    AppConfig appConfig;
    Dialog dialog;
    ProgressDialog progressDialog;

    String SireURL = "https://test181120221003.inkc.in/api/dog/get_sire_details";
    String DamURL  = "https://test181120221003.inkc.in/api/dog/get_dam_details";
    String DogNameURl = "https://test181120221003.inkc.in/api/dog/is_dog_name_unique";
    String SecondOwnerUrl = "https://test181120221003.inkc.in/api/user/get_second_owner_id";
    String ColorAndMakingUrl = "https://test181120221003.inkc.in/api/dog/dog_color_marking_list";
    String MainUrl = "https://test181120221003.inkc.in/api/dog/";



    TextView sireset,damset,dognameset,colormakingid;
    LinearLayout secondeownerlayout;
    EditText secondownerid;
    TextView secondeownerset;
    ImageView imageselected;
    TextView errorimage;

    //color and making spinner
    ArrayList<ColorAndMakingSpinner> colorAndMakingSpinnerslist = new ArrayList<>();
    ArrayAdapter<ColorAndMakingSpinner> colorAndMakingSpinnerArrayAdapter;

    String path;




    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MyDogActivity.class));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedigree_from);

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
        vscroll1 = findViewById(R.id.vscroll1);
        linear1 = findViewById(R.id.linear1);
        textview3 = findViewById(R.id.textview3);
        textview15 = findViewById(R.id.textview15);
        textview4 = findViewById(R.id.textview4);
        sire = findViewById(R.id.edittext1);
        textview5 = findViewById(R.id.textview5);
        dam = findViewById(R.id.edittext2);
        textview17 = findViewById(R.id.textview17);
        dogname = findViewById(R.id.edittext10);
        textview6 = findViewById(R.id.textview6);
        linear6 = findViewById(R.id.linear6);
        textview19 = findViewById(R.id.textview19);
        coloandmaking = findViewById(R.id.spinner1);
        linear4 = findViewById(R.id.linear4);
        textview7 = findViewById(R.id.textview7);
        linear8 = findViewById(R.id.linear8);
        linear9 = findViewById(R.id.linear9);
        textview8 = findViewById(R.id.textview8);
        linear3 = findViewById(R.id.linear3);
        submit = findViewById(R.id.button2);
        textview16 = findViewById(R.id.textview16);
//        radiobutton9 = findViewById(R.id.radiobutton9);
//        radiobutton10 = findViewById(R.id.radiobutton10);
        edittext3 = findViewById(R.id.edittext3);
        imageview1 = findViewById(R.id.imageview1);
        textview9 = findViewById(R.id.textview9);
//        radiobutton6 = findViewById(R.id.radiobutton6);
//        radiobutton5 = findViewById(R.id.radiobutton5);
        selectimage = findViewById(R.id.button1);
        textview18 = findViewById(R.id.textview18);
        imageview3 = findViewById(R.id.imageview3);
        imageview4 = findViewById(R.id.imageview4);
        imageview5 = findViewById(R.id.imageview5);
//        radiobutton3 = findViewById(R.id.radiobutton3);
//        radiobutton4 = findViewById(R.id.radiobutton4);
        colormakingid = findViewById(R.id.colormakingid);
        imageselected = findViewById(R.id.imageselected);
        errorimage    = findViewById(R.id.errorimage);

        sireset = findViewById(R.id.sireset);
        damset = findViewById(R.id.damset);
        dognameset = findViewById(R.id.dognameset);

        secondeownerset = findViewById(R.id.secondeownerset);
        secondeownerlayout = findViewById(R.id.secondeownerlayout);
        secondownerid  = findViewById(R.id.secondownerid);


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
                    Toast.makeText(PedigreeFromActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        Toast.makeText(PedigreeFromActivity.this, "1", Toast.LENGTH_SHORT).show();
                        male = "1";
                    }
                    else
                    {
                        Toast.makeText(PedigreeFromActivity.this, "0", Toast.LENGTH_SHORT).show();
                        male = "0";
                    }

                }
            }
        });


        //owner
        radioGroup1 = findViewById(R.id.radiogroupgender1);
        radiobutton11 = radioGroup1.findViewById(R.id.radiobutton11);
        radiobutton22 = radioGroup1.findViewById(R.id.radiobutton22);

        radiobutton22.setChecked(true);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(PedigreeFromActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Yes"))
                    {
                        Toast.makeText(PedigreeFromActivity.this, "1", Toast.LENGTH_SHORT).show();
                        owner = "1";
                        secondeownerlayout.setVisibility(View.VISIBLE);
                        secondeownerset.setVisibility(View.VISIBLE);
                        secondownerid.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        Toast.makeText(PedigreeFromActivity.this, "0", Toast.LENGTH_SHORT).show();
                        owner = "0";
                        secondeownerlayout.setVisibility(View.GONE);
                        secondeownerset.setVisibility(View.GONE);
                        secondownerid.setVisibility(View.GONE);
                    }

                }
            }
        });


        //micro
        microgrop = findViewById(R.id.microgrop);
        required = microgrop.findViewById(R.id.required);
        required.setChecked(true);
        microgrop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(PedigreeFromActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Yes, I Require "))
                    {
                        Toast.makeText(PedigreeFromActivity.this, "1", Toast.LENGTH_SHORT).show();
                        micro = "1";
                    }
                    else
                    {
                        Toast.makeText(PedigreeFromActivity.this, "0", Toast.LENGTH_SHORT).show();
                        micro = "0";
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
                        PedigreeFromActivity.this,
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
                        PedigreeFromActivity.this,
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


        sire.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(PedigreeFromActivity.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                String sirenumber = sire.getText().toString().trim();
                StringRequest request = new StringRequest(Request.Method.POST, SireURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    String data = jsonObject.getString("data");
                                    String access_module = jsonObject.getString("access_module");
                                    String message = jsonObject.getString("message");
                                    String code = jsonObject.getString("code");
                                    String status = jsonObject.getString("status");

                                    if (code.equals("200"))
                                    {

                                        sireset.setVisibility(View.VISIBLE);
                                        sireset.setText(data);
                                    }
                                    else
                                    {
                                        sireset.setVisibility(View.VISIBLE);
                                        sireset.setText(data);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PedigreeFromActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                        params.put("sire_reg_number", sirenumber);
                        return  params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(PedigreeFromActivity.this);
                requestQueue.add(request);
            }
        });

        dam.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(PedigreeFromActivity.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                String damnumber = dam.getText().toString().trim();
                StringRequest request = new StringRequest(Request.Method.POST, DamURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    String data = jsonObject.getString("data");
                                    String access_module = jsonObject.getString("access_module");
                                    String message = jsonObject.getString("message");
                                    String code = jsonObject.getString("code");
                                    String status = jsonObject.getString("status");

                                    if (code.equals("200"))
                                    {

                                        damset.setVisibility(View.VISIBLE);
                                        damset.setText(data);
                                    }
                                    else
                                    {
                                        damset.setVisibility(View.VISIBLE);
                                        damset.setText(data);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PedigreeFromActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                        params.put("dam_reg_number", damnumber);
                        return  params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(PedigreeFromActivity.this);
                requestQueue.add(request);
            }
        });

        dogname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(PedigreeFromActivity.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                String damnamecheck = dogname.getText().toString().trim();
                StringRequest request = new StringRequest(Request.Method.POST, DogNameURl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    String data = jsonObject.getString("data");
                                    String access_module = jsonObject.getString("access_module");
                                    String message = jsonObject.getString("message");
                                    String code = jsonObject.getString("code");
                                    String status = jsonObject.getString("status");

                                    if (data.equals(""))
                                    {
                                        dognameset.setVisibility(View.GONE);
                                    }
                                    else
                                    {
                                        dognameset.setVisibility(View.VISIBLE);
                                        dognameset.setText(data);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PedigreeFromActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                        params.put("pet_name", damnamecheck);
                        return  params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(PedigreeFromActivity.this);
                requestQueue.add(request);
            }
        });

        secondownerid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(PedigreeFromActivity.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                String secondeName = secondownerid.getText().toString().trim();

                StringRequest request = new StringRequest(Request.Method.POST, SecondOwnerUrl,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    String data = jsonObject.getString("data");

                                    if (data.equals(""))
                                    {
                                        secondeownerset.setVisibility(View.GONE);
                                    }
                                    else
                                    {
                                        secondeownerset.setVisibility(View.VISIBLE);
                                        secondeownerset.setText(data);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(PedigreeFromActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

                RequestQueue requestQueue = Volley.newRequestQueue(PedigreeFromActivity.this);
                requestQueue.add(request);
            }
        });

        ColorAndMaking();

        coloandmaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(PedigreeFromActivity.this);

                // set custom dialog
                dialog.setContentView(R.layout.dialog_color_and_making_spinner);

                // set custom height and width
                dialog.getWindow().setLayout(950, 1100);

                // set transparent background
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // show dialog
                dialog.show();

                // Initialize and assign variable
                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                listView.setAdapter(colorAndMakingSpinnerArrayAdapter);
                editText.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                                        colorAndMakingSpinnerArrayAdapter.getFilter().filter(charSequence);
                                                    }

                                                    @Override
                                                    public void afterTextChanged(Editable editable) {

                                                    }

                                                }

                );


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // when item selected from list
                        // set selected item on textView
                        // select_category.setText(categoryAdapter.getItem(position));

                        ColorAndMakingSpinner spn = (ColorAndMakingSpinner) parent.getItemAtPosition(position);
                        coloandmaking.setText(spn.colour_name);
                        colormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });

        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent,10);
                }
                else
                {
                    ActivityCompat.requestPermissions(PedigreeFromActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddData();
            }
        });

    }

    private void AddData() {
        String Sire = sire.getText().toString().trim();
        String Dam  = dam.getText().toString().trim();
        String second = secondownerid.getText().toString();
        String Dog = dogname.getText().toString().trim();
        String Date = date.getText().toString().trim();
        String Color = colormakingid.getText().toString().trim();
        String Genger = male;
        String Micro  = micro;
        String Owner  = owner;

        if(Sire.isEmpty()){
            sire.requestFocus();
            sire.setError("Please enter your sire number");
            return;
        }
        else if(Dam.isEmpty()){
            dam.requestFocus();
            dam.setError("Please enter your dam number");
            return;
        }
        else if(Owner.equals("1")) {
         if (second.isEmpty()) {
                secondownerid.requestFocus();
                secondownerid.setError("Please enter owner id");
                return;
            }
         else if(Dog.isEmpty()){
             dogname.requestFocus();
             dogname.setError("Please enter name");
             return;
         }
         else if(Date.isEmpty()){
             date.requestFocus();
             date.setError("Please select date");
             return;
         }
         else if(Color.isEmpty()){
             coloandmaking.requestFocus();
             coloandmaking.setError("Please color and making");
             return;
         }
         else if(imageselected.getDrawable()==null){
             errorimage.setVisibility(View.VISIBLE);
             Toast.makeText(this, "please select dog image", Toast.LENGTH_SHORT).show();
         }
         else
         {
             progressDialog  = new ProgressDialog(PedigreeFromActivity.this);
             progressDialog.setMessage("Loading please...");
             progressDialog.show();

             appConfig = new AppConfig(PedigreeFromActivity.this);
             String token = appConfig.getuser_token();
             String userId = appConfig.getInkcRegis();

             Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                     .addConverterFactory(GsonConverterFactory.create()).build();

             File file =new File(path);
             RequestBody requestFiledog = RequestBody.create(MediaType.parse("multipart/form-data"),file);
             MultipartBody.Part body = MultipartBody.Part.createFormData("pet_image",file.getName(),requestFiledog);

             RequestBody Sirenum = RequestBody.create(MediaType.parse("multipart/form-data"),Sire);
             RequestBody Damnum = RequestBody.create(MediaType.parse("multipart/form-data"),Dam);
             RequestBody gender = RequestBody.create(MediaType.parse("multipart/form-data"),Genger);
             RequestBody date = RequestBody.create(MediaType.parse("multipart/form-data"),Date);
             RequestBody dog = RequestBody.create(MediaType.parse("multipart/form-data"),Dog);
             RequestBody color = RequestBody.create(MediaType.parse("multipart/form-data"),Color);
             RequestBody micro = RequestBody.create(MediaType.parse("multipart/form-data"),Micro);
             RequestBody owner = RequestBody.create(MediaType.parse("multipart/form-data"),Owner);
             RequestBody Second = RequestBody.create(MediaType.parse("multipart/form-data"),second);

             ApiService apiService = retrofit.create(ApiService.class);

             Call<PedigreeFromResponse> call = apiService.AddDataPadigree(body,Sirenum,Damnum,gender,date,dog,color,micro,owner,Second,userId,token);

             call.enqueue(new Callback<PedigreeFromResponse>() {
                 @Override
                 public void onResponse(Call<PedigreeFromResponse> call, retrofit2.Response<PedigreeFromResponse> response) {
                     if(response.isSuccessful())
                     {
                         if(response.body().getCode().equals(200)){
                             String message = response.body().getMessage();
                             Toast.makeText(PedigreeFromActivity.this, message, Toast.LENGTH_SHORT).show();
                             progressDialog.dismiss();
                         }
                         else
                         {
                             Toast.makeText(PedigreeFromActivity.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();
                             progressDialog.dismiss();
                         }
                     }
                     else
                     {
                         Toast.makeText(PedigreeFromActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                         progressDialog.dismiss();
                     }
                 }

                 @Override
                 public void onFailure(Call<PedigreeFromResponse> call, Throwable t) {
                     Toast.makeText(PedigreeFromActivity.this, "Something is Wrong", Toast.LENGTH_SHORT).show();
                     progressDialog.dismiss();
                 }
             });

         }
        }
        else if(Dog.isEmpty()){
            dogname.requestFocus();
            dogname.setError("Please enter name");
            return;
        }
        else if(Date.isEmpty()){
            date.requestFocus();
            date.setError("Please select date");
            return;
        }
        else if(Color.isEmpty()){
            coloandmaking.requestFocus();
            coloandmaking.setError("Please color and making");
            return;
        }
        else if(imageselected.getDrawable()==null){
            errorimage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "please select dog image", Toast.LENGTH_SHORT).show();
        }
        else
        {
            progressDialog  = new ProgressDialog(PedigreeFromActivity.this);
            progressDialog.setMessage("Loading please...");
            progressDialog.show();

            appConfig = new AppConfig(PedigreeFromActivity.this);
            String token = appConfig.getuser_token();
            String userId = appConfig.getInkcRegis();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            File file =new File(path);
            RequestBody requestFiledog = RequestBody.create(MediaType.parse("multipart/form-data"),file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("pet_image",file.getName(),requestFiledog);

            RequestBody Sirenum = RequestBody.create(MediaType.parse("multipart/form-data"),Sire);
            RequestBody Damnum = RequestBody.create(MediaType.parse("multipart/form-data"),Dam);
            RequestBody gender = RequestBody.create(MediaType.parse("multipart/form-data"),Genger);
            RequestBody date = RequestBody.create(MediaType.parse("multipart/form-data"),Date);
            RequestBody dog = RequestBody.create(MediaType.parse("multipart/form-data"),Dog);
            RequestBody color = RequestBody.create(MediaType.parse("multipart/form-data"),Color);
            RequestBody micro = RequestBody.create(MediaType.parse("multipart/form-data"),Micro);
            RequestBody owner = RequestBody.create(MediaType.parse("multipart/form-data"),Owner);
            RequestBody Second = RequestBody.create(MediaType.parse("multipart/form-data"),second);

            ApiService apiService = retrofit.create(ApiService.class);

            Call<PedigreeFromResponse> call = apiService.AddDataPadigree(body,Sirenum,Damnum,gender,date,dog,color,micro,owner,Second,userId,token);

            call.enqueue(new Callback<PedigreeFromResponse>() {
                @Override
                public void onResponse(Call<PedigreeFromResponse> call, retrofit2.Response<PedigreeFromResponse> response) {
                    if(response.isSuccessful())
                    {
                        if(response.body().getCode().equals(200)){
                            String message = response.body().getMessage();
                            Toast.makeText(PedigreeFromActivity.this, message, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(PedigreeFromActivity.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                    else
                    {
                        Toast.makeText(PedigreeFromActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<PedigreeFromResponse> call, Throwable t) {
                    Toast.makeText(PedigreeFromActivity.this, "Something is Wrong", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            });

        }

    }

    private void ColorAndMaking() {

        appConfig = new AppConfig(PedigreeFromActivity.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        StringRequest request = new StringRequest(Request.Method.POST, ColorAndMakingUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            int j = 0;
                            JSONObject jsonObject = new JSONObject(response);
                            String data = jsonObject.getString("data");
                            if (data.equals("false")) {

                                Toast.makeText(PedigreeFromActivity.this, "Data is not available", Toast.LENGTH_SHORT).show();
//                                progressDialog.dismiss();
                            }else
                            {
                                JSONArray jsonArray = jsonObject.getJSONArray("data");

//                                String user_token = jsonObject.getString("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    j++;
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String sn = String.valueOf(j);

                                    String colour_id = object.getString("colour_id");
                                    String colour_code = object.getString("colour_code");
                                    String colour_name = object.getString("colour_name");
                                    String colour_status = object.getString("colour_status");

                                    colorAndMakingSpinnerslist.add(new ColorAndMakingSpinner(colour_id,colour_code,colour_name,colour_status));
                                    colorAndMakingSpinnerArrayAdapter = new ArrayAdapter<ColorAndMakingSpinner>(PedigreeFromActivity.this,
                                            android.R.layout.simple_spinner_dropdown_item,colorAndMakingSpinnerslist);
                                    colorAndMakingSpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PedigreeFromActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap headers = new HashMap();
                headers.put("Userid", userId);
                headers.put("Usertoken",token);
                return headers;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(PedigreeFromActivity.this);
        requestQueue.add(request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 10 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = PedigreeFromActivity.this;
            path = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imageselected.setVisibility(View.VISIBLE);
            imageselected.setImageBitmap(bitmap);
            errorimage.setVisibility(View.GONE);
        }


    }

    private void initializeLogic() {
//        _view(button2, 30, 13, "#40c9a2");
//        spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list));
//        list.add("Select color and marking");
//        list.add("White");
//        list.add("White with black marking");
//        list.add("Brindle and white");
//        list.add("White with brown markings");
//        list.add("Black/white");
//        spinner1.setAdapter(new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list));
    }

    public void _view(final View _view, final double _radius, final double _shadow, final String _color) {
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