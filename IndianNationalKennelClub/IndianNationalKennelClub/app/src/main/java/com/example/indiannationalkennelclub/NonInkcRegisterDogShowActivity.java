package com.example.indiannationalkennelclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
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
import com.example.indiannationalkennelclub.Adapter.AdapterClassNonInkcRegisterDog;
import com.example.indiannationalkennelclub.ResponseModel.ResponseModelNonInkcRegistreDog;
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

public class NonInkcRegisterDogShowActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private LinearLayout main_ui;
    private LinearLayout linear4;
    private LinearLayout linear6;




    RecyclerView recyclerView;
    String noninkcregisterurl = "https://test181120221003.inkc.in/api/dog/non_inkc_kci_registered_dog";
    ProgressDialog progressDialog;
    List<ResponseModelNonInkcRegistreDog> datalist;
    AppConfig appConfig;
    LinearLayoutManager linearLayoutManager;
    ResponseModelNonInkcRegistreDog responseModelNonInkcRegistreDog;

    AdapterClassNonInkcRegisterDog adapterClassNonInkcRegisterDog;
    private AdapterClassNonInkcRegisterDog.RecycleViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_inkc_register_dog_show);
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



        fetchdata();
        recycleClickLister();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        datalist = new ArrayList<>();
        adapterClassNonInkcRegisterDog = new AdapterClassNonInkcRegisterDog(listener,datalist,NonInkcRegisterDogShowActivity.this);
        recyclerView.setAdapter(adapterClassNonInkcRegisterDog);

       // inkc = new AlertDialog.Builder(this);



    }

    private void recycleClickLister() {
        listener = new AdapterClassNonInkcRegisterDog.RecycleViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                String id = datalist.get(position).getPet_id();
                String image = datalist.get(position).getPet_image();
                Intent intent = new Intent(getApplicationContext(),NonInkcDogDetails.class);
                intent.putExtra("UserId",id);
                intent.putExtra("images",image);
                startActivity(intent);
            }
        };
    }

    private void fetchdata() {
        progressDialog  = new ProgressDialog(NonInkcRegisterDogShowActivity.this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        appConfig = new AppConfig(NonInkcRegisterDogShowActivity.this);
        String token = appConfig.getuser_token();
        String userId = appConfig.getInkcRegis();

        StringRequest request = new StringRequest(Request.Method.POST, noninkcregisterurl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            JSONObject jsonObject = new JSONObject(response);

                            String code = jsonObject.getString("code");

                            if(code.equals("202"))
                            {
                                //progressDialog.dismiss();
                                appConfig = new AppConfig(NonInkcRegisterDogShowActivity.this);
                                appConfig.updateUserLoginStatus(false);
                                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                            }

                            String data = jsonObject.getString("data");
                            if (data.equals("false")) {

                                Toast.makeText(NonInkcRegisterDogShowActivity.this, "Data is not available", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }else {
                                JSONArray jsonArray = jsonObject.getJSONArray("data");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String pet_id = object.getString("pet_id");
                                    String owner_id = object.getString("owner_id");
                                    String is_second_owner = object.getString("is_second_owner");
                                    String second_owner_id = object.getString("second_owner_id");
                                    String litter_kennel_id = object.getString("litter_kennel_id");
                                    String is_non_inkc_registration = object.getString("is_non_inkc_registration");
                                    String pet_name = object.getString("pet_name");
                                    String implemented_date = object.getString("implemented_date");
                                    String birth_date = object.getString("birth_date");
                                    String pet_category_id = object.getString("pet_category_id");
                                    String pet_sub_category_id = object.getString("pet_sub_category_id");
                                    String is_microchip_require = object.getString("is_microchip_require");
                                    String pet_microchip_number = object.getString("pet_microchip_number");
                                    String upload_microchip_document = object.getString("upload_microchip_document");
                                    String is_document_require = object.getString("is_document_require");
                                    String pet_registration_number = object.getString("pet_registration_number");
                                    String sire_reg_number = object.getString("sire_reg_number");
                                    String sire_user_approval = object.getString("sire_user_approval");
                                    String sire_user_approval_comment = object.getString("sire_user_approval_comment");
                                    String sire_admin_approval = object.getString("sire_admin_approval");
                                    String sire_admin_approval_comment = object.getString("sire_admin_approval_comment");
                                    String dam_reg_number = object.getString("dam_reg_number");
                                    String dam_user_approval = object.getString("dam_user_approval");
                                    String dam_user_approval_comment = object.getString("dam_user_approval_comment");
                                    String dam_admin_approval = object.getString("dam_admin_approval");
                                    String dam_admin_approval_comment = object.getString("dam_admin_approval_comment");
                                    String implement_by = object.getString("implement_by");
                                    String implementer_name = object.getString("implementer_name");
                                    String implementer_mobile_number = object.getString("implementer_mobile_number");
                                    String microchip_status = object.getString("microchip_status");
                                    String pet_gender = object.getString("pet_gender");
                                    String color_marking = object.getString("color_marking");
                                    String breded_country = object.getString("breded_country");

                                    String pet_image = object.getString("pet_image");
                                    String front_side_certificate = object.getString("front_side_certificate");
                                    String back_side_certificate = object.getString("back_side_certificate");
                                    String pet_height_image = object.getString("pet_height_image");
                                    String pet_side_image = object.getString("pet_side_image");
                                    String document_upload = object.getString("document_upload");
                                    String pet_comment = object.getString("pet_comment");
                                    String is_transfer_changed_name = object.getString("is_transfer_changed_name");
                                    String pet_updated_on = object.getString("pet_updated_on");
                                    String pet_created_on = object.getString("pet_created_on");
                                    String pet_registered_as = object.getString("pet_registered_as");
                                    String pet_checked = object.getString("pet_checked");

                                    String is_death = object.getString("is_death");
                                    String death_date = object.getString("death_date");

                                    String pet_status = object.getString("pet_status");
                                    String is_paid_for_pet = object.getString("is_paid_for_pet");
                                    String user_full_name = object.getString("user_full_name");
                                    String category_name = object.getString("category_name");
                                    String sub_category_name = object.getString("sub_category_name");

                                    responseModelNonInkcRegistreDog = new ResponseModelNonInkcRegistreDog(pet_id, owner_id, is_second_owner, second_owner_id, litter_kennel_id, is_non_inkc_registration, pet_name, implemented_date, birth_date, pet_category_id, pet_sub_category_id, is_microchip_require, pet_microchip_number, upload_microchip_document, is_document_require, pet_registration_number, sire_reg_number, sire_user_approval, sire_user_approval_comment,
                                            sire_admin_approval, sire_admin_approval_comment, dam_reg_number, dam_user_approval, dam_user_approval_comment, dam_admin_approval, dam_admin_approval_comment, implement_by, implementer_name, implementer_mobile_number, microchip_status, pet_gender, color_marking, breded_country, pet_image, front_side_certificate, back_side_certificate, pet_height_image, pet_side_image, document_upload, pet_comment, is_transfer_changed_name, pet_updated_on, pet_created_on, pet_registered_as, pet_checked, is_death, death_date,
                                            pet_status, is_paid_for_pet, user_full_name, category_name, sub_category_name);
                                    datalist.add(responseModelNonInkcRegistreDog);
                                    adapterClassNonInkcRegisterDog.notifyDataSetChanged();
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
                Toast.makeText(NonInkcRegisterDogShowActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
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
        RequestQueue requestQueue = Volley.newRequestQueue(NonInkcRegisterDogShowActivity.this);
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