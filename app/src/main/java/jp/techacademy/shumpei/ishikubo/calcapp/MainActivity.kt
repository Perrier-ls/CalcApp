package jp.techacademy.shumpei.ishikubo.calcapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        additionBtn.setOnClickListener(this)
        subtractionBtn.setOnClickListener(this)
        multiplicationBtn.setOnClickListener(this)
        divisionBtn.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.additionBtn -> calc(v, additionBtn.text.toString())
            R.id.subtractionBtn -> calc(v, subtractionBtn.text.toString())
            R.id.multiplicationBtn -> calc(v, multiplicationBtn.text.toString())
            R.id.divisionBtn -> calc(v, divisionBtn.text.toString())
        }
    }

    fun calc(view: View, operator: String){
        var firstValue = inputFirstValue.text.toString()
        var secondValue = inputSecondValue.text.toString()
        var fVDouble:Double
        var sVDouble:Double
        var result:Double

        if(valueInputValidation(view, firstValue, secondValue, operator)) {
            fVDouble = firstValue.toDouble()
            sVDouble = secondValue.toDouble()

            when (operator) {
                "+" -> { result = fVDouble + sVDouble }
                "-" -> { result = fVDouble - sVDouble }
                "÷" -> { result = fVDouble / sVDouble }
                "×" -> { result = fVDouble * sVDouble }
                else -> result = 0.0
            }

            val intent = Intent(this, calcResult::class.java)

            intent.putExtra("result", result)
            startActivity(intent)

        }
    }

    fun valueInputValidation(view: View, firstValue:String, secondValue:String, operator: String):Boolean {
        var validationStatus:Boolean = true

        if ((TextUtils.isEmpty(firstValue))||(TextUtils.isEmpty(secondValue))){
            Snackbar.make(view, "数値を入力してください", Snackbar.LENGTH_SHORT).show()
            validationStatus = false
        }
        try {
            if (((firstValue.toDouble()==0.0)||(secondValue.toDouble()==0.0))&&(operator.equals("÷"))){
                Snackbar.make(view, "0除算が発生しています。再度数値を入力してください", Snackbar.LENGTH_SHORT).show()
                validationStatus = false
            }

        }catch (e: NumberFormatException){
            Snackbar.make(view, "文字列ではなく数値を入力してください", Snackbar.LENGTH_SHORT).show()
            validationStatus = false
        }

        return validationStatus
    }
}