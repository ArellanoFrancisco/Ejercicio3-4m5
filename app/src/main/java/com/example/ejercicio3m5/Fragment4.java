package com.example.ejercicio3m5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio3m5.databinding.Fragment4Binding;

public class Fragment4 extends Fragment {

    private Fragment4Binding f4Binding;
    private static final String ARG_NAME = "nombre";

    private String nName;

    public Fragment4() {
        // Required empty public constructor
    }

    public static Fragment4 newInstance(String name) {
        Fragment4 fragment = new Fragment4();
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
        f4Binding = Fragment4Binding.inflate(inflater, container, false);
        View view = f4Binding.getRoot();
        if (getArguments() != null) {
            nName = getArguments().getString(ARG_NAME);
        }

        String name = getString(R.string.respuesta1, nName);
        f4Binding.text5.setText(name);

        f4Binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString(ARG_NAME, nName);
                Navigation.findNavController(f4Binding.getRoot()).navigate(R.id.action_fragment4_to_fragment2, bundle);
            }
        });

        return view;
    }
}