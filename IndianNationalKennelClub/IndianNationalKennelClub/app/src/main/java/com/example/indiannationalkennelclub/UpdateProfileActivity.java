package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import com.bumptech.glide.Glide;
import com.example.indiannationalkennelclub.RealPath.RealPathUtil;
import com.example.indiannationalkennelclub.ResponseModel.UpdateProfileResponse;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.google.android.material.appbar.AppBarLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpdateProfileActivity extends AppCompatActivity {


    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout main_ui;
    private ScrollView vscroll1;
    private TextView textview1;
    private LinearLayout linear7;
    private LinearLayout linear1;
    private CircleImageView circleimageview1;
    private Button selectimage;
    private TextView textview2;
    private EditText edittext1;
    private TextView textview8;
    private TextView address;
    private TextView textview4;
    private EditText email;
    private TextView textview5;
    private EditText Number;
    private LinearLayout linear3;
    private Button button2;
    private TextView textview3;

    private Intent user = new Intent();
    private Intent notifications = new Intent();
    private Intent cart = new Intent();
    private Intent home = new Intent();
    private Intent home1 = new Intent();



    final int CODE_GALLERY_REQUEST = 999;
    Bitmap bitmap;
    String PincodeURL = "https://test181120221003.inkc.in/api/user/get_city_data_from_pincode";
    AppConfig appConfig;
    ArrayList<String> spinner = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    static String pincodestring = "", locality = "", District = "", State = "", Addressline1 = "",Addressline2 = "";
    String UpdateProfileURL = "https://test181120221003.inkc.in/api/user/update_profile";
    String MainUrl = "https://test181120221003.inkc.in/api/user/";
    //Gender
    RadioGroup radioGroup;
    RadioButton radiobutton1,radiobutton2;
    static String male= "1";


    ProgressDialog progressDialog;
    Context context;

    // Retrofit
    static String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
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
        linear4 = findViewById(R.id.linear4);
        linear5 = findViewById(R.id.linear5);
        main_ui = findViewById(R.id.main_ui);
        vscroll1 = findViewById(R.id.vscroll1);
        textview1 = findViewById(R.id.textview1);
        linear7 = findViewById(R.id.linear7);
        linear1 = findViewById(R.id.linear1);
        circleimageview1 = findViewById(R.id.circleimageview1);
        selectimage = findViewById(R.id.button3);
        textview2 = findViewById(R.id.textview2);
        edittext1 = findViewById(R.id.edittext1);
        textview8 = findViewById(R.id.textview8);
        address = findViewById(R.id.edittext2);
        textview4 = findViewById(R.id.textview4);
        email = findViewById(R.id.edittext3);
        textview5 = findViewById(R.id.textview5);
        Number = findViewById(R.id.edittext4);
        linear3 = findViewById(R.id.linear3);
        button2 = findViewById(R.id.button2);
        textview3 = findViewById(R.id.textview3);

        String Email1 = getIntent().getStringExtra("Email");
        String alternetcontact1 = getIntent().getStringExtra("alternetcontact");
        String pincode1 = getIntent().getStringExtra("pincode");
        String local1 = getIntent().getStringExtra("local");
        String distric1 = getIntent().getStringExtra("distric");
        String state1 = getIntent().getStringExtra("state");
        String add11 = getIntent().getStringExtra("add1");
        String add22 = getIntent().getStringExtra("add2");
        String gender1 = getIntent().getStringExtra("gender");
        String image = getIntent().getStringExtra("Images");
        Log.d("Pannir", "initialize: "+image);
        Glide.with(UpdateProfileActivity.this).load(image).into(circleimageview1);
        path =image;




        // Gender
        radioGroup = findViewById(R.id.radiogroupgender);
        radiobutton1 = radioGroup.findViewById(R.id.radiobutton1);
        radiobutton2 = radioGroup.findViewById(R.id.radiobutton2);
        if(gender1.equals("1"))
        radiobutton1.setChecked(true);
        else
        radiobutton2.setChecked(true);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                if(selectid == -1)
                {
                    Toast.makeText(UpdateProfileActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Male"))
                    {
                        Toast.makeText(UpdateProfileActivity.this, "1", Toast.LENGTH_SHORT).show();
                        male = "1";
                    }
                    else
                    {
                        Toast.makeText(UpdateProfileActivity.this, "0", Toast.LENGTH_SHORT).show();
                        male = "0";
                    }

                }
            }
        });




        pincodestring = pincode1;
        locality = local1;
        District = distric1;
        State = state1;
        Addressline1 = add11;
        Addressline2 = add22;




        email.setText(Email1);
        Number.setText(alternetcontact1);
        address.setText(add11 +","+add22 +","+local1 +","+distric1 +","+state1 +"," +pincode1);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Upload();
