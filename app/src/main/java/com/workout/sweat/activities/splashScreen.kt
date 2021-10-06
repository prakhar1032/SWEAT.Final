package com.workout.sweat.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.workout.sweat.R
import com.workout.sweat.firebase.FirestoreClass

class splashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // This is used to hide the status bar and make the splash screen as a full screen activity.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )


        // Adding the handler to after the a task after some delay.
        Handler().postDelayed({

            // Get the current user id
            val currentUserID = FirestoreClass().getCurrentUserID()
            // Start the Intro Activity

            if (currentUserID.isNotEmpty()) {
                // Start the Main Activity
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                // Start the Intro Activity
                startActivity(Intent(this, Intro::class.java))
            }
            finish() // Call this when your activity is done and should be closed.
            // END
        }, 2500) // Here we pass the delay time in milliSeconds after which the splash activity will disappear.

    }
}