package com.example.medicinedose

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class MedicineVM(application: Application) : AndroidViewModel(application) {
    private val repository: MedicineRepository = MedicineRepository(application)

    fun getMedicines(): LiveData<List<Medicine>> {
        return repository.getMedicines()
    }

    fun getMedicineByName(name: String): LiveData<Medicine> {
        return repository.getMedicineByName(name)
    }
}
