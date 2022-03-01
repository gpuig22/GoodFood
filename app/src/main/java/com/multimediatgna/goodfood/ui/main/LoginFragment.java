package com.multimediatgna.goodfood.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.multimediatgna.goodfood.R;

public class LoginFragment extends Fragment {

    private MainViewModel mViewModel;
    EditText mynameedittext,mypasswdedittext;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment, container, false);
        Intent intent = getActivity().getIntent();
        mynameedittext = root.findViewById(R.id.myusername);
        mypasswdedittext = root.findViewById(R.id.mypasswd);
        mynameedittext.setText(intent.getStringExtra("myname"));
        mypasswdedittext.setText(intent.getStringExtra("mypassword"));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}