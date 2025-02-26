package com.shawn.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.shawn.database.model.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query(
        value = """
        SELECT * FROM course
        WHERE id = :courseId
    """
    )
    fun getCourseEntityStream(courseId: Int): Flow<CourseEntity>

    @Query(value = "SELECT * FROM course")
    fun getCourseListEntitiesStream(): Flow<List<CourseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrIgnoreCourse(courseEntities: List<CourseEntity>): List<Long>

    @Update
    suspend fun updateCourse(entities: List<CourseEntity>)

    @Query(value = "UPDATE course SET saved_status = :saved WHERE id = :id")
    suspend fun updateCourseSave(id: Int, saved: String) : Int

    @Upsert
    suspend fun upsertCourse(entities: List<CourseEntity>)

    @Query(
        value = """
            DELETE FROM course
            WHERE id in (:ids)
        """
    )
    suspend fun deleteCourse(ids: List<Int>)

    @Query(value = "DELETE FROM course")
    suspend fun deleteAll()
}