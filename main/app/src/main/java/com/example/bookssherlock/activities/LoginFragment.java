package com.example.bookssherlock.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.Credentials;
import com.example.bookssherlock.models.LoginPage;
import com.example.bookssherlock.sqlite.DbHelper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private DbHelper helper;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        this.helper = DbHelper.getInstance(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnLogin = view.findViewById(R.id.btn_login);

        EditText email = view.findViewById(R.id.email);
        EditText password = view.findViewById(R.id.password);

        btnLogin.setOnClickListener(v -> {
            String userEmail = email.getText().toString();
            String pass = password.getText().toString();
            final Credentials credentials = this.helper.getUser(userEmail,pass);

            if (credentials != null) {
                SharedPreferences sharedpreferences = this.getActivity().getSharedPreferences("storage", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedpreferences.edit();
                edit.putString("email", userEmail);
                edit.apply();
                startActivity(new Intent(view.getContext(), BooksListActivity.class));
            } else {
                Context context = getContext();
                CharSequence text = "User is not exist!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });
        Button signUp = view.findViewById(R.id.btn_reg);
        signUp.setOnClickListener(v -> startActivity(new Intent(view.getContext(), RegisterActivity.class)));
    }
}