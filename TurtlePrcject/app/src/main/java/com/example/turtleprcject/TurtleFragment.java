package com.example.turtleprcject;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class TurtleFragment extends Fragment {


    private MediaPlayer mediaPlayer;

    private RadioGroup radioGroup;
    private TextView textView;
    private ImageButton imageButton;
    private int state = R.drawable.tmntleo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayer = MediaPlayer.create(getActivity(),R.raw.tmnt_theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_turtle, container, false);
        radioGroup = (RadioGroup)v.findViewById(R.id.radio_group);
        textView = (TextView)v.findViewById(R.id.text_view);
        imageButton = (ImageButton)v.findViewById(R.id.image_button);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        //我选择在这里设置监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                pickturtle(i);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showname();
            }
        });
        textView.setText("");
    }

    private void pickturtle(int id){
        switch (id){
            case R.id.leo:
                imageButton.setImageResource(R.drawable.tmntleo);
                state = R.drawable.tmntleo;
                break;
            case R.id.mike:
                imageButton.setImageResource(R.drawable.tmntmike);
                state = R.drawable.tmntmike;
                break;
            case R.id.don:
                imageButton.setImageResource(R.drawable.tmntdon);
                state = R.drawable.tmntdon;
                break;
            case R.id.raph:
                imageButton.setImageResource(R.drawable.tmntraph);
                state = R.drawable.tmntraph;
                break;
        }
    }

    private void showname(){
        switch (state){
            case R.drawable.tmntleo:
                textView.setText(R.string.Leo);
                break;
            case R.drawable.tmntmike:
                textView.setText(R.string.Mike);
                break;
            case R.drawable.tmntdon:
                textView.setText(R.string.Don);
                break;
            case R.drawable.tmntraph:
                textView.setText(R.string.Raph);
                break;
        }
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onResume(){
        super.onResume();
        if(mediaPlayer != null){
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mediaPlayer.release();
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }



}
