 package com.example.fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

 public class MainActivity extends AppCompatActivity implements InputFragment.FragmentAListner  {
    private datafragment fragmentA;
    private InputFragment fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentA = new datafragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer ,fragmentA).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.containertwo, new InputFragment(this)).commit();
    }

    @Override
    public void onInputASent(String input, String input2) {
        Log.d("","input= "+input+"input2= "+input2);
        fragmentA.updateRecycler(input,input2);
    }
}