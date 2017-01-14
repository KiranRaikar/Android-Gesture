package com.example.kraikar.learngesture;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView kinasTextView;
    private Button clickMeButton;
    private GestureDetectorCompat gestureDetectorCompat;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        kinasTextView = (TextView) findViewById(R.id.KinasTextView);
        clickMeButton = (Button) findViewById(R.id.clickMeButton);
        gestureDetectorCompat = new GestureDetectorCompat(this, this);
        gestureDetectorCompat.setOnDoubleTapListener(this);

        eventHandling();
    }

    ///////////////// Start of Event Handling ////////////

    private void eventHandling(){
        clickMeButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        kinasTextView.setText("Yeah! you clicked me..");
                    }
                }
        );

        clickMeButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        kinasTextView.setText("It's realy a longgggggg click...");
                        return true;
                    }
                }
        );
    }
    ///////////////// Start of Event Handling ////////////
    
    ///////////////// Start of Gestures //////////////////

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        kinasTextView.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        kinasTextView.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        kinasTextView.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        kinasTextView.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        kinasTextView.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        kinasTextView.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        kinasTextView.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        kinasTextView.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        kinasTextView.setText("onFling");
        return true;
    }

    ///////////////// End of Gestures //////////////////


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
