package com.bignerdranch.android.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;

    private Fragment fragment1;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fragment = fm.findFragmentById(R.id.fragment_one);
        fragment1 = fm.findFragmentById(R.id.fragment_two);

        if(fragment == null){
            fragment = new OneFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_one,fragment)
                    .commit();
        }


        //另一个再fragment中有管理的fragment
//        if(fragment1 == null){
//            fragment1 = new TwoFragment();
//            fm.beginTransaction()
//                    .add(R.id.fragment_two,fragment1)
//                    .commit();
//        }
    }

//    private void Remove(){
//        fm.beginTransaction()
//                .remove(fragment1)
//                .commit();
//        fragment1 = new BlankFragment();
//        fm.beginTransaction()
//                .add(R.id.fragment_two,fragment1)
//                .commit();
//    }
}
