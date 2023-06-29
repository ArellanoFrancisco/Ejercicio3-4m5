package com.example.ejercicio3m5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ejercicio3m5.databinding.Fragment1Binding;

public class Fragment1 extends Fragment {
    private Fragment1Binding f1Binding;

    public Fragment1() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        f1Binding = Fragment1Binding.inflate(inflater,container,false);
        return f1Binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        f1Binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (f1Binding.name.getText().toString().isEmpty()){
                    String toast1 = getString(R.string.toast);
                    Toast.makeText(requireContext(), toast1, Toast.LENGTH_LONG).show();
                }else{
                    SendName();
                }
            }
        });
    }
    private void SendName(){
        Bundle bundle = new Bundle();
        bundle.putString("nombre", f1Binding.name.getText().toString());

        Navigation.findNavController(requireView())
                .navigate(R.id.action_fragment1_to_fragment2,bundle);
    }
}