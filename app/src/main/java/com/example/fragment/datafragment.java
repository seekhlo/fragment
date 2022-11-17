package com.example.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;




public class datafragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<modelClass> dataholder= new ArrayList<>();
    Button btnrefresh;
    myadapter adapter = new myadapter(getActivity(), dataholder);

    public datafragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_datafragment, container, false);
        recyclerView = v.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        modelClass model1 = new modelClass(R.drawable.ic_launcher_foreground, "Shahzaib", "Ali");
        dataholder.add(model1);
        dataholder.add(new modelClass(R.drawable.ic_launcher_background,"Ali", "Hamza"));
        dataholder.add(new modelClass(R.drawable.ic_launcher_background,"USama", "Hamza"));
        dataholder.add(new modelClass(R.drawable.ic_launcher_background,"USama", "Hamza"));
        dataholder.add(new modelClass(R.drawable.ic_launcher_background,"USama", "Hamza"));
        dataholder.add(new modelClass(R.drawable.ic_launcher_background,"USama", "Hamza"));
        recyclerView.setAdapter(adapter);

        return v;
    }
    public void updateRecycler(String a, String b){
        dataholder.add(new modelClass(R.drawable.ic_launcher_foreground,a,b));
        adapter.notifyItemInserted(dataholder.size()-1);
        recyclerView.scrollToPosition(dataholder.size()-1);
    }
}



//        btnrefresh = v.findViewById(R.id.refresh);
//        Bundle bundle = this.getArguments();
//        String data1 = bundle.getString("Header");
//        String data2 = bundle.getString("Desc");
//        dataholder.add(new modelClass(R.drawable.ic_launcher_background, data1,data2));
//        adapter.notifyItemInserted(dataholder.size()-1);
//        recyclerView.scrollToPosition(dataholder.size()-1);
//        btnrefresh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });