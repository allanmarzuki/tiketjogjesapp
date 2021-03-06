package id.co.bubui.tiketsayaapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class SplashActivity : AppCompatActivity() {
    private lateinit var app_splash : Animation
    private lateinit var btt : Animation
    private lateinit var handler: Handler
    private lateinit var app_logo : ImageView
    private lateinit var app_subtitle : TextView

    private var USERNAME_KEY = "username_key"
    private var username_key = ""
    private var username_key_new = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        getUsernameLocal()
        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash)
        btt = AnimationUtils.loadAnimation(this, R.anim.btt)
        //load element
        app_logo = findViewById(R.id.app_logo)
        app_subtitle = findViewById(R.id.app_subtitle)

        app_logo.startAnimation(app_splash)
        app_subtitle.startAnimation(btt)

//
    }

    fun getUsernameLocal(){
        val sharedPreference: SharedPreferences = getSharedPreferences(USERNAME_KEY, Context.MODE_PRIVATE)
        username_key_new = sharedPreference.getString(username_key, "").toString()
        if(username_key_new.isEmpty()){
            // Membuat handler
            handler = Handler()
            //setting timer untuk 1 detik auto Intent ke GetStartedActivity
            handler.postDelayed({
                intent = Intent(this, GetStartedActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000) // 2000 Millis -> 2 Detik
        } else {

            // Membuat handler
            handler = Handler()
            //setting timer untuk 1 detik auto Intent ke GetStartedActivity
            handler.postDelayed({
                intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }, 3000) // 2000 Millis -> 2 Detik
        }
    }
}
