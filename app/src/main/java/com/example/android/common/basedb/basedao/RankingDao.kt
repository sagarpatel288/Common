package com.example.android.common.basedb.basedao

import androidx.room.Dao
import androidx.room.Query
import com.example.android.ecommerce.model.Ranking

@Dao
interface RankingDao : BaseDao<Ranking> {

    @Query("select * from Ranking")
    fun getAllRankings(): List<Ranking>

    @Query("delete from Ranking")
    fun deleteAllRanking()
}