package com.example.indiannationalkennelclub;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.indiannationalkennelclub.RealPath.RealPathUtil;
import com.example.indiannationalkennelclub.ResponseModel.LitterRegisterFromResponse;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.example.indiannationalkennelclub.Spinner.ColorAndMakingSpinner;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.util.*;

import org.json.*;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LitterRegistraionFromAllPuppyActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private ScrollView vscroll1;
//    private LinearLayout linear1;
//    private TextView textview2;
//    private TextView textview3;
//    private EditText edittext1;
//    private LinearLayout linear16;
//    private EditText edittext2;
//    private LinearLayout linear17;
//    private LinearLayout linear15;
//    private LinearLayout linear18;
//    private LinearLayout linear40;
//    private LinearLayout linear2;
//    private EditText edittext25;
//    private LinearLayout linear39;
//    private LinearLayout linear3;
//    private TextView textview9;
//    private TextView textview10;
//    private EditText edittext4;
//    private LinearLayout linear20;
//    private LinearLayout linear4;
//    private LinearLayout linear19;
//    private EditText edittext5;
//    private TextView textview75;
//    private TextView textview41;
//    private TextView textview40;
//    private EditText edittext6;
//    private LinearLayout linear27;
//    private LinearLayout linear6;
//    private LinearLayout linear28;
//    private EditText edittext7;
//    private TextView textview76;
//    private TextView textview37;
//    private TextView textview32;
//    private EditText edittext8;
//    private LinearLayout linear29;
//    private LinearLayout linear5;
//    private LinearLayout linear30;
//    private EditText edittext9;
//    private TextView textview77;
//    private TextView textview34;
//    private TextView textview33;
//    private EditText edittext15;
//    private LinearLayout linear31;
//    private LinearLayout linear7;
//    private LinearLayout linear32;
//    private EditText edittext14;
//    private TextView textview78;
//    private TextView textview29;
//    private TextView textview28;
//    private EditText edittext13;
//    private LinearLayout linear33;
//    private LinearLayout linear8;
//    private LinearLayout linear34;
//    private EditText edittext12;
//    private TextView textview79;
//    private TextView textview23;
//    private TextView textview24;
//    private EditText edittext11;
//    private LinearLayout linear35;
//    private LinearLayout linear10;
//    private LinearLayout linear36;
//    private EditText edittext10;
//    private TextView textview80;
//    private TextView textview20;
//    private TextView textview18;
//    private EditText edittext22;
//    private LinearLayout linear37;
//    private LinearLayout linear11;
//    private LinearLayout linear38;
//    private EditText edittext23;
//    private TextView textview81;
//    private TextView textview11;
//    private TextView textview15;
//    private EditText edittext20;
//    private LinearLayout linear25;
//    private LinearLayout linear12;
//    private LinearLayout linear26;
//    private EditText edittext26;
//    private TextView textview82;
//    private TextView textview13;
//    private TextView textview43;
//    private EditText edittext18;
//    private LinearLayout linear24;
//    private LinearLayout linear14;
//    private LinearLayout linear23;
//    private EditText edittext19;
//    private TextView textview83;
//    private TextView textview46;
//    private TextView textview45;
//    private EditText edittext16;
//    private LinearLayout linear22;
//    private LinearLayout linear13;
//    private LinearLayout linear21;
//    private EditText edittext17;
//    private Button button2;
//    private TextView textview4;
//    private TextView textview53;
//    private TextView textview5;
//    private TextView textview52;
//    private EditText edittext24;
//    private ImageView imageview1;
//    private TextView textview6;
//    private TextView textview51;
//    private TextView textview7;
//    private TextView textview8;
//    private TextView textview84;
//    private RadioButton radiobutton3;
//    private RadioButton radiobutton4;
//    private TextView textview19;
//    private TextView textview55;
//    private RadioButton radiobutton5;
//    private RadioButton radiobutton6;
//    private TextView textview26;
//    private TextView textview57;
//    private TextView textview39;
//    private TextView textview56;
//    private RadioButton radiobutton23;
//    private RadioButton radiobutton24;
//    private TextView textview38;
//    private TextView textview74;
//    private TextView textview36;
//    private TextView textview71;
//    private RadioButton radiobutton21;
//    private RadioButton radiobutton22;
//    private TextView textview35;
//    private TextView textview70;
//    private TextView textview31;
//    private TextView textview73;
//    private RadioButton radiobutton19;
//    private RadioButton radiobutton20;
//    private TextView textview30;
//    private TextView textview72;
//    private TextView textview25;
//    private TextView textview69;
//    private RadioButton radiobutton17;
//    private RadioButton radiobutton18;
//    private TextView textview27;
//    private TextView textview68;
//    private TextView textview22;
//    private TextView textview66;
//    private RadioButton radiobutton15;
//    private RadioButton radiobutton16;
//    private TextView textview21;
//    private TextView textview67;
//    private TextView textview17;
//    private TextView textview65;
//    private RadioButton radiobutton13;
//    private RadioButton radiobutton14;
//    private TextView textview16;
//    private TextView textview64;
//    private TextView textview12;
//    private TextView textview63;
//    private RadioButton radiobutton11;
//    private RadioButton radiobutton12;
//    private TextView textview54;
//    private TextView textview62;
//    private TextView textview48;
//    private TextView textview61;
//    private RadioButton radiobutton7;
//    private RadioButton radiobutton8;
//    private TextView textview47;
//    private TextView textview60;
//    private TextView textview44;
//    private TextView textview58;
//    private RadioButton radiobutton9;
//    private RadioButton radiobutton10;
//    private TextView textview42;
//    private TextView textview59;
//    private Button button1;
//    private ImageView imageview2;


    //Gender
    RadioGroup radioGroup;
    RadioButton radiobutton1;
    static String male= "1";

    //Dog name with kennel Name
    RadioGroup radioGroup1;
    RadioButton radiobutton11,radiobutton22;
    static String owner= "0";

    //Date
    ImageView date1;
    TextView date;

    TextView example;
    LinearLayout puppy1,puppy2,puppy3,puppy4,puppy5,puppy6,puppy7,puppy8,puppy9,puppy10;

    TextView sireset;
    EditText sirenumber;

    AppConfig appConfig;
    Dialog dialog;
    ProgressDialog progressDialog;

    // Urls
    String SireURL = "https://test181120221003.inkc.in/api/dog/get_sire_details";
    String KennelURL = "https://test181120221003.inkc.in/api/user/kennel_details";
    String ColorAndMakingUrl = "https://test181120221003.inkc.in/api/dog/dog_color_marking_list";
    String MainUrl = "https://test181120221003.inkc.in/api/dog/";


    //color and making spinner
    ArrayList<ColorAndMakingSpinner> colorAndMakingSpinnerslist = new ArrayList<>();
    ArrayAdapter<ColorAndMakingSpinner> colorAndMakingSpinnerArrayAdapter;



    //Image Select
    ImageView imageselected;
    TextView errorimage;
    String path;
    Button selectimg;

    //Dam list
    private EditText dam;
    TextView damset;
    String DamURL  = "https://test181120221003.inkc.in/api/dog/get_dam_details";


    //Kennel Name
    ArrayList<KennelInfoLitterRegister> kennelInfoLitterRegisterslist = new ArrayList<>();
    ArrayAdapter<KennelInfoLitterRegister> kennelInfoLitterRegisterArrayAdapter ;
    TextView kennelname,kennelsetvalue;


    // puppy 1
    EditText puppy1name;
    RadioGroup puppy1radiogroupgender;
    RadioButton puppy1radiobutton1,puppy1radiobutton2;
    static String puppy1gender= "1";
    TextView puppy1setcolor,puppy1setcolormakingid;

    // puppy 2
    EditText puppy2name;
    RadioGroup puppy2radiogroupgender;
    RadioButton puppy2radiobutton1,puppy2radiobutton2;
    static String puppy2gender= "1";
    TextView puppy2setcolor,puppy2setcolormakingid;

    // puppy 3
    EditText puppy3name;
    RadioGroup puppy3radiogroupgender;
    RadioButton puppy3radiobutton1,puppy3radiobutton2;
    static String puppy3gender= "1";
    TextView puppy3setcolor,puppy3setcolormakingid;

    // puppy 4
    EditText puppy4name;
    RadioGroup puppy4radiogroupgender;
    RadioButton puppy4radiobutton1,puppy4radiobutton2;
    static String puppy4gender= "1";
    TextView puppy4setcolor,puppy4setcolormakingid;

    // puppy 5
    EditText puppy5name;
    RadioGroup puppy5radiogroupgender;
    RadioButton puppy5radiobutton1,puppy5radiobutton2;
    static String puppy5gender= "1";
    TextView puppy5setcolor,puppy5setcolormakingid;

    // puppy 6
    EditText puppy6name;
    RadioGroup puppy6radiogroupgender;
    RadioButton puppy6radiobutton1,puppy6radiobutton2;
    static String puppy6gender= "1";
    TextView puppy6setcolor,puppy6setcolormakingid;

    // puppy 7
    EditText puppy7name;
    RadioGroup puppy7radiogroupgender;
    RadioButton puppy7radiobutton1,puppy7radiobutton2;
    static String puppy7gender= "1";
    TextView puppy7setcolor,puppy7setcolormakingid;

    // puppy 8
    EditText puppy8name;
    RadioGroup puppy8radiogroupgender;
    RadioButton puppy8radiobutton1,puppy8radiobutton2;
    static String puppy8gender= "1";
    TextView puppy8setcolor,puppy8setcolormakingid;

    // puppy 9
    EditText puppy9name;
    RadioGroup puppy9radiogroupgender;
    RadioButton puppy9radiobutton1,puppy9radiobutton2;
    static String puppy9gender= "1";
    TextView puppy9setcolor,puppy9setcolormakingid;

    // puppy 10
    EditText puppy10name;
    RadioGroup puppy10radiogroupgender;
    RadioButton puppy10radiobutton1,puppy10radiobutton2;
    static String puppy10gender= "1";
    TextView puppy10setcolor,puppy10setcolormakingid;



    Button sumbit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litter_registraion_from_all_puppy);
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

        puppy1 = findViewById(R.id.puppy1);
        puppy2 = findViewById(R.id.puppy2);
        puppy3 = findViewById(R.id.puppy3);
        puppy4 = findViewById(R.id.puppy4);
        puppy5 = findViewById(R.id.puppy5);
        puppy6 = findViewById(R.id.puppy6);
        puppy7 = findViewById(R.id.puppy7);
        puppy8 = findViewById(R.id.puppy8);
        puppy9 = findViewById(R.id.puppy9);
        puppy10 = findViewById(R.id.puppy10);

        sumbit = findViewById(R.id.sumbit);
        sumbit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                String CountPuppy = getIntent().getStringExtra("puppy_number");
                String SireNumer = sirenumber.getText().toString().trim();
                String DamNumber = dam.getText().toString().trim();
                String Date = date.getText().toString();
                String Kennel = kennelname.getText().toString();
                String prifix = owner;

                if(SireNumer.isEmpty())
                {
                    sirenumber.requestFocus();
                    sirenumber.setError("Enter Sire Number");
                }
                else if(DamNumber.isEmpty())
                {
                    dam.requestFocus();
                    dam.setError("Enter Dam Number");
                }
                else if(Date.isEmpty())
                {
                    date.requestFocus();
                    date.setError("Select date");
                }
                else if(Kennel.isEmpty())
                {
                    kennelname.requestFocus();
                    kennelname.setError("Select");
                }
                else if((imageselected.getDrawable()==null)) {
                    errorimage.setVisibility(View.VISIBLE);
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "please select dog image", Toast.LENGTH_SHORT).show();
                }
                else {
                    Upload();
                }
            }
        });

        sireset = findViewById(R.id.sireset);
        sirenumber = findViewById(R.id.sirenumber);
        sirenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(LitterRegistraionFromAllPuppyActivity.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                String sirenumbervalue = sirenumber.getText().toString().trim();
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
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                        params.put("sire_reg_number", sirenumbervalue);
                        return  params;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(LitterRegistraionFromAllPuppyActivity.this);
                requestQueue.add(request);
            }
        });

        String CountPuppy = getIntent().getStringExtra("puppy_number");
        if(CountPuppy.equals("1")){
            puppy1.setVisibility(View.VISIBLE);
        }
      else if(CountPuppy.equals("2"))
            {
                puppy2.setVisibility(View.VISIBLE);
            }
        else if(CountPuppy.equals("3")){
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);

        }
        else if(CountPuppy.equals("4")){
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);
            puppy4.setVisibility(View.VISIBLE);

        }
        else if(CountPuppy.equals("5")){
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);
            puppy4.setVisibility(View.VISIBLE);
            puppy5.setVisibility(View.VISIBLE);
        }
        else if(CountPuppy.equals("6")){
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);
            puppy4.setVisibility(View.VISIBLE);
            puppy5.setVisibility(View.VISIBLE);
            puppy6.setVisibility(View.VISIBLE);
        }
        else if(CountPuppy.equals("7")){
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);
            puppy4.setVisibility(View.VISIBLE);
            puppy5.setVisibility(View.VISIBLE);
            puppy6.setVisibility(View.VISIBLE);
            puppy7.setVisibility(View.VISIBLE);
        }
        else if(CountPuppy.equals("8")){
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);
            puppy4.setVisibility(View.VISIBLE);
            puppy5.setVisibility(View.VISIBLE);
            puppy6.setVisibility(View.VISIBLE);
            puppy7.setVisibility(View.VISIBLE);
            puppy8.setVisibility(View.VISIBLE);
        }
        else if(CountPuppy.equals("9")){
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);
            puppy4.setVisibility(View.VISIBLE);
            puppy5.setVisibility(View.VISIBLE);
            puppy6.setVisibility(View.VISIBLE);
            puppy7.setVisibility(View.VISIBLE);
            puppy8.setVisibility(View.VISIBLE);
            puppy9.setVisibility(View.VISIBLE);
        }else
        {
            puppy2.setVisibility(View.VISIBLE);
            puppy3.setVisibility(View.VISIBLE);
            puppy4.setVisibility(View.VISIBLE);
            puppy5.setVisibility(View.VISIBLE);
            puppy6.setVisibility(View.VISIBLE);
            puppy7.setVisibility(View.VISIBLE);
            puppy8.setVisibility(View.VISIBLE);
            puppy9.setVisibility(View.VISIBLE);
            puppy10.setVisibility(View.VISIBLE);
        }

        ColorAndMaking();

        // puppy1 gender
        puppy1name = findViewById(R.id.puppy1name);
        puppy1setcolor = findViewById(R.id.puppy1setcolor);
        puppy1setcolormakingid = findViewById(R.id.puppy1setcolormakingid);
        puppy1radiogroupgender = findViewById(R.id.puppy1radiogroupgender);
        puppy1radiobutton1 = puppy1radiogroupgender.findViewById(R.id.puppy1radiobutton1);
        puppy1radiobutton2 = puppy1radiogroupgender.findViewById(R.id.puppy1radiobutton2);

        puppy1radiobutton1.setChecked(true);
        puppy1radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy1gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy1gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy1gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy1gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy1setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy1setcolor.setText(spn.colour_name);
                        puppy1setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });



        // puppy2 gender
        puppy2name = findViewById(R.id.puppy2name);
        puppy2setcolor = findViewById(R.id.puppy2setcolor);
        puppy2setcolormakingid = findViewById(R.id.puppy2setcolormakingid);
        puppy2radiogroupgender = findViewById(R.id.puppy2radiogroupgender);
        puppy2radiobutton1 = puppy2radiogroupgender.findViewById(R.id.puppy2radiobutton1);
        puppy2radiobutton2 = puppy2radiogroupgender.findViewById(R.id.puppy2radiobutton2);

        puppy2radiobutton1.setChecked(true);
        puppy2radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy2gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy2gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy2gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy2gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy2setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy2setcolor.setText(spn.colour_name);
                        puppy2setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });



        // puppy3 gender
        puppy3name = findViewById(R.id.puppy3name);
        puppy3setcolor = findViewById(R.id.puppy3setcolor);
        puppy3setcolormakingid = findViewById(R.id.puppy3setcolormakingid);
        puppy3radiogroupgender = findViewById(R.id.puppy3radiogroupgender);
        puppy3radiobutton1 = puppy3radiogroupgender.findViewById(R.id.puppy3radiobutton1);
        puppy3radiobutton2 = puppy3radiogroupgender.findViewById(R.id.puppy3radiobutton2);

        puppy3radiobutton1.setChecked(true);
        puppy3radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy3gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy3gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy3gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy3gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy3setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy3setcolor.setText(spn.colour_name);
                        puppy3setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });


        // puppy4 gender
        puppy4name = findViewById(R.id.puppy4name);
        puppy4setcolor = findViewById(R.id.puppy4setcolor);
        puppy4setcolormakingid = findViewById(R.id.puppy4setcolormakingid);
        puppy4radiogroupgender = findViewById(R.id.puppy4radiogroupgender);
        puppy4radiobutton1 = puppy4radiogroupgender.findViewById(R.id.puppy4radiobutton1);
        puppy4radiobutton2 = puppy4radiogroupgender.findViewById(R.id.puppy4radiobutton2);

        puppy4radiobutton1.setChecked(true);
        puppy4radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy4gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy4gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy4gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy4gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy4setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy4setcolor.setText(spn.colour_name);
                        puppy4setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });



        // puppy5 gender
        puppy5name = findViewById(R.id.puppy5name);
        puppy5setcolor = findViewById(R.id.puppy5setcolor);
        puppy5setcolormakingid = findViewById(R.id.puppy5setcolormakingid);
        puppy5radiogroupgender = findViewById(R.id.puppy5radiogroupgender);
        puppy5radiobutton1 = puppy5radiogroupgender.findViewById(R.id.puppy5radiobutton1);
        puppy5radiobutton2 = puppy5radiogroupgender.findViewById(R.id.puppy5radiobutton2);

        puppy5radiobutton1.setChecked(true);
        puppy5radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy5gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy5gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy5gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy5gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy5setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy5setcolor.setText(spn.colour_name);
                        puppy5setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });



        // puppy6 gender
        puppy6name = findViewById(R.id.puppy6name);
        puppy6setcolor = findViewById(R.id.puppy6setcolor);
        puppy6setcolormakingid = findViewById(R.id.puppy6setcolormakingid);
        puppy6radiogroupgender = findViewById(R.id.puppy6radiogroupgender);
        puppy6radiobutton1 = puppy6radiogroupgender.findViewById(R.id.puppy6radiobutton1);
        puppy6radiobutton2 = puppy6radiogroupgender.findViewById(R.id.puppy6radiobutton2);

        puppy6radiobutton1.setChecked(true);
        puppy6radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy6gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy6gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy6gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy6gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy6setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy6setcolor.setText(spn.colour_name);
                        puppy6setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });


        // puppy7 gender
        puppy7name = findViewById(R.id.puppy7name);
        puppy7setcolor = findViewById(R.id.puppy7setcolor);
        puppy7setcolormakingid = findViewById(R.id.puppy7setcolormakingid);
        puppy7radiogroupgender = findViewById(R.id.puppy7radiogroupgender);
        puppy7radiobutton1 = puppy7radiogroupgender.findViewById(R.id.puppy7radiobutton1);
        puppy7radiobutton2 = puppy7radiogroupgender.findViewById(R.id.puppy7radiobutton2);

        puppy7radiobutton1.setChecked(true);
        puppy7radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy7gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy7gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy7gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy7gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy7setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy7setcolor.setText(spn.colour_name);
                        puppy7setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });


        // puppy8 gender
        puppy8name = findViewById(R.id.puppy8name);
        puppy8setcolor = findViewById(R.id.puppy8setcolor);
        puppy8setcolormakingid = findViewById(R.id.puppy8setcolormakingid);
        puppy8radiogroupgender = findViewById(R.id.puppy8radiogroupgender);
        puppy8radiobutton1 = puppy8radiogroupgender.findViewById(R.id.puppy8radiobutton1);
        puppy8radiobutton2 = puppy8radiogroupgender.findViewById(R.id.puppy8radiobutton2);

        puppy8radiobutton1.setChecked(true);
        puppy8radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy8gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy8gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy8gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy8gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy8setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy8setcolor.setText(spn.colour_name);
                        puppy8setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });


        // puppy9 gender
        puppy9name = findViewById(R.id.puppy9name);
        puppy9setcolor = findViewById(R.id.puppy9setcolor);
        puppy9setcolormakingid = findViewById(R.id.puppy9setcolormakingid);
        puppy9radiogroupgender = findViewById(R.id.puppy9radiogroupgender);
        puppy9radiobutton1 = puppy9radiogroupgender.findViewById(R.id.puppy9radiobutton1);
        puppy9radiobutton2 = puppy9radiogroupgender.findViewById(R.id.puppy9radiobutton2);

        puppy9radiobutton1.setChecked(true);
        puppy9radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy9gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy9gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy9gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy9gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        puppy9setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy9setcolor.setText(spn.colour_name);
                        puppy9setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });


        // puppy10 gender
        puppy10name = findViewById(R.id.puppy10name);
        puppy10setcolor = findViewById(R.id.puppy10setcolor);
        puppy10setcolormakingid = findViewById(R.id.puppy10setcolormakingid);
        puppy10radiogroupgender = findViewById(R.id.puppy10radiogroupgender);
        puppy10radiobutton1 = puppy10radiogroupgender.findViewById(R.id.puppy10radiobutton1);
        puppy10radiobutton2 = puppy10radiogroupgender.findViewById(R.id.puppy10radiobutton2);

        puppy10radiobutton1.setChecked(true);
        puppy10radiogroupgender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        puppy10gender = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy10gender, Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        puppy10gender = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, puppy10gender, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        puppy10setcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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
                        puppy10setcolor.setText(spn.colour_name);
                        puppy10setcolormakingid.setText(spn.colour_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
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
                        LitterRegistraionFromAllPuppyActivity.this,
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
                        LitterRegistraionFromAllPuppyActivity.this,
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


        //Dog name with kennel Name
        radioGroup1 = findViewById(R.id.radiogroupgender1);
        radiobutton11 = radioGroup1.findViewById(R.id.radiobutton11);
        radiobutton22 = radioGroup1.findViewById(R.id.radiobutton22);

        example = findViewById(R.id.example);

        radiobutton22.setChecked(true);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Prefix kennel name"))
                    {
                        owner = "0";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, owner, Toast.LENGTH_SHORT).show();
                        example.setText("Eg. Name of the puppy is Jimmy and kennel name is Indian, then the name will be Jimmy of Indian");
                    }
                    else
                    {
                        owner = "1";
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, owner, Toast.LENGTH_SHORT).show();
                       example.setText("Eg. Name of the puppy is Jimmy and kennel name is Indian, then the name will be Jimmy");
                    }

                }
            }
        });

        //kennel name
        KennelNameFetch();
        kennelname = findViewById(R.id.kennelname);
        kennelsetvalue = findViewById(R.id.kennelsetvalue);
        kennelname.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                // Initialize dialog
                dialog = new Dialog(LitterRegistraionFromAllPuppyActivity.this);

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

                listView.setAdapter(kennelInfoLitterRegisterArrayAdapter);
                editText.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                                        kennelInfoLitterRegisterArrayAdapter.getFilter().filter(charSequence);
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

                        KennelInfoLitterRegister spn = (KennelInfoLitterRegister) parent.getItemAtPosition(position);
                       kennelname.setText(spn.kennel_name);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });

        //Image selected
        imageselected = findViewById(R.id.imageselected);
        selectimg  = findViewById(R.id.selectimg);
        errorimage = findViewById(R.id.errorimage);

        selectimg.setOnClickListener(new OnClickListener() {
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
                    ActivityCompat.requestPermissions(LitterRegistraionFromAllPuppyActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });

        dam = findViewById(R.id.edittext2);
        damset = findViewById(R.id.damset);
        dam.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                appConfig = new AppConfig(LitterRegistraionFromAllPuppyActivity.this);
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
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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

                RequestQueue requestQueue = Volley.newRequestQueue(LitterRegistraionFromAllPuppyActivity.this);
                requestQueue.add(request);
            }
        });

