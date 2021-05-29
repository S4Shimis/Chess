package com.example.chess

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val intent = intent

        val white_name = intent.getStringExtra("White_Player_Name")
        val black_name = intent.getStringExtra("Black_Player_Name")

        val player_turn = findViewById<Button>(R.id.button3)
        player_turn.isClickable = false
        //♔ ♕ ♖ ♗ ♘ ♙   White
        //♚ ♛ ♜ ♝ ♞ ♟︎Black︎

        val white_disposal = findViewById<TextView>(R.id.White_disposal)
        val black_disposal = findViewById<TextView>(R.id.Black_disposal)

        val win = findViewById<TextView>(R.id.textView66)

        val start_new_game = findViewById<Button>(R.id.button)
        val go_back_to_menu = findViewById<Button>(R.id.button2)

        var iRow = 0
        var jColoumn = 0
        var info = ""
        var move_piece = true
        var white_to_move = true
        var white_king_moved = false
        var black_king_moved = false

        val A8 = findViewById<TextView>(R.id.textView)
        val B8 = findViewById<TextView>(R.id.textView2)
        val C8 = findViewById<TextView>(R.id.textView4)
        val D8 = findViewById<TextView>(R.id.textView5)
        val E8 = findViewById<TextView>(R.id.textView6)
        val F8 = findViewById<TextView>(R.id.textView7)
        val G8 = findViewById<TextView>(R.id.textView8)
        val H8 = findViewById<TextView>(R.id.textView9)

        val A7 = findViewById<TextView>(R.id.textView10)
        val B7 = findViewById<TextView>(R.id.textView11)
        val C7 = findViewById<TextView>(R.id.textView12)
        val D7 = findViewById<TextView>(R.id.textView13)
        val E7 = findViewById<TextView>(R.id.textView14)
        val F7 = findViewById<TextView>(R.id.textView15)
        val G7 = findViewById<TextView>(R.id.textView16)
        val H7 = findViewById<TextView>(R.id.textView17)

        val A6 = findViewById<TextView>(R.id.textView18)
        val B6 = findViewById<TextView>(R.id.textView19)
        val C6 = findViewById<TextView>(R.id.textView20)
        val D6 = findViewById<TextView>(R.id.textView21)
        val E6 = findViewById<TextView>(R.id.textView22)
        val F6 = findViewById<TextView>(R.id.textView23)
        val G6 = findViewById<TextView>(R.id.textView24)
        val H6 = findViewById<TextView>(R.id.textView25)

        val A5 = findViewById<TextView>(R.id.textView26)
        val B5 = findViewById<TextView>(R.id.textView27)
        val C5 = findViewById<TextView>(R.id.textView28)
        val D5 = findViewById<TextView>(R.id.textView29)
        val E5 = findViewById<TextView>(R.id.textView30)
        val F5 = findViewById<TextView>(R.id.textView31)
        val G5 = findViewById<TextView>(R.id.textView32)
        val H5 = findViewById<TextView>(R.id.textView33)

        val A4 = findViewById<TextView>(R.id.textView34)
        val B4 = findViewById<TextView>(R.id.textView35)
        val C4 = findViewById<TextView>(R.id.textView36)
        val D4 = findViewById<TextView>(R.id.textView37)
        val E4 = findViewById<TextView>(R.id.textView38)
        val F4 = findViewById<TextView>(R.id.textView39)
        val G4 = findViewById<TextView>(R.id.textView40)
        val H4 = findViewById<TextView>(R.id.textView41)

        val A3 = findViewById<TextView>(R.id.textView42)
        val B3 = findViewById<TextView>(R.id.textView43)
        val C3 = findViewById<TextView>(R.id.textView44)
        val D3 = findViewById<TextView>(R.id.textView45)
        val E3 = findViewById<TextView>(R.id.textView46)
        val F3 = findViewById<TextView>(R.id.textView47)
        val G3 = findViewById<TextView>(R.id.textView48)
        val H3 = findViewById<TextView>(R.id.textView49)

        val A2 = findViewById<TextView>(R.id.textView50)
        val B2 = findViewById<TextView>(R.id.textView51)
        val C2 = findViewById<TextView>(R.id.textView52)
        val D2 = findViewById<TextView>(R.id.textView53)
        val E2 = findViewById<TextView>(R.id.textView54)
        val F2 = findViewById<TextView>(R.id.textView55)
        val G2 = findViewById<TextView>(R.id.textView56)
        val H2 = findViewById<TextView>(R.id.textView57)

        val A1 = findViewById<TextView>(R.id.textView58)
        val B1 = findViewById<TextView>(R.id.textView59)
        val C1 = findViewById<TextView>(R.id.textView60)
        val D1 = findViewById<TextView>(R.id.textView61)
        val E1 = findViewById<TextView>(R.id.textView62)
        val F1 = findViewById<TextView>(R.id.textView63)
        val G1 = findViewById<TextView>(R.id.textView64)
        val H1 = findViewById<TextView>(R.id.textView65)

        val board_array = arrayOf (
                arrayOf(A8, B8, C8, D8, E8, F8, G8, H8),
                arrayOf(A7, B7, C7, D7, E7, F7, G7, H7),
                arrayOf(A6, B6, C6, D6, E6, F6, G6, H6),
                arrayOf(A5, B5, C5, D5, E5, F5, G5, H5),
                arrayOf(A4, B4, C4, D4, E4, F4, G4, H4),
                arrayOf(A3, B3, C3, D3, E3, F3, G3, H3),
                arrayOf(A2, B2, C2, D2, E2, F2, G2, H2),
                arrayOf(A1, B1, C1, D1, E1, F1, G1, H1)
        )

        fun start_position() {

            iRow = 0
            jColoumn = 0
            info = ""
            move_piece = true
            white_to_move = true
            white_king_moved = false
            black_king_moved = false
            player_turn.setBackgroundColor(Color.WHITE)

            white_disposal.text = ""
            black_disposal.text = ""
            win.text = ""

            //♔ ♕ ♖ ♗ ♘ ♙   White
            //♚ ♛ ♜ ♝ ♞ ♟︎Black

            for (i in 0..7) {
                for (j in 0..7) {
                    board_array[i][j].isClickable = true
                    //Black
                    if ((i == 0) && ((j == 0) || (j == 7))) board_array[i][j].text = "♜"
                    else if ((i == 0) && ((j == 1) || (j == 6))) board_array[i][j].text = "♞"
                    else if ((i == 0) && ((j == 2) || (j == 5))) board_array[i][j].text = "♝"
                    else if ((i == 0) && (j == 3)) board_array[i][j].text = "♛"
                    else if ((i == 0) && (j == 4)) board_array[i][j].text = "♚"
                    else if (i == 1) board_array[i][j].text = "♟"

                    //White
                    else if (i == 6) board_array[i][j].text = "♙"
                    else if ((i == 7) && ((j == 0) || (j == 7))) board_array[i][j].text = "♖"
                    else if ((i == 7) && ((j == 1) || (j == 6))) board_array[i][j].text = "♘"
                    else if ((i == 7) && ((j == 2) || (j == 5))) board_array[i][j].text = "♗"
                    else if ((i == 7) && (j == 3)) board_array[i][j].text = "♕"
                    else if ((i == 7) && (j == 4)) board_array[i][j].text = "♔"

                    //Empty space
                    else board_array[i][j].text=""

                }
            }
        }

        fun piece_detection(cTV: TextView):Boolean {
            //♔ ♕ ♖ ♗ ♘ ♙   White
            //♚ ♛ ♜ ♝ ♞ ♟︎Black
            //cTV.text = "1"
            if (((cTV.text == "♙") || (cTV.text == "♘") ||(cTV.text == "♗") ||(cTV.text == "♖") ||(cTV.text == "♕") ||(cTV.text == "♔")) && white_to_move) {
                return true
            }
            else if (((cTV.text == "♟") ||(cTV.text == "♞") ||(cTV.text == "♝") ||(cTV.text == "♜") ||(cTV.text == "♛") ||(cTV.text == "♚")) && !white_to_move) {
                return true
            }
            else return false
        }

        fun pawn_move(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
            if (board_array[i1][j1].text == "♙") {
                if (j1 - j2 > 1 || j2 - j1 > 1) return false
                if (i2 == 4 && i1 == 6 && board_array[i2][j2].text=="" && board_array[i2+1][j2].text=="") return true
                if (i1 - i2 == 1 && board_array[i2][j2].text=="") return true
                if (i1 - i2 == 1 && j1 - j2 == 1 && (board_array[i2][j2].text== "♟" || board_array[i2][j2].text== "♞" || board_array[i2][j2].text== "♝" || board_array[i2][j2].text== "♜" || board_array[i2][j2].text== "♛" || board_array[i2][j2].text== "♚")) return true
                return (i1 - i2 == 1 && j2 - j1 == 1 && (board_array[i2][j2].text== "♟" || board_array[i2][j2].text== "♞" || board_array[i2][j2].text== "♝" || board_array[i2][j2].text== "♜" || board_array[i2][j2].text== "♛" || board_array[i2][j2].text== "♚"))
            }
            else if (board_array[i1][j1].text == "♟") {
                if (j1 - j2 > 1 || j2 - j1 > 1) return false
                if (i2 == 3 && i1 == 1 && board_array[i2][j2].text=="" && board_array[i2-1][j2].text=="") return true
                if (i2 - i1 == 1 && board_array[i2][j2].text=="") return true
                if (i2 - i1 == 1 && j1 - j2 == 1 && (board_array[i2][j2].text== "♙" || board_array[i2][j2].text== "♘" || board_array[i2][j2].text== "♗" || board_array[i2][j2].text== "♖" || board_array[i2][j2].text== "♕" || board_array[i2][j2].text== "♔")) return true
                return i2 - i1 == 1 && j2 - j1 == 1 && (board_array[i2][j2].text== "♙" || board_array[i2][j2].text== "♘" || board_array[i2][j2].text== "♗" || board_array[i2][j2].text== "♖" || board_array[i2][j2].text== "♕" || board_array[i2][j2].text== "♔")
            }
            else return false
        }

        fun horse_move(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
            if (board_array[i1][j1].text == "♘") {
                if ((((i2 == i1 + 2 || i2 == i1 - 2) && (j2 == j1 + 1 || j2 == j1 - 1)) || ((i2 == i1 + 1 || i2 == i1 - 1) && (j2 == j1 + 2 || j2 == j1 - 2))) && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                else return false
            }
            else if (board_array[i1][j1].text == "♞") {
                if ((((i2 == i1 + 2 || i2 == i1 - 2) && (j2 == j1 + 1 || j2 == j1 - 1)) || ((i2 == i1 + 1 || i2 == i1 - 1) && (j2 == j1 + 2 || j2 == j1 - 2))) && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                else return false
            }
            else return false
        }

        fun bishop_move(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
            val iTMP = i2 - i1
            val jTMP = j2 - j1
            if ((i2 - i1 != j2 - j1) && (-(i2 - i1) != j2 - j1)) return false
            if (board_array[i1][j1].text == "♗" || board_array[i1][j1].text == "♕") {
                if (iTMP < 0 && jTMP < 0) {
                    for (i in 1..7) {
                        if (i1-i == i2 && j1-i == j2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i1-i][j1-i].text != "") return false
                    }
                }
                else if (iTMP < 0 && jTMP > 0) {
                    for (i in 1..7) {
                        if (i1-i == i2 && j1+i == j2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i1-i][j1+i].text != "") return false
                    }
                }
                else if (iTMP > 0 && jTMP < 0) {
                    for (i in 1..7) {
                        if (i1+i == i2 && j1-i == j2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i1+i][j1-i].text != "") return false
                    }
                }
                else if (iTMP > 0 && jTMP > 0) {
                    for (i in 1..7) {
                        if (i1+i == i2 && j1+i == j2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i1+i][j1+i].text != "") return false
                    }
                }
            }
            else if (board_array[i1][j1].text == "♝" || board_array[i1][j1].text == "♛") {
                if (iTMP < 0 && jTMP < 0) {
                    for (i in 1..7) {
                        if (i1-i == i2 && j1-i == j2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i1-i][j1-i].text != "") return false
                    }
                }
                else if (iTMP < 0 && jTMP > 0) {
                    for (i in 1..7) {
                        if (i1-i == i2 && j1+i == j2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i1-i][j1+i].text != "") return false
                    }
                }
                else if (iTMP > 0 && jTMP < 0) {
                    for (i in 1..7) {
                        if (i1+i == i2 && j1-i == j2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i1+i][j1-i].text != "") return false
                    }
                }
                else if (iTMP > 0 && jTMP > 0) {
                    for (i in 1..7) {
                        if (i1+i == i2 && j1+i == j2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i1+i][j1+i].text != "") return false
                    }
                }
            }
            else return false
            return false
        }

        fun rook_move(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
            val iTMP = i2 - i1
            val jTMP = j2 - j1
            if (i1 != i2 && j1 != j2) return false
            if (board_array[i1][j1].text == "♖" || board_array[i1][j1].text == "♕") {
                if (iTMP < 0 && jTMP == 0) {
                    for (i in 1..7) {
                        if (i1-i == i2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i1-i][j2].text != "") return false
                    }
                }
                else if (iTMP == 0 && jTMP > 0) {
                    for (j in 1..7) {
                        if (j1+j == j2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i2][j1+j].text != "") return false
                    }
                }
                else if (iTMP > 0 && jTMP == 0) {
                    for (i in 1..7) {
                        if (i1+i == i2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i1+i][j2].text != "") return false
                    }
                }
                else if (iTMP == 0 && jTMP < 0) {
                    for (j in 1..7) {
                        if (j1-j == j2 && (board_array[i2][j2].text != "♙" && board_array[i2][j2].text != "♘" && board_array[i2][j2].text != "♗" && board_array[i2][j2].text != "♖" && board_array[i2][j2].text != "♕" && board_array[i2][j2].text != "♔")) return true
                        if (board_array[i2][j1-j].text != "") return false
                    }
                }
            }
            else if (board_array[i1][j1].text == "♜" || board_array[i1][j1].text == "♛"){
                if (iTMP < 0 && jTMP == 0) {
                    for (i in 1..7) {
                        if (i1-i == i2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i1-i][j2].text != "") return false
                    }
                }
                else if (iTMP == 0 && jTMP > 0) {
                    for (j in 1..7) {
                        if (j1+j == j2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i2][j2+j].text != "") return false
                    }
                }
                else if (iTMP > 0 && jTMP == 0) {
                    for (i in 1..7) {
                        if (i1+i == i2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i1+i][j2].text != "") return false
                    }
                }
                else if (iTMP == 0 && jTMP < 0) {
                    for (j in 1..7) {
                        if (j1-j == j2 && (board_array[i2][j2].text != "♟" && board_array[i2][j2].text != "♞" && board_array[i2][j2].text != "♝" && board_array[i2][j2].text != "♜" && board_array[i2][j2].text != "♛" && board_array[i2][j2].text != "♚")) return true
                        if (board_array[i2][j2-j].text != "") return false
                    }
                }

            }
            else return false
            return false
        }

        fun queen_move(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
            if (((i2 - i1 != j2 - j1) && (-(i2 - i1) != j2 - j1)) && (i1 != i2 && j1 != j2)) return false
            if (i1 == i2 || j1 == j2) return rook_move(i1, j1, i2, j2)
            if ((i2 - i1 == j2 - j1) || (-(i2 - i1) == j2 - j1)) return bishop_move(i1, j1, i2, j2)
            else return false
        }

        fun king_move(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
            if (i2 - i1 > 1 || i2 - i1 < -1 || j2 - j1 > 1 || j2 - j1 < -1) {
                if (board_array[i1][j1].text=="♔") {
                    if (!white_king_moved && board_array[i2][j2] == G1 && F1.text=="" && G1.text=="" && H1.text=="♖") {
                        white_king_moved = true
                        H1.text = ""
                        F1.text = "♖"
                        return true
                    }
                    else if (!white_king_moved && board_array[i2][j2] == C1 && B1.text=="" && C1.text=="" && D1.text=="" && A1.text=="♖") {
                        white_king_moved = true
                        A1.text = ""
                        D1.text = "♖"
                        return true
                    }
                    else return false
                }
                else if (board_array[i1][j1].text=="♚") {
                    if (!black_king_moved && board_array[i2][j2] == G8 && F8.text=="" && G8.text=="" && H8.text=="♖") {
                        black_king_moved = true
                        H8.text = ""
                        F8.text = "♖"
                        return true
                    }
                    else if (!black_king_moved && board_array[i2][j2] == C8 && B8.text=="" && C8.text=="" && D8.text=="" && A8.text=="♖") {
                        black_king_moved = true
                        A8.text = ""
                        D8.text = "♖"
                        return true
                    }
                    else return false
                }

                else return false
            }
            if (board_array[i1][j1].text == "♔") {
                white_king_moved = true
                if (board_array[i2][j2].text== "♙" || board_array[i2][j2].text== "♘" || board_array[i2][j2].text== "♗" || board_array[i2][j2].text== "♖" || board_array[i2][j2].text== "♕" || board_array[i2][j2].text== "♔") return false
                else return true
            }
            else if (board_array[i1][j1].text == "♚") {
                black_king_moved = true
                if (board_array[i2][j2].text== "♟" || board_array[i2][j2].text== "♞" || board_array[i2][j2].text== "♝" || board_array[i2][j2].text== "♜" || board_array[i2][j2].text== "♛" || board_array[i2][j2].text== "♚") return false
                else return true
            }
            else return false
        }

        fun move_is_legal(i1: Int, j1: Int, i2: Int, j2: Int): Boolean {
            if (board_array[i1][j1].text == "♙" || board_array[i1][j1].text == "♟") {
                return pawn_move(i1, j1, i2, j2)
            }
            else if (board_array[i1][j1].text == "♘" || board_array[i1][j1].text == "♞") {
                return horse_move(i1, j1, i2, j2)
            }
            else if (board_array[i1][j1].text == "♗" || board_array[i1][j1].text == "♝") {
                return bishop_move(i1, j1, i2, j2)
            }
            else if (board_array[i1][j1].text == "♖" || board_array[i1][j1].text == "♜") {
                return rook_move(i1, j1, i2, j2)
            }
            else if (board_array[i1][j1].text == "♕" || board_array[i1][j1].text == "♛") {
                return queen_move(i1, j1, i2, j2)
            }
            else if (board_array[i1][j1].text == "♔" || board_array[i1][j1].text == "♚") {
                return king_move(i1, j1, i2, j2)
            }
            else return false
        }

        fun promote(i: Int, j: Int) {
            var promote_piece = ""
            val items = arrayOf("Queen", "Rook", "Bishop", "Knight")
            val builder = AlertDialog.Builder(this)
            with(builder)
            {
                setTitle("Pawn promotes to...")
                setItems(items) { dialog, which ->
                    Toast.makeText(applicationContext, items[which] + " promotion", Toast.LENGTH_SHORT).show()
                    promote_piece = items[which]
                    if (promote_piece == "Queen") {
                        if (board_array[i][j].text == "♙") board_array[i][j].text = "♕"
                        if (board_array[i][j].text == "♟") board_array[i][j].text = "♛"
                    }
                    if (promote_piece == "Rook") {
                        if (board_array[i][j].text == "♙") board_array[i][j].text = "♖"
                        if (board_array[i][j].text == "♟") board_array[i][j].text = "♜"
                    }
                    if (promote_piece == "Bishop") {
                        if (board_array[i][j].text == "♙") board_array[i][j].text = "♗"
                        if (board_array[i][j].text == "♟") board_array[i][j].text = "♝"
                    }
                    else {
                        if (board_array[i][j].text == "♙") board_array[i][j].text = "♘"
                        if (board_array[i][j].text == "♟") board_array[i][j].text = "♞"
                    }
                }
                show()
            }
        }

        fun white_win() {

            var b = true
            for(i in 0..7) {
                for (j in 0..7) {
                    if (board_array[i][j].text == "♚") b = false
                }
            }

            if (b) {
                win.text = "Game over. " + white_name + " is victorious!"
                for(i in 0..7) {
                    for (j in 0..7) {
                        board_array[i][j].isClickable = false
                    }
                }
            }

            if (white_to_move) player_turn.setBackgroundColor(Color.WHITE)
            else player_turn.setBackgroundColor(Color.BLACK)

        }
        fun black_win() {
            var b = true
            for(i in 0..7) {
                for (j in 0..7) {
                    if (board_array[i][j].text == "♔") b = false
                }
            }

            if (b) {
                win.text = "Game over. " + black_name + " is victorious!"
                for(i in 0..7) {
                    for (j in 0..7) {
                        board_array[i][j].isClickable = false
                    }
                }
            }

            if (white_to_move) player_turn.setBackgroundColor(Color.WHITE)
            else player_turn.setBackgroundColor(Color.BLACK)

        }
