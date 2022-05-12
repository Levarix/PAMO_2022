package com.example.zdrowie_kotlin.ui.bmi

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.zdrowie_kotlin.databinding.FragmentBmiBinding
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.utils.ColorTemplate
import java.text.DecimalFormat
import java.util.*

class BmiFragment : Fragment() {
    var bmiValues: ArrayList<BarEntry> = ArrayList<BarEntry>()
    private var height = 0.0
    private var weight = 0.0f
    private var bmi = 0.0f
    private var binding: FragmentBmiBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBmiBinding.inflate(inflater, container, false)
        val root: View = binding!!.getRoot()
        val heightEditText = binding!!.heightEditNumber as EditText
        heightEditText.addTextChangedListener(heightEditTextWatcher)
        val weightEditText = binding!!.weightEditNumber as EditText
        weightEditText.addTextChangedListener(weightEditTextWatcher)
        val chart: BarChart = binding!!.barchart as BarChart
        val saveButton = binding!!.saveButton as Button


        //bmiValues.add(new BarEntry(TimeUnit.MILLISECONDS.toDays(133), 4200));
        val dataset = BarDataSet(bmiValues, "BMI")
        dataset.setColors(ColorTemplate.MATERIAL_COLORS)
        dataset.setValueTextColor(Color.BLACK)
        dataset.setValueTextSize(16f)
        val data = BarData(dataset)
        chart.setFitBars(true)
        chart.setData(data)
        chart.getDescription().setText("Bar Chart")
        chart.animateY(2000)
        setOnClick(saveButton, chart, dataset)
        return root
    }

    private fun calculate() {
        bmi = if (weight > 0.0f && height > 0) {
            (weight / (height / 100 * (height / 100))).toFloat()
        } else {
            0.0f
        }
        setText(decimalFormat.format(bmi.toDouble()))
    }

    fun setText(text: String?) {
        val view = binding?.bmiTextView as TextView
        view.text = text
    }

    private val heightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            height = try {
                s.toString().toInt().toDouble()
            } catch (e: NumberFormatException) {
                0.0
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }
    private val weightEditTextWatcher: TextWatcher = object : TextWatcher {
        override fun onTextChanged(
            s: CharSequence, start: Int,
            before: Int, count: Int
        ) {
            weight = try {
                s.toString().toFloat()
            } catch (e: NumberFormatException) {
                0.0f
            }
            calculate()
        }

        override fun afterTextChanged(s: Editable) {}
        override fun beforeTextChanged(
            s: CharSequence, start: Int, count: Int, after: Int
        ) {
        }
    }

    private fun setOnClick(btn: Button, chart: BarChart, dataset: BarDataSet) {
        btn.setOnClickListener {
            val rand = Random()
            dataset.addEntry(BarEntry(dataset.getEntryCount().toFloat(), bmi) as BarEntry?)
            chart.getData().notifyDataChanged()
            chart.notifyDataSetChanged()
            chart.invalidate()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        private val decimalFormat = DecimalFormat("0.0")
    }
}

private fun BarDataSet.setColors(materialColors: IntArray?) {

}
