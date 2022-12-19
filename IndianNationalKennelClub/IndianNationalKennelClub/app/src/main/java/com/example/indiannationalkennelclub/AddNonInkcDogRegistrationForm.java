package com.example.indiannationalkennelclub;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
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
import com.example.indiannationalkennelclub.ResponseModel.AddNonInkcDogRegisterResponse;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.example.indiannationalkennelclub.Spinner.BreedSpinner;
import com.example.indiannationalkennelclub.Spinner.InkcClubSpinners;
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


public class AddNonInkcDogRegistrationForm extends AppCompatActivity {



    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private ArrayList<String> list1 = new ArrayList<>();
    private ArrayList<String> list2 = new ArrayList<>();

    private ScrollView vscroll1;
    private LinearLayout linear1;
    private LinearLayout linear10;
    private LinearLayout linear19;
    private LinearLayout linear11;
    private LinearLayout linear23;
    private LinearLayout linear25;
    private LinearLayout linear8;
    private LinearLayout linear26;
    private LinearLayout linear27;
    private LinearLayout linear14;
    private LinearLayout linear33;
    private LinearLayout linear28;
    private EditText dogname;
    private LinearLayout linear13;
    private LinearLayout linear6;
    private LinearLayout linear29;
    private TextView breeds;
    private LinearLayout linear30;
    private Button submit;
    private LinearLayout linear39;
    private LinearLayout linear40;
    private TextView textview41;
    private TextView textview4;
    private TextView textview20;
    private LinearLayout linear21;
    private Button chosephotodog;
    private TextView textview30;
    private TextView textview5;
    private TextView textview27;
    private LinearLayout linear24;
    private Button chosephotofront;
    private TextView textview31;
    private TextView textview7;
    private TextView textview32;
    private Button chosephotoback;
    private TextView textview18;
    private TextView textview33;
    private TextView textview34;
    private EditText regnumber;
    private TextView textview8;
    private TextView textview26;
    private TextView kanelname;
    private TextView textview35;
    private TextView textview36;
    private TextView textview6;
    private TextView textview23;
    private EditText edittext3;
    private ImageView imageview1;
    private TextView textview37;
    private TextView textview38;
    private TextView textview39;
    private TextView textview40;
    private RadioButton radiobutton11;
    private RadioButton radiobutton12;


    ImageView chosephotodogimage,chosephotofrontimage,chosephotobackimage;
    // Retrofit
    String pathdog,pathfront,pathback;

    //Gender
    RadioGroup radioGroup;
    RadioButton radiobutton1,radiobutton2;
    static String male= "1";

    //Date
    ImageView date1;
    TextView date;

    //Spinner
    ArrayList<InkcClubSpinners> inkcClubSpinnerslist = new ArrayList<>();
    ArrayAdapter<InkcClubSpinners> spinnersArrayAdapter;

    ArrayList<BreedSpinner> breedSpinnerslist = new ArrayList<>();
    ArrayAdapter<BreedSpinner> breedSpinnerArrayAdapter;

    //URLs
    String kanelnameUrl = "https://test181120221003.inkc.in/api/dog/kennel_list_for_non_inkc";
    String BreedUrl = "https://test181120221003.inkc.in/api/dog/dog_breed_list";
    String MainUrl = "https://test181120221003.inkc.in/api/dog/";


    AppConfig appConfig;
    ProgressDialog progressDialog;
    Dialog dialog;

    // SetIds
    TextView setbreedid,kennelclubsetid;

