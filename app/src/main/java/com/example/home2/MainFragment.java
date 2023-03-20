package com.example.home2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import javax.microedition.khronos.egl.EGLDisplay;


public class MainFragment extends Fragment {
    private ImageView btn_add_fragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_add).setOnClickListener(view1 -> {
            AddFragment addFragment = new AddFragment();

            EditText search = view.findViewById(R.id.search_field);
            Bundle bundle = new Bundle();
            bundle.putString("key", search.getText().toString() );
            addFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new AddFragment())
                    .commit();

        });

        btn_add_fragment = view.findViewById(R.id.btn_add);
        btn_add_fragment.setOnClickListener(View->{
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, new AddFragment()).commit();
        });
    }
}