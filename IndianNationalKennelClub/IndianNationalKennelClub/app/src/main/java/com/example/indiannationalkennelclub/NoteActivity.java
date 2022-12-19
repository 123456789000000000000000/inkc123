package com.example.indiannationalkennelclub;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class NoteActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private LinearLayout main_ui;
    private LinearLayout linear4;
    private LinearLayout linear6;

    RecyclerView recyclerView;
    AppConfig appConfig;
    LinearLayoutManager linearLayoutManager;
    List<ResponseModelNote> datalist;
    ResponseModelNote responseModelNote;
    String NoteShowURL = "https://test181120221003.inkc.in/api/dog/note_list";
    String AddNoteURL = "https://test181120221003.inkc.in/api/dog/add_note";
    private AdapterClassNoteList.RecycleViewClickListener listener;
    AdapterClassNoteList adapterClassNoteList;
    ProgressDialog progressDialog;


    EditText write_note;
    Button submit_note;
    static String Id = "";

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
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
        recyclerView = findViewById(R.id.recview);

        write_note = findViewById(R.id.write_note);
        submit_note= findViewById(R.id.submit_note);


        appConfig = new AppConfig(NoteActivity.this);
        Id = appConfig.getPet_id();


        submit_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = write_note.getText().toString().trim();


                if(note.isEmpty()){
                    write_note.requestFocus();
                    write_note.setError("Please enter note");
                    return;
                }
                else
                {
                    progressDialog = new ProgressDialog(NoteActivity.this);
                    progressDialog.setMessage("Loading Please ...");
                    progressDialog.show();

                    appConfig = new AppConfig(NoteActivity.this);
                    String token = appConfig.getuser_token();
                    String userId = appConfig.getInkcRegis();

                    StringRequest request = new StringRequest(Request.Method.POST, AddNoteURL,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(NoteActivity.this, "Success Add Note", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),NoteActivity.class));

                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(NoteActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                            params.put("note_pet_id", Id);
                            params.put("note_message", note);

                            return  params;
                        }
                    };
                    RequestQueue requestQueue = Volley.newRequestQueue(NoteActivity.this);
                    requestQueue.add(request);

                }
            }
        });

        fetchdata();
        recycleClickLister();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        datalist = new ArrayList<>();
        adapterClassNoteList = new AdapterClassNoteList(listener,datalist);
        recyclerView.setAdapter(adapterClassNoteList);

        //inkc = new AlertDialog.Builder(this);

    }

    private void recycleClickLister() {
        listener = new AdapterClassNoteList.RecycleViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                String id = datalist.get(position).note_id;
                Toast.makeText(NoteActivity.this, id, Toast.LENGTH_SHORT).show();
            }
        };
    }

    private void fetchdata() {
        progressDialog  = new ProgressDialog(NoteActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        appConfig = new AppConfig(NoteActivity.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

//        String Ids = getIntent().getStringExtra("Id");
        Log.d("findvale", "onResponse: "+Id);


        StringRequest request = new StringRequest(Request.Method.POST, NoteShowURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            int j = 0;
                            JSONObject jsonObject = new JSONObject(response);

                            String code = jsonObject.getString("code");

                            if(code.equals("202"))
                            {
                                //progressDialog.dismiss();
                                appConfig = new AppConfig(NoteActivity.this);
                                appConfig.updateUserLoginStatus(false);
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            }

                            String data = jsonObject.getString("data");
                            if (data.equals("false")) {

                                Toast.makeText(NoteActivity.this, "Data is not available", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else
                            {

                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            String user_token = jsonObject.getString("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    j++;
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String sn = String.valueOf(j);

                                    String note_id = object.getString("note_id");
                                    String note_pet_id = object.getString("note_pet_id");
                                    String note_user_id = object.getString("note_user_id");
                                    String note_message = object.getString("note_message");
                                    String note_created_on = object.getString("note_created_on");

                                    //String datetime= "2017-03-08 13:27:00";
                                    String[] divide = note_created_on.split("\\s");
                                    String date = divide[0]; //2017-03-08

                                    String[] datedivide = date.split("\\-");
                                    //for(int i=0; i<datedivide.length)
                                    String year = datedivide[0];
                                    String month = datedivide[1];
                                    String day = datedivide[2];
//								String time= divide[1]; // 13:27:00

                                    responseModelNote = new ResponseModelNote(sn, note_id, note_pet_id, note_user_id, note_message, note_created_on, year, month, day);
                                    datalist.add(responseModelNote);
                                    adapterClassNoteList.notifyDataSetChanged();
                                    progressDialog.dismiss();

                                }


                        }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NoteActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
                params.put("note_pet_id", Id);
                return  params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(NoteActivity.this);
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