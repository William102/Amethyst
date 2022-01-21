package org.robovikes.amethyst.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.robovikes.amethyst.Adapters.EventListAdapter;
import org.robovikes.amethyst.EventManager;
import org.robovikes.amethyst.R;
import org.robovikes.amethyst.databinding.FragmentEventsBinding;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    private FragmentEventsBinding binding;
    private ArrayList<String> eventStart  = new ArrayList<>();
    private ArrayList<String> eventEnd  = new ArrayList<>();
    private ArrayList<String> events  = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentEventsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        EventListAdapter eventListAdapter = new EventListAdapter(getActivity(), events, eventStart, eventEnd);
        ListView listView = root.findViewById(R.id.eventsList);
        listView.setAdapter(eventListAdapter);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference reference = db.getReference("events");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                events.clear();
                eventStart.clear();
                eventEnd.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String eventName = snapshot.getKey();
                    String start = String.valueOf(snapshot.child("start").getValue());
                    String end = String.valueOf(snapshot.child("end").getValue());
                    events.add(eventName);
                    eventStart.add(start);
                    eventEnd.add(end);
                }
                System.out.println(events);
                eventListAdapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            EventManager EventManager = new EventManager();
            EventManager.setCurrentEvent(events.get(position));
            System.out.println(EventManager.getCurrentEvent());
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}