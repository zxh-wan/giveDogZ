package com.zxh.work.di.module

import android.app.Application


import androidx.sqlite.db.SupportSQLiteOpenHelper
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory
import top.horsttop.appcore.BuildConfig

import com.squareup.sqlbrite3.BriteDatabase
import com.squareup.sqlbrite3.SqlBrite
import com.zxh.work.model.db.DbCallback
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Singleton

/**
 * Created by horsttop on 11.October.2018
 */

@Singleton
@Module
class DBModule{
    @Provides
    fun providesSQLBrite(): SqlBrite {
        return SqlBrite.Builder()
                .logger { message -> Timber.v(message) }
                .build()
    }

    @Provides
    fun providesDataBase(sqlBrite: SqlBrite,application:Application): BriteDatabase {
        val configuration = SupportSQLiteOpenHelper.Configuration.builder(application)
                .name(BuildConfig.DB_NAME)
                .callback(DbCallback(BuildConfig.DB_VERSION))
                .build()
        val factory = FrameworkSQLiteOpenHelperFactory()
        val helper = factory.create(configuration)
        val db = sqlBrite.wrapDatabaseHelper(helper, Schedulers.io())
        db.setLoggingEnabled(true)
        return db
    }
}