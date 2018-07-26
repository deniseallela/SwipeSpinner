package com.example.allela.swipeafte;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
private GestureDetectorCompat movement;
MediaPlayer music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //get music placed on the direcory raw
        music=MediaPlayer.create(MainActivity.this,R.raw.al);
        movement=new GestureDetectorCompat(this,new LearnGesture());
        //LearnGesture is a class file

    }
    public boolean onTouchEvent(MotionEvent event){
        this.movement.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
    class LearnGesture extends GestureDetector.SimpleOnGestureListener{
        //a gesture listener tells which gesture has been made

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if (e2.getX()>e1.getX()){
                    if (music.isPlaying()){
                        music.pause();
                        Intent hh=new Intent(getApplicationContext(),Main22.class);
                        startActivity(hh);
                    }
                }
                else
                    if (e2.getX()<e1.getX()) music.start();
                return true;
        }
    }

}
