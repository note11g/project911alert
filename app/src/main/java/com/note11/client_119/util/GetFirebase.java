package com.note11.client_119.util;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class GetFirebase {

    public static void getOnRTDB(Context c) {

        DatabaseReference mPostReference = FirebaseDatabase.getInstance().getReference("list");
        GpsModel m = new GpsModel(0.0, 0.0, 0L);
        GpsCache.setGps(c, m);

        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot d : dataSnapshot.getChildren()) {

                    HashMap<String, Object> result = (HashMap<String, Object>) d.getValue();

                    //Toast.makeText(c, result+"", Toast.LENGTH_SHORT).show();

                    GpsCache.clear(c);

                    GpsCache.setGps(c, new GpsModel(
                            (Double) result.get("longitude"),
                            (Double) result.get("latitude"),
                            (Long) result.get("check")
                    ));

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(c, databaseError + "", Toast.LENGTH_SHORT).show();
                m.setType(0L);
                m.setLatitude(0.0);
                m.setLongitude(0.0);
                GpsCache.clear(c);
            }
        };
        mPostReference.addValueEventListener(postListener);


    }
}