//                Imagecheck();
            }
        });

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(UpdateProfileActivity.this);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View customLayout = getLayoutInflater().inflate(R.layout.custom_address, null);
                alertDialog.setView(customLayout);

                appConfig = new AppConfig(UpdateProfileActivity.this);
                String token = appConfig.getuser_token();
                String userId = appConfig.getInkcRegis();

                EditText pincode,distic,state,add1,add2;
                EditText local;


                 pincode = customLayout.findViewById(R.id.pincode);
                 local = customLayout.findViewById(R.id.local);
                 distic = customLayout.findViewById(R.id.distic);
                 state = customLayout.findViewById(R.id.state);
                 add1 = customLayout.findViewById(R.id.address1);
                 add2 = customLayout.findViewById(R.id.address2);



                 pincode.setText(pincodestring);
                if(pincodestring.length() == 6){
                    PincodeFetch(pincodestring);
                }
                Log.d("uncle", "onClick: "+pincodestring);
                 local.setText(locality);
                 distic.setText(District);
                 state.setText(State);
                 add1.setText(Addressline1);
                 add2.setText(Addressline2);


                // Find address
                 pincode.addTextChangedListener(new TextWatcher() {
                     @Override
                     public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                     }

                     @Override
                     public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                     }

                     @Override
                     public void afterTextChanged(Editable editable) {

                         if(pincode.getText().toString().length() == 6){
                             String pincode1 =  pincode.getText().toString().trim();
                             Log.d("pincho", "afterTextChanged: "+pincode1.length());

                             StringRequest request = new StringRequest(Request.Method.POST, PincodeURL,
                                     new Response.Listener<String>() {
                                         @Override
                                         public void onResponse(String response) {
                                             try {

                                                 JSONObject object = new JSONObject(response);

//                                                 String message = object.getString("message");
//                                                 String code = object.getString("code");
//                                                 String status = object.getString("status");

                                                 String data = object.getString("data");
                                                 JSONObject jsonObject = new JSONObject(data);

                                                 String user_local = jsonObject.getString("user_local");
                                                 if (user_local.equals("")){
                                                     Toast.makeText(UpdateProfileActivity.this, "Invalid Pincode ", Toast.LENGTH_SHORT).show();
                                                 }

                                                 //   String s = user_local.replace(",", "");
                                                  String[] ss =user_local.split("\\s*,\\s*");
                                                  for (int i=0;i<ss.length;i++)
                                                  {
                                                      spinner.add(ss[i]);
                                                      arrayAdapter = new ArrayAdapter(UpdateProfileActivity.this, android.R.layout.simple_spinner_dropdown_item,spinner);
                                                      arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                     // Log.d("Checkdaata", "onResponse: "+ss[i]);

                                                  }

                                                 String user_state = jsonObject.getString("user_state");
                                                 String user_district = jsonObject.getString("user_district");

                                                 distic.setText(user_district);
                                                 state.setText(user_state);



//                                                 Log.d("Checkdaata", "onResponse: "+message +"/"+ code+"/"+status +"/"+user_local);

                                             } catch (JSONException e) {
                                                 e.printStackTrace();
                                             }

                                         }
                                     }, new Response.ErrorListener() {
                                 @Override
                                 public void onErrorResponse(VolleyError error) {
                                     Toast.makeText(UpdateProfileActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                                     params.put("user_pincode",pincode1);
                                     return  params;
                                 }

                             };

                             RequestQueue requestQueue = Volley.newRequestQueue(UpdateProfileActivity.this);
                             requestQueue.add(request);
                         }
                         else
                         {
                          //   Toast.makeText(UpdateProfileActivity.this, "Please Enter right pincode", Toast.LENGTH_SHORT).show();
                         }

                     }
                 });

                 // localtion select
                 local.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {
                        Dialog dialog = new Dialog(UpdateProfileActivity.this);

                         // set custom dialog
                         dialog.setContentView(R.layout.dialog_searchable_spinner_stock_type);

                         // set custom height and width
                         dialog.getWindow().setLayout(750, 900);

                         // set transparent background
                         dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                         // show dialog
                         dialog.show();

                         // Initialize and assign variable
                         ListView listView = dialog.findViewById(R.id.list_view);

                         listView.setAdapter(arrayAdapter);

                         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                             @Override
                             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                 // when item selected from list
                                 // set selected item on textView

                                 //  select_type.setText(spinnerArrayAdapter.getItem(position));
                                 String item = (String) listView.getItemAtPosition(position);
                                 local.setText(item);

                                 //Toast.makeText(Add_Stock_Type_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                                 dialog.dismiss();
                             }
                         });
                     }
                 });


