package org.robovikes.amethyst.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.robovikes.amethyst.MatchListAdapter;
import org.robovikes.amethyst.R;
import org.robovikes.amethyst.databinding.FragmentMatchesBinding;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {

    private FragmentMatchesBinding binding;
    private String[] countryNames  = {
            "1",
            "2",
            "3",
            "4"
    };
    private String[] capitalNames  = {
            "1",
            "2",
            "3",
            "4"
    };
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMatchesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0;i < 15; i++) {
            list.add(String.valueOf(i));
        }
        ListView listView = root.findViewById(R.id.matchList);
        MatchListAdapter customCountryList = new MatchListAdapter(getActivity(), countryNames, capitalNames);
        listView.setAdapter(customCountryList);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}