package org.robovikes.amethyst.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.robovikes.amethyst.Adapters.MatchListAdapter;
import org.robovikes.amethyst.R;
import org.robovikes.amethyst.databinding.FragmentMatchesBinding;

import java.util.ArrayList;

public class MatchesFragment extends Fragment {

    private FragmentMatchesBinding binding;
    private ArrayList<String> countryNames  = new ArrayList<>();
    private ArrayList<String> capitalNames  = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMatchesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        countryNames.add("1");
        countryNames.add("2");
        countryNames.add("3");
        countryNames.add("4");

        capitalNames.add("1");
        capitalNames.add("2");
        capitalNames.add("3");
        capitalNames.add("4");

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