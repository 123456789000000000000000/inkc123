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
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
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
import com.example.indiannationalkennelclub.ResponseModel.UnknowPedigreeFromResponse;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.example.indiannationalkennelclub.Spinner.BreedSpinner;
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

public class UnknownPadigreeRegistration extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> list1 = new ArrayList<>();
    private ArrayList<String> list2 = new ArrayList<>();

    private LinearLayout linear23;
    private ScrollView vscroll1;
    private LinearLayout linear1;
    private LinearLayout linear7;
    private LinearLayout linear11;
    private EditText edittext1;
    private LinearLayout linear12;
    private LinearLayout linear6;
    private CalendarView calendarview1;
    private LinearLayout linear13;
    private Spinner spinner1;
    private LinearLayout linear14;
    private Spinner spinner2;
    private LinearLayout linear4;
    private LinearLayout linear15;
    private LinearLayout linear8;
    private LinearLayout linear20;
    private LinearLayout linear16;
    private LinearLayout linear9;
    private LinearLayout linear21;
    private LinearLayout linear17;
    private LinearLayout linear10;
    private LinearLayout linear22;
    private LinearLayout linear18;
    private LinearLayout linear3;
    private Button button2;
    private TextView textview16;
    private TextView textview23;
    private RadioButton radiobutton9;
    private RadioButton radiobutton10;
    private TextView textview4;
    private TextView textview24;
    private TextView textview6;
    private TextView textview25;
    private EditText edittext3;
    private ImageView imageview1;
    private TextView textview14;
    private TextView textview26;
    private TextView textview5;
    private TextView textview27;
    private TextView textview9;
    private TextView textview28;
    private RadioButton radiobutton6;
    private RadioButton radiobutton5;
    private TextView textview7;
    private TextView textview29;
    private Button button1;
    private TextView textview18;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private TextView textview19;
    private TextView textview30;
    private Button button3;
    private TextView textview20;
    private ImageView imageview5;
    private TextView textview21;
    private TextView textview31;
    private Button button4;
    private TextView textview22;
    private ImageView imageview6;
    private ImageView imageview7;
    private TextView textview8;
    private TextView textview32;
    private RadioButton radiobutton3;
    private RadioButton radiobutton4;
    private LinearLayout linear24;
    private TextView textview3;
    private TextView textview15;

    //Gender
    RadioGroup radioGroup;
    RadioButton radiobutton1,radiobutton2;
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

    //breed Spinner
    ArrayList<BreedSpinner> breedSpinnerslist = new ArrayList<>();
    ArrayAdapter<BreedSpinner> breedSpinnerArrayAdapter;

    //color and making spinner
    ArrayList<ColorAndMakingSpinner> colorAndMakingSpinnerslist = new ArrayList<>();
    ArrayAdapter<ColorAndMakingSpinner> colorAndMakingSpinnerArrayAdapter;

    //URL's
    String BreedUrl = "https://test181120221003.inkc.in/api/dog/dog_breed_list";
    String MainUrl = "https://test181120221003.inkc.in/api/dog/";
    String ColorAndMakingUrl = "https://test181120221003.inkc.in/api/dog/dog_color_marking_list";
    String DogNameURl = "https://test181120221003.inkc.in/api/dog/is_dog_name_unique";
    String SecondOwnerUrl = "https://test181120221003.inkc.in/api/user/get_second_owner_id";



    AppConfig appConfig;
    ProgressDialog progressDialog;
    Dialog dialog;

    String pathdog,pathhigh,pathsize;

    LinearLayout secondeownerlayout;
    EditText secondownerid,dogname;
    TextView dognameset;
    TextView secondeownerset, colormaking,colormakingid, breed,setbreedid;
    Button selectimagedog,selectimagehigh,selectimagesize;
    ImageView imageselected,imageselecthigh,imageselectedside;
    TextView errorimage,errorimagehigh,errorimageside;
    Button submit;


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        startActivity(new Intent(getApplicationContext(),MyDogActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unknown_padigree_registration);
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
        linear23 = findViewById(R.id.linear23);
        vscroll1 = findViewById(R.id.vscroll1);
        linear1 = findViewById(R.id.linear1);
        linear7 = findViewById(R.id.linear7);
        linear11 = findViewById(R.id.linear11);
        edittext1 = findViewById(R.id.edittext1);
        linear12 = findViewById(R.id.linear12);
        linear6 = findViewById(R.id.linear6);
        linear13 = findViewById(R.id.linear13);
        linear14 = findViewById(R.id.linear14);
        linear4 = findViewById(R.id.linear4);
        linear15 = findViewById(R.id.linear15);
        linear8 = findViewById(R.id.linear8);
        linear20 = findViewById(R.id.linear20);
        linear16 = findViewById(R.id.linear16);
        linear9 = findViewById(R.id.linear9);
        linear21 = findViewById(R.id.linear21);
        linear17 = findViewById(R.id.linear17);
        linear10 = findViewById(R.id.linear10);
        linear22 = findViewById(R.id.linear22);
        linear3 = findViewById(R.id.linear3);
        button2 = findViewById(R.id.button2);
        textview16 = findViewById(R.id.textview16);
        textview23 = findViewById(R.id.textview23);

        textview4 = findViewById(R.id.textview4);
        textview6 = findViewById(R.id.textview6);
        textview25 = findViewById(R.id.textview25);
        edittext3 = findViewById(R.id.edittext3);
        imageview1 = findViewById(R.id.imageview1);
        textview14 = findViewById(R.id.textview14);
        textview26 = findViewById(R.id.textview26);
        textview5 = findViewById(R.id.textview5);
        textview27 = findViewById(R.id.textview27);
        textview9 = findViewById(R.id.textview9);
        textview28 = findViewById(R.id.textview28);

        textview7 = findViewById(R.id.textview7);
        textview29 = findViewById(R.id.textview29);
        button1 = findViewById(R.id.button1);
        textview18 = findViewById(R.id.textview18);
        imageview2 = findViewById(R.id.imageview2);
        imageview3 = findViewById(R.id.imageview3);
        imageview4 = findViewById(R.id.imageview4);
        textview19 = findViewById(R.id.textview19);
        textview30 = findViewById(R.id.textview30);
        button3 = findViewById(R.id.button3);
        textview20 = findViewById(R.id.textview20);
        imageview5 = findViewById(R.id.imageview5);
        textview21 = findViewById(R.id.textview21);
        textview31 = findViewById(R.id.textview31);
        button4 = findViewById(R.id.button4);
        textview22 = findViewById(R.id.textview22);
        imageview6 = findViewById(R.id.imageview6);
        imageview7 = findViewById(R.id.imageview7);
        textview8 = findViewById(R.id.textview8);
        textview32 = findViewById(R.id.textview32);

        linear24 = findViewById(R.id.linear24);
        textview3 = findViewById(R.id.textview3);
        textview15 = findViewById(R.id.textview15);

        secondeownerset = findViewById(R.id.secondeownerset);
        secondeownerlayout = findViewById(R.id.secondeownerlayout);
        secondownerid  = findViewById(R.id.secondownerid);

        secondownerid.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(UnknownPadigreeRegistration.this);
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
                        Toast.makeText(UnknownPadigreeRegistration.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

                RequestQueue requestQueue = Volley.newRequestQueue(UnknownPadigreeRegistration.this);
                requestQueue.add(request);
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
                    Toast.makeText(UnknownPadigreeRegistration.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        Toast.makeText(UnknownPadigreeRegistration.this, "1", Toast.LENGTH_SHORT).show();
                        male = "1";
                    }
                    else
                    {
                        Toast.makeText(UnknownPadigreeRegistration.this, "0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(UnknownPadigreeRegistration.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Yes"))
                    {
                        Toast.makeText(UnknownPadigreeRegistration.this, "1", Toast.LENGTH_SHORT).show();
                        owner = "1";
                        secondeownerlayout.setVisibility(View.VISIBLE);
                        secondeownerset.setVisibility(View.VISIBLE);
                        secondownerid.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        Toast.makeText(UnknownPadigreeRegistration.this, "0", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(UnknownPadigreeRegistration.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Yes, I Require "))
                    {
                        Toast.makeText(UnknownPadigreeRegistration.this, "1", Toast.LENGTH_SHORT).show();
                        micro = "1";
                    }
                    else
                    {
                        Toast.makeText(UnknownPadigreeRegistration.this, "0", Toast.LENGTH_SHORT).show();
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
                        UnknownPadigreeRegistration.this,
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
                        UnknownPadigreeRegistration.this,
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

        ColorAndMaking();
        colormakingid = findViewById(R.id.colormakingid);
        colormaking   = findViewById(R.id.colormaking);

        colormaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(UnknownPadigreeRegistration.this);

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
                        colormaking.setText(spn.colour_name);
                        colormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });

        BreedFetch();
        setbreedid = findViewById(R.id.setbreedid);
        breed = findViewById(R.id.breed);

        breed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(UnknownPadigreeRegistration.this);

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
                        breed.setText(spn.sub_category_name);
                        setbreedid.setText(spn.sub_cat_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();


                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });


            }
        });

        //Dog Name
        dogname = findViewById(R.id.dogname);
        dognameset = findViewById(R.id.dognameset);
        dogname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(UnknownPadigreeRegistration.this);
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
                        Toast.makeText(UnknownPadigreeRegistration.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

                RequestQueue requestQueue = Volley.newRequestQueue(UnknownPadigreeRegistration.this);
                requestQueue.add(request);
            }
        });


        //Select images
        selectimagedog  = findViewById(R.id.selectimagedog);
        selectimagehigh = findViewById(R.id.selectimagehigh);
        selectimagesize = findViewById(R.id.selectimagesize);

        selectimagedog.setOnClickListener(new View.OnClickListener() {
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
                    ActivityCompat.requestPermissions(UnknownPadigreeRegistration.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });
        selectimagehigh.setOnClickListener(new View.OnClickListener() {
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
                    ActivityCompat.requestPermissions(UnknownPadigreeRegistration.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });
        selectimagesize.setOnClickListener(new View.OnClickListener() {
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
                    ActivityCompat.requestPermissions(UnknownPadigreeRegistration.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });



        //selected images
        imageselected = findViewById(R.id.imageselected);
        errorimage    = findViewById(R.id.errorimage);

        imageselecthigh = findViewById(R.id.imageselecthigh);
        errorimagehigh  = findViewById(R.id.errorimagehigh);

        imageselectedside = findViewById(R.id.imageselectedside);
        errorimageside    = findViewById(R.id.errorimageside);


        // submitData
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubmitDataUnknow();

            }
        });


    }

    private void SubmitDataUnknow() {
        String Owner =owner;
        String Second = secondownerid.getText().toString();
        String DogName = dogname.getText().toString();
        String Date = date.getText().toString().trim();
        String Color = colormakingid.getText().toString();
        String Breed = setbreedid.getText().toString();
        String Gender = male;
        String Micro = micro;

        if(Owner.equals("1")){
            if (Second.isEmpty()) {
                secondownerid.requestFocus();
                secondownerid.setError("Please enter owner id");
                return;
            }
            else if(DogName.isEmpty()){
                dogname.clearFocus();
                dogname.requestFocus();
                dogname.setError("Please enter your dam number");
                return;
            }
            else if(Date.isEmpty()){
                date.clearFocus();
                date.requestFocus();
                date.setError("Please select date");
                return;
            }
            else if(Color.isEmpty()){
                colormaking.clearFocus();
                colormaking.requestFocus();
                colormaking.setError("Please select color and making");
                return;
            }
            else if(Breed.isEmpty()){
                breed.clearFocus();
                breed.requestFocus();
                breed.setError("Please select breed");
                return;
            }
            else if(imageselected.getDrawable()==null){
                errorimage.setVisibility(View.VISIBLE);
                Toast.makeText(this, "please select dog image", Toast.LENGTH_SHORT).show();
            }
            else if(imageselecthigh.getDrawable()==null){
                errorimagehigh.setVisibility(View.VISIBLE);
                Toast.makeText(this, "please select size image", Toast.LENGTH_SHORT).show();
            }
            else if(imageselectedside.getDrawable()==null){
                errorimageside.setVisibility(View.VISIBLE);
                Toast.makeText(this, "please select side image", Toast.LENGTH_SHORT).show();
            }

            else
            {
                progressDialog  = new ProgressDialog(UnknownPadigreeRegistration.this);
                progressDialog.setMessage("Loading please...");
                progressDialog.show();

                appConfig = new AppConfig(UnknownPadigreeRegistration.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                        .addConverterFactory(GsonConverterFactory.create()).build();

                File filedog =new File(pathdog);
                RequestBody requestFiledog = RequestBody.create(MediaType.parse("multipart/form-data"),filedog);
                MultipartBody.Part bodydog = MultipartBody.Part.createFormData("pet_image",filedog.getName(),requestFiledog);

                File filehigh =new File(pathhigh);
                RequestBody requestFilefront = RequestBody.create(MediaType.parse("multipart/form-data"),filehigh);
                MultipartBody.Part bodyhigh = MultipartBody.Part.createFormData("pet_height_image",filehigh.getName(),requestFilefront);

                File fileside =new File(pathsize);
                RequestBody requestFileback = RequestBody.create(MediaType.parse("multipart/form-data"),fileside);
                MultipartBody.Part bodyside = MultipartBody.Part.createFormData("pet_side_image",fileside.getName(),requestFileback);

                RequestBody DogBreed = RequestBody.create(MediaType.parse("multipart/form-data"),Breed);
                RequestBody DogGender = RequestBody.create(MediaType.parse("multipart/form-data"),Gender);
                RequestBody DogDate = RequestBody.create(MediaType.parse("multipart/form-data"),Date);
                RequestBody dogname = RequestBody.create(MediaType.parse("multipart/form-data"),DogName);
                RequestBody DogColor = RequestBody.create(MediaType.parse("multipart/form-data"),Color);
                RequestBody DogMicro = RequestBody.create(MediaType.parse("multipart/form-data"),Micro);
                RequestBody DogOwner= RequestBody.create(MediaType.parse("multipart/form-data"),Owner);
                RequestBody DogSecond = RequestBody.create(MediaType.parse("multipart/form-data"),Second);

                ApiService apiService = retrofit.create(ApiService.class);

                Call<UnknowPedigreeFromResponse> call = apiService.AddUnknowPedigree(bodydog,bodyhigh,bodyside,DogBreed,DogGender,DogDate,
                        dogname,DogColor,DogMicro,DogOwner,DogSecond,userId,token);

                call.enqueue(new Callback<UnknowPedigreeFromResponse>() {
                    @Override
                    public void onResponse(Call<UnknowPedigreeFromResponse> call, retrofit2.Response<UnknowPedigreeFromResponse> response) {
                        if(response.isSuccessful())
                        {
                            if(response.body().getCode().equals(200)){
                                String message = response.body().getMessage();
                                Toast.makeText(UnknownPadigreeRegistration.this, message, Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                            else
                            {
                                Toast.makeText(UnknownPadigreeRegistration.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();

                            }
                        }
                        else
                        {
                            Toast.makeText(UnknownPadigreeRegistration.this, "Invalid Response", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }

                    }

                    @Override
                    public void onFailure(Call<UnknowPedigreeFromResponse> call, Throwable t) {
                        Toast.makeText(UnknownPadigreeRegistration.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                });
            }
        }
        else if(DogName.isEmpty()){
            dogname.clearFocus();
            dogname.requestFocus();
            dogname.setError("Please enter your dam number");
            return;
        }
        else if(Date.isEmpty()){
            date.clearFocus();
            date.requestFocus();
            date.setError("Please select date");
            return;
        }
        else if(Color.isEmpty()){
            colormaking.clearFocus();
            colormaking.requestFocus();
            colormaking.setError("Please select color and making");
            return;
        }
        else if(Breed.isEmpty()){
            breed.clearFocus();
            breed.requestFocus();
            breed.setError("Please select breed");
            return;
        }
        else if(imageselected.getDrawable()==null){
            errorimage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "please select dog image", Toast.LENGTH_SHORT).show();
        }
        else if(imageselecthigh.getDrawable()==null){
            errorimagehigh.setVisibility(View.VISIBLE);
            Toast.makeText(this, "please select size image", Toast.LENGTH_SHORT).show();
        }
        else if(imageselectedside.getDrawable()==null){
            errorimageside.setVisibility(View.VISIBLE);
            Toast.makeText(this, "please select side image", Toast.LENGTH_SHORT).show();
        }

        else
        {
            progressDialog  = new ProgressDialog(UnknownPadigreeRegistration.this);
            progressDialog.setMessage("Loading please...");
            progressDialog.show();

            appConfig = new AppConfig(UnknownPadigreeRegistration.this);
            String token = appConfig.getuser_token();
            String userId = appConfig.getInkcRegis();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            File filedog =new File(pathdog);
            RequestBody requestFiledog = RequestBody.create(MediaType.parse("multipart/form-data"),filedog);
            MultipartBody.Part bodydog = MultipartBody.Part.createFormData("pet_image",filedog.getName(),requestFiledog);

            File filehigh =new File(pathhigh);
            RequestBody requestFilefront = RequestBody.create(MediaType.parse("multipart/form-data"),filehigh);
            MultipartBody.Part bodyhigh = MultipartBody.Part.createFormData("pet_height_image",filehigh.getName(),requestFilefront);

            File fileside =new File(pathsize);
            RequestBody requestFileback = RequestBody.create(MediaType.parse("multipart/form-data"),fileside);
            MultipartBody.Part bodyside = MultipartBody.Part.createFormData("pet_side_image",fileside.getName(),requestFileback);

            RequestBody DogBreed = RequestBody.create(MediaType.parse("multipart/form-data"),Breed);
            RequestBody DogGender = RequestBody.create(MediaType.parse("multipart/form-data"),Gender);
            RequestBody DogDate = RequestBody.create(MediaType.parse("multipart/form-data"),Date);
            RequestBody dogname = RequestBody.create(MediaType.parse("multipart/form-data"),DogName);
            RequestBody DogColor = RequestBody.create(MediaType.parse("multipart/form-data"),Color);
            RequestBody DogMicro = RequestBody.create(MediaType.parse("multipart/form-data"),Micro);
            RequestBody DogOwner= RequestBody.create(MediaType.parse("multipart/form-data"),Owner);
            RequestBody DogSecond = RequestBody.create(MediaType.parse("multipart/form-data"),Second);

            ApiService apiService = retrofit.create(ApiService.class);

            Call<UnknowPedigreeFromResponse> call = apiService.AddUnknowPedigree(bodydog,bodyhigh,bodyside,DogBreed,DogGender,DogDate,
                    dogname,DogColor,DogMicro,DogOwner,DogSecond,userId,token);

            call.enqueue(new Callback<UnknowPedigreeFromResponse>() {
                @Override
                public void onResponse(Call<UnknowPedigreeFromResponse> call, retrofit2.Response<UnknowPedigreeFromResponse> response) {
                    if(response.isSuccessful())
                    {
                        if(response.body().getCode().equals(200)){
                            String message = response.body().getMessage();
                            Toast.makeText(UnknownPadigreeRegistration.this, message, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(UnknownPadigreeRegistration.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();

                        }
                    }
                    else
                    {
                        Toast.makeText(UnknownPadigreeRegistration.this, "Invalid Response", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }

                }

                @Override
                public void onFailure(Call<UnknowPedigreeFromResponse> call, Throwable t) {
                    Toast.makeText(UnknownPadigreeRegistration.this, "Something is wrong", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            });
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 10 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = UnknownPadigreeRegistration.this;
            pathdog = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(pathdog);
            imageselected.setVisibility(View.VISIBLE);
            imageselected.setImageBitmap(bitmap);
            errorimage.setVisibility(View.GONE);
        }
        else if(requestCode== 11 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = UnknownPadigreeRegistration.this;
            pathhigh = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(pathhigh);
            imageselecthigh.setVisibility(View.VISIBLE);
            imageselecthigh.setImageBitmap(bitmap);
            errorimagehigh.setVisibility(View.GONE);
        }
        else if(requestCode== 12 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = UnknownPadigreeRegistration.this;
            pathsize = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(pathsize);
            imageselectedside.setVisibility(View.VISIBLE);
            imageselectedside.setImageBitmap(bitmap);
            errorimageside.setVisibility(View.GONE);
        }

    }

    private void BreedFetch() {
        appConfig = new AppConfig(UnknownPadigreeRegistration.this);
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

                                Toast.makeText(UnknownPadigreeRegistration.this, "Data is not available", Toast.LENGTH_SHORT).show();
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
                                    breedSpinnerArrayAdapter = new ArrayAdapter<BreedSpinner>(UnknownPadigreeRegistration.this,
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
                Toast.makeText(UnknownPadigreeRegistration.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(UnknownPadigreeRegistration.this);
        requestQueue.add(request);
    }

    private void ColorAndMaking() {

        appConfig = new AppConfig(UnknownPadigreeRegistration.this);
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

                                Toast.makeText(UnknownPadigreeRegistration.this, "Data is not available", Toast.LENGTH_SHORT).show();
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
                                    colorAndMakingSpinnerArrayAdapter = new ArrayAdapter<ColorAndMakingSpinner>(UnknownPadigreeRegistration.this,
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
                Toast.makeText(UnknownPadigreeRegistration.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(UnknownPadigreeRegistration.this);
        requestQueue.add(request);
    }

    private void initializeLogic() {
        //_view(button2, 35, 13, "#40c9a2");
//        spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list1));
//        list1.add("Select color and marking");
//        list1.add("White");
//        list1.add("White with black markings ");
//        list1.add("Brindle and white");
//        list1.add("White with brown marking");
//        list1.add("Black/white");
//        spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list1));
//        spinner2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list2));
//        list2.add("Select Breed");
//        list2.add("Cross breed");
//        list2.add("Doberman");
//        list2.add("Pomeranian");
//        list2.add("Pekingese");
//        list2.add("Labrador Retriever ");
//        list2.add("Beagle");
//        spinner2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list2));
//        _view(linear1, 50, 3, "#ffffff");
//        _view(linear24, 30, 3, "#ffebee");
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