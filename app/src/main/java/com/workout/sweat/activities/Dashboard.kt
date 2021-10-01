package SWEAT.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
//import com.SWEAT.R
import com.workout.sweat.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_dashboard.toolbar_bmi_activity

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        setSupportActionBar(toolbar_bmi_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //set back button
        supportActionBar?.title = "Start Workout" // Setting an title in the action bar.

        toolbar_bmi_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
// Click event for start Button which we have created in XML.
        llStart.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }
    }
}