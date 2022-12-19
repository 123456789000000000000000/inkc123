package com.example.indiannationalkennelclub;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.AppBarLayout;

import java.util.ArrayList;
import java.util.Random;

public class LitterRegistrationActivity extends AppCompatActivity {

    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;

    private LinearLayout main_ui;
    private LinearLayout linear4;
    private LinearLayout linear6;
    private TextView textview1;
    private LinearLayout linear5;
    private LinearLayout linear7;
    private ImageView imageview1;
    private TextView textview2;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private ImageView imageview2;
    private TextView textview4;
    private ImageView imageview3;
    private TextView textview5;
    private TextView textview3;

    private Intent adddog = new Intent();
    private AlertDialog.Builder inkc;
    private Intent i1 = new Intent();

    EditText numberpuppy;
    TextView errorshow;
    int numbercount = 0;
    Button puppysubmit;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        startActivity(new Intent(getApplicationContext(),MyDogActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litter_registration);
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
        textview1 = findViewById(R.id.textview1);
        linear5 = findViewById(R.id.linear5);
        linear7 = findViewById(R.id.linear7);
        imageview1 = findViewById(R.id.imageview1);
        textview2 = findViewById(R.id.textview2);
        linear8 = findViewById(R.id.linear8);
        linear9 = findViewById(R.id.linear9);
        imageview2 = findViewById(R.id.imageview2);
        textview4 = findViewById(R.id.textview4);
        imageview3 = findViewById(R.id.imageview3);
        textview5 = findViewById(R.id.textview5);
        textview3 = findViewById(R.id.textview3);
        inkc = new AlertDialog.Builder(this);

        numberpuppy = findViewById(R.id.numberpuppy);
        errorshow = findViewById(R.id.errorshow);



        puppysubmit = findViewById(R.id.puppysubmit);
        puppysubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String get = numberpuppy.getText().toString();
                if (get.isEmpty()) {

                    errorshow.setVisibility(View.VISIBLE);
                    errorshow.setText("This field is required.");
                    return;
                }
                else if(Integer.parseInt(get) == 0)
                {
                    errorshow.setVisibility(View.VISIBLE);
                    errorshow.setText("Please enter a valid value  ");
                }
                    else if(Integer.parseInt(get) <= 10 ){

                    Intent intent = new Intent(getApplicationContext(),LitterRegistraionFromAllPuppyActivity.class);
                    intent.putExtra("puppy_number",get);
                    startActivity(intent);
                }
                else
                {
                    errorshow.setVisibility(View.VISIBLE);
                    errorshow.setText("Please enter a value less than or equal to 10. ");
                }
            }
        });


        numberpuppy.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                String get = numberpuppy.getText().toString();


                if (get.isEmpty()) {

                    errorshow.setVisibility(View.VISIBLE);
                    errorshow.setText("This field is required.");
                    return;
                } else {
                    numbercount = Integer.parseInt(get);

                    if (numbercount <= 10) {
//                        errorshow.setVisibility(View.VISIBLE);
//                        errorshow.setText("Please enter a value greater than or equal to 1.");
                        errorshow.setVisibility(View.GONE);
                    } else if (numbercount <= 10) {
                        String send = numberpuppy.getText().toString();
                    } else {
                        errorshow.setVisibility(View.VISIBLE);
                        errorshow.setText("Please enter a value less than or equal to 10. ");

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
//        _radius(linear5, 60, 13, "#40c9a2");
//        _radius(linear8, 20, 10, "#ffffff");
//        _radius(linear9, 20, 10, "#ffffff");
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