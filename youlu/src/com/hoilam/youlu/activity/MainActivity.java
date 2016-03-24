package com.hoilam.youlu.activity;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.hoilam.youlu.R;
import com.hoilam.youlu.fragment.ContactFragment;


public class MainActivity extends FragmentActivity{
	
	private ViewPager viewpager;
	private RadioGroup radioGroup;
	private ArrayList<Fragment> fg;
	
	private RadioButton rb1;
	private RadioButton rb2;
	private RadioButton rb3;
	private RadioButton rb4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setView();//视图
		setListener();//监听器
		setAdapter();//适配器
			
	}
	//监听器方法
	@SuppressWarnings("deprecation")
	private void setListener() {
		
		//当更换ViewPager的某一页时，更新底部导航
		viewpager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					rb1.setChecked(true);
					break;

				case 1:
					rb2.setChecked(true);
					break;
					
				case 2:
					rb3.setChecked(true);
					break;
				
				case 3:
					rb4.setChecked(true);
					break;				
				}
				
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
		//更换选项时，让viewPager联动
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {

				switch (checkedId) {
				case R.id.radioButton1:
					viewpager.setCurrentItem(0);
					break;

				case R.id.radioButton2:
					viewpager.setCurrentItem(1);
					break;
					
				case R.id.radioButton3:
					viewpager.setCurrentItem(2);
					break;
					
				case R.id.radioButton4:
					viewpager.setCurrentItem(3);
					break;
				}

			}
		});
		
	}

	private void setAdapter() {

		MyPagerAdapter adapter= new MyPagerAdapter(getSupportFragmentManager());
		//构造Fragment的集合List
		fg=new ArrayList<Fragment>();
		fg.add(new ContactFragment());
		fg.add(new ContactFragment());
		fg.add(new ContactFragment());
		fg.add(new ContactFragment());
		
		viewpager.setAdapter(adapter);
	}




	private void setView() {

		viewpager=(ViewPager) findViewById(R.id.viewPager);
		radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
		rb1=(RadioButton) findViewById(R.id.radioButton1);
		rb2=(RadioButton) findViewById(R.id.radioButton2);
		rb3=(RadioButton) findViewById(R.id.radioButton3);
		rb4=(RadioButton) findViewById(R.id.radioButton4);
		
	}
	
	class MyPagerAdapter extends FragmentPagerAdapter{

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);

		}

		@Override
		public Fragment getItem(int position) {
			return fg.get(position);
		}

		@Override
		public int getCount() {

			return fg.size();
		}
		
	}

}
