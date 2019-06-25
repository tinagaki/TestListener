package com.example.testlistenerapplication

/**
 * TODO クラス説明
 *
 * Created by tomohiroinagaki on 2019-06-25.
 */
open class Task {
    private  lateinit  var listener: TestListenner


    interface TestListenner {
        fun onSuccess(result: Int)
    }

    fun setListener(listener: TestListenner) {
        this.listener = listener
    }

    internal fun taskStart() {
        var sum = 1
        for (i in 0..5000000) {
            sum += i
        }
        try {
            Thread.sleep(3000) //3000ミリ秒Sleepする
        } catch (e: InterruptedException) {
        }

        if(listener != null){
            listener.onSuccess(sum)
        }
    }
}