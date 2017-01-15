package lyw.littlegift;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import com.lidroid.xutils.DbUtils;

import java.util.ArrayList;
import java.util.List;

import lyw.littlegift.base.NoScrollViewPager;
import lyw.littlegift.fragment.BirthFragment;
import lyw.littlegift.fragment.FindFragment;
import lyw.littlegift.fragment.HomeFragment;
import lyw.littlegift.ui.AddActivity;
import lyw.littlegift.utils.PopwindowUtils;
import lyw.littlegift.widget.SystemBarTintManager;

public class MainActivity extends AppCompatActivity {

    protected SystemBarTintManager tintManager;
    private RadioGroup radioGroup;
    private NoScrollViewPager viewPager;
    private TextView title_tv;
    private List<Fragment> fragments;
    private ImageView imageView;
    private int index = 0;
    private PopwindowUtils mPopwindowUtils;
    DbUtils db;
    public static MainActivity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_main);

        instance = this;
        //设置沉浸式状态栏
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.maincolor);

        initView();
        initFragment();
        initAdapter();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                imageView.setVisibility(View.VISIBLE);

                switch (checkedId) {
                    case R.id.menu_home:
                        index = 0;
                        title_tv.setText("纪念日");
                        break;
                    case R.id.menu_birth:
                        index = 1;
                        imageView.setVisibility(View.GONE);
                        title_tv.setText("生日管理");
                        break;
                    case R.id.menu_find:
                        index = 2;
                        imageView.setVisibility(View.GONE);
                        title_tv.setText("发现");
                        break;
                }
                viewPager.setCurrentItem(index);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.startActivity(new Intent(MainActivity.this, AddActivity.class));
//                MainActivity.this.finish();

            }
        });

    }


    private void initAdapter() {

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

    }

    private void initFragment() {
        fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new BirthFragment());
        fragments.add(new FindFragment());
    }

    private void initView() {

        title_tv = (TextView) findViewById(R.id.title_tv);
        title_tv.setText("纪念日");
        imageView = (ImageView) findViewById(R.id.right_img);
        viewPager = (NoScrollViewPager) findViewById(R.id.main_viewpager);
        radioGroup = (RadioGroup) findViewById(R.id.menu_tab);

        setImage((RadioButton) findViewById(R.id.menu_home), R.drawable.tab_home_bg);
        setImage((RadioButton) findViewById(R.id.menu_birth), R.drawable.tab_birth_bg);
        setImage((RadioButton) findViewById(R.id.menu_find), R.drawable.tab_find_bg);

    }

    /**
     * 设置图片大小
     *
     * @param radioButton
     */
    public void setImage(RadioButton radioButton, int id) {
        Drawable drawable = getResources().getDrawable(id);
        drawable.setBounds(0, 0, dip2px(MainActivity.this, 30)
                , dip2px(MainActivity.this, 30));// 第一0是距左边距离，第二0是距上边距离，40分别是长宽
        radioButton.setCompoundDrawables(null, drawable, null, null);
        // radioButton.setCompoundDrawablePadding(dip2px(MainActivity.this, 10));
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onStart() {
        super.onStart();


    }

    @Override
    public void onStop() {
        super.onStop();


    }
}
