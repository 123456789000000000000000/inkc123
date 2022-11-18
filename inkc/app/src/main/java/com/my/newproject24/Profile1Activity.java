package com.my.newproject24;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
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
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class Profile1Activity extends AppCompatActivity {
	
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
	private Button button3;
	private TextView textview2;
	private EditText edittext1;
	private TextView textview8;
	private EditText edittext2;
	private TextView textview4;
	private EditText edittext3;
	private TextView textview5;
	private EditText edittext4;
	private LinearLayout linear3;
	private Button button2;
	private TextView textview3;
	
	private Intent user = new Intent();
	private Intent notifications = new Intent();
	private Intent cart = new Intent();
	private Intent home = new Intent();
	private Intent home1 = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile1);
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
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		main_ui = findViewById(R.id.main_ui);
		vscroll1 = findViewById(R.id.vscroll1);
		textview1 = findViewById(R.id.textview1);
		linear7 = findViewById(R.id.linear7);
		linear1 = findViewById(R.id.linear1);
		circleimageview1 = findViewById(R.id.circleimageview1);
		button3 = findViewById(R.id.button3);
		textview2 = findViewById(R.id.textview2);
		edittext1 = findViewById(R.id.edittext1);
		textview8 = findViewById(R.id.textview8);
		edittext2 = findViewById(R.id.edittext2);
		textview4 = findViewById(R.id.textview4);
		edittext3 = findViewById(R.id.edittext3);
		textview5 = findViewById(R.id.textview5);
		edittext4 = findViewById(R.id.edittext4);
		linear3 = findViewById(R.id.linear3);
		button2 = findViewById(R.id.button2);
		textview3 = findViewById(R.id.textview3);
	}
	
	private void initializeLogic() {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF2196f3);SketchUi.setCornerRadii(new float[]{
				d*0,d*0,d*0 ,d*0,d*0,d*0 ,d*103,d*103});
			main_ui.setElevation(d*3);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			main_ui.setBackground(SketchUiRD);
			main_ui.setClickable(true);
		}
		_view(button2, 50, 13, "#2196f3");
		_view(linear1, 50, 0, "#ffffff");
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