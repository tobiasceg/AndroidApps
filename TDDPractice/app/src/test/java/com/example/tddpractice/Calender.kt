package com.example.tddpractice

class Calender {

    fun sth(day:Int, month: Int): String {
        var res :String = ""

        when(day){
            1 -> res += "Mon"
            2 -> res += "Tue"
            3 -> res += "Wed"
            4 -> res += "Thur"
            5 -> res += "Fri"
            6 -> res += "Sat"
            7 -> res += "Sun"
        }

        when(month){
            1 -> res += ",Jan"
            2 -> res += ",Feb"
            3 -> res += ",Mar"
            4 -> res += ",Apr"
            5 -> res += ",May"
            6 -> res += ",Jun"
            7 -> res += ",Jul"
            //...
            12 -> res += ",Dec"
        }

        return res

    }

}
