package com.example.indiannationalkennelclub;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.indiannationalkennelclub.SharedPrifrence.AppConfig;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    AppConfig appConfig;


    private Toolbar _toolbar;
    private AppBarLayout _app_bar;
    private CoordinatorLayout _coordinator;
    private DrawerLayout _drawer;

    private ViewPager viewpager1;
    private BottomNavigationView bottomnavigation1;
    private LinearLayout _drawer_linear6;
    private LinearLayout _drawer_linear7;
    private ImageView _drawer_imageview6;
    private LinearLayout _drawer_linear1;
    private LinearLayout _drawer_linear2;
    private LinearLayout _drawer_linear3;
    private LinearLayout _drawer_linear4;
    private LinearLayout _drawer_linear5;
    private ImageView _drawer_imageview1;
    private TextView _drawer_textview1;
    private ImageView _drawer_imageview2;
    private TextView _drawer_textview2;
    private ImageView _drawer_imageview3;
    private TextView _drawer_textview3;
    private ImageView _drawer_imageview4;
    private TextView _drawer_textview4;
    private ImageView _drawer_imageview5;
    private TextView _drawer_textview5;

    private Intent home = new Intent();
    private Intent notification = new Intent();
    private Intent home1 = new Intent();
    private Intent adddog = new Intent();
    private Intent crt = new Intent();
    private Intent profile = new Intent();
    private FragFragmentAdapter frag;
    private Intent about = new Intent();
    private Intent contact = new Intent();
    private Intent social = new Intent();

    private static long back_pressed;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize(savedInstanceState);
        initializeLogic();
        AppConfig appConfig = new AppConfig(this);
        String user = appConfig.getInkcRegis();
        Log.d("TAGng", user);
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
        _drawer = findViewById(R.id._drawer);
        ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
        _drawer.addDrawerListener(_toggle);
        _toggle.syncState();

        LinearLayout _nav_view = findViewById(R.id._nav_view);

        viewpager1 = findViewById(R.id.viewpager1);
        bottomnavigation1 = findViewById(R.id.bottomnavigation1);
        _drawer_linear6 = _nav_view.findViewById(R.id.linear6);
        _drawer_linear7 = _nav_view.findViewById(R.id.linear7);
        _drawer_imageview6 = _nav_view.findViewById(R.id.imageview6);
        _drawer_linear1 = _nav_view.findViewById(R.id.linear1);
        _drawer_linear2 = _nav_view.findViewById(R.id.linear2);
        _drawer_linear3 = _nav_view.findViewById(R.id.linear3);
        _drawer_linear4 = _nav_view.findViewById(R.id.linear4);
        _drawer_linear5 = _nav_view.findViewById(R.id.linear5);
        _drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
        _drawer_textview1 = _nav_view.findViewById(R.id.textview1);
        _drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
        _drawer_textview2 = _nav_view.findViewById(R.id.textview2);
        _drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
        _drawer_textview3 = _nav_view.findViewById(R.id.textview3);
        _drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
        _drawer_textview4 = _nav_view.findViewById(R.id.textview4);
        _drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
        _drawer_textview5 = _nav_view.findViewById(R.id.textview5);
        frag = new FragFragmentAdapter(getApplicationContext(), getSupportFragmentManager());

        viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int _position) {
                bottomnavigation1.getMenu().getItem(_position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int _scrollState) {

            }
        });

        bottomnavigation1.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                final int _itemId = item.getItemId();
                viewpager1.setCurrentItem((int)_itemId);
                return true;
            }
        });

        _drawer_linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
//                about.setClass(getApplicationContext(), AboutusActivity.class);
//                startActivity(about);
            }
        });

        _drawer_linear2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
//                contact.setClass(getApplicationContext(), ContactusActivity.class);
//                startActivity(contact);
            }
        });

        _drawer_linear3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
