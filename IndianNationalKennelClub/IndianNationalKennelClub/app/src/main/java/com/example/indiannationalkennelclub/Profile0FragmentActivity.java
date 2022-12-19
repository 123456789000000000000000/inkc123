package com.example.indiannationalkennelclub;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class Profile0FragmentActivity extends Fragment {
	
	private LinearLayout main_ui;
	private ScrollView vscroll1;
	private LinearLayout linear10;
	private TextView textview2;
	private LinearLayout linear8;
	private CircleImageView circleimageview1;
	private TextView textview3;
	private TextView textview9;
	private LinearLayout linear11;
	private TextView textview5;
	private TextView textview4;
	private TextView textview11;
	private TextView textview12;
	private TextView textview13;
	private TextView textview7;
	private LinearLayout linear9;
	private TextView textview10;
	private RadioButton radiobutton1;
	private RadioButton radiobutton2;
	private Button button1;
	private Button button2;
	private TextView textview8;
	
	private Intent edit = new Intent();
	private Intent home = new Intent();

	String profileURL = "https://test181120221003.inkc.in/api/user/user_profile";
	AppConfig appConfig;
	Context context;
	ProgressDialog progressDialog;
	TextView setimageprofileurl;
	TextView namefirst,namelast,Gender,dateofbirth,Contact,email,address,alternetcontact,persnolid;
	LinearLayout ediprofile;
	static String pincode = "",local = "",distic = "",state = "",add1 = "",add2 = "",gender1 = "";
	static String imageset = "";

	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.profile0_fragment, _container, false);
		context = _container.getContext();
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;

	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		main_ui = _view.findViewById(R.id.main_ui);
		vscroll1 = _view.findViewById(R.id.vscroll1);
//		linear10 = _view.findViewById(R.id.linear10);
//		textview2 = _view.findViewById(R.id.textview2);
//		linear8 = _view.findViewById(R.id.linear8);
		circleimageview1 = _view.findViewById(R.id.circleimageview1);
//		textview3 = _view.findViewById(R.id.textview3);
//		textview9 = _view.findViewById(R.id.textview9);
//		textview5 = _view.findViewById(R.id.textview5);
//		textview4 = _view.findViewById(R.id.textview4);
//		textview11 = _view.findViewById(R.id.textview11);
//		textview7 = _view.findViewById(R.id.textview7);
//		linear9 = _view.findViewById(R.id.linear9);
//		textview10 = _view.findViewById(R.id.textview10);
//		radiobutton1 = _view.findViewById(R.id.radiobutton1);
//		radiobutton2 = _view.findViewById(R.id.radiobutton2);
//		textview8 = _view.findViewById(R.id.textview8);

		// My Data
		namefirst  = _view.findViewById(R.id.first);
		namelast   = _view.findViewById(R.id.last);
		Gender     = _view.findViewById(R.id.gender);
		dateofbirth= _view.findViewById(R.id.dob);
		Contact    = _view.findViewById(R.id.contact);
		email      = _view.findViewById(R.id.email);
		address    = _view.findViewById(R.id.address);
		alternetcontact = _view.findViewById(R.id.altercontact);
		persnolid  = _view.findViewById(R.id.persnalid);
		ediprofile = _view.findViewById(R.id.ediprofile);
		setimageprofileurl = _view.findViewById(R.id.setimageprofileurl);


		ediprofile.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				String ima = setimageprofileurl.getText().toString().trim();