/*
        fun white_sort(s :String) :String{
            var tmp = 'a'
            val ch = s.toCharArray()
            for (i in 0..ch.size-1) {
                for (j in 0..ch.size-2) {
                    if (ch[j] == '♙' && (ch[j+1] == '♘'|| ch[j+1] == '♗'|| ch[j+1] == '♖'|| ch[j+1] == '♕'|| ch[j+1] == '♔')) {
                        //var tmp = 'a'
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♘' && (ch[j+1] == '♗'|| ch[j+1] == '♖'|| ch[j+1] == '♕'|| ch[j+1] == '♔')) {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♗'&& (ch[j+1] == '♖'|| ch[j+1] == '♕'|| ch[j+1] == '♔')) {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♖' && (ch[j+1] == '♕'|| ch[j+1] == '♔')) {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♕' && ch[j+1] == '♔') {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                }
            }
            return ch.toString()
        }

        fun black_sort(s :String) :String{
            var tmp = 'a'
            val ch = s.toCharArray()
            for (i in 0..ch.size-1) {
                for (j in 0..ch.size-2) {
                    if (ch[j] == '♟' && (ch[j+1] == '♞'|| ch[j+1] == '♝'|| ch[j+1] == '♜'|| ch[j+1] == '♛'|| ch[j+1] == '♚')) {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♞' && (ch[j+1] == '♝'|| ch[j+1] == '♜'|| ch[j+1] == '♛'|| ch[j+1] == '♚')) {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♝'&& (ch[j+1] == '♜'|| ch[j+1] == '♛'|| ch[j+1] == '♚')) {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♜' && (ch[j+1] == '♛'|| ch[j+1] == '♚')) {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                    else if (ch[j] == '♛' && ch[j+1] == '♚') {
                        tmp = ch[j]
                        ch[j] = ch[j+1]
                        ch[j+1] = tmp
                    }
                }
            }
            return ch.toString()
        }

        fun disposal_bar(s :String){

            var tmp = ""
            var ch :CharArray

            if ((s == "♙") || (s == "♘") ||(s == "♗") ||(s == "♖") ||(s == "♕") ||(s == "♔")) {
                tmp = black_disposal.text as String
                tmp += s
                ch = tmp.toCharArray()
                tmp = ch.sorted().joinToString("")
                black_disposal.text = white_sort(tmp)
            }

            if ((s == "♟") ||(s == "♞") ||(s == "♝") ||(s == "♜") ||(s == "♛") ||(s == "♚")) {
                //tmp = black_disposal.text as String
                //white_disposal.text = black_sort(tmp + s)
                tmp = black_disposal.text as String
                tmp += s
                ch = tmp.toCharArray()
                tmp = ch.sorted().joinToString("")
                white_disposal.text = white_sort(tmp)
            }
            //board_array[0][5].text = "A"
        }

*/

        start_position()

        start_new_game.setOnClickListener {
            start_position()
        }

        go_back_to_menu.setOnClickListener {
           finish()
        }

        board_array[0][0].setOnClickListener {
            if (piece_detection(board_array[0][0])) {
                if (move_piece) {
                    info = A8.text as String
                    iRow = 0
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 0)) {
                        //disposal_bar(board_array[0][0].text as String)
                        //white_disposal.text = board_array[0][0].text
                        A8.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 0)) {
                        //disposal_bar(board_array[0][0].text as String)
                        A8.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (A8.text == "♙" || A8.text == "♟") promote(0,0)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][0].setOnClickListener {
            if (piece_detection(board_array[1][0])) {
                if (move_piece) {
                    info = A7.text as String
                    iRow = 1
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 0)) {
                        A7.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 0)) {
                        A7.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][0].setOnClickListener {
            if (piece_detection(board_array[2][0])) {
                if (move_piece) {
                    info = A6.text as String
                    iRow = 2
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 0)) {
                        A6.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 0)) {
                        A6.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][0].setOnClickListener {
            if (piece_detection(board_array[3][0])) {
                if (move_piece) {
                    info = A5.text as String
                    iRow = 3
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 0)) {
                        A5.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 0)) {
                        A5.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][0].setOnClickListener {
            if (piece_detection(board_array[4][0])) {
                if (move_piece) {
                    info = A4.text as String
                    iRow = 4
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 0)) {
                        A4.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 0)) {
                        A4.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][0].setOnClickListener {
            if (piece_detection(board_array[5][0])) {
                if (move_piece) {
                    info = A3.text as String
                    iRow = 5
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 0)) {
                        A3.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 0)) {
                        A3.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][0].setOnClickListener {
            if (piece_detection(board_array[6][0])) {
                if (move_piece) {
                    info = A2.text as String
                    iRow = 6
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 0)) {
                        A2.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 0)) {
                        A2.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][0].setOnClickListener {
            if (piece_detection(board_array[7][0])) {
                if (move_piece) {
                    info = A1.text as String
                    iRow = 7
                    jColoumn = 0
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 0)) {
                        A1.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 0)) {
                        A1.text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (A1.text == "♙" || A1.text == "♟") promote(7,0)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }


        board_array[0][1].setOnClickListener {
            if (piece_detection(board_array[0][1])) {
                if (move_piece) {
                    info = board_array[0][1].text as String
                    iRow = 0
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 1)) {
                        board_array[0][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 1)) {
                        board_array[0][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[0][1].text == "♙" || board_array[0][1].text == "♟") promote(0,1)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][1].setOnClickListener {
            if (piece_detection(board_array[1][1])) {
                if (move_piece) {
                    info = board_array[1][1].text as String
                    iRow = 1
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 1)) {
                        board_array[1][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 1)) {
                        board_array[1][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][1].setOnClickListener {
            if (piece_detection(board_array[2][1])) {
                if (move_piece) {
                    info = board_array[2][1].text as String
                    iRow = 2
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 1)) {
                        board_array[2][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 1)) {
                        board_array[2][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][1].setOnClickListener {
            if (piece_detection(board_array[3][1])) {
                if (move_piece) {
                    info = board_array[3][1].text as String
                    iRow = 3
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 1)) {
                        board_array[3][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 1)) {
                        board_array[3][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][1].setOnClickListener {
            if (piece_detection(board_array[4][1])) {
                if (move_piece) {
                    info = board_array[4][1].text as String
                    iRow = 4
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 1)) {
                        board_array[4][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 1)) {
                        board_array[4][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][1].setOnClickListener {
            if (piece_detection(board_array[5][1])) {
                if (move_piece) {
                    info = board_array[5][1].text as String
                    iRow = 5
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 1)) {
                        board_array[5][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 1)) {
                        board_array[5][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][1].setOnClickListener {
            if (piece_detection(board_array[6][1])) {
                if (move_piece) {
                    info = board_array[6][1].text as String
                    iRow = 6
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 1)) {
                        board_array[6][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 1)) {
                        board_array[6][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][1].setOnClickListener {
            if (piece_detection(board_array[7][1])) {
                if (move_piece) {
                    info = board_array[7][1].text as String
                    iRow = 7
                    jColoumn = 1
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 1)) {
                        board_array[7][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 1)) {
                        board_array[7][1].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[7][1].text == "♙" || board_array[7][1].text == "♟") promote(7,1)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }


        board_array[0][2].setOnClickListener {
            if (piece_detection(board_array[0][2])) {
                if (move_piece) {
                    info = board_array[0][2].text as String
                    iRow = 0
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 2)) {
                        board_array[0][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 2)) {
                        board_array[0][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[0][2].text == "♙" || board_array[0][2].text == "♟") promote(0,2)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][2].setOnClickListener {
            if (piece_detection(board_array[1][2])) {
                if (move_piece) {
                    info = board_array[1][2].text as String
                    iRow = 1
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 2)) {
                        board_array[1][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 2)) {
                        board_array[1][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][2].setOnClickListener {
            if (piece_detection(board_array[2][2])) {
                if (move_piece) {
                    info = board_array[2][2].text as String
                    iRow = 2
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 2)) {
                        board_array[2][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 2)) {
                        board_array[2][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][2].setOnClickListener {
            if (piece_detection(board_array[3][2])) {
                if (move_piece) {
                    info = board_array[3][2].text as String
                    iRow = 3
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 2)) {
                        board_array[3][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 2)) {
                        board_array[3][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][2].setOnClickListener {
            if (piece_detection(board_array[4][2])) {
                if (move_piece) {
                    info = board_array[4][2].text as String
                    iRow = 4
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 2)) {
                        board_array[4][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 2)) {
                        board_array[4][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][2].setOnClickListener {
            if (piece_detection(board_array[5][2])) {
                if (move_piece) {
                    info = board_array[5][2].text as String
                    iRow = 5
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 2)) {
                        board_array[5][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 2)) {
                        board_array[5][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][2].setOnClickListener {
            if (piece_detection(board_array[6][2])) {
                if (move_piece) {
                    info = board_array[6][2].text as String
                    iRow = 6
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 2)) {
                        board_array[6][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 2)) {
                        board_array[6][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][2].setOnClickListener {
            if (piece_detection(board_array[7][2])) {
                if (move_piece) {
                    info = board_array[7][2].text as String
                    iRow = 7
                    jColoumn = 2
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 2)) {
                        board_array[7][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 2)) {
                        board_array[7][2].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[7][2].text == "♙" || board_array[7][2].text == "♟") promote(7,2)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }


        board_array[0][3].setOnClickListener {
            if (piece_detection(board_array[0][3])) {
                if (move_piece) {
                    info = board_array[0][3].text as String
                    iRow = 0
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 3)) {
                        board_array[0][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 3)) {
                        board_array[0][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[0][3].text == "♙" || board_array[0][3].text == "♟") promote(0,3)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][3].setOnClickListener {
            if (piece_detection(board_array[1][3])) {
                if (move_piece) {
                    info = board_array[1][3].text as String
                    iRow = 1
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 3)) {
                        board_array[1][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 3)) {
                        board_array[1][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][3].setOnClickListener {
            if (piece_detection(board_array[2][3])) {
                if (move_piece) {
                    info = board_array[2][3].text as String
                    iRow = 2
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 3)) {
                        board_array[2][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 3)) {
                        board_array[2][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][3].setOnClickListener {
            if (piece_detection(board_array[3][3])) {
                if (move_piece) {
                    info = board_array[3][3].text as String
                    iRow = 3
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 3)) {
                        board_array[3][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 3)) {
                        board_array[3][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][3].setOnClickListener {
            if (piece_detection(board_array[4][3])) {
                if (move_piece) {
                    info = board_array[4][3].text as String
                    iRow = 4
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 3)) {
                        board_array[4][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 3)) {
                        board_array[4][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][3].setOnClickListener {
            if (piece_detection(board_array[5][3])) {
                if (move_piece) {
                    info = board_array[5][3].text as String
                    iRow = 5
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 3)) {
                        board_array[5][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 3)) {
                        board_array[5][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][3].setOnClickListener {
            if (piece_detection(board_array[6][3])) {
                if (move_piece) {
                    info = board_array[6][3].text as String
                    iRow = 6
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 3)) {
                        board_array[6][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 3)) {
                        board_array[6][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][3].setOnClickListener {
            if (piece_detection(board_array[7][3])) {
                if (move_piece) {
                    info = board_array[7][3].text as String
                    iRow = 7
                    jColoumn = 3
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 3)) {
                        board_array[7][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 3)) {
                        board_array[7][3].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[7][3].text == "♙" || board_array[7][3].text == "♟") promote(7,3)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }


        board_array[0][4].setOnClickListener {
            if (piece_detection(board_array[0][4])) {
                if (move_piece) {
                    info = board_array[0][4].text as String
                    iRow = 0
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 4)) {
                        board_array[0][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 4)) {
                        board_array[0][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[0][4].text == "♙" || board_array[0][4].text == "♟") promote(0,4)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][4].setOnClickListener {
            if (piece_detection(board_array[1][4])) {
                if (move_piece) {
                    info = board_array[1][4].text as String
                    iRow = 1
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 4)) {
                        board_array[1][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 4)) {
                        board_array[1][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][4].setOnClickListener {
            if (piece_detection(board_array[2][4])) {
                if (move_piece) {
                    info = board_array[2][4].text as String
                    iRow = 2
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 4)) {
                        board_array[2][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 4)) {
                        board_array[2][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][4].setOnClickListener {
            if (piece_detection(board_array[3][4])) {
                if (move_piece) {
                    info = board_array[3][4].text as String
                    iRow = 3
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 4)) {
                        board_array[3][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 4)) {
                        board_array[3][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][4].setOnClickListener {
            if (piece_detection(board_array[4][4])) {
                if (move_piece) {
                    info = board_array[4][4].text as String
                    iRow = 4
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 4)) {
                        board_array[4][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 4)) {
                        board_array[4][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][4].setOnClickListener {
            if (piece_detection(board_array[5][4])) {
                if (move_piece) {
                    info = board_array[5][4].text as String
                    iRow = 5
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 4)) {
                        board_array[5][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 4)) {
                        board_array[5][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][4].setOnClickListener {
            if (piece_detection(board_array[6][4])) {
                if (move_piece) {
                    info = board_array[6][4].text as String
                    iRow = 6
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 4)) {
                        board_array[6][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 4)) {
                        board_array[6][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][4].setOnClickListener {
            if (piece_detection(board_array[7][4])) {
                if (move_piece) {
                    info = board_array[7][4].text as String
                    iRow = 7
                    jColoumn = 4
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 4)) {
                        board_array[7][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 4)) {
                        board_array[7][4].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[7][4].text == "♙" || board_array[7][4].text == "♟") promote(7,4)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }


        board_array[0][5].setOnClickListener {
            if (piece_detection(board_array[0][5])) {
                if (move_piece) {
                    info = board_array[0][5].text as String
                    iRow = 0
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 5)) {
                        board_array[0][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 5)) {
                        board_array[0][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[0][5].text == "♙" || board_array[0][5].text == "♟") promote(0,5)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][5].setOnClickListener {
            if (piece_detection(board_array[1][5])) {
                if (move_piece) {
                    info = board_array[1][5].text as String
                    iRow = 1
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 5)) {
                        board_array[1][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 5)) {
                        board_array[1][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][5].setOnClickListener {
            if (piece_detection(board_array[2][5])) {
                if (move_piece) {
                    info = board_array[2][5].text as String
                    iRow = 2
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 5)) {
                        board_array[2][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 5)) {
                        board_array[2][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][5].setOnClickListener {
            if (piece_detection(board_array[3][5])) {
                if (move_piece) {
                    info = board_array[3][5].text as String
                    iRow = 3
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 5)) {
                        board_array[3][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 5)) {
                        board_array[3][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][5].setOnClickListener {
            if (piece_detection(board_array[4][5])) {
                if (move_piece) {
                    info = board_array[4][5].text as String
                    iRow = 4
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 5)) {
                        board_array[4][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 5)) {
                        board_array[4][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][5].setOnClickListener {
            if (piece_detection(board_array[5][5])) {
                if (move_piece) {
                    info = board_array[5][5].text as String
                    iRow = 5
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 5)) {
                        board_array[5][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 5)) {
                        board_array[5][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][5].setOnClickListener {
            if (piece_detection(board_array[6][5])) {
                if (move_piece) {
                    info = board_array[6][5].text as String
                    iRow = 6
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 5)) {
                        board_array[6][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 5)) {
                        board_array[6][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][5].setOnClickListener {
            if (piece_detection(board_array[7][5])) {
                if (move_piece) {
                    info = board_array[7][5].text as String
                    iRow = 7
                    jColoumn = 5
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 5)) {
                        board_array[7][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 5)) {
                        board_array[7][5].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[7][5].text == "♙" || board_array[7][5].text == "♟") promote(7,5)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }


        board_array[0][6].setOnClickListener {
            if (piece_detection(board_array[0][6])) {
                if (move_piece) {
                    info = board_array[0][6].text as String
                    iRow = 0
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 6)) {
                        board_array[0][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 6)) {
                        board_array[0][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[0][6].text == "♙" || board_array[0][6].text == "♟") promote(0,6)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][6].setOnClickListener {
            if (piece_detection(board_array[1][6])) {
                if (move_piece) {
                    info = board_array[1][6].text as String
                    iRow = 1
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 6)) {
                        board_array[1][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 6)) {
                        board_array[1][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][6].setOnClickListener {
            if (piece_detection(board_array[2][6])) {
                if (move_piece) {
                    info = board_array[2][6].text as String
                    iRow = 2
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 6)) {
                        board_array[2][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 6)) {
                        board_array[2][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][6].setOnClickListener {
            if (piece_detection(board_array[3][6])) {
                if (move_piece) {
                    info = board_array[3][6].text as String
                    iRow = 3
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 6)) {
                        board_array[3][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 6)) {
                        board_array[3][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][6].setOnClickListener {
            if (piece_detection(board_array[4][6])) {
                if (move_piece) {
                    info = board_array[4][6].text as String
                    iRow = 4
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 6)) {
                        board_array[4][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 6)) {
                        board_array[4][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][6].setOnClickListener {
            if (piece_detection(board_array[5][6])) {
                if (move_piece) {
                    info = board_array[5][6].text as String
                    iRow = 5
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 6)) {
                        board_array[5][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 6)) {
                        board_array[5][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][6].setOnClickListener {
            if (piece_detection(board_array[6][6])) {
                if (move_piece) {
                    info = board_array[6][6].text as String
                    iRow = 6
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 6)) {
                        board_array[6][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 6)) {
                        board_array[6][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][6].setOnClickListener {
            if (piece_detection(board_array[7][6])) {
                if (move_piece) {
                    info = board_array[7][6].text as String
                    iRow = 7
                    jColoumn = 6
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 6)) {
                        board_array[7][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 6)) {
                        board_array[7][6].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[7][6].text == "♙" || board_array[7][6].text == "♟") promote(7,6)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }


        board_array[0][7].setOnClickListener {
            //board_array[0][7].text = "G"
            if (piece_detection(board_array[0][7])) {
                //board_array[0][7].text = "A"
                if (move_piece) {
                    info = board_array[0][7].text as String
                    //board_array[0][7].text = "N"
                    iRow = 0
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 0, 7)) {
                        board_array[0][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 0, 7)) {
                        board_array[0][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[0][7].text == "♙" || board_array[0][7].text == "♟") promote(0,7)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[1][7].setOnClickListener {
            if (piece_detection(board_array[1][7])) {
                if (move_piece) {
                    info = board_array[1][7].text as String
                    iRow = 1
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 1, 7)) {
                        board_array[1][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 1, 7)) {
                        board_array[1][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[2][7].setOnClickListener {
            if (piece_detection(board_array[2][7])) {
                if (move_piece) {
                    info = board_array[2][7].text as String
                    iRow = 2
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 2, 7)) {
                        board_array[2][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 2, 7)) {
                        board_array[2][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[3][7].setOnClickListener {
            if (piece_detection(board_array[3][7])) {
                if (move_piece) {
                    info = board_array[3][7].text as String
                    iRow = 3
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 3, 7)) {
                        board_array[3][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 3, 7)) {
                        board_array[3][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[4][7].setOnClickListener {
            if (piece_detection(board_array[4][7])) {
                if (move_piece) {
                    info = board_array[4][7].text as String
                    iRow = 4
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 4, 7)) {
                        board_array[4][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 4, 7)) {
                        board_array[4][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[5][7].setOnClickListener {
            if (piece_detection(board_array[5][7])) {
                if (move_piece) {
                    info = board_array[5][7].text as String
                    iRow = 5
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 5, 7)) {
                        board_array[5][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 5, 7)) {
                        board_array[5][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[6][7].setOnClickListener {
            if (piece_detection(board_array[6][7])) {
                if (move_piece) {
                    info = board_array[6][7].text as String
                    iRow = 6
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 6, 7)) {
                        board_array[6][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 6, 7)) {
                        board_array[6][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }

        board_array[7][7].setOnClickListener {
            if (piece_detection(board_array[7][7])) {
                if (move_piece) {
                    info = board_array[7][7].text as String
                    iRow = 7
                    jColoumn = 7
                    move_piece = false
                } else {
                    if (move_is_legal(iRow, jColoumn, 7, 7)) {
                        board_array[7][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                    }
                    move_piece = true
                }
            }
            else {
                if (!move_piece) {
                    if (move_is_legal(iRow, jColoumn, 7, 7)) {
                        board_array[7][7].text = info
                        board_array[iRow][jColoumn].text=""
                        white_to_move = !white_to_move
                        if (board_array[7][7].text == "♙" || board_array[7][7].text == "♟") promote(7,7)
                    }
                    move_piece = true
                }
            }
            white_win()
            black_win()
        }
    }
}