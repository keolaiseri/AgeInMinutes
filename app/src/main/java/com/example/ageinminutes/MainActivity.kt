package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
    val tvSelectedDate = findViewById<TextView>(R.id.tvSelectedDate)
    val tvSelectedDateInMinutes = findViewById<TextView>(R.id.tvSelectedDateInMinutes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener {view ->
            clickDatePicker(view)
             }

    }

    fun clickDatePicker(view : View){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

       val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this,
                    "The chosen is year $selectedYear, the chosen month is $selectedMonth, the chosen day is $selectedDayOfMonth"
                    , Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                tvSelectedDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate!!.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate!!.time/ 60000

                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                tvSelectedDateInMinutes.setText(differenceInMinutes.toString())

            }
            ,year
            ,month
            ,day)


            dpd.datePicker.setMaxDate(Date().time - 86400000)
            dpd.show()




    }



}


