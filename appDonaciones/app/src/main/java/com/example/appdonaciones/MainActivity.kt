package com.example.appdonaciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addCountry()
        butCalcular.setOnClickListener(this)
    }


    private fun addCountry() {
        val lstMeses: MutableList<String> = ArrayList()
        lstMeses.add("Peru")
        lstMeses.add("Chile")
        lstMeses.add("Ecuador")
        val dataAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, lstMeses)
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spiPais.adapter = dataAdapter
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.butCalcular->{
                calcular()

            }
        }
    }

    private fun calcular(){
        var number1=""
        val result:Double
        var monto =eteMonto.text

        if(!monto.isEmpty()){
            number1= monto.toString()
            val int1: Double = number1.toDouble()

            if (rbuVisa.isChecked){
                result=int1*0.1
                tviResult.text="El monto donado Visa: ${result}"
            }else if(rbuMasterCard.isChecked){
                result=int1*0.4
                tviResult.text="El monto donado MasterCard: ${result}"
            }else{
                Toast.makeText(this,"seleccione tipo de tarjeta", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Ingrese monto", Toast.LENGTH_LONG).show()
        }
    }
}
