package com.gphackathon

import android.content.Context
import android.util.Log
import com.gphackathon.base.BaseApplication
import com.gphackathon.data.db.AppDB
import timber.log.Timber


/*
 * Created by : 
 * <a href="https://www.github.com/ashiqursuperfly">Ashiqur Rahman</a> on 12/4/20.
*/

class GpApp : BaseApplication() {

    override fun afterOnCreate() {
        AppDB.initDb(this)
        plantTimber()
    }

    private fun plantTimber() {

        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String? {
                    return "Timber: "+super.createStackElementTag(element) +
                            " Line:${element.lineNumber}  ${element.methodName}()"
                }
            })
            return
        }

        Timber.plant(CrashReportingTree())
    }

    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }

            FakeCrashLibrary.log(priority, tag, message)

            if (t != null) {
                if (priority == Log.ERROR) {
                    FakeCrashLibrary.logError(t)
                } else if (priority == Log.WARN) {
                    //FakeCrashLibrary.logWarning(t)
                }
            }
        }
    }

    class FakeCrashLibrary private constructor() {

        init {
            throw AssertionError("No instances.")
        }

        companion object {
            fun log(priority: Int, tag: String?, message: String) {

            }

            fun logWarning(t: Throwable) {

            }

            fun logError(t: Throwable) {

            }
        }
    }

    companion object {
        fun getApplicationContext(): Context {
            return BaseApplication.getApplicationContext()
        }
    }
}