//                 pincode.setOnClickListener(new View.OnClickListener() {
//                     @Override
//                     public void onClick(View view) {
//                         StringRequest request = new StringRequest(Request.Method.POST, PincodeURL,
//                                 new Response.Listener<String>() {
//                                     @Override
//                                     public void onResponse(String response) {
//                                         try {
//                                             JSONObject object = new JSONObject(response);
//                                             String user_local = object.getString("user_local");
//                                             Log.d("TAGgggg", "onResponse: "+user_local);
//                                         } catch (JSONException e) {
//                                             e.printStackTrace();
//                                         }
//
//                                     }
//                                 }, new Response.ErrorListener() {
//                             @Override
//                             public void onErrorResponse(VolleyError error) {
//                                 Toast.makeText(UpdateProfileActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
//                             }
//                         }){
//
//                             @Override
//                             public Map<String, String> getHeaders() throws AuthFailureError {
//                                 HashMap headers = new HashMap();
//                                 headers.put("Userid", userId);
//                                 headers.put("Usertoken",token);
//                                 return headers;
//                             }
//
//                             @Nullable
//                             @Override
//                             protected Map<String, String> getParams() throws AuthFailureError {
//                                 Map<String,String> params = new HashMap<String,String>();
//                                 params.put("user_pincode", pincode.getText().toString().trim());
//                                 return  params;
//                             }
//
//                         };
//
//                         RequestQueue requestQueue = Volley.newRequestQueue(UpdateProfileActivity.this);
//                         requestQueue.add(request);
//
//
//                     }
//                 });



                alertDialog.setPositiveButton("Ok" , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String Pincode = pincode.getText().toString().trim();
                        String Location = local.getText().toString().trim();
                        String Distic = distic.getText().toString().trim();
                        String State  =  state.getText().toString().trim();
                        String Address1 =  add1.getText().toString().trim();
                        if(Pincode.isEmpty()){
                            pincode.requestFocus();
                            pincode.setError("Enter Pinocde");
                        }
                        else if(Location.isEmpty()){
                            local.requestFocus();
                            local.setError("Select Location");
                        }
                        else if(Distic.isEmpty()){
                            distic.requestFocus();
                            distic.setError("Enter District");
                        }
                        else if(State.isEmpty()){
                            state.requestFocus();
                            state.setError("Enter State");
                        }
                        else if(Address1.isEmpty()){
                            add1.requestFocus();
                            add1.setError("Enter Address");
                        }
                        else {

                            address.setText(add1.getText().toString().trim() + ", " + add2.getText().toString().trim() + ", " + local.getText().toString().trim() + ", " + ", " + distic.getText().toString().trim() + ", " + ", " + state.getText().toString().trim() + ", " + pincode.getText().toString().trim());
                            pincodestring = pincode.getText().toString().trim();
                            locality = local.getText().toString().trim();
                            District = distic.getText().toString().trim();
                            State = state.getText().toString().trim();
                            Addressline1 = add1.getText().toString().trim();
                            Addressline2 = add2.getText().toString().trim();
                        }

                    }
                });

                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });

                AlertDialog alert = alertDialog.create();
                alert.setCanceledOnTouchOutside(false);
                alert.show();
            }
        });



        //Image Select
        selectimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ActivityCompat.requestPermissions(UpdateProfileActivity.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        CODE_GALLERY_REQUEST);
                if(ContextCompat.checkSelfPermission(getApplicationContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intent,10);
                }
                else
                {
                    ActivityCompat.requestPermissions(UpdateProfileActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });
    }

    private void PincodeFetch(String pincodestring) {

        appConfig = new AppConfig(UpdateProfileActivity.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        StringRequest request = new StringRequest(Request.Method.POST, PincodeURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject object = new JSONObject(response);

//                                                 String message = object.getString("message");
//                                                 String code = object.getString("code");
//                                                 String status = object.getString("status");

                            String data = object.getString("data");
                            JSONObject jsonObject = new JSONObject(data);

                            String user_local = jsonObject.getString("user_local");
                            if (user_local.equals("")){
                                Toast.makeText(UpdateProfileActivity.this, "Invalid Pincode ", Toast.LENGTH_SHORT).show();
                            }

                            //   String s = user_local.replace(",", "");
                            String[] ss =user_local.split("\\s*,\\s*");
                            for (int i=0;i<ss.length;i++)
                            {
                                spinner.add(ss[i]);
                                arrayAdapter = new ArrayAdapter(UpdateProfileActivity.this, android.R.layout.simple_spinner_dropdown_item,spinner);
                                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                // Log.d("Checkdaata", "onResponse: "+ss[i]);

                            }

                            String user_state = jsonObject.getString("user_state");
                            String user_district = jsonObject.getString("user_district");




//                                                 Log.d("Checkdaata", "onResponse: "+message +"/"+ code+"/"+status +"/"+user_local);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UpdateProfileActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                params.put("user_pincode",pincodestring);
                return  params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(UpdateProfileActivity.this);
        requestQueue.add(request);
    }


    public void Upload()
    {
        String Email = email.getText().toString().trim();
        String phone = Number.getText().toString().trim();
        String Address = address.getText().toString().trim();

        if(Email.isEmpty()){
            email.requestFocus();
            email.setError("Enter email id");
        }
       else if(Address.isEmpty()){
           address.requestFocus();
           address.setError("Fill Form");
        }
       else {

            progressDialog = new ProgressDialog(UpdateProfileActivity.this);
            progressDialog.setMessage("Loading please...");
            progressDialog.show();


            appConfig = new AppConfig(UpdateProfileActivity.this);
            String token = appConfig.getuser_token();
            String userId = appConfig.getInkcRegis();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            File file = new File(path);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);

            MultipartBody.Part body = MultipartBody.Part.createFormData("user_profile_image",file.getName(), requestFile);

            RequestBody email = RequestBody.create(MediaType.parse("multipart/form-data"), Email);
            RequestBody user_local = RequestBody.create(MediaType.parse("multipart/form-data"), locality);
            RequestBody user_state = RequestBody.create(MediaType.parse("multipart/form-data"), State);
            RequestBody user_pincode = RequestBody.create(MediaType.parse("multipart/form-data"), pincodestring);
            RequestBody user_address = RequestBody.create(MediaType.parse("multipart/form-data"), Addressline1);
            RequestBody user_address2 = RequestBody.create(MediaType.parse("multipart/form-data"), Addressline2);
            RequestBody user_district = RequestBody.create(MediaType.parse("multipart/form-data"), District);
            RequestBody gender = RequestBody.create(MediaType.parse("multipart/form-data"), male);
            RequestBody alternet_contact_number = RequestBody.create(MediaType.parse("multipart/form-data"), phone);

            ApiService apiService = retrofit.create(ApiService.class);

            Call<UpdateProfileResponse> call = apiService.Update(body, email, user_local, user_state, user_pincode, user_address, user_address2, user_district, gender, alternet_contact_number, userId, token);
            call.enqueue(new Callback<UpdateProfileResponse>() {
                @Override
                public void onResponse(Call<UpdateProfileResponse> call, retrofit2.Response<UpdateProfileResponse> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getCode().equals(200)) {

                            Toast.makeText(UpdateProfileActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Profile0FragmentActivity.class));
                            progressDialog.dismiss();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UpdateProfileResponse> call, Throwable t) {
//                    Toast.makeText(UpdateProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("onnnnnnn", "onFailure: "+t);
                    Toast.makeText(UpdateProfileActivity.this, "Please Select New Image ", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            });
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(requestCode == CODE_GALLERY_REQUEST && resultCode == RESULT_OK && data != null){
//            Uri filepath = data.getData();
//
//            try {
//                InputStream inputStream = getContentResolver().openInputStream(filepath);
//                 bitmap = BitmapFactory.decodeStream(inputStream);
//                 String chec= String.valueOf(bitmap);
//                Toast.makeText(this, chec, Toast.LENGTH_SHORT).show();
//                circleimageview1.setImageBitmap(bitmap);
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }

        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 10 && resultCode == Activity.RESULT_OK){
            Uri uri = data.getData();
            Context context = UpdateProfileActivity.this;
            path = RealPathUtil.getRealPath(context,uri);
            Log.d("pathcheeck", "onActivityResult: "+path);
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            circleimageview1.setImageBitmap(bitmap);
        }else{
//            Toast.makeText(UpdateProfileActivity.this, "System not compatible", Toast.LENGTH_SHORT).show();
        }


    }


//    private String imagetostring(Bitmap bitmap){
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
//        //bitmap.compress(Bitmap.CompressFormat.PNG,100,outputStream);
//        byte[] imagebyte = outputStream.toByteArray();
//
//        String encodedImage = Base64.encodeToString(imagebyte,Base64.DEFAULT);
//        return encodedImage;
//
//    }

    private void initializeLogic() {
        {
            GradientDrawable SketchUi = new GradientDrawable();
            int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
            SketchUi.setColor(0xFFfaa916);SketchUi.setCornerRadii(new float[]{
                d*0,d*0,d*0 ,d*0,d*0,d*0 ,d*103,d*103});
            main_ui.setElevation(d*3);
            RippleDrawable SketchUiRD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
            main_ui.setBackground(SketchUiRD);
            main_ui.setClickable(true);
        }
//        _view(button2, 50, 13, "#40c9a2");
        _view(linear1, 50, 0, "#ffffff");
    }

    public void _view(final View _view, final double _radius, final double _shadow, final String _color) {
        GradientDrawable ab = new GradientDrawable();

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