package jp.techacademy.shumpei.ishikubo.calcapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calc_result.*

class calcResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_result)

        var result = intent.getDoubleExtra("result", 0.0)

        calcResultView.text = result.toString()
    }
}
