package com.example.indiannationalkennelclub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.Random;


public class KennelNameRegistrationActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private LinearLayout main_ui;
    private LinearLayout linear4;
    private LinearLayout linear6;

    //seconde owner
    RadioGroup radioGroup1;
    RadioButton radiobutton11,radiobutton22;
    static String owner= "0";


    AppConfig appConfig;
    Dialog dialog;
    ProgressDialog progressDialog;

    LinearLayout secondeownerlayout;
    EditText secondownerid;
    TextView secondeownerset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kennel_name_registration);
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


        secondeownerset = findViewById(R.id.secondeownerset);
        secondeownerlayout = findViewById(R.id.secondeownerlayout);
        secondownerid  = findViewById(R.id.secondownerid);

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
                    Toast.makeText(KennelNameRegistrationActivity.this, "No One Selected", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    RadioButton radioButton = radioGroup.findViewById(selectid);
                    // Toast.makeText(Signup.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                    if(radioButton.getText().equals("Yes"))
                    {
                        Toast.makeText(KennelNameRegistrationActivity.this, "1", Toast.LENGTH_SHORT).show();
                        owner = "1";
                        secondeownerlayout.setVisibility(View.VISIBLE);
                        secondeownerset.setVisibility(View.VISIBLE);
                        secondownerid.setVisibility(View.VISIBLE);
                    }
                    else
                    {
                        Toast.makeText(KennelNameRegistrationActivity.this, "0", Toast.LENGTH_SHORT).show();
                        owner = "0";
                        secondeownerlayout.setVisibility(View.GONE);
                        secondeownerset.setVisibility(View.GONE);
                        secondownerid.setVisibility(View.GONE);
                    }

                }
            }
        });

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