package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentAListner listner;
    EditText headerdata, descdata;
    Button btn;


    public interface  FragmentAListner{
        void onInputASent(String input, String input2);
    }
    public InputFragment(FragmentAListner fragmentAListner) {
        listner=fragmentAListner;
        // Required empty public constructor
    }

//    public static InputFragment newInstance(String param1, String param2) {
//        InputFragment fragment = new InputFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_input, container, false);
        headerdata = v.findViewById(R.id.headeredittext);
        descdata = v.findViewById(R.id.descedittext);
        btn = v.findViewById(R.id.submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 String input = headerdata.getText().toString();
                String input2 = descdata.getText().toString();
                listner.onInputASent(input, input2);
//                Bundle bundle = new Bundle();
//                bundle.putString("Header", headerdata.getText().toString());
//                bundle.putString("Desc", descdata.getText().toString());
//                InputFragment frag = new InputFragment();
//                frag.setArguments(bundle);
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListner)
        {
            listner = (FragmentAListner) context;
        }
        else {throw new RuntimeException(new Exception().toString()+"Must be Implemented FragmentAListner");}
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }

}