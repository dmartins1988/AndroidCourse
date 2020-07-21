package com.example.viewmodelexample.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.viewmodelexample.R;

public class MainFragment extends Fragment {


    private TextView display1, display2;
    private Button plus3, plus3Duplicate;

    private MainViewModel mViewModel;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        display1 = view.findViewById(R.id.display1);
        display2 = view.findViewById(R.id.display2);
        plus3 = view.findViewById(R.id.plus_three);
        plus3Duplicate = view.findViewById(R.id.plus_three_duplicate);

        setClickListeners();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.get_addThree().observe(getViewLifecycleOwner(), s -> display1.setText(s));
        mViewModel.get_addThreeDuplicate().observe(getViewLifecycleOwner(), s -> display2.setText(s));

    }

    private void setClickListeners() {
        plus3.setOnClickListener(v -> {
            final String s = display1.getText().toString();
            mViewModel.addThree(s);
        });

        plus3Duplicate.setOnClickListener(v -> {
            final String s = display2.getText().toString();
            mViewModel.addThreeDuplicate(s);
        });

    }

}