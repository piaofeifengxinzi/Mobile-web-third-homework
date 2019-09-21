package com.bignerdranch.android.criminalintent;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class CrimeFragment extends Fragment {
    private String TAG = "CrimeFragment";

    private Crime mCrime;
    private EditText mTitleField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
        Log.e(TAG,"执行onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"执行onCreateView()");
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        return v;
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        Log.e(TAG,"执行onAttach()");
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        Log.e(TAG,"执行onActivityCreated()");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.e(TAG,"执行onStart()");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.e(TAG,"执行onResume()");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.e(TAG,"执行onPause()");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.e(TAG,"执行onStop()");
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        Log.e(TAG,"执行onDestroyView()");
    }

    @Override
    public void onDetach(){
        super.onDetach();
        Log.e(TAG,"执行onDetach()");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.e(TAG,"执行onDestroy()");
    }
}
