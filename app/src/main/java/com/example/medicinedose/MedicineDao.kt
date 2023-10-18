package com.example.medicinedose

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicine(medicine: Medicine)

    @Query("SELECT * FROM medicine")
    fun getAllMedicines(): LiveData<List<Medicine>>

    @Query("SELECT * FROM medicine WHERE name = :name")
    fun getMedicineByName(name: String): LiveData<Medicine>

    @Query("DELETE FROM medicine")
    fun deleteAllMedicines()
}
