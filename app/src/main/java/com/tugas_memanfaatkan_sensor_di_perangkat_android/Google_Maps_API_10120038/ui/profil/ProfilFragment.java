package com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.ui.profil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.R;
import com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.databinding.FragmentProfilBinding;

public class ProfilFragment extends Fragment {
    //Nim   : 10120038
    //Nama  : Randi Hardiansyah
    //Kelas : IF-1

    private FragmentProfilBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}