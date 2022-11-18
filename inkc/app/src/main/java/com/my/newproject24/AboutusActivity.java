package com.my.newproject24;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class AboutusActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout main_ui;
	private ScrollView vscroll1;
	private TextView textview1;
	private LinearLayout linear5;
	private TextView textview3;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview10;
	private LinearLayout linear10;
	private LinearLayout linear9;
	private ImageView imageview5;
	private TextView textview7;
	private ImageView imageview4;
	private TextView textview6;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private ImageView imageview6;
	private TextView textview8;
	private ImageView imageview7;
	private TextView textview9;
	private TextView textview2;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.aboutus);
		initialize(_savedInstanceState);
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
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		main_ui = findViewById(R.id.main_ui);
		vscroll1 = findViewById(R.id.vscroll1);
		textview1 = findViewById(R.id.textview1);
		linear5 = findViewById(R.id.linear5);
		textview3 = findViewById(R.id.textview3);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		textview10 = findViewById(R.id.textview10);
		linear10 = findViewById(R.id.linear10);
		linear9 = findViewById(R.id.linear9);
		imageview5 = findViewById(R.id.imageview5);
		textview7 = findViewById(R.id.textview7);
		imageview4 = findViewById(R.id.imageview4);
		textview6 = findViewById(R.id.textview6);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		imageview6 = findViewById(R.id.imageview6);
		textview8 = findViewById(R.id.textview8);
		imageview7 = findViewById(R.id.imageview7);
		textview9 = findViewById(R.id.textview9);
		textview2 = findViewById(R.id.textview2);
	}
	
	private void initializeLogic() {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF2196F3);SketchUi.setCornerRadii(new float[]{
				d*0,d*0,d*0 ,d*0,d*0,d*0 ,d*103,d*103});
			main_ui.setElevation(d*3);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			main_ui.setBackground(SketchUiRD);
			main_ui.setClickable(true);
		}
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