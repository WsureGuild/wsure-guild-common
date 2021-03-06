package top.wsure.guild.common.utils

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

/**

 * FileName: Timer
 * Author:   wsure
 * Date:     2021/1/21 3:32 下午
 * Description:
 */

object ScheduleUtils {
    @OptIn(DelicateCoroutinesApi::class)
    fun loopEvent(process:suspend ()->Unit, start:Date, period:Long):Timer{
        val t = Timer()
        val tt = object :TimerTask(){
            override fun run(){
                GlobalScope.launch{
                    process()
                }
            }
        }
        t.schedule(tt,start,period)
        return t
    }

}