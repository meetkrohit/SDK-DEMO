package demoapplication.application.com.statlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class NewTestActivity extends AppCompatActivity {

    /*private TextView heading;
    private Button submit;*/
    private TextView name, address, age;
    //private FirebaseRemoteConfig mFirebaseRemoteConfig;
    FirebaseFirestore firebaseFirestore;
    private StorageReference storageReference;
    private FirebaseDatabase dB;
    private FirebaseStorage firebaseStorage;
    private DocumentReference listData;
    TestDataOne testDataOne;
    FirebaseAPI firebaseAPI;
    private FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_test);
        firebaseAPI = new FirebaseAPI();
        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        age = findViewById(R.id.age);
        //firebaseManager = new FirebaseManager(this);

        String nameI = getIntent().getStringExtra("name");
        String ageI = getIntent().getStringExtra("age");
        String addressII = getIntent().getStringExtra("address");

        /*name.setText(nameI);
        age.setText(ageI);
        address.setText(addressII);*/

        FirebaseFirestore.getInstance().collection("Test2").document("nfAWl9uP2EQt85emS7JT").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("docs", documentSnapshot.getDocumentReference("details").toString());

                /*FirebaseFirestore.getInstance().document(documentSnapshot.getDocumentReference("details").toString()).get().addOnSuccessListener(new OnSuccessListener<>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Log.d("documents",queryDocumentSnapshots.toString());
                    }
                });*/

               /* listData = FirebaseFirestore.getInstance().document(documentSnapshot.getDocumentReference("details").toString());
                listData.addSnapshotListener(new EventListener<DocumentSnapshot>() {
                    @Override
                    public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable
                            FirebaseFirestoreException e) {
                        if (documentSnapshot != null && documentSnapshot.exists()) {
                            try {
                                JSONObject jsonObject = new JSONObject(documentSnapshot.getData());
                                Map map = new HashMap();
                                Gson gson = new GsonBuilder().serializeNulls().create();
                                map.put("Hello", gson.fromJson(jsonObject.toString(),
                                        TestDataOne.class));
                                testDataOne = (TestDataOne) map.get("Hello");

                                name.setText(testDataOne.getName());
                                age.setText(testDataOne.getAge());
                                address.setText(testDataOne.getAddress());

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }

                        }
                    }
                });*/
            }
        });

       /* listData = FirebaseFirestore.getInstance().collection("Test2").document("nfAWl9uP2EQt85emS7JT");
        listData.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable
                    FirebaseFirestoreException e) {
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    try {
                        JSONObject jsonObject = new JSONObject(documentSnapshot.getData());
                       *//* Map map = new HashMap();
                        Gson gson = new GsonBuilder().serializeNulls().create();
                        map.put("Hello", gson.fromJson(jsonObject.toString(),
                                TestDataOne.class));
                        testDataOne = (TestDataOne) map.get("Hello");

                        name.setText(testDataOne.getName());
                        age.setText(testDataOne.getAge());
                        address.setText(testDataOne.getAddress());*//*

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });*/

        /*firebaseManager.getTeamsByDocument( "Test",
                "nfAWl9uP2EQt85emS7JT", new FirebaseCallBack() {
                    @Override
                    public void onSuccess(String success, Map map) {
                        testDataOne = (TestDataOne) map.get("RESPONSE");
                        name.setText(testDataOne.getName());
                        age.setText(testDataOne.getAge());
                        address.setText(testDataOne.getAddress());
                    }

                    @Override
                    public void onError(String error) {

                    }

                    @Override
                    public void onResponseCode(int code) {

                    }
                });*/
    }

    public void updateData() {

        /*String nameString = mFirebaseRemoteConfig.getString("name");
        String headingString = mFirebaseRemoteConfig.getString("heading");
        String passwordString = mFirebaseRemoteConfig.getString("password");
        String submitString = mFirebaseRemoteConfig.getString("submit");*/
        /*name.setText(nameString);
        heading.setText(headingString);
        password.setText(passwordString);
        submit.setText(submitString);*/

    }
}