    //SetError Image
    TextView errordogimage,errorfrontimage,errorbackimage;


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MyDogActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_non_inkc_dog_registration_form);
        initialize(savedInstanceState);
        initializeLogic();
    }


    @SuppressLint("WrongViewCast")
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
        vscroll1 = findViewById(R.id.vscroll1);
        linear1 = findViewById(R.id.linear1);
        linear10 = findViewById(R.id.linear10);
        linear19 = findViewById(R.id.linear19);
        linear11 = findViewById(R.id.linear11);
        linear23 = findViewById(R.id.linear23);
        linear25 = findViewById(R.id.linear25);
        linear8 = findViewById(R.id.linear8);
        linear26 = findViewById(R.id.linear26);
        linear27 = findViewById(R.id.linear27);
        linear14 = findViewById(R.id.linear14);
        linear33 = findViewById(R.id.linear33);
        linear28 = findViewById(R.id.linear28);
        dogname = findViewById(R.id.edittext12);
        linear13 = findViewById(R.id.linear13);
        linear6 = findViewById(R.id.linear6);
        linear29 = findViewById(R.id.linear29);
        breeds = findViewById(R.id.breed);
        linear30 = findViewById(R.id.linear30);
        submit = findViewById(R.id.button2);
        linear39 = findViewById(R.id.linear39);
        linear40 = findViewById(R.id.linear40);
        textview41 = findViewById(R.id.textview41);
        textview4 = findViewById(R.id.textview4);
        textview20 = findViewById(R.id.textview20);
        linear21 = findViewById(R.id.linear21);
        chosephotodog = findViewById(R.id.button4);
        textview30 = findViewById(R.id.textview30);
        textview5 = findViewById(R.id.textview5);
        textview27 = findViewById(R.id.textview27);
        linear24 = findViewById(R.id.linear24);
        chosephotofront = findViewById(R.id.button5);
        textview31 = findViewById(R.id.textview31);
        textview7 = findViewById(R.id.textview7);
        textview32 = findViewById(R.id.textview32);
        chosephotoback = findViewById(R.id.button1);
        textview18 = findViewById(R.id.textview18);
        textview33 = findViewById(R.id.textview33);
        textview34 = findViewById(R.id.textview34);
        regnumber = findViewById(R.id.edittext11);
        textview8 = findViewById(R.id.textview8);
        textview26 = findViewById(R.id.textview26);
        kanelname = findViewById(R.id.edittext14);
        textview35 = findViewById(R.id.textview35);
        textview36 = findViewById(R.id.textview36);
        textview6 = findViewById(R.id.textview6);
        textview23 = findViewById(R.id.textview23);
        edittext3 = findViewById(R.id.edittext3);
        imageview1 = findViewById(R.id.imageview1);
        textview37 = findViewById(R.id.textview37);
        textview38 = findViewById(R.id.textview38);
        textview39 = findViewById(R.id.textview39);
        textview40 = findViewById(R.id.textview40);

        setbreedid = findViewById(R.id.setbreedid);
        kennelclubsetid = findViewById(R.id.kennelclubsetid);

        errordogimage = findViewById(R.id.errordogimage);
        errorfrontimage = findViewById(R.id.errorfrontimage);
        errorbackimage  = findViewById(R.id.errorbackimage);

        KanelNameFetch();
        BreedFetch();



        chosephotodogimage = findViewById(R.id.chosephotodog);
        chosephotofrontimage = findViewById(R.id.chosephotofront);
        chosephotobackimage  = findViewById(R.id.chosephotoback);

        chosephotodog.setOnClickListener(new View.OnClickListener() {
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
                    ActivityCompat.requestPermissions(AddNonInkcDogRegistrationForm.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });
        chosephotofront.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent,11);
                }
                else
                {
                    ActivityCompat.requestPermissions(AddNonInkcDogRegistrationForm.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });
        chosephotoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent,12);
                }
                else
                {
                    ActivityCompat.requestPermissions(AddNonInkcDogRegistrationForm.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });

        // Gender
        radioGroup = findViewById(R.id.radiogroupgender);
        radiobutton1 = radioGroup.findViewById(R.id.radiobutton1);
        radiobutton2 = radioGroup.findViewById(R.id.radiobutton2);
        radiobutton1.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(AddNonInkcDogRegistrationForm.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        Toast.makeText(AddNonInkcDogRegistrationForm.this, "1", Toast.LENGTH_SHORT).show();
                        male = "1";
                    }
                    else
                    {
                        Toast.makeText(AddNonInkcDogRegistrationForm.this, "0", Toast.LENGTH_SHORT).show();
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
                        AddNonInkcDogRegistrationForm.this,
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
                        AddNonInkcDogRegistrationForm.this,
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

        kanelname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(AddNonInkcDogRegistrationForm.this);

                // set custom dialog
                dialog.setContentView(R.layout.dialog_spinner_kanel_name);

                // set custom height and width
                dialog.getWindow().setLayout(950, 1100);

                // set transparent background
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // show dialog
                dialog.show();

                // Initialize and assign variable
                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                listView.setAdapter(spinnersArrayAdapter);
                editText.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                                        spinnersArrayAdapter.getFilter().filter(charSequence);
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

                        InkcClubSpinners spn = (InkcClubSpinners) parent.getItemAtPosition(position);
                        kanelname.setText(spn.kennel_club_name);
                        kennelclubsetid.setText(spn.kennel_club_prefix);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();


                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });


            }
        });
        breeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(AddNonInkcDogRegistrationForm.this);

                // set custom dialog
                dialog.setContentView(R.layout.dialog_spinner_breed);

                // set custom height and width
                dialog.getWindow().setLayout(950, 1100);

                // set transparent background
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                // show dialog
                dialog.show();

                // Initialize and assign variable
                EditText editText = dialog.findViewById(R.id.edit_text);
                ListView listView = dialog.findViewById(R.id.list_view);

                listView.setAdapter(breedSpinnerArrayAdapter);
                editText.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                                        breedSpinnerArrayAdapter.getFilter().filter(charSequence);
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

                        BreedSpinner spn = (BreedSpinner) parent.getItemAtPosition(position);
                        breeds.setText(spn.sub_category_name);
                        setbreedid.setText(spn.sub_cat_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();


                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });


            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Upload();
            }
        });
    }

    private void BreedFetch() {
        appConfig = new AppConfig(AddNonInkcDogRegistrationForm.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        StringRequest request = new StringRequest(Request.Method.POST, BreedUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            int j = 0;
                            JSONObject jsonObject = new JSONObject(response);
                            String data = jsonObject.getString("data");
                            if (data.equals("false")) {

                                Toast.makeText(AddNonInkcDogRegistrationForm.this, "Data is not available", Toast.LENGTH_SHORT).show();
//                                progressDialog.dismiss();
                            }else
                            {
                                JSONArray jsonArray = jsonObject.getJSONArray("data");

                                String user_token = jsonObject.getString("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    j++;
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String sn = String.valueOf(j);

                                    String sub_cat_id = object.getString("sub_cat_id");
                                    String pet_category_id = object.getString("pet_category_id");
                                    String sub_category_name = object.getString("sub_category_name");
                                    String sub_category_code = object.getString("sub_category_code");

                                    breedSpinnerslist.add(new BreedSpinner(sub_cat_id,pet_category_id,sub_category_name,sub_category_code));
                                    breedSpinnerArrayAdapter = new ArrayAdapter<BreedSpinner>(AddNonInkcDogRegistrationForm.this,
                                            android.R.layout.simple_spinner_dropdown_item,breedSpinnerslist);
                                    breedSpinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddNonInkcDogRegistrationForm.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(AddNonInkcDogRegistrationForm.this);
        requestQueue.add(request);
    }

    private void KanelNameFetch() {
        appConfig = new AppConfig(AddNonInkcDogRegistrationForm.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        StringRequest request = new StringRequest(Request.Method.POST, kanelnameUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            int j = 0;
                            JSONObject jsonObject = new JSONObject(response);
                            String data = jsonObject.getString("data");
                            if (data.equals("false")) {

                                Toast.makeText(AddNonInkcDogRegistrationForm.this, "Data is not available", Toast.LENGTH_SHORT).show();
//                                progressDialog.dismiss();
                            }else
                            {
                                JSONArray jsonArray = jsonObject.getJSONArray("data");

                                String user_token = jsonObject.getString("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    j++;
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String sn = String.valueOf(j);

                                    String kennel_club_id = object.getString("kennel_club_id");
                                    String kennel_club_name = object.getString("kennel_club_name");
                                    String kennel_club_prefix = object.getString("kennel_club_prefix");

                                    inkcClubSpinnerslist.add(new InkcClubSpinners(kennel_club_id,kennel_club_name,kennel_club_prefix));
                                    spinnersArrayAdapter = new ArrayAdapter<InkcClubSpinners>(AddNonInkcDogRegistrationForm.this,
                                            android.R.layout.simple_spinner_dropdown_item,inkcClubSpinnerslist);
                                    spinnersArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                                }
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(AddNonInkcDogRegistrationForm.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(AddNonInkcDogRegistrationForm.this);
        requestQueue.add(request);
    }

    private void Upload() {

        String RegNumber = regnumber.getText().toString().trim();
        String Dogname   = dogname.getText().toString().trim();
        String kannelnameid = kennelclubsetid.getText().toString().trim();
        String breedid    =  setbreedid.getText().toString().trim();
        String Date       = date.getText().toString().trim();

        if(chosephotodogimage.getDrawable()==null){
           errordogimage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "please select dog image", Toast.LENGTH_SHORT).show();
        }
        else if(chosephotofrontimage.getDrawable() == null){
            errorfrontimage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "please select certificate front image", Toast.LENGTH_SHORT).show();
        }
        else if(chosephotobackimage.getDrawable() == null){
            errorbackimage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "please select certificate back image", Toast.LENGTH_SHORT).show();
        }
        else if(RegNumber.isEmpty()){
            regnumber.requestFocus();
            regnumber.setError("Please enter Register Number");
            return;
        }
        else if(kannelnameid.isEmpty()){
            kanelname.requestFocus();
            kanelname.setError("Please select kennel name");
            return;
        }
        else if(Dogname.isEmpty()){
            dogname.requestFocus();
            dogname.setError("Please enter dog name");
            return;
        }
        else if(Date.isEmpty()){
            date.requestFocus();
            date.setError("Please select date");
            return;
        }
        else if(breedid.isEmpty()){
            breeds.requestFocus();
            breeds.setError("Please select breed");
            return;
        }
        else
        {
            progressDialog  = new ProgressDialog(AddNonInkcDogRegistrationForm.this);
            progressDialog.setMessage("Loading please...");
            progressDialog.show();

            appConfig = new AppConfig(AddNonInkcDogRegistrationForm.this);
            String token = appConfig.getuser_token();
            String userId = appConfig.getInkcRegis();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            File filedog =new File(pathdog);
            RequestBody requestFiledog = RequestBody.create(MediaType.parse("multipart/form-data"),filedog);
            MultipartBody.Part bodydog = MultipartBody.Part.createFormData("pet_image",filedog.getName(),requestFiledog);

            File filefront =new File(pathfront);
            RequestBody requestFilefront = RequestBody.create(MediaType.parse("multipart/form-data"),filefront);
            MultipartBody.Part bodyfront = MultipartBody.Part.createFormData("front_side_certificate",filefront.getName(),requestFilefront);

            File fileback =new File(pathback);
            RequestBody requestFileback = RequestBody.create(MediaType.parse("multipart/form-data"),fileback);
            MultipartBody.Part bodyback = MultipartBody.Part.createFormData("back_side_certificate",fileback.getName(),requestFileback);

            RequestBody Registernumber = RequestBody.create(MediaType.parse("multipart/form-data"),RegNumber);
            RequestBody kennelid = RequestBody.create(MediaType.parse("multipart/form-data"),kannelnameid);
            RequestBody dogname = RequestBody.create(MediaType.parse("multipart/form-data"),Dogname);
            RequestBody date = RequestBody.create(MediaType.parse("multipart/form-data"),Date);
            RequestBody breed = RequestBody.create(MediaType.parse("multipart/form-data"),breedid);
            RequestBody gender = RequestBody.create(MediaType.parse("multipart/form-data"),male);

            ApiService apiService = retrofit.create(ApiService.class);

            Call<AddNonInkcDogRegisterResponse>  call = apiService.AddData(bodydog,bodyfront,bodyback,Registernumber,kennelid,
                    dogname,date,breed,gender,userId,token);

            call.enqueue(new Callback<AddNonInkcDogRegisterResponse>() {
                @Override
                public void onResponse(Call<AddNonInkcDogRegisterResponse> call, retrofit2.Response<AddNonInkcDogRegisterResponse> response) {
                    if(response.isSuccessful())
                    {
                        if(response.body().getCode().equals(200)){
                            String message = response.body().getMessage();
                            Toast.makeText(AddNonInkcDogRegistrationForm.this, message, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),NonInkcRegisterDogShowActivity.class));
                            progressDialog.show();
                        }
                        else
                        {
                            regnumber.requestFocus();
                            regnumber.setError("Dog registration number allready exist...");
                            Toast.makeText(AddNonInkcDogRegistrationForm.this, "Dog registration number allready exist...", Toast.LENGTH_SHORT).show();
                            progressDialog.show();

                        }
                    }
                }

                @Override
                public void onFailure(Call<AddNonInkcDogRegisterResponse> call, Throwable t) {
                    Toast.makeText(AddNonInkcDogRegistrationForm.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                }
            });


        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 10 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = AddNonInkcDogRegistrationForm.this;
            pathdog = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(pathdog);
            chosephotodogimage.setImageBitmap(bitmap);
            errordogimage.setVisibility(View.GONE);
        }
        else if(requestCode== 11 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = AddNonInkcDogRegistrationForm.this;
            pathfront = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(pathfront);
            chosephotofrontimage.setImageBitmap(bitmap);
            errorfrontimage.setVisibility(View.GONE);
        }
        else if(requestCode== 12 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = AddNonInkcDogRegistrationForm.this;
            pathback = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(pathback);
            chosephotobackimage.setImageBitmap(bitmap);
            errorbackimage.setVisibility(View.GONE);
        }

    }

    private void initializeLogic() {
//        _view(submit, 35, 13, "#40c9a2");
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