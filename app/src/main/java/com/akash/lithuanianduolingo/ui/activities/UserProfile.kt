package com.akash.lithuanianduolingo.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.akash.lithuanianduolingo.MainActivity
import com.akash.lithuanianduolingo.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth

class UserProfile: AppCompatActivity() {

    @BindView(R.id.sign_out)
    lateinit var sign_out: TextView

    lateinit var mGoogleSignInClient: GoogleSignInClient

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }


// pass the same server client ID used while implementing the LogIn feature earlier.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        ButterKnife.bind(this)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso)


        sign_out.setOnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener{
                val intent= Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }

}