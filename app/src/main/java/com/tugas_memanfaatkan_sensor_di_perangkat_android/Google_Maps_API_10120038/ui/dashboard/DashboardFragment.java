package com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.R;
import com.tugas_memanfaatkan_sensor_di_perangkat_android.Google_Maps_API_10120038.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {
    //Nim   : 10120038
    //Nama  : Randi Hardiansyah
    //Kelas : IF-1

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_maps, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}