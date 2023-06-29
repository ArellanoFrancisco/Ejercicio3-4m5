package com.example.ejercicio3m5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio3m5.databinding.Fragment3Binding;

public class Fragment3 extends Fragment {

    private Fragment3Binding f3Binding;
    private static final String ARG_NAME = "nombre";

    private String nName;

    public Fragment3() {
        // Required empty public constructor
    }

    public static Fragment3 newInstance(String name) {
        Fragment3 fragment = new Fragment3();
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
        f3Binding = Fragment3Binding.inflate(inflater, container,false);
        View view = f3Binding.getRoot();
        if (getArguments() != null) {
            nName = getArguments().getString(ARG_NAME);
        }

        String name = getString(R.string.respuesta2, nName);
        f3Binding.text4.setText(name);

        f3Binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ARG_NAME, nName);
                Navigation.findNavController(f3Binding.getRoot()).navigate(R.id.action_fragment3_to_fragment2, bundle);
            }
        });

        return view;
    }
}