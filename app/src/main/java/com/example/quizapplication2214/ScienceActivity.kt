package com.example.quizapplication2214

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapplication2214.databinding.ActivityScienceBinding

class ScienceActivity : AppCompatActivity() {
    val science = listOf(
        ScienceModel(
            "Matematika", listOf(
                QuizModel(
                    "2 ning kvadrati nechi",
                    R.drawable.dfjbdifb,
                    "32",
                    "43",
                    "546",
                    "345",
                    "C"
                ),
                QuizModel("172367hdhv dz hzdsg hasd", null, "453", "869", "84576", "895469", "A"),
                QuizModel(
                    "10 * 10 nechchi",
                    R.drawable.car,
                    "845768",
                    "867",
                    "949",
                    "8549",
                    "D"
                ),
                QuizModel(
                    "84898yu45u4ugouuh ",
                    R.drawable.bmw,
                    "8o3489",
                    "34875",
                    "348758",
                    "8475",
                    "C"
                ),
                QuizModel(
                    "4809590yu590euyh09  g",
                    R.drawable.dfsjvbh,
                    "7854",
                    "e98",
                    "45y98",
                    "54y8",
                    "A"
                )
            )
        ),
        ScienceModel(
            "Ona tili", listOf(
                QuizModel(
                    "2 ning kvadrati nechi",
                    null,
                    "32",
                    "43",
                    "546",
                    "345",
                    "C"
                ),
                QuizModel("172367hdhv dz hzdsg hasd", null, "453", "869", "84576", "895469", "A"),
                QuizModel(
                    "389475 3r97gyw47ygudff",
                    null,
                    "845768",
                    "867",
                    "949",
                    "8549",
                    "D"
                ),
                QuizModel(
                    "84898yu45u4ugouuh ",
                    null,
                    "8o3489",
                    "34875",
                    "348758",
                    "8475",
                    "C"
                ),
                QuizModel(
                    "asjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjdcsdgveh rt th rth ",
                    null,
                    "7854",
                    "e98",
                    "45y98",
                    "54y8",
                    "A"
                )
            )
        ),
        ScienceModel(
            "Fizika", listOf(
                QuizModel(
                    "2 ning kvadrati nechi",
                    R.drawable.stasdfv,
                    "32",
                    "43",
                    "546",
                    "345",
                    "C"
                ),
                QuizModel("172367hdhv dz hzdsg hasd", null, "453", "869", "84576", "895469", "A"),
                QuizModel(
                    "389475 3r97gyw47ygudff",
                    R.drawable.tele,
                    "845768",
                    "867",
                    "949",
                    "8549",
                    "D"
                ),
                QuizModel(
                    "84898yu45u4ugouuh ",
                    R.drawable.xacker,
                    "8o3489",
                    "34875",
                    "348758",
                    "8475",
                    "C"
                ),
                QuizModel(
                    "4809590yu590euyh09  g",
                    R.drawable.img3,
                    "7854",
                    "e98",
                    "45y98",
                    "54y8",
                    "A"
                )
            )
        )
    )
    lateinit var binding: ActivityScienceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScienceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scienceRec.layoutManager = LinearLayoutManager(this)
        binding.scienceRec.adapter = ScienceAdapter(science, object:ScienceAdapterCAllback{
            override fun onClick(item: ScienceModel) {
                val intent = Intent(this@ScienceActivity, QuestionActivity::class.java)
                intent.putExtra("extra", item)
                startActivity(intent)
            }
        })
    }
}