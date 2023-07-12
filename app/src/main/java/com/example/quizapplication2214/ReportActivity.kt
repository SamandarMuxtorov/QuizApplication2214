package com.example.quizapplication2214

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapplication2214.databinding.ActivityReportBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class ReportActivity : AppCompatActivity() {
    lateinit var binding: ActivityReportBinding
    lateinit var items: ScienceModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }
        items = intent.getSerializableExtra("extra_data") as ScienceModel
        binding.tvTitle.text = items.title
        var reportText = ""
        var correctCount = 0
        items.quizList.forEachIndexed { index, it ->
            if (it.answer != it.correctAnswer) {
                reportText += "${index + 1}.Sizning javobinggiz: ${it.answer}\n To'g'ri javob: ${it.correctAnswer}\n"
            } else {
                correctCount++
                reportText += "${index + 1}, To'g'ri javob ${it.correctAnswer}\n"
            }
        }
        binding.tvReport.text = reportText
        setupPieChart(correctCount, items.quizList.count())
    }

    fun setupPieChart(correctCount: Int, count: Int) {

        
        val pieEnteries = arrayListOf<PieEntry>()
        pieEnteries.add(PieEntry((count - correctCount).toFloat()))
        pieEnteries.add(PieEntry(correctCount.toFloat()))

        binding.pieChart.animateXY(3000, 3000)

        val pieDataSet = PieDataSet(pieEnteries, "NATIJA")

        pieDataSet.setColors(
            ContextCompat.getColor(this, R.color.red),
            ContextCompat.getColor(this, R.color.green)
        )
        pieDataSet.sliceSpace = 3f
        val pieData = PieData(pieDataSet)
        pieData.setDrawValues(true)
        binding.pieChart.data = pieData

        binding.pieChart.holeRadius = 5f
        binding.pieChart.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
    }
}