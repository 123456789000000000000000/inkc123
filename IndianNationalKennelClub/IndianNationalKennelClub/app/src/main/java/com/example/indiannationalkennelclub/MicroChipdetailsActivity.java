package com.example.indiannationalkennelclub;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.view.*;
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
import com.example.indiannationalkennelclub.ResponseModel.MicroResponse;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.*;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MicroChipdetailsActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private ArrayList<String> list = new ArrayList<>();

    private ScrollView vscroll1;
    private LinearLayout linear1;

    TextView petnamesave,petregistersave,implementby,implset,errorimage;
    EditText micronumber,nameimplement,numberimplement;
    //Date
    ImageView date1;
    TextView date;
    Dialog dialog;

    Button selectimage;
    ImageView imageselected;

    AppConfig appConfig;
    String ImplementbyUrl = "https://test181120221003.inkc.in/api/dog/implemented_by_list";
    String path;
    ProgressDialog progressDialog;

    Button submitmicro;


    ArrayList<SpinnerMicroImplementedby> spinnerMicroImplementedbyArrayList = new ArrayList<>();
    ArrayAdapter<SpinnerMicroImplementedby> spinnerMicroImplementedbyArrayAdapter;

    String MainUrl = "https://test181120221003.inkc.in/api/dog/";

    String MicroUrl = "https://test181120221003.inkc.in/api/dog/upload_document_microchip";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_micro_chipdetails);

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
        vscroll1 = findViewById(R.id.vscroll1);
        linear1 = findViewById(R.id.linear1);


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
                        MicroChipdetailsActivity.this,
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
                        MicroChipdetailsActivity.this,
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

        petnamesave = findViewById(R.id.petnamesave);
        petregistersave = findViewById(R.id.petregistersave);
        implementby = findViewById(R.id.implementby);
        implset = findViewById(R.id.implset);

        micronumber = findViewById(R.id.micronumber);
        nameimplement = findViewById(R.id.nameimplement);
        numberimplement = findViewById(R.id.numberimplement);

        selectimage = findViewById(R.id.selectimage);
        imageselected = findViewById(R.id.imageselected);

        String name = getIntent().getStringExtra("name");
        String reg  = getIntent().getStringExtra("reg");
        petnamesave.setText(name);
        petregistersave.setText(reg);
        errorimage = findViewById(R.id.errorimage);

        ImplementedBy();
        implementby.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize dialog
                dialog = new Dialog(MicroChipdetailsActivity.this);

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

                listView.setAdapter(spinnerMicroImplementedbyArrayAdapter);
                editText.addTextChangedListener(new TextWatcher() {
                                                    @Override
                                                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                                                    }

                                                    @Override
                                                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                                        spinnerMicroImplementedbyArrayAdapter.getFilter().filter(charSequence);
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

                        SpinnerMicroImplementedby spn = (SpinnerMicroImplementedby) parent.getItemAtPosition(position);
                        implementby.setText(spn.emp_type_name);
                        implset.setText(spn.emp_type_id);

                        //Toast.makeText(Add_Stock_Size_Activity.this, spn.stock_category_id, Toast.LENGTH_SHORT).show();

                        // Dismiss dialog
                        dialog.dismiss();


                    }
                });
            }
        });

        selectimage.setOnClickListener(new OnClickListener() {
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
                    ActivityCompat.requestPermissions(MicroChipdetailsActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }
            }
        });

        submitmicro = findViewById(R.id.submitmicro);
        submitmicro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Upload();
            }
        });

    }

    private void Upload() {

        String name = getIntent().getStringExtra("name");
        String reg  = getIntent().getStringExtra("reg");

        String micro = micronumber.getText().toString().trim();
        String Setidimp  = implset.getText().toString().trim();
        String name_imp = nameimplement.getText().toString().trim();
        String number = numberimplement.getText().toString().trim();
        String Date  = date.getText().toString().trim();


         if(micro.isEmpty()){
            micronumber.requestFocus();
            micronumber.setError("Micro number is required");
        }
        else if(Setidimp.isEmpty()){
            implementby.requestFocus();
            implementby.setError("Please Select");
        }
        else if(name_imp.isEmpty())
        {
            nameimplement.requestFocus();
            nameimplement.setError("Please Enter name");
        }
        else if(number.isEmpty())
        {
            numberimplement.requestFocus();
            numberimplement.setError("Please Enter number");
        }
        else if(Date.isEmpty())
        {
            date.requestFocus();
            date.setError("Please Select Date");
        }
        else  if(imageselected.getDrawable()==null){
             errorimage.setVisibility(View.VISIBLE);
             Toast.makeText(this, "please select dog image", Toast.LENGTH_SHORT).show();
         }
        else
        {

            progressDialog  = new ProgressDialog(MicroChipdetailsActivity.this);
            progressDialog.setMessage("Loading please...");
            progressDialog.show();

            appConfig = new AppConfig(MicroChipdetailsActivity.this);
            String token = appConfig.getuser_token();
            String userId = appConfig.getInkcRegis();

            Retrofit retrofit = new Retrofit.Builder().baseUrl(MainUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            File file =new File(path);
            RequestBody requestFiledog = RequestBody.create(MediaType.parse("multipart/form-data"),file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("upload_microchip_document",file.getName(),requestFiledog);

            RequestBody nameimp = RequestBody.create(MediaType.parse("multipart/form-data"),name_imp);
            RequestBody setimp = RequestBody.create(MediaType.parse("multipart/form-data"),Setidimp);
            RequestBody microimp = RequestBody.create(MediaType.parse("multipart/form-data"),micro);
            RequestBody numberimp = RequestBody.create(MediaType.parse("multipart/form-data"),number);
            RequestBody dateimp = RequestBody.create(MediaType.parse("multipart/form-data"),Date);

            ApiService apiService = retrofit.create(ApiService.class);

            Call<MicroResponse> call = apiService.MicroAdd(body,nameimp,setimp,microimp,numberimp,dateimp,userId,token);

            call.enqueue(new Callback<MicroResponse>() {
                @Override
                public void onResponse(Call<MicroResponse> call, retrofit2.Response<MicroResponse> response) {
                    if(response.isSuccessful())
                    {
                        if(response.body().getCode().equals(200)){
                            String message = response.body().getMessage();
                            Toast.makeText(MicroChipdetailsActivity.this, message, Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(MicroChipdetailsActivity.this, "Please Enter Valid Details", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                    else
                    {
                        Toast.makeText(MicroChipdetailsActivity.this, "Invalid Details", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<MicroResponse> call, Throwable t) {
                    Toast.makeText(MicroChipdetailsActivity.this, "Something is Wrong", Toast.LENGTH_SHORT).show();
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
            Context context = MicroChipdetailsActivity.this;
            path = RealPathUtil.getRealPath(context,uri);
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            imageselected.setVisibility(View.VISIBLE);
            imageselected.setImageBitmap(bitmap);
            errorimage.setVisibility(View.GONE);
        }


    }


    private void ImplementedBy() {

        appConfig = new AppConfig(MicroChipdetailsActivity.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        StringRequest request = new StringRequest(Request.Method.POST, ImplementbyUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject object = jsonArray.getJSONObject(i);
                                String emp_type_id = object.getString("emp_type_id");
                                String emp_type_name = object.getString("emp_type_name");
                                spinnerMicroImplementedbyArrayList.add(new SpinnerMicroImplementedby(emp_type_id,emp_type_name));
                                spinnerMicroImplementedbyArrayAdapter = new ArrayAdapter<SpinnerMicroImplementedby>(MicroChipdetailsActivity.this,
                                        android.R.layout.simple_spinner_dropdown_item,spinnerMicroImplementedbyArrayList);
                                spinnerMicroImplementedbyArrayAdapter.setDropDownViewResource(  android.R.layout.simple_spinner_dropdown_item);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MicroChipdetailsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(MicroChipdetailsActivity.this);
        requestQueue.add(request);
    }

    private void initializeLogic() {
//        _view(button2, 38, 8, "#40c9a2");
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