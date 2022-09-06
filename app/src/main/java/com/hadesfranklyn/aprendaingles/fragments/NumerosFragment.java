package com.hadesfranklyn.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.hadesfranklyn.aprendaingles.R;


public class NumerosFragment extends Fragment implements View.OnClickListener {

    private ImageButton imageButton1, imageButton2, imageButton3,
            imageButton4, imageButton5, imageButton6;

    private MediaPlayer mediaPlayer;

    public NumerosFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        imageButton1 = view.findViewById(R.id.imageButton1);

        imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton4 = view.findViewById(R.id.imageButton4);
        imageButton5 = view.findViewById(R.id.imageButton5);
        imageButton6 = view.findViewById(R.id.imageButton6);

        // Aplica eventos de click
        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageButton1:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;
            case R.id.imageButton2:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;
            case R.id.imageButton3:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;
            case R.id.imageButton4:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;
            case R.id.imageButton5:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;
            case R.id.imageButton6:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
                tocarSom();
                break;
        }
    }

    //Sem interface
    private void tocarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}