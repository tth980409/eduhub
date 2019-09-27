package com.example.android.eduhub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MathsMainFragment extends Fragment {


    public MathsMainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_view, container, false);
        // Inflate the layout for this fragment
        String ChapterList[] = {"Mathematics", "Additional Maths"};
        ListView simpleList = view.findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_listview, R.id.textView, ChapterList);
        simpleList.setAdapter(arrayAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fragment = null;

                Object obj = parent.getAdapter().getItem(position);
                String value = obj.toString();

                switch (value) {
                    case "Mathematics":
                        fragment = new MathsSubFragment();
                        replaceFragment(fragment);
                        break;

                    case "Additional Maths":
                        fragment = new AdditionalMathsSubFragment();
                        replaceFragment(fragment);
                        break;

                    default:
                        break;
                }
            }


        });
        return view;
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutContent, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}

