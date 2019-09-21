package com.bignerdranch.android.fragmenttest;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class OneFragment extends Fragment {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private FragmentManager fragmentManager;
    private Fragment fm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_one, container, false);
        button1 = (Button)v.findViewById(R.id.button1);
        button2 = (Button)v.findViewById(R.id.button2);
        button3 = (Button)v.findViewById(R.id.button3);
        button4 = (Button)v.findViewById(R.id.button4);
        return v;
    }

    @Override
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        fragmentManager = getFragmentManager();
        Log.e("xinxi","start()");

    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        if(fm == null){
            fm = new TwoFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_two,fm)
                    .commit();
        }
        setOnclick();
    }

    private void setOnclick(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Remove();
            }
        });
    }

    public Fragment returnNewFragment(){
        return fm;
    }

    private void Remove(){
        fragmentManager.beginTransaction()
                .remove(fm)
                .commit();
        fm = new BlankFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_two,fm)
                .commit();
    }
}
