package jp.techacademy.shumpei.ishikubo.calcapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
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
            R.id.additionBtn -> valueInputValidation(v, additionBtn.text.toString())
            R.id.subtractionBtn -> valueInputValidation(v, subtractionBtn.text.toString())
            R.id.multiplicationBtn -> valueInputValidation(v, multiplicationBtn.text.toString())
            R.id.divisionBtn -> valueInputValidation(v, divisionBtn.text.toString())
        }
    }

    fun valueInputValidation(view: View, operator: String){
        var firstValue = inputFirstValue.text.toString()
        var secondValue = inputSecondValue.text.toString()
        if((firstValue.isEmpty())&&(secondValue.isEmpty())) {
            Snackbar.make(view, "何か数値を入力してください", Snackbar.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, calcResult::class.java)
            intent.putExtra("firstValue", firstValue.toDouble())
            intent.putExtra("secondValue", secondValue.toDouble())
            intent.putExtra("operator", operator)
            startActivity(intent)
        }
    }
}