package com.displaynumbers.billsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.displaynumbers.billsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()
        binding.etUsername.setOnClickListener {

            val intent= Intent(this, Nextpage::class.java)
            startActivity(intent)
        }
        binding.btnNextP.setOnClickListener {
            validateSign()
        }
    }


    fun validateSign(){
        val userName=binding.etUsername.text.toString()
        val email=binding.etEmail.text.toString()
        val  passWord=binding.etPassword.text.toString()
        val passwordConf=binding.etPassword.text.toString()
        var error=false


        if (userName.isBlank()){
            binding.etUsername.error="User name is required"
            error=true
        }
        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
            error=true
        }
        if (passWord.isBlank()){
            binding.tilPassword.error="Password is required"
            error=true
        }

        if (!error){
            Toast.makeText(this,"$userName $email,",Toast.LENGTH_LONG)
                .show()
        }
    }
}
