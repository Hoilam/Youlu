package com.hoilam.youlu.fragment;

import com.hoilam.youlu.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class ContactFragment extends Fragment {
	
	private GridView gridView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment_contact, null);
		gridView=(GridView) view.findViewById(R.id.gridVeiw);
		
		return view;
	}

}