//                social.setClass(getApplicationContext(), SocialmediaActivity.class);
//                startActivity(social);
            }
        });

        _drawer_linear4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {

            }
        });
        _drawer_linear5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _view) {
                appConfig = new AppConfig(MainActivity.this);
                appConfig.updateUserLoginStatus(false);
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });


    }

    private void initializeLogic() {
        frag.setTabCount(4);
        viewpager1.setAdapter(frag);
        bottomnavigation1.getMenu().add(0, 0, 0, "Home").setIcon(R.drawable.ic_baseline_home_24);
        bottomnavigation1.getMenu().add(0, 1, 0, "Cart").setIcon(R.drawable.ic_local_grocery_store_black);
        bottomnavigation1.getMenu().add(0, 2, 0, "Notification").setIcon(R.drawable.ic_notifications_on_black);
        bottomnavigation1.getMenu().add(0, 3, 0, "Profile ").setIcon(R.drawable.ic_person_black);
    }

    public class FragFragmentAdapter extends FragmentStatePagerAdapter {
        // This class is deprecated, you should migrate to ViewPager2:
        // https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2
        Context context;
        int tabCount;

        public FragFragmentAdapter(Context context, FragmentManager manager) {
            super(manager);
            this.context = context;
        }

        public void setTabCount(int tabCount) {
            this.tabCount = tabCount;
        }

        @Override
        public int getCount() {
            return tabCount;
        }

        @Override
        public CharSequence getPageTitle(int _position) {

            return null;
        }

        @Override
        public Fragment getItem(int _position) {
            if (_position == 0) {
                return new HomeFragmentActivity();
            }
            if (_position == 1) {
                return new Cart1FragmentActivity();
            }
            if (_position == 2) {
                return new NotificationFragmentActivity();
            }
            if (_position == 3) {
                return new Profile0FragmentActivity();
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        if (_drawer.isDrawerOpen(GravityCompat.START)) {
            _drawer.closeDrawer(GravityCompat.START);
        } else {
            if (back_pressed + 2000 > System.currentTimeMillis()){
                finishAffinity();
            }
            else{
                Toast.makeText(getBaseContext(), "Press once again to exit",
                        Toast.LENGTH_SHORT).show();
                back_pressed = System.currentTimeMillis();
            }
        }
    }
    public void _radius(final View _view, final double _radius, final double _shadow, final String _color) {

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

//    TextView namefirst,namelast,Gender,dateofbirth,Contact,email,address,alternetcontact,persnolid;


// My Data
//		namefirst  = _view.findViewById(R.id.first);
//		namelast   = _view.findViewById(R.id.last);
//		Gender     = _view.findViewById(R.id.gender);
//		dateofbirth= _view.findViewById(R.id.dob);
//		Contact    = _view.findViewById(R.id.contact);
//		email      = _view.findViewById(R.id.email);
//		address    = _view.findViewById(R.id.address);
//		alternetcontact = _view.findViewById(R.id.altercontact);
//		persnolid  = _view.findViewById(R.id.persnalid);


//								namefirst.setText(first_name);
//								namelast.setText(last_name);
//								if(gender.equals("0"))
//								    Gender.setText("Female");
//								else
//									Gender.setText("Male");
//								dateofbirth.setText(user_birth_date);
//								Contact.setText(user_phone_number);
//								email.setText(user_email_id);
//								address.setText(user_address+","+user_address_2+","+user_local+","+user_district+","+user_state+","+user_pincode);
//								persnolid.setText(user_id);


//<LinearLayout
//	xmlns:android="http://schemas.android.com/apk/res/android"
//            xmlns:app="http://schemas.android.com/apk/res-auto"
//            xmlns:tools="http://schemas.android.com/tools"
//            android:layout_width="match_parent"
//            android:layout_height="match_parent"
//            android:orientation="vertical">
//<LinearLayout
//		android:id="@+id/main_ui"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:padding="8dp"
//                android:gravity="center_horizontal|center_vertical"
//                android:orientation="horizontal">
//<TextView
//			android:id="@+id/textview2"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:padding="8dp"
//                    android:gravity="center_horizontal|center_vertical"
//                    android:text="My Profile "
//                    android:textSize="25sp"
//                    android:textStyle="bold"
//                    android:textColor="#000000"
//                    android:layout_gravity="center_horizontal|center_vertical" />
//</LinearLayout>
//<ScrollView
//		android:id="@+id/vscroll1"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:padding="8dp"
//                android:background="#FFFFFF"
//                android:layout_weight="1">
//<LinearLayout
//			android:id="@+id/linear8"
//                    android:layout_width="match_parent"
//                    android:layout_height="wrap_content"
//                    android:padding="8dp"
//                    android:background="#FFFFFF"
//                    android:orientation="vertical">
//<de.hdodenhof.circleimageview.CircleImageView
//        android:id="@+id/circleimageview1"
//        android:layout_width="150dp"
//        android:layout_height="150dp"
//        android:layout_marginTop="20dp"
//        android:src="@drawable/user"
//        android:layout_gravity="center_horizontal|center_vertical"
//        app:civ_border_width="3dp"
//        app:civ_border_color="#008DCD"
//        app:civ_circle_background_color="#FFFFFF"
//        app:civ_border_overlay="true" />
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="First Name :"
//                            android:textColor="#000000"
//                            android:textSize="16sp"
//                            android:textStyle="bold" />
//
//<TextView
//					android:id="@+id/first"
//                            android:layout_width="250sp"
//                            android:layout_height="wrap_content"
//                            android:layout_alignParentRight="true"
//                            android:padding="8dp"
//                            android:textColor="#000000"
//                            android:textSize="16sp"
//                            android:textStyle="bold" />
//</RelativeLayout>
//
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="Last Name :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/last"
//                            android:layout_width="250sp"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:layout_alignParentRight="true"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//</RelativeLayout>
//
//
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="Gender :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/gender"
//                            android:layout_width="250sp"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:layout_alignParentRight="true"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//</RelativeLayout>
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="Date of Birth :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/dob"
//                            android:layout_width="250sp"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:layout_alignParentRight="true"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//</RelativeLayout>
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="Contact Number :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/contact"
//                            android:layout_width="200sp"
//                            android:layout_height="wrap_content"
//                            android:layout_alignParentRight="true"
//                            android:padding="8dp"
//                            android:textColor="#000000"
//                            android:textSize="16sp"
//                            android:textStyle="bold" />
//</RelativeLayout>
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="Email :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/email"
//                            android:layout_width="220sp"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:layout_alignParentRight="true"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//</RelativeLayout>
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="Address :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/address"
//                            android:layout_width="230sp"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:layout_alignParentRight="true"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//</RelativeLayout>
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text=" Alternet Contact Number :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/altercontact"
//                            android:layout_width="160sp"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:layout_alignParentRight="true"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//</RelativeLayout>
//<RelativeLayout
//				android:layout_width="match_parent"
//                        android:layout_height="wrap_content"
//                        android:layout_marginTop="20dp"
//                        android:layout_marginEnd="20dp"
//                        >
//
//<TextView
//					android:layout_width="wrap_content"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:text="Personal ID :"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//
//<TextView
//					android:id="@+id/persnalid"
//                            android:layout_width="150sp"
//                            android:layout_height="wrap_content"
//                            android:padding="8dp"
//                            android:layout_alignParentRight="true"
//                            android:textSize="16sp"
//                            android:textStyle="bold"
//                            android:textColor="#000000" />
//</RelativeLayout>
//
//
//
//
//</LinearLayout>
//</ScrollView>
//<LinearLayout
//		android:id="@+id/linear10"
//                android:layout_width="match_parent"
//                android:layout_height="wrap_content"
//                android:padding="8dp"
//                android:background="#FFFFFF"
//                android:gravity="center_horizontal"
//                android:orientation="horizontal">
//<TextView
//			android:id="@+id/textview8"
//                    android:layout_width="wrap_content"
//                    android:layout_height="wrap_content"
//                    android:padding="8dp"
//                    android:text="Dog for a good life... A good life for a dog."
//                    android:textSize="16sp"
//                    android:textStyle="bold|italic"
//                    android:textColor="#000000" />
//</LinearLayout>
//</LinearLayout>
