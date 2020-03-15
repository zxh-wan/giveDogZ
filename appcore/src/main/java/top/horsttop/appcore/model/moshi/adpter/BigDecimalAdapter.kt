package top.horsttop.appcore.model.moshi.adpter

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.ToJson
import java.lang.Exception
import java.math.BigDecimal

/**
 * Created by horsttop on 15.October.2018
 */

class BigDecimalAdapter{

    @ToJson fun toJson(bigDecimal: BigDecimal):String{

        return bigDecimal.toString()
    }

    @FromJson fun fromJson(string: String):BigDecimal{
        return try {
            BigDecimal(string)
        } catch (e : Exception){
            BigDecimal.ZERO
        }


    }
}