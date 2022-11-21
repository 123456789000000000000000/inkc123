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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class HomeFragmentActivity extends Fragment {
	
	private LinearLayout linear34;
	private LinearLayout linear35;
	private LinearLayout main_ui;
	private ScrollView vscroll1;
	private ImageView imageview8;
	private LinearLayout linear24;
	private TextView textview7;
	private TextView textview8;
	private LinearLayout linear39;
	private LinearLayout linear40;
	private LinearLayout linear41;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private ImageView imageview15;
	private TextView textview17;
	private ImageView imageview16;
	private TextView textview18;
	private LinearLayout linear45;
	private LinearLayout linear46;
	private ImageView imageview17;
	private TextView textview20;
	private ImageView imageview18;
	private TextView textview21;
	private TextView textview15;
	
	private Intent cart = new Intent();
	private Intent mydog = new Intent();
	private Intent Registration = new Intent();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.home_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear34 = _view.findViewById(R.id.linear34);
		linear35 = _view.findViewById(R.id.linear35);
		main_ui = _view.findViewById(R.id.main_ui);
		vscroll1 = _view.findViewById(R.id.vscroll1);
		imageview8 = _view.findViewById(R.id.imageview8);
		linear24 = _view.findViewById(R.id.linear24);
		textview7 = _view.findViewById(R.id.textview7);
		textview8 = _view.findViewById(R.id.textview8);
		linear39 = _view.findViewById(R.id.linear39);
		linear40 = _view.findViewById(R.id.linear40);
		linear41 = _view.findViewById(R.id.linear41);
		linear42 = _view.findViewById(R.id.linear42);
		linear43 = _view.findViewById(R.id.linear43);
		imageview15 = _view.findViewById(R.id.imageview15);
		textview17 = _view.findViewById(R.id.textview17);
		imageview16 = _view.findViewById(R.id.imageview16);
		textview18 = _view.findViewById(R.id.textview18);
		linear45 = _view.findViewById(R.id.linear45);
		linear46 = _view.findViewById(R.id.linear46);
		imageview17 = _view.findViewById(R.id.imageview17);
		textview20 = _view.findViewById(R.id.textview20);
		imageview18 = _view.findViewById(R.id.imageview18);
		textview21 = _view.findViewById(R.id.textview21);
		textview15 = _view.findViewById(R.id.textview15);
		
		linear42.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				mydog.setClass(getContext().getApplicationContext(), MydogsActivity.class);
				startActivity(mydog);
			}
		});
		
		linear43.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				cart.setClass(getContext().getApplicationContext(), CartActivity.class);
				startActivity(cart);
			}
		});
		
		linear45.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Registration.setClass(getContext().getApplicationContext(), RegistrationActivity.class);
				startActivity(Registration);
			}
		});
	}
	
	private void initializeLogic() {
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			int d = (int) getContext().getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFfaa916);SketchUi.setCornerRadii(new float[]{
				d*0,d*0,d*0 ,d*0,d*0,d*0 ,d*200,d*200});
			main_ui.setElevation(d*12);
			android.graphics.drawable.RippleDrawable SketchUiRD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			main_ui.setBackground(SketchUiRD);
			main_ui.setClickable(false);
		}
		_radius(linear42, 50, 14, "#d7ccc8");
		_radius(linear43, 50, 14, "#c8e6c9");
		_radius(linear45, 50, 14, "#fff9c4");
		_radius(linear46, 50, 14, "#fce4ec");
	}
	
	public void _radius(final View _view, final double _radius, final double _shadow, final String _color) {
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
}