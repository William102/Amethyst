package org.robovikes.amethyst.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.robovikes.amethyst.R;
import org.robovikes.amethyst.databinding.FragmentPitBinding;

public class PitScoutingFragment extends Fragment {

    SeekBar seekBar;
    TextView textView;

    private Spinner deviceSpinner;
    private Spinner teamSpinner;

    private FragmentPitBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentPitBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        seekBar = (SeekBar) root.findViewById(R.id. seekBar);
        textView = (TextView) root.findViewById(R.id.textViewRating);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText("rating " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBar = (SeekBar) root.findViewById(R.id. seekBarAccuracy);
        textView = (TextView) root.findViewById(R.id.textViewAccuracy);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                textView.setText("accuracy " + String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main);
                BottomNavigationView scoutingBar = root.findViewById(R.id.scouting_bar);
                NavigationUI.setupWithNavController(scoutingBar, navController);



            }
        }, 10);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Spinner spinner = teamSpinner.findViewById();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.teamNumbers,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource()

        binding = null;

        public void setupSpinners(){
            View root = binding.getRoot();

            teamSpinner = root.findViewById(R.id.spinner2);

            ArrayAdapter<CharSequence> teamAdapter = ArrayAdapter.createFromResource(root.getContext(),R.array.teams,android.R.layout.simple_spinner_item);
            teamAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            teamSpinner.setAdapter(teamAdapter);

            teamSpinner.setOnItemSelectedListener(this);
        }

    }
}
