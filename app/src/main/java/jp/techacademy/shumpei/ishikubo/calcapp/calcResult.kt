package jp.techacademy.shumpei.ishikubo.calcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calc_result.*

class calcResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)

        val firstValue = intent.getDoubleExtra("firstValue", 0.0)
        val secondValue = intent.getDoubleExtra("secondValue", 0.0)
        val operator = intent.extras.getString("operator", "none")
        var result:Double

        when (operator) {
            "+" -> { result = firstValue + secondValue }
            "-" -> { result = firstValue - secondValue }
            "÷" -> { result = firstValue / secondValue }
            "×" -> { result = firstValue * secondValue }
            else -> result = 0.0
        }

        calcResultView.text = result.toString()
    }
}
