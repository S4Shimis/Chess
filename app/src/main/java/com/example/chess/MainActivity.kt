package com.example.chess

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pvP_Button = findViewById<Button>(R.id.button4)
        val player_names = findViewById<Button>(R.id.button5)

        var white = "White"
        var black = "Black"
        /*val bot_Button = findViewById<Button>(R.id.button5);
        bot_Button.setBackgroundColor(Color.WHITE)
        bot_Button.isClickable = false*/
        val exit_Button = findViewById<Button>(R.id.button6);

        pvP_Button.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java);
            intent.putExtra("White_Player_Name", white)
            intent.putExtra("Black_Player_Name", black)
            startActivity(intent);
        }

        player_names.setOnClickListener {


            val alert = AlertDialog.Builder(this)
            val context: Context = alert.getContext()
            val layout = LinearLayout(context)
            layout.orientation = LinearLayout.VERTICAL

            val whiteBox = EditText(context)
            whiteBox.hint = "White"
            layout.addView(whiteBox)

            val blackBox = EditText(context)
            blackBox.hint = "Black"
            layout.addView(blackBox)
            alert.setPositiveButton(android.R.string.yes) {
                dialog, whichButton ->
                white = whiteBox.text.toString()
                black = blackBox.text.toString()
                if (white == "") white = "White"
                if (black == "") black = "Black"
                Toast.makeText(applicationContext, white + " is playing as White\n" + black + " is playing as Black", Toast.LENGTH_SHORT).show()
            }
            alert.setView(layout)
            alert.show()
        }

        /*bot_Button.setOnClickListener {
            //startActivity(Intent(MainActivity.this, GameActivity.class));
            val intent = Intent(this, GameActivity::class.java);
            startActivity(intent);
        }*/

        exit_Button.setOnClickListener {
            finish();
            exitProcess(0);
        }

    }
}