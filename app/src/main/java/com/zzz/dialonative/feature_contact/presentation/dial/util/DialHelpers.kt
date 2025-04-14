package com.zzz.dialonative.feature_contact.presentation.dial.util

fun String.removeDigit(start : Int, end : Int) :String{
    if(start==0){
        return this
    }
    return if(start == end){
        this.removeRange(start-1,end)
    }else{
        this.removeRange(start,end)
    }
}

fun String.addDigit(start: Int,end: Int,digit : String) : String{
    return this.substring(0,start) + digit + this.substring(end,this.length)
}