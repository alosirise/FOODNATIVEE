package com.example.foodfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
public class ListActivity extends AppCompatActivity {
//public class ListActivity extends AppCompatActivity implements MyAdapter.OnNoteListener {
//    private ArrayList<String> Name = new ArrayList<String>();
//    private ArrayList<String> pic = new ArrayList<String>();
//    private ArrayList<String> id = new ArrayList<String>();
//    private String[] ID;

//
//        final String TAG = "LISTACCCTIIVIIITYY";
//        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        db.collection("restaurant").orderBy("name").limit(9)
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()) {
//                            for (QueryDocumentSnapshot document : task.getResult()) {
//
//                                Name.add(document.get("name").toString());
//                                pic.add(document.get("pic").toString());
//                                id.add(document.getId());
//                            }
//
//                            ID = id.toArray(new String[0]);
//                            String[] name = Name.toArray(new String[0]);
//                            String[] Pic = pic.toArray(new String[0]);
//                            myAdapter = new MyAdapter(ListActivity.this,Pic,name,ListActivity.this);
//                            recyclerView.setAdapter(myAdapter);
//                        } else {
//                            Log.w(TAG, "Error getting documents.", task.getException());
//                        }
//                    }
//                });
//}

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<List2> list;
    MyAdapter adapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView=(RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference().child("restaurant");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<List2>();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    List2 p =dataSnapshot1.getValue(List2.class);
                    list.add(p);

                }
                adapter = new MyAdapter(ListActivity.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(ListActivity.this,"OHH.... Something is Wrong ja",Toast.LENGTH_SHORT).show() ;
            }
        });
    }

    public void logoutclick(View view){

        Logout();
    }
    public void  Logout(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
