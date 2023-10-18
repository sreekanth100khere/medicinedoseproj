package com.example.medicinedose

import android.app.Application
import androidx.lifecycle.LiveData

class MedicineRepository(application: Application) {
    private val medicineDao: MedicineDao

    init {
        val database = MedicineDatabase.getInstance(application)
        medicineDao = database.medicineDao()
    }

    fun getMedicines(): LiveData<List<Medicine>> {
        return medicineDao.getAllMedicines()
    }

    fun getMedicineByName(name: String): LiveData<Medicine> {
        return medicineDao.getMedicineByName(name)
    }

    // Add a method to fetch data from the API and store it in the database.
    // You can use Retrofit for API calls and Room for database operations.
}
