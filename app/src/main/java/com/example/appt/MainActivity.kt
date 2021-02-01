package com.example.appt

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.appt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var exame = Testes()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.exame = exame

        binding.buttonToTest1.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("Teste","1")
            startActivityForResult(intent,1)
        }

        binding.buttonToTest2.setOnClickListener {
            val intent = Intent(this,Activity2::class.java)
            intent.putExtra("Teste", " 2")
            startActivityForResult(intent,2)
        }

        binding.buttonToTest3.setOnClickListener {
            val intent = Intent(this,Activity2::class.java)
            intent.putExtra("Teste", "3")
            startActivityForResult(intent,3)
        }

        binding.buttonResult.setOnClickListener {
            if (binding.exame!!.resp1 == "Resposta1" ||
                binding.exame!!.resp2 == "Resposta2" ||
                binding.exame!!.resp3 == "Resposta3"){
                Toast.makeText(this, "Realize o teste", Toast.LENGTH_SHORT).show()
            }
            else {
                if (binding.exame!!.resp1 == "2" &&
                    binding.exame!!.resp2 == "29" &&
                    binding.exame!!.resp3 == "74"){
                    binding.exame!!.resultado = "Sua visão está normal"
                    binding.invalidateAll()
                }
                else {
                    binding.exame!!.resultado = "Você é daltônico"
                    binding.invalidateAll()
                }
            }
        }

        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
                if(requestCode == 1) {
                    if (resultCode == Activity.RESULT_OK) {
                        binding.exame!!.resp1 = data?.getStringExtra("Resposta").toString()
                        binding.invalidateAll()
                }
                } else if(requestCode == 2) {
                    if (resultCode == Activity.RESULT_OK) {
                        binding.exame!!.resp2 = data?.getStringExtra("Resposta").toString()
                        binding.invalidateAll()
                }
                } else if(requestCode == 3) {
                    if (resultCode == Activity.RESULT_OK) {
                        binding.exame!!.resp3 = data?.getStringExtra("Resposta").toString()
                        binding.invalidateAll()
                    }
        }
    }

    }




