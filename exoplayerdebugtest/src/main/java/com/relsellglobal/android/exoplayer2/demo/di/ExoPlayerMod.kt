package com.relsellglobal.android.exoplayer2.demo.di

import android.content.Context
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.relsellglobal.android.exoplayer2.demo.DemoUtil

import dagger.Module
import dagger.Provides

@Module
class ExoPlayerMod (context: Context,videoUri: String) {
    var context: Context = context
    var videoUri: String = videoUri


    @Provides
    fun context(): Context {
        return context
    }


    @Provides
    fun providesDataSourceFactory() : DataSource.Factory {
        var dataSourceFactory = DemoUtil.getDataSourceFactory(context)
        return dataSourceFactory
    }

    @Provides
    fun providesMediaSourceFactory (dataSourceFactory : DataSource.Factory) : MediaSource.Factory{
        var defaultMediaSourceFactory = DefaultMediaSourceFactory(context)

//        defaultMediaSourceFactory.setDataSourceFactory(dataSourceFactory)
        return defaultMediaSourceFactory
    }

}