//        linear1 = findViewById(R.id.linear1);
//        textview2 = findViewById(R.id.textview2);
//        textview3 = findViewById(R.id.textview3);
//        edittext1 = findViewById(R.id.edittext1);
//        linear16 = findViewById(R.id.linear16);
//        edittext2 = findViewById(R.id.edittext2);
//        linear17 = findViewById(R.id.linear17);
//        linear15 = findViewById(R.id.linear15);
//        linear18 = findViewById(R.id.linear18);
//        linear40 = findViewById(R.id.linear40);
//        linear2 = findViewById(R.id.linear2);
//        edittext25 = findViewById(R.id.edittext25);
//        linear39 = findViewById(R.id.linear39);
//        linear3 = findViewById(R.id.linear3);
//        textview9 = findViewById(R.id.textview9);
//        textview10 = findViewById(R.id.textview10);
//        edittext4 = findViewById(R.id.edittext4);
//        linear20 = findViewById(R.id.linear20);
//        linear4 = findViewById(R.id.linear4);
//        linear19 = findViewById(R.id.linear19);
//        edittext5 = findViewById(R.id.edittext5);
//        textview75 = findViewById(R.id.textview75);
//        textview41 = findViewById(R.id.textview41);
//        textview40 = findViewById(R.id.textview40);
//        edittext6 = findViewById(R.id.edittext6);
//        linear27 = findViewById(R.id.linear27);
//        linear6 = findViewById(R.id.linear6);
//        linear28 = findViewById(R.id.linear28);
//        edittext7 = findViewById(R.id.edittext7);
//        textview76 = findViewById(R.id.textview76);
//        textview37 = findViewById(R.id.textview37);
//        textview32 = findViewById(R.id.textview32);
//        edittext8 = findViewById(R.id.edittext8);
//        linear29 = findViewById(R.id.linear29);
//        linear5 = findViewById(R.id.linear5);
//        linear30 = findViewById(R.id.linear30);
//        edittext9 = findViewById(R.id.edittext9);
//        textview77 = findViewById(R.id.textview77);
//        textview34 = findViewById(R.id.textview34);
//        textview33 = findViewById(R.id.textview33);
//        edittext15 = findViewById(R.id.edittext15);
//        linear31 = findViewById(R.id.linear31);
//        linear7 = findViewById(R.id.linear7);
//        linear32 = findViewById(R.id.linear32);
//        edittext14 = findViewById(R.id.edittext14);
//        textview78 = findViewById(R.id.textview78);
//        textview29 = findViewById(R.id.textview29);
//        textview28 = findViewById(R.id.textview28);
//        edittext13 = findViewById(R.id.edittext13);
//        linear33 = findViewById(R.id.linear33);
//        linear8 = findViewById(R.id.linear8);
//        linear34 = findViewById(R.id.linear34);
//        edittext12 = findViewById(R.id.edittext12);
//        textview79 = findViewById(R.id.textview79);
//        textview23 = findViewById(R.id.textview23);
//        textview24 = findViewById(R.id.textview24);
//        edittext11 = findViewById(R.id.edittext11);
//        linear35 = findViewById(R.id.linear35);
//        linear10 = findViewById(R.id.linear10);
//        linear36 = findViewById(R.id.linear36);
//        edittext10 = findViewById(R.id.edittext10);
//        textview80 = findViewById(R.id.textview80);
//        textview20 = findViewById(R.id.textview20);
//        textview18 = findViewById(R.id.textview18);
//        edittext22 = findViewById(R.id.edittext22);
//        linear37 = findViewById(R.id.linear37);
//        linear11 = findViewById(R.id.linear11);
//        linear38 = findViewById(R.id.linear38);
//        edittext23 = findViewById(R.id.edittext23);
//        textview81 = findViewById(R.id.textview81);
//        textview11 = findViewById(R.id.textview11);
//        textview15 = findViewById(R.id.textview15);
//        edittext20 = findViewById(R.id.edittext20);
//        linear25 = findViewById(R.id.linear25);
//        linear12 = findViewById(R.id.linear12);
//        linear26 = findViewById(R.id.linear26);
//        edittext26 = findViewById(R.id.edittext26);
//        textview82 = findViewById(R.id.textview82);
//        textview13 = findViewById(R.id.textview13);
//        textview43 = findViewById(R.id.textview43);
//        edittext18 = findViewById(R.id.edittext18);
//        linear24 = findViewById(R.id.linear24);
//        linear14 = findViewById(R.id.linear14);
//        linear23 = findViewById(R.id.linear23);
//        edittext19 = findViewById(R.id.edittext19);
//        textview83 = findViewById(R.id.textview83);
//        textview46 = findViewById(R.id.textview46);
//        textview45 = findViewById(R.id.textview45);
//        edittext16 = findViewById(R.id.edittext16);
//        linear22 = findViewById(R.id.linear22);
//        linear13 = findViewById(R.id.linear13);
//        linear21 = findViewById(R.id.linear21);
//        edittext17 = findViewById(R.id.edittext17);
//        button2 = findViewById(R.id.button2);
//        textview4 = findViewById(R.id.textview4);
//        textview53 = findViewById(R.id.textview53);
//        textview5 = findViewById(R.id.textview5);
//        textview52 = findViewById(R.id.textview52);
//        edittext24 = findViewById(R.id.edittext24);
//        imageview1 = findViewById(R.id.imageview1);
//        textview6 = findViewById(R.id.textview6);
//        textview51 = findViewById(R.id.textview51);
//        textview7 = findViewById(R.id.textview7);
//        textview8 = findViewById(R.id.textview8);
//        textview84 = findViewById(R.id.textview84);
//        radiobutton3 = findViewById(R.id.radiobutton3);
//        radiobutton4 = findViewById(R.id.radiobutton4);
//        textview19 = findViewById(R.id.textview19);
//        textview55 = findViewById(R.id.textview55);
//        radiobutton5 = findViewById(R.id.radiobutton5);
//        radiobutton6 = findViewById(R.id.radiobutton6);
//        textview26 = findViewById(R.id.textview26);
//        textview57 = findViewById(R.id.textview57);
//        textview39 = findViewById(R.id.textview39);
//        textview56 = findViewById(R.id.textview56);
//        radiobutton23 = findViewById(R.id.radiobutton23);
//        radiobutton24 = findViewById(R.id.radiobutton24);
//        textview38 = findViewById(R.id.textview38);
//        textview74 = findViewById(R.id.textview74);
//        textview36 = findViewById(R.id.textview36);
//        textview71 = findViewById(R.id.textview71);
//        radiobutton21 = findViewById(R.id.radiobutton21);
//        radiobutton22 = findViewById(R.id.radiobutton22);
//        textview35 = findViewById(R.id.textview35);
//        textview70 = findViewById(R.id.textview70);
//        textview31 = findViewById(R.id.textview31);
//        textview73 = findViewById(R.id.textview73);
//        radiobutton19 = findViewById(R.id.radiobutton19);
//        radiobutton20 = findViewById(R.id.radiobutton20);
//        textview30 = findViewById(R.id.textview30);
//        textview72 = findViewById(R.id.textview72);
//        textview25 = findViewById(R.id.textview25);
//        textview69 = findViewById(R.id.textview69);
//        radiobutton17 = findViewById(R.id.radiobutton17);
//        radiobutton18 = findViewById(R.id.radiobutton18);
//        textview27 = findViewById(R.id.textview27);
//        textview68 = findViewById(R.id.textview68);
//        textview22 = findViewById(R.id.textview22);
//        textview66 = findViewById(R.id.textview66);
//        radiobutton15 = findViewById(R.id.radiobutton15);
//        radiobutton16 = findViewById(R.id.radiobutton16);
//        textview21 = findViewById(R.id.textview21);
//        textview67 = findViewById(R.id.textview67);
//        textview17 = findViewById(R.id.textview17);
//        textview65 = findViewById(R.id.textview65);
//        radiobutton13 = findViewById(R.id.radiobutton13);
//        radiobutton14 = findViewById(R.id.radiobutton14);
//        textview16 = findViewById(R.id.textview16);
//        textview64 = findViewById(R.id.textview64);
//        textview12 = findViewById(R.id.textview12);
//        textview63 = findViewById(R.id.textview63);
//        radiobutton11 = findViewById(R.id.radiobutton11);
//        radiobutton12 = findViewById(R.id.radiobutton12);
//        textview54 = findViewById(R.id.textview54);
//        textview62 = findViewById(R.id.textview62);
//        textview48 = findViewById(R.id.textview48);
//        textview61 = findViewById(R.id.textview61);
//        radiobutton7 = findViewById(R.id.radiobutton7);
//        radiobutton8 = findViewById(R.id.radiobutton8);
//        textview47 = findViewById(R.id.textview47);
//        textview60 = findViewById(R.id.textview60);
//        textview44 = findViewById(R.id.textview44);
//        textview58 = findViewById(R.id.textview58);
//        radiobutton9 = findViewById(R.id.radiobutton9);
//        radiobutton10 = findViewById(R.id.radiobutton10);
//        textview42 = findViewById(R.id.textview42);
//        textview59 = findViewById(R.id.textview59);
//        button1 = findViewById(R.id.button1);
//        imageview2 = findViewById(R.id.imageview2);
//
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View _view) {
//
//            }
//        });
//
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View _view) {
//
//            }
//        });
    }

    public  Boolean PuppyCheck(String puppyname, String puppycolotr)
    {
        if(puppyname.isEmpty())
        {
            puppy1name.requestFocus();
            puppy1name.setError("Enter Name ");
            return false;
        }
        else if(puppycolotr.isEmpty())
        {
            puppy1setcolor.requestFocus();
            puppy1setcolor.setError("Select Color");
            return false;
        }
        return true;
    }
    private void Upload() {

        String CountPuppy = getIntent().getStringExtra("puppy_number");
        String SireNumer = sirenumber.getText().toString().trim();
        String DamNumber = dam.getText().toString().trim();
        String Date = date.getText().toString();
        String Kennel = kennelname.getText().toString();
        String prifix = owner;

        if(CountPuppy.equals("1")){

            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(Puppy1name,Puppy1SetColor,Puppy1Gender);

                }

        }
        else if(CountPuppy.equals("2")) {
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String puppy = Puppy1name+","+Puppy2name;
            String color = Puppy1SetColor+","+Puppy2SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
            puppy2name.requestFocus();
            puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("3")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("4")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String Puppy4name = puppy4name.getText().toString();
            String Puppy4ColorName = puppy4setcolor.getText().toString();
            String Puppy4SetColor = puppy4setcolormakingid.getText().toString();
            String Puppy4Gender   = puppy4gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name+","+Puppy4name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor+","+Puppy4SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender+","+Puppy4Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else if(Puppy4name.isEmpty()){
                puppy4name.requestFocus();
                puppy4name.setError("Please Enter Name");
            }
            else if(Puppy4SetColor.isEmpty()){
                puppy4setcolor.requestFocus();
                puppy4setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("5")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String Puppy4name = puppy4name.getText().toString();
            String Puppy4ColorName = puppy4setcolor.getText().toString();
            String Puppy4SetColor = puppy4setcolormakingid.getText().toString();
            String Puppy4Gender   = puppy4gender;

            String Puppy5name = puppy5name.getText().toString();
            String Puppy5ColorName = puppy5setcolor.getText().toString();
            String Puppy5SetColor = puppy5setcolormakingid.getText().toString();
            String Puppy5Gender   = puppy5gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name+","+Puppy4name+","+Puppy5name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor+","+Puppy4SetColor+","+Puppy5SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender+","+Puppy4Gender+","+Puppy5Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else if(Puppy4name.isEmpty()){
                puppy4name.requestFocus();
                puppy4name.setError("Please Enter Name");
            }
            else if(Puppy4SetColor.isEmpty()){
                puppy4setcolor.requestFocus();
                puppy4setcolor.setError("Select Color");
            }
            else if(Puppy5name.isEmpty()){
                puppy5name.requestFocus();
                puppy5name.setError("Please Enter Name");
            }
            else if(Puppy5SetColor.isEmpty()){
                puppy5setcolor.requestFocus();
                puppy5setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("6")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String Puppy4name = puppy4name.getText().toString();
            String Puppy4ColorName = puppy4setcolor.getText().toString();
            String Puppy4SetColor = puppy4setcolormakingid.getText().toString();
            String Puppy4Gender   = puppy4gender;

            String Puppy5name = puppy5name.getText().toString();
            String Puppy5ColorName = puppy5setcolor.getText().toString();
            String Puppy5SetColor = puppy5setcolormakingid.getText().toString();
            String Puppy5Gender   = puppy5gender;

            String Puppy6name = puppy6name.getText().toString();
            String Puppy6ColorName = puppy6setcolor.getText().toString();
            String Puppy6SetColor = puppy6setcolormakingid.getText().toString();
            String Puppy6Gender   = puppy6gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name+","+Puppy4name+","+Puppy5name+","+Puppy6name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor+","+Puppy4SetColor+","+Puppy5SetColor+","+Puppy6SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender+","+Puppy4Gender+","+Puppy5Gender+","+Puppy6Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else if(Puppy4name.isEmpty()){
                puppy4name.requestFocus();
                puppy4name.setError("Please Enter Name");
            }
            else if(Puppy4SetColor.isEmpty()){
                puppy4setcolor.requestFocus();
                puppy4setcolor.setError("Select Color");
            }
            else if(Puppy5name.isEmpty()){
                puppy5name.requestFocus();
                puppy5name.setError("Please Enter Name");
            }
            else if(Puppy5SetColor.isEmpty()){
                puppy5setcolor.requestFocus();
                puppy5setcolor.setError("Select Color");
            }
            else if(Puppy6name.isEmpty()){
                puppy6name.requestFocus();
                puppy6name.setError("Please Enter Name");
            }
            else if(Puppy6SetColor.isEmpty()){
                puppy6setcolor.requestFocus();
                puppy6setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("7")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String Puppy4name = puppy4name.getText().toString();
            String Puppy4ColorName = puppy4setcolor.getText().toString();
            String Puppy4SetColor = puppy4setcolormakingid.getText().toString();
            String Puppy4Gender   = puppy4gender;

            String Puppy5name = puppy5name.getText().toString();
            String Puppy5ColorName = puppy5setcolor.getText().toString();
            String Puppy5SetColor = puppy5setcolormakingid.getText().toString();
            String Puppy5Gender   = puppy5gender;

            String Puppy6name = puppy6name.getText().toString();
            String Puppy6ColorName = puppy6setcolor.getText().toString();
            String Puppy6SetColor = puppy6setcolormakingid.getText().toString();
            String Puppy6Gender   = puppy6gender;

            String Puppy7name = puppy7name.getText().toString();
            String Puppy7ColorName = puppy7setcolor.getText().toString();
            String Puppy7SetColor = puppy7setcolormakingid.getText().toString();
            String Puppy7Gender   = puppy7gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name+","+Puppy4name+","+Puppy5name+","+Puppy6name+","+Puppy7name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor+","+Puppy4SetColor+","+Puppy5SetColor+","+Puppy6SetColor+","+Puppy7SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender+","+Puppy4Gender+","+Puppy5Gender+","+Puppy6Gender+","+Puppy7Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else if(Puppy4name.isEmpty()){
                puppy4name.requestFocus();
                puppy4name.setError("Please Enter Name");
            }
            else if(Puppy4SetColor.isEmpty()){
                puppy4setcolor.requestFocus();
                puppy4setcolor.setError("Select Color");
            }
            else if(Puppy5name.isEmpty()){
                puppy5name.requestFocus();
                puppy5name.setError("Please Enter Name");
            }
            else if(Puppy5SetColor.isEmpty()){
                puppy5setcolor.requestFocus();
                puppy5setcolor.setError("Select Color");
            }
            else if(Puppy6name.isEmpty()){
                puppy6name.requestFocus();
                puppy6name.setError("Please Enter Name");
            }
            else if(Puppy6SetColor.isEmpty()){
                puppy6setcolor.requestFocus();
                puppy6setcolor.setError("Select Color");
            }
            else if(Puppy7name.isEmpty()){
                puppy7name.requestFocus();
                puppy7name.setError("Please Enter Name");
            }
            else if(Puppy7SetColor.isEmpty()){
                puppy7setcolor.requestFocus();
                puppy7setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("8")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String Puppy4name = puppy4name.getText().toString();
            String Puppy4ColorName = puppy4setcolor.getText().toString();
            String Puppy4SetColor = puppy4setcolormakingid.getText().toString();
            String Puppy4Gender   = puppy4gender;

            String Puppy5name = puppy5name.getText().toString();
            String Puppy5ColorName = puppy5setcolor.getText().toString();
            String Puppy5SetColor = puppy5setcolormakingid.getText().toString();
            String Puppy5Gender   = puppy5gender;

            String Puppy6name = puppy6name.getText().toString();
            String Puppy6ColorName = puppy6setcolor.getText().toString();
            String Puppy6SetColor = puppy6setcolormakingid.getText().toString();
            String Puppy6Gender   = puppy6gender;

            String Puppy7name = puppy7name.getText().toString();
            String Puppy7ColorName = puppy7setcolor.getText().toString();
            String Puppy7SetColor = puppy7setcolormakingid.getText().toString();
            String Puppy7Gender   = puppy7gender;

            String Puppy8name = puppy8name.getText().toString();
            String Puppy8ColorName = puppy8setcolor.getText().toString();
            String Puppy8SetColor = puppy8setcolormakingid.getText().toString();
            String Puppy8Gender   = puppy8gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name+","+Puppy4name+","+Puppy5name+","+Puppy6name+","+Puppy7name+","+Puppy8name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor+","+Puppy4SetColor+","+Puppy5SetColor+","+Puppy6SetColor+","+Puppy7SetColor+","+Puppy8SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender+","+Puppy4Gender+","+Puppy5Gender+","+Puppy6Gender+","+Puppy7Gender+","+Puppy8Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else if(Puppy4name.isEmpty()){
                puppy4name.requestFocus();
                puppy4name.setError("Please Enter Name");
            }
            else if(Puppy4SetColor.isEmpty()){
                puppy4setcolor.requestFocus();
                puppy4setcolor.setError("Select Color");
            }
            else if(Puppy5name.isEmpty()){
                puppy5name.requestFocus();
                puppy5name.setError("Please Enter Name");
            }
            else if(Puppy5SetColor.isEmpty()){
                puppy5setcolor.requestFocus();
                puppy5setcolor.setError("Select Color");
            }
            else if(Puppy6name.isEmpty()){
                puppy6name.requestFocus();
                puppy6name.setError("Please Enter Name");
            }
            else if(Puppy6SetColor.isEmpty()){
                puppy6setcolor.requestFocus();
                puppy6setcolor.setError("Select Color");
            }
            else if(Puppy7name.isEmpty()){
                puppy7name.requestFocus();
                puppy7name.setError("Please Enter Name");
            }
            else if(Puppy7SetColor.isEmpty()){
                puppy7setcolor.requestFocus();
                puppy7setcolor.setError("Select Color");
            }
            else if(Puppy8name.isEmpty()){
                puppy8name.requestFocus();
                puppy8name.setError("Please Enter Name");
            }
            else if(Puppy8SetColor.isEmpty()){
                puppy8setcolor.requestFocus();
                puppy8setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("9")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String Puppy4name = puppy4name.getText().toString();
            String Puppy4ColorName = puppy4setcolor.getText().toString();
            String Puppy4SetColor = puppy4setcolormakingid.getText().toString();
            String Puppy4Gender   = puppy4gender;

            String Puppy5name = puppy5name.getText().toString();
            String Puppy5ColorName = puppy5setcolor.getText().toString();
            String Puppy5SetColor = puppy5setcolormakingid.getText().toString();
            String Puppy5Gender   = puppy5gender;

            String Puppy6name = puppy6name.getText().toString();
            String Puppy6ColorName = puppy6setcolor.getText().toString();
            String Puppy6SetColor = puppy6setcolormakingid.getText().toString();
            String Puppy6Gender   = puppy6gender;

            String Puppy7name = puppy7name.getText().toString();
            String Puppy7ColorName = puppy7setcolor.getText().toString();
            String Puppy7SetColor = puppy7setcolormakingid.getText().toString();
            String Puppy7Gender   = puppy7gender;

            String Puppy8name = puppy8name.getText().toString();
            String Puppy8ColorName = puppy8setcolor.getText().toString();
            String Puppy8SetColor = puppy8setcolormakingid.getText().toString();
            String Puppy8Gender   = puppy8gender;

            String Puppy9name = puppy9name.getText().toString();
            String Puppy9ColorName = puppy9setcolor.getText().toString();
            String Puppy9SetColor = puppy9setcolormakingid.getText().toString();
            String Puppy9Gender   = puppy9gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name+","+Puppy4name+","+Puppy5name+","+Puppy6name+","+Puppy7name+","+Puppy8name+","+Puppy9name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor+","+Puppy4SetColor+","+Puppy5SetColor+","+Puppy6SetColor+","+Puppy7SetColor+","+Puppy8SetColor+","+Puppy9SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender+","+Puppy4Gender+","+Puppy5Gender+","+Puppy6Gender+","+Puppy7Gender+","+Puppy8Gender+","+Puppy9Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else if(Puppy4name.isEmpty()){
                puppy4name.requestFocus();
                puppy4name.setError("Please Enter Name");
            }
            else if(Puppy4SetColor.isEmpty()){
                puppy4setcolor.requestFocus();
                puppy4setcolor.setError("Select Color");
            }
            else if(Puppy5name.isEmpty()){
                puppy5name.requestFocus();
                puppy5name.setError("Please Enter Name");
            }
            else if(Puppy5SetColor.isEmpty()){
                puppy5setcolor.requestFocus();
                puppy5setcolor.setError("Select Color");
            }
            else if(Puppy6name.isEmpty()){
                puppy6name.requestFocus();
                puppy6name.setError("Please Enter Name");
            }
            else if(Puppy6SetColor.isEmpty()){
                puppy6setcolor.requestFocus();
                puppy6setcolor.setError("Select Color");
            }
            else if(Puppy7name.isEmpty()){
                puppy7name.requestFocus();
                puppy7name.setError("Please Enter Name");
            }
            else if(Puppy7SetColor.isEmpty()){
                puppy7setcolor.requestFocus();
                puppy7setcolor.setError("Select Color");
            }
            else if(Puppy8name.isEmpty()){
                puppy8name.requestFocus();
                puppy8name.setError("Please Enter Name");
            }
            else if(Puppy8SetColor.isEmpty()){
                puppy8setcolor.requestFocus();
                puppy8setcolor.setError("Select Color");
            }
            else if(Puppy9name.isEmpty()){
                puppy9name.requestFocus();
                puppy9name.setError("Please Enter Name");
            }
            else if(Puppy9SetColor.isEmpty()){
                puppy9setcolor.requestFocus();
                puppy9setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
        else if(CountPuppy.equals("10")){
            String Puppy1name = puppy1name.getText().toString();
            String Puppy1ColorName = puppy1setcolor.getText().toString();
            String Puppy1SetColor = puppy1setcolormakingid.getText().toString();
            String Puppy1Gender   = puppy1gender;

            String Puppy2name = puppy2name.getText().toString();
            String Puppy2ColorName = puppy2setcolor.getText().toString();
            String Puppy2SetColor = puppy2setcolormakingid.getText().toString();
            String Puppy2Gender   = puppy2gender;

            String Puppy3name = puppy3name.getText().toString();
            String Puppy3ColorName = puppy3setcolor.getText().toString();
            String Puppy3SetColor = puppy3setcolormakingid.getText().toString();
            String Puppy3Gender   = puppy3gender;

            String Puppy4name = puppy4name.getText().toString();
            String Puppy4ColorName = puppy4setcolor.getText().toString();
            String Puppy4SetColor = puppy4setcolormakingid.getText().toString();
            String Puppy4Gender   = puppy4gender;

            String Puppy5name = puppy5name.getText().toString();
            String Puppy5ColorName = puppy5setcolor.getText().toString();
            String Puppy5SetColor = puppy5setcolormakingid.getText().toString();
            String Puppy5Gender   = puppy5gender;

            String Puppy6name = puppy6name.getText().toString();
            String Puppy6ColorName = puppy6setcolor.getText().toString();
            String Puppy6SetColor = puppy6setcolormakingid.getText().toString();
            String Puppy6Gender   = puppy6gender;

            String Puppy7name = puppy7name.getText().toString();
            String Puppy7ColorName = puppy7setcolor.getText().toString();
            String Puppy7SetColor = puppy7setcolormakingid.getText().toString();
            String Puppy7Gender   = puppy7gender;

            String Puppy8name = puppy8name.getText().toString();
            String Puppy8ColorName = puppy8setcolor.getText().toString();
            String Puppy8SetColor = puppy8setcolormakingid.getText().toString();
            String Puppy8Gender   = puppy8gender;

            String Puppy9name = puppy9name.getText().toString();
            String Puppy9ColorName = puppy9setcolor.getText().toString();
            String Puppy9SetColor = puppy9setcolormakingid.getText().toString();
            String Puppy9Gender   = puppy9gender;

            String Puppy10name = puppy10name.getText().toString();
            String Puppy10ColorName = puppy10setcolor.getText().toString();
            String Puppy10SetColor = puppy10setcolormakingid.getText().toString();
            String Puppy10Gender   = puppy10gender;

            String puppy = Puppy1name+","+Puppy2name+","+Puppy3name+","+Puppy4name+","+Puppy5name+","+Puppy6name+","+Puppy7name+","+Puppy8name+","+Puppy9name+","+Puppy10name;
            String color = Puppy1SetColor+","+Puppy2SetColor+","+Puppy3SetColor+","+Puppy4SetColor+","+Puppy5SetColor+","+Puppy6SetColor+","+Puppy7SetColor+","+Puppy8SetColor+","+Puppy9SetColor+","+Puppy10SetColor;
            String age   = Puppy1Gender+","+Puppy2Gender+","+Puppy3Gender+","+Puppy4Gender+","+Puppy5Gender+","+Puppy6Gender+","+Puppy7Gender+","+Puppy8Gender+","+Puppy9Gender+","+Puppy10Gender;



            if(Puppy1name.isEmpty()){
                puppy1name.requestFocus();
                puppy1name.setError("Please Enter Name");
            }
            else if(Puppy1SetColor.isEmpty()){
                puppy1setcolor.requestFocus();
                puppy1setcolor.setError("Select Color");
            }
            else if(Puppy2name.isEmpty()){
                puppy2name.requestFocus();
                puppy2name.setError("Please Enter Name");
            }
            else if(Puppy2SetColor.isEmpty()){
                puppy2setcolor.requestFocus();
                puppy2setcolor.setError("Select Color");
            }
            else if(Puppy3name.isEmpty()){
                puppy3name.requestFocus();
                puppy3name.setError("Please Enter Name");
            }
            else if(Puppy3SetColor.isEmpty()){
                puppy3setcolor.requestFocus();
                puppy3setcolor.setError("Select Color");
            }
            else if(Puppy4name.isEmpty()){
                puppy4name.requestFocus();
                puppy4name.setError("Please Enter Name");
            }
            else if(Puppy4SetColor.isEmpty()){
                puppy4setcolor.requestFocus();
                puppy4setcolor.setError("Select Color");
            }
            else if(Puppy5name.isEmpty()){
                puppy5name.requestFocus();
                puppy5name.setError("Please Enter Name");
            }
            else if(Puppy5SetColor.isEmpty()){
                puppy5setcolor.requestFocus();
                puppy5setcolor.setError("Select Color");
            }
            else if(Puppy6name.isEmpty()){
                puppy6name.requestFocus();
                puppy6name.setError("Please Enter Name");
            }
            else if(Puppy6SetColor.isEmpty()){
                puppy6setcolor.requestFocus();
                puppy6setcolor.setError("Select Color");
            }
            else if(Puppy7name.isEmpty()){
                puppy7name.requestFocus();
                puppy7name.setError("Please Enter Name");
            }
            else if(Puppy7SetColor.isEmpty()){
                puppy7setcolor.requestFocus();
                puppy7setcolor.setError("Select Color");
            }
            else if(Puppy8name.isEmpty()){
                puppy8name.requestFocus();
                puppy8name.setError("Please Enter Name");
            }
            else if(Puppy8SetColor.isEmpty()){
                puppy8setcolor.requestFocus();
                puppy8setcolor.setError("Select Color");
            }
            else if(Puppy9name.isEmpty()){
                puppy9name.requestFocus();
                puppy9name.setError("Please Enter Name");
            }
            else if(Puppy9SetColor.isEmpty()){
                puppy9setcolor.requestFocus();
                puppy9setcolor.setError("Select Color");
            }
            else if(Puppy10name.isEmpty()){
                puppy10name.requestFocus();
                puppy10name.setError("Please Enter Name");
            }
            else if(Puppy10SetColor.isEmpty()){
                puppy10setcolor.requestFocus();
                puppy10setcolor.setError("Select Color");
            }
            else {

                SendDataTOUpload(puppy,color,age);

            }
        }
    }

    private void SendDataTOUpload(String puppy1name, String puppy1SetColor, String puppy1Gender) {
        String PuppyName =  puppy1name+",";
        String Color = puppy1SetColor+",";
        String Age   = puppy1Gender+",";

        String SireNumer = sirenumber.getText().toString().trim();
        String DamNumber = dam.getText().toString().trim();
        String Date = date.getText().toString();
        String Kennel = kennelname.getText().toString();
        String prifix = owner;

        progressDialog  = new ProgressDialog(LitterRegistraionFromAllPuppyActivity.this);
        progressDialog.setMessage("Loading please...");
        progressDialog.show();

        appConfig = new AppConfig(LitterRegistraionFromAllPuppyActivity.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                .addConverterFactory(GsonConverterFactory.create()).build();

        File file =new File(path);
        RequestBody requestFiledog = RequestBody.create(MediaType.parse("multipart/form-data"),file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("pet_image",file.getName(),requestFiledog);


        RequestBody Sirenum = RequestBody.create(MediaType.parse("multipart/form-data"),SireNumer);
        RequestBody Damnum = RequestBody.create(MediaType.parse("multipart/form-data"),DamNumber);
        RequestBody gender = RequestBody.create(MediaType.parse("multipart/form-data"),Age);
        RequestBody date = RequestBody.create(MediaType.parse("multipart/form-data"),Date);
        RequestBody dogname = RequestBody.create(MediaType.parse("multipart/form-data"),PuppyName);
        RequestBody color = RequestBody.create(MediaType.parse("multipart/form-data"),Color);
        RequestBody kennel = RequestBody.create(MediaType.parse("multipart/form-data"),Kennel);
        RequestBody Prifix = RequestBody.create(MediaType.parse("multipart/form-data"),prifix);

        ApiService apiService = retrofit.create(ApiService.class);

        Call<LitterRegisterFromResponse> call = apiService.LitterAdd(body,Sirenum,Damnum,gender,date,dogname,color,kennel,Prifix,userId,token);
        call.enqueue(new Callback<LitterRegisterFromResponse>() {
            @Override
            public void onResponse(Call<LitterRegisterFromResponse> call, retrofit2.Response<LitterRegisterFromResponse> response) {
                if(response.isSuccessful())
                {
                    if(response.body().getCode().equals(200)){
                        Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MyDogActivity.class));
                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<LitterRegisterFromResponse> call, Throwable t) {
                Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
//        Toast.makeText(this, Puppy +" / "+Color +" / " +Age , Toast.LENGTH_SHORT).show();
//        Log.d("Tenali", "SendDataTOUpload: "+Puppy +" / "+Color +" / " +Age );



    }

    private void ColorAndMaking() {

        appConfig = new AppConfig(LitterRegistraionFromAllPuppyActivity.this);
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

                                Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "Data is not available", Toast.LENGTH_SHORT).show();
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
                                    colorAndMakingSpinnerArrayAdapter = new ArrayAdapter<ColorAndMakingSpinner>(LitterRegistraionFromAllPuppyActivity.this,
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
                Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(LitterRegistraionFromAllPuppyActivity.this);
        requestQueue.add(request);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 10 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = LitterRegistraionFromAllPuppyActivity.this;
            path = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imageselected.setVisibility(View.VISIBLE);
            imageselected.setImageBitmap(bitmap);
            errorimage.setVisibility(View.GONE);
        }


    }


    private void KennelNameFetch() {

        appConfig = new AppConfig(LitterRegistraionFromAllPuppyActivity.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        StringRequest request = new StringRequest(Request.Method.POST, KennelURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // Log.d("bagqraji", "onResponse: "+response);

                        try {

                            int j = 0;
                            JSONObject jsonObject = new JSONObject(response);
                            String data = jsonObject.getString("data");
                            if (data.equals("false")) {

                                Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "Data is not available", Toast.LENGTH_SHORT).show();
//                                progressDialog.dismiss();
                            }else
                            {

                                    JSONObject kennel_info = new JSONObject(data);
                                    String kennel_info_string = kennel_info.getString("kennel_info");

                                    JSONObject kennel_value = new JSONObject(kennel_info_string);

                                    String kennel_id = kennel_value.getString("kennel_id");
                                    String owner_user_id = kennel_value.getString("owner_user_id");
                                    String is_second_owner = kennel_value.getString("is_second_owner");
                                    String second_owner_id = kennel_value.getString("second_owner_id");
                                    String kennel_name = kennel_value.getString("kennel_name");
                                    String kennel_comment = kennel_value.getString("kennel_comment");
                                    String kennel_status = kennel_value.getString("kennel_status");
                                    String is_kennel_name_paid = kennel_value.getString("is_kennel_name_paid");

                                    kennelInfoLitterRegisterslist.add(new KennelInfoLitterRegister(kennel_id,owner_user_id,is_second_owner,kennel_name));
                                    kennelInfoLitterRegisterArrayAdapter = new ArrayAdapter<KennelInfoLitterRegister>(LitterRegistraionFromAllPuppyActivity.this,
                                            android.R.layout.simple_spinner_dropdown_item,kennelInfoLitterRegisterslist);




                                JSONObject kennel_history = new JSONObject(data);
                                String kennel_history_value = kennel_history.getString("kennel_history");

                                if(kennel_history_value.equals(false)) {
                                    Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, "Kennel name is Not data", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    JSONArray jsonArray = kennel_history.getJSONArray("kennel_history");
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject object = jsonArray.getJSONObject(i);

                                        String history_id = object.getString("history_id");
                                        String kennel_id_history = object.getString("kennel_id");
                                        String kennel_club_name = object.getString("kennel_club_name");
                                        String kennel_club_comment = object.getString("kennel_club_comment");
                                        String kennel_club_status = object.getString("kennel_club_status");

//                                    Log.d("icebug", "onResponse: "+history_id);

                                    }
                                }



                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LitterRegistraionFromAllPuppyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(LitterRegistraionFromAllPuppyActivity.this);
        requestQueue.add(request);
    }

    private void initializeLogic() {
//        _view(button2, 35, 13, "#40c9a2");
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