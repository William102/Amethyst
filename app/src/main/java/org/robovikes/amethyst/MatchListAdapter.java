package org.robovikes.amethyst;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Random;

public class MatchListAdapter extends ArrayAdapter {

    public Activity context;

    public MatchListAdapter(Activity context, String[] countryNames, String[] capitalNames) {
        super(context, R.layout.match_layout, countryNames);
        this.context = context;
        this.countryNames = countryNames;
        this.capitalNames = capitalNames;

    }
    private String[] countryNames;
    private String[] capitalNames;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null) {
            row = inflater.inflate(R.layout.match_layout, null, true);
            TextView blue = (TextView) row.findViewById(R.id.blue1);
            TextView red = (TextView) row.findViewById(R.id.red1);
            TextView score = (TextView) row.findViewById(R.id.score);
            ProgressBar imageFlag = row.findViewById(R.id.progressBar);
            int blueScore = new Random().nextInt(100) + 1;
            int redScore = new Random().nextInt(100) + 1;
            double totalScore = redScore + blueScore + 0.0;
            double bluePercent = blueScore / totalScore;
            int finalScore = (int) (bluePercent * 100);

            score.setText(blueScore + " - " + redScore);
            imageFlag.setProgress(finalScore);
            blue.setText("1\n2\n3");
            red.setText(capitalNames[position]);
        }
        return  row;
    }
}
