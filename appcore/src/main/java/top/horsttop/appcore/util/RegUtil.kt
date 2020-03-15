package top.horsttop.appcore.util

import java.util.regex.Pattern

/**
 * Created by horsttop on 11.October.2018
 */
object RegUtil{

    fun isPhoneNumber(phone:String):Boolean{
        val phoneNumberReg = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$"
        return isMatch(phoneNumberReg,phone)
    }


    private fun isMatch(regex:String,input:String?):Boolean{
        return input != null && input.isNotEmpty() && Pattern.matches(regex, input)
    }
}