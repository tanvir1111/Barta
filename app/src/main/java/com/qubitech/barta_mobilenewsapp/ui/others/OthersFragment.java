package com.qubitech.barta_mobilenewsapp.ui.others;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.qubitech.barta_mobilenewsapp.R;

public class OthersFragment extends Fragment {

    private OthersViewModel othersViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        othersViewModel =
                new ViewModelProvider(this).get(OthersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_others, container, false);

        othersViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }


}