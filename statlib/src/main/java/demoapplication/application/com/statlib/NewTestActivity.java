package demoapplication.application.com.statlib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
    private String ref;
    Task<DocumentSnapshot> query;

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
                ref = documentSnapshot.getDocumentReference("details").getPath();
                Log.d("docs", ""+ref);
                getData(ref);

            }

        });


    }

    private void getData(String ref) {
        query = FirebaseFirestore.getInstance().document(ref).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                Log.d("docs","---"+task.getResult().getData().get("name"));
            }
        });
    }

}