//				Toast.makeText(context, ima, Toast.LENGTH_SHORT).show();


				Intent intent = new Intent(getContext(),UpdateProfileActivity.class);
				intent.putExtra("Email",email.getText().toString().trim());
				intent.putExtra("alternetcontact",alternetcontact.getText().toString().trim());
				intent.putExtra("pincode",pincode );
				intent.putExtra("local",local );
				intent.putExtra("distric",distic );
				intent.putExtra("state", state);
				intent.putExtra("add1", add1);
				intent.putExtra("add2",add2 );
				intent.putExtra("gender",gender1 );
				intent.putExtra("Images",ima);
				startActivity(intent);




			}
		});


		Fetchdata();
		

	}

	private void Fetchdata() {
		progressDialog = new ProgressDialog(context);
		progressDialog.setMessage("Please Wait..");
		progressDialog.show();

		appConfig = new AppConfig(context);
		String token = appConfig.getuser_token();
		String userId = appConfig.getInkcRegis();
		Log.d("Tagggg", token+"/"+ userId);
		StringRequest request = new StringRequest(Request.Method.POST, profileURL,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						Log.d("onResponse", response);

						try {
							JSONObject jsonObject = new JSONObject(response);


							String code = jsonObject.getString("code");

							if(code.equals("202"))
							{
								progressDialog.dismiss();
								appConfig = new AppConfig(getContext());
								appConfig.updateUserLoginStatus(false);
								startActivity(new Intent(getContext(),LoginActivity.class));
							}
							else
							{
								String data = jsonObject.getString("data");
								String access_module = jsonObject.getString("access_module");
								String message = jsonObject.getString("message");

								JSONArray jsonArray = jsonObject.getJSONArray("data");

								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject object = jsonArray.getJSONObject(i);
									String first_name = object.getString("first_name");
									String last_name = object.getString("last_name");
									String gender = object.getString("gender");
									String user_birth_date = object.getString("user_birth_date");
									String user_phone_number = object.getString("user_phone_number");
									String user_email_id = object.getString("user_email_id");
									String user_address = object.getString("user_address");
									String user_address_2 = object.getString("user_address_2");
									String user_local = object.getString("user_local");
									String user_district = object.getString("user_district");
									String user_state = object.getString("user_state");
									String user_pincode = object.getString("user_pincode");
									String alternet_contact_number = object.getString("alternet_contact_number");
									String user_id = object.getString("user_id");
									String user_profile_image = object.getString("user_profile_image");

									Glide.with(context).load("https://test181120221003.inkc.in/" + user_profile_image).into(circleimageview1);
									progressDialog.dismiss();

//
									setimageprofileurl.setText("https://test181120221003.inkc.in/" +user_profile_image);
									namefirst.setText(first_name);
									namelast.setText(last_name);
									if (gender.equals("0"))
										Gender.setText("Female");
									else
										Gender.setText("Male");
									dateofbirth.setText(user_birth_date);
									Contact.setText(user_phone_number);
									email.setText(user_email_id);
									address.setText(user_address + "," + user_address_2 + "," + user_local + "," + user_district + "," + user_state + "," + user_pincode);
									persnolid.setText(user_id);
									alternetcontact.setText(alternet_contact_number);
									//progressDialog.dismiss();

									add1 = user_address;
									add2 = user_address_2;
									local = user_local;
									distic = user_district;
									state = user_state;
									pincode = user_pincode;
									gender1 = gender;




									circleimageview1.setOnClickListener(new OnClickListener() {
										@Override
										public void onClick(View view) {
											Dialog dialog = new Dialog(context);
											dialog.setContentView(R.layout.showimage);
											//dialog.getWindow().setLayout(850, 850);
											dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
											dialog.show();

											ImageView nameAdmin = dialog.findViewById(R.id.imageview);

											Glide.with(Profile0FragmentActivity.this).load("https://test181120221003.inkc.in/" + user_profile_image).into(nameAdmin);

										}

									});

								}
								progressDialog.dismiss();
							}


						} catch (JSONException e) {
							e.printStackTrace();
						}

					}
				}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {

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
		RequestQueue requestQueue = Volley.newRequestQueue(context);
		requestQueue.add(request);
	}

	private void initializeLogic() {
		{
			GradientDrawable SketchUi = new GradientDrawable();
			int d = (int) getContext().getApplicationContext().getResources().getDisplayMetrics().density;
			SketchUi.setColor(0xFFfaa916);SketchUi.setCornerRadii(new float[]{
				d*0,d*0,d*0 ,d*0,d*0,d*0 ,d*103,d*103});
			main_ui.setElevation(d*3);
			RippleDrawable SketchUiRD = new RippleDrawable(new ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFFFFFFF}), SketchUi, null);
			main_ui.setBackground(SketchUiRD);
			main_ui.setClickable(true);
		}
//		_radius(button1, 35, 12, "#40c9a2");
//		_radius(button2, 35, 12, "#40c9a2");
	}
	
	public void _radius(final View _view, final double _radius, final double _shadow, final String _color) {
		GradientDrawable ab = new GradientDrawable();
		
		ab.setColor(Color.parseColor(_color));
		ab.setCornerRadius((float) _radius);
		_view.setElevation((float) _shadow);
		_view.setBackground(ab);
	}
	
}
