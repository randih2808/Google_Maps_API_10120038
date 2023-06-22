package com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    //Nim   : 10120038
    //Nama  : Randi Hardiansyah
    //Kelas : IF-1

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Tugas Aplikasi Memanfaatkan Sensor");
    }

    public LiveData<String> getText() {
        return mText;
    }
}