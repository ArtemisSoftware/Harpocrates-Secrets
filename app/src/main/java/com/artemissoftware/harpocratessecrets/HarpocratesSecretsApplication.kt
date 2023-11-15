package com.artemissoftware.harpocratessecrets

import android.app.Application
import com.artemissoftware.harpocratessecrets.di.databaseModule
import com.artemissoftware.harpocratessecrets.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.loadKoinModules
import org.koin.core.context.startKoin

class HarpocratesSecretsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HarpocratesSecretsApplication)
            loadKoinModules(
                listOf(
                    databaseModule,
                    repositoryModule,
                ),
            )
        }
    }
}
