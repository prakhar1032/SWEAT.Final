package SWEAT.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.workout.sweat.R
//import com.SWEAT.R
import kotlinx.android.synthetic.main.activity_bmi.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        setSupportActionBar(toolbar_bmi_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //set back button
        supportActionBar?.title = "Sign Up" // Setting an title in the action bar.
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        toolbar_bmi_activity.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}