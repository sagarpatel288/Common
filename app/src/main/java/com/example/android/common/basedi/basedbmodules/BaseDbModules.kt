package com.example.android.common.basedi.basedbmodules

import androidx.room.Room
import com.example.android.common.basedb.BaseDatabase
import com.example.android.common.baserepository.BaseRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val baseDbModule = module {
    single {
        Room
            .databaseBuilder(
                androidApplication(),
                BaseDatabase::class.java,
                "baseApp.db"
            )
            .allowMainThreadQueries()
            .build()
    }

    single {
        get<BaseDatabase>().getCategoryDao()
    }

    single {
        get<BaseDatabase>().getProductDao()
    }

    single {
        get<BaseDatabase>().getRankingDao()
    }

    single {
        BaseRepository()
    }
}