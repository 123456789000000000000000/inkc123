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
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class Profile0FragmentActivity extends Fragment {
	
	private LinearLayout main_ui;
	private ScrollView vscroll1;
	private LinearLayout linear10;
	private TextView textview2;
	private LinearLayout linear8;
	private CircleImageView circleimageview1;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private LinearLayout linear9;
	private Button button1;
	private Button button2;
	private TextView textview8;
	
	private Intent edit = new Intent();
	private Intent home = new Intent();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.profile0_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		main_ui = _view.findViewById(R.id.main_ui);
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear10 = _view.findViewById(R.id.linear10);
		textview2 = _view.findViewById(R.id.textview2);
		linear8 = _view.findViewById(R.id.linear8);
		circleimageview1 = _view.findViewById(R.id.circleimageview1);
		textview3 = _view.findViewById(R.id.textview3);
		textview4 = _view.findViewById(R.id.textview4);
		textview5 = _view.findViewById(R.id.textview5);
		textview6 = _view.findViewById(R.id.textview6);
		textview7 = _view.findViewById(R.id.textview7);
		linear9 = _view.findViewById(R.id.linear9);
		button1 = _view.findViewById(R.id.button1);
		button2 = _view.findViewById(R.id.button2);
		textview8 = _view.findViewById(R.id.textview8);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edit.setClass(getContext().getApplicationContext(), Profile1Activity.class);
				startActivity(edit);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
	}
	
	private void initializeLogic() {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getContext().getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFF2196f3);SketchUi.setCornerRadii(new float[]{
				d*0,d*0,d*0 ,d*0,d*0,d*0 ,d*103,d*103});
			main_ui.setElevation(d*3);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			main_ui.setBackground(SketchUiRD);
			main_ui.setClickable(true);
		}
		_radius(button1, 50, 12, "#2196f3");
		_radius(button2, 50, 12, "#2196f3");
	}
	
	public void _radius(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
}