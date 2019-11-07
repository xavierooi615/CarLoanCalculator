package com.example.carloancalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btnCal).setOnClickListener {
            //
            updateResult(it)
        }
    }

    public fun calculation(){
        val carPrice = car_price.text.toString()
        val downPayment = down_payment.text.toString()
        val rates = rate.text.toString()
        val period = load_period.text.toString()

        val carLoan = carPrice.toDouble()-downPayment.toDouble()
        val interest:Double = carLoan.toDouble()*rates.toDouble()*period.toDouble()
        val monthlyRepay = (carLoan.toDouble()+interest)/period.toDouble()/12

        result1.text="RM %.2f".format(carLoan)
        result2.text="%.2f".format(interest)
        result3.text="%.2f".format(monthlyRepay)
    }

    public fun updateResult(view: View){
        val r1 = findViewById<TextView>(R.id.result1)
        val r2 = findViewById<TextView>(R.id.result2)
        val r3 = findViewById<TextView>(R.id.result3)
        val tv7 = findViewById<TextView>(R.id.textView7)
        val tv8 = findViewById<TextView>(R.id.textView8)
        val tv9 = findViewById<TextView>(R.id.textView9)
        r1.visibility = View.VISIBLE
        r2.visibility = View.VISIBLE
        r3.visibility = View.VISIBLE
        tv7.visibility = View.VISIBLE
        tv8.visibility = View.VISIBLE
        tv9.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        calculation()
    }
}
