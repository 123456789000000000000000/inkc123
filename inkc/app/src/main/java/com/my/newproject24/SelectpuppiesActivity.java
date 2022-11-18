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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
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

public class SelectpuppiesActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout linear1;
	private LinearLayout linear9;
	private LinearLayout main_ui;
	private TextView textview2;
	private ScrollView vscroll1;
	private TextView textview1;
	private LinearLayout linear10;
	private LinearLayout linear6;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	private Button button10;
	private Button button11;
	private Button button12;
	private TextView textview3;
	
	private Intent puppy1 = new Intent();
	private Intent two = new Intent();
	private Intent four = new Intent();
	private Intent six = new Intent();
	private Intent seven = new Intent();
	private Intent nine = new Intent();
	private Intent ten = new Intent();
	private Intent three1 = new Intent();
	private Intent five1 = new Intent();
	private Intent eight1 = new Intent();
	private Intent eleven = new Intent();
	private Intent twelve = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.selectpuppies);
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
		linear1 = findViewById(R.id.linear1);
		linear9 = findViewById(R.id.linear9);
		main_ui = findViewById(R.id.main_ui);
		textview2 = findViewById(R.id.textview2);
		vscroll1 = findViewById(R.id.vscroll1);
		textview1 = findViewById(R.id.textview1);
		linear10 = findViewById(R.id.linear10);
		linear6 = findViewById(R.id.linear6);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		button3 = findViewById(R.id.button3);
		button4 = findViewById(R.id.button4);
		button5 = findViewById(R.id.button5);
		button6 = findViewById(R.id.button6);
		button7 = findViewById(R.id.button7);
		button8 = findViewById(R.id.button8);
		button9 = findViewById(R.id.button9);
		button10 = findViewById(R.id.button10);
		button11 = findViewById(R.id.button11);
		button12 = findViewById(R.id.button12);
		textview3 = findViewById(R.id.textview3);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				puppy1.setClass(getApplicationContext(), LitterActivity.class);
				startActivity(puppy1);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				two.setClass(getApplicationContext(), Puppy2Activity.class);
				startActivity(two);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				three1.setClass(getApplicationContext(), Puppy3Activity.class);
				startActivity(three1);
			}
		});
		
		button4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				four.setClass(getApplicationContext(), Puppy4Activity.class);
				startActivity(four);
			}
		});
		
		button5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				five1.setClass(getApplicationContext(), Puppy5Activity.class);
				startActivity(five1);
			}
		});
		
		button6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				six.setClass(getApplicationContext(), Puppy6Activity.class);
				startActivity(six);
			}
		});
		
		button7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				seven.setClass(getApplicationContext(), Puppy7Activity.class);
				startActivity(seven);
			}
		});
		
		button8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				eight1.setClass(getApplicationContext(), Puppy8Activity.class);
				startActivity(eight1);
			}
		});
		
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				nine.setClass(getApplicationContext(), Puppy9Activity.class);
				startActivity(nine);
			}
		});
		
		button10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ten.setClass(getApplicationContext(), Puppy10Activity.class);
				startActivity(ten);
			}
		});
		
		button11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				eleven.setClass(getApplicationContext(), Puppy11Activity.class);
				startActivity(eleven);
			}
		});
		
		button12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				twelve.setClass(getApplicationContext(), Puppy12Activity.class);
				startActivity(twelve);
			}
		});
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
		_view(button1, 50, 13, "#64b5f6");
		_view(button2, 50, 13, "#64b5f6");
		_view(button3, 50, 13, "#64b5f6");
		_view(button4, 50, 13, "#64b5f6");
		_view(button5, 50, 13, "#64b5f6");
		_view(button6, 50, 13, "#64b5f6");
		_view(button7, 50, 13, "#64b5f6");
		_view(button8, 50, 13, "#64b5f6");
		_view(button9, 50, 13, "#64b5f6");
		_view(button10, 50, 13, "#64b5f6");
		_view(button11, 50, 13, "#64b5f6");
		_view(button12, 50, 13, "#64b5f6");
		_view(linear6, 50, 0, "#e3f2fd");
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