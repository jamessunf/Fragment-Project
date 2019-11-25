package com.example.fragmentapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.fragmentapplication.R.layout.activity_listview;


public class SecondFragment extends Fragment {

    TextView txtSnd;
    ListView lstResult;

    public static SecondFragment newInstance(String str){
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("input_string",str);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtSnd = (TextView) view.findViewById(R.id.txt_second);
        if(getArguments() != null)
        txtSnd.setText(getArguments().getString("input_string"));

        final String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
                "WebOS","Ubuntu","Windows7","Max OS X"};

        final ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(), activity_listview, mobileArray);

        lstResult = (ListView) view.findViewById(R.id.lst_result);
        lstResult.setAdapter(adapter);

       lstResult.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               Toast.makeText(getActivity(),mobileArray[position],Toast.LENGTH_SHORT).show();

               PopupMenu popupMenu = new PopupMenu(getActivity(),view);
               popupMenu.getMenuInflater().inflate(R.menu.my_menu,popupMenu.getMenu());

               popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                   @Override
                   public boolean onMenuItemClick(MenuItem item) {
                       return true;
                   }
               });
               popupMenu.show();

           }
       });






    }



    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.my_menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
