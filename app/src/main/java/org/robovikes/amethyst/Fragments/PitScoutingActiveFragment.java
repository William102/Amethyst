package org.robovikes.amethyst.Fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import org.robovikes.amethyst.R;
import org.robovikes.amethyst.databinding.FragmentPitActiveBinding;



    public class PitScoutingActiveFragment extends Fragment {

        SeekBar seekBar;
        SeekBar seekBarAccuracy;
        TextView textView;
        TextView textViewAccuracy;


        private FragmentPitActiveBinding binding;

        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            binding = FragmentPitActiveBinding.inflate(inflater, container, false);
            View root = binding.getRoot();
            setupSpinners();

            Button button = root.findViewById(R.id.idsaveData);


            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    NavController navController = Navigation.findNavController(getActivity(),R.id.nav_host_fragment_content_main);
                    navController.navigate(R.id.nav_pitHome);

                }

            });

            seekBar = (SeekBar) root.findViewById(R.id. seekBar);
            textView = (TextView) root.findViewById(R.id.textViewRating);

            seekBarAccuracy = (SeekBar) root.findViewById(R.id. seekBarAccuracy);
            textViewAccuracy = (TextView) root.findViewById(R.id.textViewAccuracy);



            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    textView.setText("rating " + String.valueOf(progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            seekBarAccuracy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    textViewAccuracy.setText("accuracy " + String.valueOf(progress));
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });

            return root;
    }

        private void setupSpinners() {
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            binding = null;


        }
    }

