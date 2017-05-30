package com.hussan.roomdatabase

import android.app.Application
import com.facebook.stetho.Stetho
import com.hussan.roomdatabase.db.DatabaseCreator

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseCreator.createDb(this)
        Stetho.initializeWithDefaults(this)
    }
}