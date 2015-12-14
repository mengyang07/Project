package com.lkmy.illegal.car.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.adapter.frgamentadapter.ViewPagerFrgamentAdapter;
import com.lkmy.illegal.car.logic.AppUpdate;
import com.lkmy.illegal.car.model.FragmentModel;
import com.lkmy.illegal.car.model.PushNotify;
import com.lkmy.illegal.car.model.VersionDownload;
import com.lkmy.illegal.car.ui.fragment.CarLlllegalFrgament2;
import com.lkmy.illegal.car.ui.fragment.MainFragment;
import com.lkmy.illegal.car.widget.notification.PushNotification;
import com.lkmy.illegal.car.widget.underbutton.UnderButtonIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 * 作者:李凯
 * 创建时间:2015/11/13 00:18
 * 描述:
 */
public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;

    private UnderButtonIndicator indicator;
    private FragmentManager fragmentManager;

    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main111);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewPager = getViewById(R.id.activity_main_viewpager);
        indicator = getViewById(R.id.activity_main_indicator);
        fragmentManager = getSupportFragmentManager();

    }

    @Override
    protected void setListener() {

    }


    private MainFragment fragment;
    private CarLlllegalFrgament2 fragment1;

    @Override
    protected void processLogic(Bundle savedInstanceState) {

        //测试用
        fragment = new MainFragment();
        fragment1 = new CarLlllegalFrgament2();
        List<FragmentModel> data = new ArrayList<>();
        data.add(new FragmentModel(fragment, "test", R.drawable.perm_group_calendar));
        data.add(new FragmentModel(fragment1, "test2", R.drawable.perm_group_camera));

        ViewPagerFrgamentAdapter frgamentAdapter = new ViewPagerFrgamentAdapter(fragmentManager, data);
        viewPager.setAdapter(frgamentAdapter);
        indicator.setViewPager(viewPager);


        Button button = (Button) findViewById(R.id.test1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                startActivity(intent);
            }
        });


        PushNotify pushNotify = new PushNotify(10009, "title", "content", "tiker", "http://baidu.com");
        PushNotification p = new PushNotification(pushNotify);
        p.showProgressNotify();

        VersionDownload V = new VersionDownload(2, "http://appdown.huacolor.com:8080/down/feijia/201505/howoldareyouapp.103.apk", "diw.apk");
        AppUpdate appUpdate = new AppUpdate(V, this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

