package com.workout.sweat.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.gms.ads.*
import com.workout.sweat.R
//import com.SWEAT.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //for ads
    lateinit var mAdView: AdView
    private var doubleBackToExitPressedOnce = false

    /**
     * This method is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        //This call the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the xml view to this class
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        dashboard.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        dashboard2.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

        llBMI.setOnClickListener {
            // Launching the BMI Activity
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        llHistory.setOnClickListener {
            // Launching the History Activity
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        //for ads
        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded()
//                Toast.makeText(this@Intro,"AD Loaded",Toast.LENGTH_SHORT).show()
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError)
                mAdView.loadAd(adRequest)
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened()
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked()

            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }

    }

    fun doubleBackToExit() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(
            this,
            resources.getString(R.string.please_click_back_again_to_exit),
            Toast.LENGTH_SHORT
        ).show()

        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
    override fun onBackPressed() {
//        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//            drawer_layout.closeDrawer(GravityCompat.START)
//        } else {
            // A double back press function is added in Base Activity.
            doubleBackToExit()
        }

}
