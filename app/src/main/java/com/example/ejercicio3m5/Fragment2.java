package com.example.ejercicio3m5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio3m5.databinding.Fragment2Binding;


public class Fragment2 extends Fragment {

    private Fragment2Binding f2Binding;

    private static final String ARG_NAME = "nombre";

    private String nName;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 newInstance(String name) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        f2Binding = Fragment2Binding.inflate(inflater, container,false);
        View view = f2Binding.getRoot();
        if (getArguments() != null) {
            nName = getArguments().getString(ARG_NAME);
        }
        // recibir nombre del fragment1
        String name = getString(R.string.text2, nName);
        f2Binding.Saludo.setText(name);

        f2Binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ARG_NAME, nName);
                if (f2Binding.radioButton3.isChecked()) {
                    Navigation.findNavController(f2Binding.getRoot()).navigate(R.id.action_fragment2_to_fragment3, bundle);

                }else {
                    Navigation.findNavController(f2Binding.getRoot()).navigate(R.id.action_fragment2_to_fragment4, bundle);
                }

            }
        });

       return view;
    }
}