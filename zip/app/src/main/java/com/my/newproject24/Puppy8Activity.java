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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.regex.*;
import org.json.*;

public class Puppy8Activity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView textview1;
	private TextView textview2;
	private EditText edittext1;
	private TextView textview3;
	private EditText edittext2;
	private TextView textview4;
	private LinearLayout linear12;
	private CalendarView calendarview1;
	private TextView textview5;
	private Button button1;
	private TextView textview6;
	private LinearLayout linear2;
	private TextView textview8;
	private LinearLayout linear3;
	private TextView textview9;
	private TextView textview7;
	private EditText edittext4;
	private TextView textview10;
	private LinearLayout linear4;
	private TextView textview11;
	private EditText edittext5;
	private TextView textview15;
	private TextView textview23;
	private EditText edittext6;
	private TextView textview30;
	private LinearLayout linear5;
	private TextView textview41;
	private EditText edittext7;
	private TextView textview42;
	private TextView textview40;
	private EditText edittext8;
	private TextView textview39;
	private LinearLayout linear6;
	private TextView textview38;
	private EditText edittext9;
	private TextView textview37;
	private TextView textview36;
	private EditText edittext10;
	private TextView textview35;
	private LinearLayout linear7;
	private TextView textview34;
	private EditText edittext18;
	private TextView textview33;
	private TextView textview32;
	private EditText edittext16;
	private TextView textview26;
	private LinearLayout linear8;
	private TextView textview31;
	private EditText edittext17;
	private TextView textview29;
	private TextView textview28;
	private EditText edittext15;
	private TextView textview27;
	private LinearLayout linear9;
	private TextView textview25;
	private EditText edittext14;
	private TextView textview22;
	private TextView textview24;
	private EditText edittext13;
	private TextView textview21;
	private LinearLayout linear10;
	private TextView textview20;
	private EditText edittext12;
	private TextView textview17;
	private TextView textview18;
	private EditText edittext19;
	private TextView textview19;
	private LinearLayout linear11;
	private TextView textview16;
	private EditText edittext11;
	private Button button2;
	private EditText edittext20;
	private ImageView imageview1;
	private RadioButton radiobutton1;
	private RadioButton radiobutton2;
	private RadioButton radiobutton3;
	private RadioButton radiobutton4;
	private RadioButton radiobutton5;
	private RadioButton radiobutton6;
	private RadioButton radiobutton7;
	private RadioButton radiobutton8;
	private RadioButton radiobutton9;
	private RadioButton radiobutton10;
	private RadioButton radiobutton11;
	private RadioButton radiobutton12;
	private RadioButton radiobutton13;
	private RadioButton radiobutton14;
	private RadioButton radiobutton15;
	private RadioButton radiobutton16;
	private RadioButton radiobutton17;
	private RadioButton radiobutton18;
	private RadioButton radiobutton19;
	private RadioButton radiobutton20;
	
	private Calendar calendar = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.puppy8);
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
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		edittext1 = findViewById(R.id.edittext1);
		textview3 = findViewById(R.id.textview3);
		edittext2 = findViewById(R.id.edittext2);
		textview4 = findViewById(R.id.textview4);
		linear12 = findViewById(R.id.linear12);
		calendarview1 = findViewById(R.id.calendarview1);
		textview5 = findViewById(R.id.textview5);
		button1 = findViewById(R.id.button1);
		textview6 = findViewById(R.id.textview6);
		linear2 = findViewById(R.id.linear2);
		textview8 = findViewById(R.id.textview8);
		linear3 = findViewById(R.id.linear3);
		textview9 = findViewById(R.id.textview9);
		textview7 = findViewById(R.id.textview7);
		edittext4 = findViewById(R.id.edittext4);
		textview10 = findViewById(R.id.textview10);
		linear4 = findViewById(R.id.linear4);
		textview11 = findViewById(R.id.textview11);
		edittext5 = findViewById(R.id.edittext5);
		textview15 = findViewById(R.id.textview15);
		textview23 = findViewById(R.id.textview23);
		edittext6 = findViewById(R.id.edittext6);
		textview30 = findViewById(R.id.textview30);
		linear5 = findViewById(R.id.linear5);
		textview41 = findViewById(R.id.textview41);
		edittext7 = findViewById(R.id.edittext7);
		textview42 = findViewById(R.id.textview42);
		textview40 = findViewById(R.id.textview40);
		edittext8 = findViewById(R.id.edittext8);
		textview39 = findViewById(R.id.textview39);
		linear6 = findViewById(R.id.linear6);
		textview38 = findViewById(R.id.textview38);
		edittext9 = findViewById(R.id.edittext9);
		textview37 = findViewById(R.id.textview37);
		textview36 = findViewById(R.id.textview36);
		edittext10 = findViewById(R.id.edittext10);
		textview35 = findViewById(R.id.textview35);
		linear7 = findViewById(R.id.linear7);
		textview34 = findViewById(R.id.textview34);
		edittext18 = findViewById(R.id.edittext18);
		textview33 = findViewById(R.id.textview33);
		textview32 = findViewById(R.id.textview32);
		edittext16 = findViewById(R.id.edittext16);
		textview26 = findViewById(R.id.textview26);
		linear8 = findViewById(R.id.linear8);
		textview31 = findViewById(R.id.textview31);
		edittext17 = findViewById(R.id.edittext17);
		textview29 = findViewById(R.id.textview29);
		textview28 = findViewById(R.id.textview28);
		edittext15 = findViewById(R.id.edittext15);
		textview27 = findViewById(R.id.textview27);
		linear9 = findViewById(R.id.linear9);
		textview25 = findViewById(R.id.textview25);
		edittext14 = findViewById(R.id.edittext14);
		textview22 = findViewById(R.id.textview22);
		textview24 = findViewById(R.id.textview24);
		edittext13 = findViewById(R.id.edittext13);
		textview21 = findViewById(R.id.textview21);
		linear10 = findViewById(R.id.linear10);
		textview20 = findViewById(R.id.textview20);
		edittext12 = findViewById(R.id.edittext12);
		textview17 = findViewById(R.id.textview17);
		textview18 = findViewById(R.id.textview18);
		edittext19 = findViewById(R.id.edittext19);
		textview19 = findViewById(R.id.textview19);
		linear11 = findViewById(R.id.linear11);
		textview16 = findViewById(R.id.textview16);
		edittext11 = findViewById(R.id.edittext11);
		button2 = findViewById(R.id.button2);
		edittext20 = findViewById(R.id.edittext20);
		imageview1 = findViewById(R.id.imageview1);
		radiobutton1 = findViewById(R.id.radiobutton1);
		radiobutton2 = findViewById(R.id.radiobutton2);
		radiobutton3 = findViewById(R.id.radiobutton3);
		radiobutton4 = findViewById(R.id.radiobutton4);
		radiobutton5 = findViewById(R.id.radiobutton5);
		radiobutton6 = findViewById(R.id.radiobutton6);
		radiobutton7 = findViewById(R.id.radiobutton7);
		radiobutton8 = findViewById(R.id.radiobutton8);
		radiobutton9 = findViewById(R.id.radiobutton9);
		radiobutton10 = findViewById(R.id.radiobutton10);
		radiobutton11 = findViewById(R.id.radiobutton11);
		radiobutton12 = findViewById(R.id.radiobutton12);
		radiobutton13 = findViewById(R.id.radiobutton13);
		radiobutton14 = findViewById(R.id.radiobutton14);
		radiobutton15 = findViewById(R.id.radiobutton15);
		radiobutton16 = findViewById(R.id.radiobutton16);
		radiobutton17 = findViewById(R.id.radiobutton17);
		radiobutton18 = findViewById(R.id.radiobutton18);
		radiobutton19 = findViewById(R.id.radiobutton19);
		radiobutton20 = findViewById(R.id.radiobutton20);
		
		calendarview1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			@Override
			public void onSelectedDayChange(CalendarView _param1, int _param2, int _param3, int _param4) {
				final int _year = _param2;
				final int _month = _param3;
				final int _day = _param4;
				calendarview1.setVisibility(View.GONE);
				calendar.set(Calendar.DAY_OF_MONTH, (int)(_day));
				calendar.set(Calendar.MONTH, (int)(_month));
				calendar.set(Calendar.YEAR, (int)(_year));
				edittext20.setText(new SimpleDateFormat("dd/MM/yyy").format(calendar.getTime()));
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				calendarview1.setVisibility(View.VISIBLE);
			}
		});
	}
	
	private void initializeLogic() {
		calendarview1.setVisibility(View.GONE);
		_view(button2, 50, 13, "#40c9a2");
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