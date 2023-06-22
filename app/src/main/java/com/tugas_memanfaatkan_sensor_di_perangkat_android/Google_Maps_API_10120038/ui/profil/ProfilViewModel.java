package com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.ui.profil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfilViewModel extends ViewModel {
    //Nim   : 10120038
    //Nama  : Randi Hardiansyah
    //Kelas : IF-1

    private final MutableLiveData<String> mText;

    public ProfilViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}