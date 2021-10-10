package choney.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import choney.myapplication.databinding.ActivityMainBinding
import java.lang.Exception
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn0.setOnClickListener { setTF("0") }
        binding.btn1.setOnClickListener { setTF("1") }
        binding.btn2.setOnClickListener { setTF("2") }
        binding.btn3.setOnClickListener { setTF("3") }
        binding.btn4.setOnClickListener { setTF("4") }
        binding.btn5.setOnClickListener { setTF("5") }
        binding.btn6.setOnClickListener { setTF("6") }
        binding.btn7.setOnClickListener { setTF("7") }
        binding.btn8.setOnClickListener { setTF("8") }
        binding.btn9.setOnClickListener { setTF("9") }
        binding.btnMinus.setOnClickListener { setTF("-") }
        binding.btnPluss.setOnClickListener { setTF("+") }
        binding.btnDivide.setOnClickListener { setTF("/") }
        binding.btnMulti.setOnClickListener { setTF("*") }
        binding.btnLBracket.setOnClickListener { setTF("(") }
        binding.btnRBracket.setOnClickListener { setTF(")") }
        binding.btnDot.setOnClickListener { setTF(".") }

        binding.btnAc.setOnClickListener {
            binding.mathOperation.text = ""
            binding.resultText.text = ""
        }

       binding.btnBack.setOnClickListener {
            val str = binding.mathOperation.text.toString()

            if (str.isNotEmpty())
                binding.mathOperation.text = str.substring(0, str.length - 1)
           binding.resultText.text = ""
        }

        binding.btnEq.setOnClickListener {
            try {
                val ex = ExpressionBuilder(binding.mathOperation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()

                if (result == longRes.toDouble())
                    binding.resultText.text = longRes.toString()
                else
                    binding.resultText.text = result.toString()
            } catch (e:Exception) {
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }
    }

    fun setTF(str: String) {
        if (binding.resultText.text != "") {
            binding.mathOperation.text = binding.resultText.text
            binding.resultText.text = ""
        }
        binding.mathOperation.append(str)
    }
}