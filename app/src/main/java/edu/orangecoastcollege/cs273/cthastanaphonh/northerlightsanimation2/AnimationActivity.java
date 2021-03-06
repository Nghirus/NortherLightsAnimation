package edu.orangecoastcollege.cs273.cthastanaphonh.northerlightsanimation2;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class AnimationActivity extends AppCompatActivity {

    // Animation drawable = used for frame animation
    private AnimationDrawable frameAnim;
    // Animation = used for tween(ed) animations
    private Animation rotateAnim;
    private Animation shakeAnim;
    private Animation customAnim;

    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        lightsImageView = (ImageView) findViewById(R.id.lightsImageView);
    }

    /**
     * This button will toggle the frame animation, which will move the image through 4 frames.
     * @param view the current view
     */
    public void toggleFrameAnim(View view){
        // hasn't been initialized
        if (frameAnim == null)
        {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        // if frameAnim is running stop it
        if(frameAnim.isRunning())
            frameAnim.stop();
            // else start it
        else
            frameAnim.start();
    }

    /**
     * This method will check to see if the rotate animation is already running and toggle
     * accordingly
     * @param view the current view where the image is located
     */
    public void toggleRotateAnim(View view){
        // hasn't been initialized yet
        if(rotateAnim == null)
        {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

            // if hasn't started or it has ended, then start it
            if(!rotateAnim.hasStarted() || rotateAnim.hasEnded())
                lightsImageView.startAnimation(rotateAnim);
        }
        else
            rotateAnim = null;
    }

    /**
     * This method will trigger a quick shake animation
     * @param view the current view where the image is located
     */
    public void toggleShakeAnim(View view){

        shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
        lightsImageView.startAnimation(shakeAnim);

    }

    public void toggleCustomAnim(View view){

    }
}