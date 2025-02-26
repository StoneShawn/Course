package com.shawn.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.shawn.database.dao.CourseDao
import com.shawn.database.model.CourseEntity
import com.shawn.database.util.SuccessCriteriaTypeConverter


@Database(
    entities = [
        CourseEntity::class
    ],
    version = 4,
    autoMigrations = [
        AutoMigration(from = 1, to =2),
        AutoMigration(from = 2, to =3),
        AutoMigration(from = 3, to =4)
    ],
    exportSchema = true
)
@TypeConverters(
    SuccessCriteriaTypeConverter::class
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}