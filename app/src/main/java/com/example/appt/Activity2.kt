package com.example.appt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.appt.databinding.Activity2Binding
import com.example.appt.databinding.ActivityMainBinding

class Activity2 : AppCompatActivity() {
    lateinit var binding: Activity2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_2)

        when(intent.getStringExtra("Teste")) {
            "1"->{
                binding.imageView.setImageResource(R.drawable.visao2)
            }
            "2"->{
                binding.imageView.setImageResource(R.drawable.visao29)
            }
            "3"->{
                binding.imageView.setImageResource(R.drawable.visao74)
            }
        }

        binding.botaoCancelar.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        binding.botaoOk.setOnClickListener {
            val confirmresult = binding.NumView.text.toString();
            if (confirmresult != "") {
                val i = Intent()
                i.putExtra("Resposta", binding.NumView.text.toString())
                setResult(Activity.RESULT_OK, i)
                finish()
            } else {
                Toast.makeText(this, "Insira", Toast.LENGTH_SHORT).show()
            }

        }

    }
}