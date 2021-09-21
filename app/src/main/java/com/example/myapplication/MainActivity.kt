package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double=0.0
    var operador: String=""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.buttondelete.setOnClickListener {
        binding.vistacal.setText(binding.vistacal.text.dropLast(1))

        }

        binding.buttonigual.setOnClickListener{
            when(operador) {
                "multiplicaciom" -> {
                    binding.vistacal.setText("${firstValue*binding.vistacal.text.toString().toDouble()}")
                }
                "division" -> {
                    binding.vistacal.setText("${firstValue/binding.vistacal.text.toString().toDouble()}")
                }

                    "sunar"-> {
                        binding.vistacal.setText("${firstValue+binding.vistacal.text.toString().toDouble()}")
                    }
                    "menos"-> {
                        binding.vistacal.setText("${firstValue-binding.vistacal.text.toString().toDouble()}")
                    }

            }
        }

        binding.buttonporcent.setOnClickListener {
            binding.vistacal.setText("${binding.vistacal.text.toString().toDouble()/100}")

        }

        binding.buttonclear.setOnClickListener {
            binding.vistacal.text.clear()
            //binding.vistacal.setText(binding.vistacal.text.dropLast(1))

        }
        //setContentView(R.layout.activity_main)
    }


    fun ButtonClicked(view: View){
        val botones = view as Button

            when (botones.id){
                binding.buttonpoint.id-> {
                    if (!binding.vistacal.text.contains('.')) {
                        binding.vistacal.text.append(".")
                    }
                }
                binding.buttocero.id -> {binding.vistacal.text.append("0")}
                binding.buttonone.id -> {binding.vistacal.text.append("1")}
                binding.buttontwo.id -> {binding.vistacal.text.append("2")}
                binding.buttontr.id -> {binding.vistacal.text.append(("3"))}
                binding.buttonfour.id -> {binding.vistacal.text.append(("4"))}
                binding.buttonfive.id -> {binding.vistacal.text.append(("5"))}
                binding.buttonsix.id -> {binding.vistacal.text.append(("6"))}
                binding.buttonseven.id -> {binding.vistacal.text.append(("7"))}
                binding.buttoneight.id -> {binding.vistacal.text.append(("8"))}
                binding.buttonnine.id -> {binding.vistacal.text.append(("9"))}
                else -> {Toast.makeText(this, "else", Toast.LENGTH_SHORT).show()}
            }



    }

    fun simbolosPresionados(view: View){
        val button = view as Button

        operador=when(button.id){
            binding.buttonmult.id->{"multiplicaciom"}
            binding.buttondivi.id-> {"division"}
            binding.buttonmas.id->{"sunar"}
            binding.buttonmenos.id->{"menos"}
            else -> {""}
        }

        firstValue=binding.vistacal.text.toString().toDouble()
        binding.vistacal.text.clear()
    }



}