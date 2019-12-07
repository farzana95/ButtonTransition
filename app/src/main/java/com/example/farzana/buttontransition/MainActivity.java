package com.example.farzana.buttontransition;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    // scenes to transition
    private Scene scene1, scene2, scene3, scene4, scene5;

    // transition to move between scenes
    private Transition transition;

    // flag to swap between scenes
    private int sceneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the layout ID
        RelativeLayout baseLayout = findViewById(R.id.base);

        // first scene
        ViewGroup startViews = (ViewGroup) getLayoutInflater()
                .inflate(R.layout.activity_main, baseLayout, false);

        ViewGroup secondViews = (ViewGroup) getLayoutInflater()
                .inflate(R.layout.scene2, baseLayout, false);

        ViewGroup thirdViews = (ViewGroup) getLayoutInflater()
                .inflate(R.layout.scene3, baseLayout, false);

        ViewGroup fourViews = (ViewGroup) getLayoutInflater()
                .inflate(R.layout.scene4, baseLayout, false);

        // second scene
        ViewGroup endViews = (ViewGroup) getLayoutInflater()
                .inflate(R.layout.scene5, baseLayout, false);

        // create the five scenes
        scene1 = new Scene(baseLayout, startViews);
        scene2 = new Scene(baseLayout, secondViews);
        scene3 = new Scene(baseLayout, thirdViews);
        scene4 = new Scene(baseLayout, fourViews);
        scene5 = new Scene(baseLayout, endViews);

        // create transition, set properties
        transition = new AutoTransition();

        transition.setDuration(1000);

        transition.setInterpolator(new AccelerateDecelerateInterpolator());

        //transition.setInterpolator(new AccelerateInterpolator());

        // initialize flag
        sceneNumber = 1;

    }

    public void changeScene(View view) {

        switch (sceneNumber) {
            case 1:
                TransitionManager.go(scene2, transition);

                sceneNumber = 2;

                break;
        }

        switch (sceneNumber) {
            case 2:
                TransitionManager.go(scene3, transition);

                sceneNumber = 3;

                break;

        }

        switch (sceneNumber) {
            case 3:
                TransitionManager.go(scene4, transition);

                sceneNumber = 4;

                break;
        }

        switch (sceneNumber) {
            case 4:
                TransitionManager.go(scene5, transition);

                sceneNumber = 5;

                break;
        }

        switch (sceneNumber) {
            case 5:
                TransitionManager.go(scene1, transition);

                sceneNumber = 1;

                break;

        }
        // check flag
        //if(sceneNumber == 1){

        //   TransitionManager.go(scene2, transition);

        //   sceneNumber = 2;

        // } else if(sceneNumber == 2){

        //  TransitionManager.go(scene3, transition);

        // sceneNumber = 3 ;

        //  } else if(sceneNumber == 3){

        //    TransitionManager.go(scene4, transition);

        //   sceneNumber = 4 ;

        // } else if(sceneNumber == 4){

        //     TransitionManager.go(scene5, transition);

        //   sceneNumber = 5 ;
//
        //} else if(sceneNumber == 5){

        // TransitionManager.go(scene1, transition);

        // sceneNumber = 1 ;

    }

}
