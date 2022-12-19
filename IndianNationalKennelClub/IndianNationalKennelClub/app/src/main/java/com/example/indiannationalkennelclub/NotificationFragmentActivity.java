package com.example.indiannationalkennelclub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.indiannationalkennelclub.Adapter.AdapterClassNotification;
import com.example.indiannationalkennelclub.ResponseModel.ResponseModelNotification;
import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationFragmentActivity extends Fragment {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout main_ui;
	private TextView textview1;
	private TextView textview2;
	RecyclerView recview;

	ProgressDialog progressDialog;
	String URl = "https://test181120221003.inkc.in/api/notifications";
	AppConfig appConfig;
	LinearLayoutManager linearLayoutManager;
	ResponseModelNotification responseModelNotification;
	List<ResponseModelNotification> datalist;
	AdapterClassNotification adapterClassNotification;
	private AdapterClassNotification.RecycleViewClickListener listener;



	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.notification_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		linear2 = _view.findViewById(R.id.linear2);
		main_ui = _view.findViewById(R.id.main_ui);
		textview1 = _view.findViewById(R.id.textview1);
		textview2 = _view.findViewById(R.id.textview2);
		recview = _view.findViewById(R.id.recview);

		fetch();
		recycleClickLister();

		linearLayoutManager = new LinearLayoutManager(getContext());
		recview.setLayoutManager(linearLayoutManager);

		datalist = new ArrayList<>();
		adapterClassNotification = new AdapterClassNotification(listener,datalist);
		recview.setAdapter(adapterClassNotification);
	}

	private void recycleClickLister() {

		listener = new AdapterClassNotification.RecycleViewClickListener() {
			@Override
			public void onClick(View v, int position) {
				String kk = datalist.get(position).getNoti_message();
				Toast.makeText(getContext(), kk, Toast.LENGTH_SHORT).show();
			}
		};
	}

	private void fetch() {
//		progressDialog  = new ProgressDialog(getContext());
//		progressDialog.setMessage("Please Wait...");
//		progressDialog.show();

		appConfig = new AppConfig(getContext());
		String token = appConfig.getuser_token();
		String userId = appConfig.getInkcRegis();

		StringRequest request = new StringRequest(Request.Method.POST, URl,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {

						try {
							JSONObject jsonObject = new JSONObject(response);

							String code = jsonObject.getString("code");

							if(code.equals("202"))
							{
								//progressDialog.dismiss();
								appConfig = new AppConfig(getContext());
								appConfig.updateUserLoginStatus(false);
								startActivity(new Intent(getContext(),LoginActivity.class));
							}

							String data = jsonObject.getString("data");
							String message = jsonObject.getString("message");
							if(message.equals("success")) {

								JSONObject jsonObject1 = new JSONObject(data);
								String noti_record = jsonObject1.getString("noti_record");
								Log.d("TAGki", noti_record);

								JSONArray jsonArray = jsonObject1.getJSONArray("noti_record");
								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject object = jsonArray.getJSONObject(i);
									String noti_id = object.getString("noti_id");
									String noti_user_id = object.getString("noti_user_id");
									String url_created = object.getString("url_created");
									String noti_message = object.getString("noti_message");
									String noti_status = object.getString("noti_status");
									String noti_created_on = object.getString("noti_created_on");
									String noti_updated_on = object.getString("noti_updated_on");

									//String datetime= "2017-03-08 13:27:00";
									String[] divide = noti_created_on.split("\\s");
									String date = divide[0]; //2017-03-08

									String[] datedivide = date.split("\\-");
									//for(int i=0; i<datedivide.length)
									String year = datedivide[0];
									String month = datedivide[1];
									String day = datedivide[2];
//								String time= divide[1]; // 13:27:00

									Log.d("TAGchi", "onResponse: " + date);

									responseModelNotification = new ResponseModelNotification(noti_id, noti_user_id, url_created, noti_message, noti_status, noti_created_on, noti_updated_on, year, month, day);
									datalist.add(responseModelNotification);
									adapterClassNotification.notifyDataSetChanged();
//									progressDialog.dismiss();

								}

							}
							else
							{
								appConfig = new AppConfig(getContext());
								appConfig.updateUserLoginStatus(false);
								startActivity(new Intent(getContext(),LoginActivity.class));
							}

						} catch (JSONException e) {
							e.printStackTrace();
						}

					}
				}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
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
		RequestQueue requestQueue = Volley.newRequestQueue(getContext());
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
	}
	
}
