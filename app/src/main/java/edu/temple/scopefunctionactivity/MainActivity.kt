package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listTest = listOf(1.0,3.0,4.0,5.0,6.5)

        Log.d("function output", getTestDataArray().toString())
        Log.d("function output", averageLessThanMedian(listTest).toString())

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        // eg. Log.d("function output", getTestDataArray().toString())

    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    // Return a list of random, sorted integers
    private fun getTestDataArray() : List<Int> {
        return MutableList(10){ Random.nextInt()}.apply {
            sort()
        }
    }

    // Return true if average value in list is greater than median value, false otherwise
    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean {
        return listOfNumbers.sorted().run {
            val avg = listOfNumbers.average()
            val median = if (size % 2 == 0)
                (get(size / 2) + get((size - 1) / 2)) / 2
            else
                get(size / 2)
            //For some reason without get the median return incorrectly and I am unsure why
            //However the average returns fine
            Log.d("Average", avg.toString())
            Log.d("Median", median.toString())
            avg < median
        }
    }

    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View {
        if (recycledView != null) {
            return (recycledView as TextView).apply{text = collection[position].toString()}
        } else return TextView(context).apply{
            setPadding(5, 10, 10, 0)
            textSize = 22f
            text = collection[position].toString()
        }
    }

}