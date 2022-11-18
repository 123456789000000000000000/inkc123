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
import android.widget.LinearLayout;
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

public class Cart1FragmentActivity extends Fragment {
	
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout main_ui;
	private LinearLayout linear4;
	private TextView textview1;
	private TextView textview2;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.cart1_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear2 = _view.findViewById(R.id.linear2);
		linear3 = _view.findViewById(R.id.linear3);
		main_ui = _view.findViewById(R.id.main_ui);
		linear4 = _view.findViewById(R.id.linear4);
		textview1 = _view.findViewById(R.id.textview1);
		textview2 = _view.findViewById(R.id.textview2);
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
	}
	
}