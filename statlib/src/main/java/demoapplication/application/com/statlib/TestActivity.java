package demoapplication.application.com.statlib;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import junit.framework.Test;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class TestActivity extends AppCompatActivity {

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
    Button nextScreen;

    private FirebaseAPI firebaseAPI;
    private FirebaseManager firebaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        name = findViewById(R.id.name);
        /*address = findViewById(R.id.address);*/
        age = findViewById(R.id.age);

        nextScreen = findViewById(R.id.nextScreen);
        firebaseManager = new FirebaseManager(this);




        firebaseManager.getTeamsByDocument("Test",
                "nfAWl9uP2EQt85emS7JT", new FirebaseCallBack() {
            @Override
            public void onSuccess(String success, Map map) {

                testDataOne = (TestDataOne) map.get("RESPONSE");

                ActivityManager am = (ActivityManager)getSystemService(Context.ACTIVITY_SERVICE);
                ComponentName cn = am.getRunningTasks(1).get(0).topActivity;

                if (cn.getClassName().equals("demoapplication.application.com.statlib.TestActivity")){
                    name.setText(testDataOne.getName());
                    age.setText(testDataOne.getAge());
                }

            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void onResponseCode(int code) {

            }
        });

        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, NewTestActivity.class);
                intent.putExtra("name", testDataOne.getName());
                intent.putExtra("age", testDataOne.getAge());
                intent.putExtra("address",testDataOne.getAddress());
                startActivity(intent);

            }
        });

       /* listData = FirebaseFirestore.getInstance().collection("Test").document("nfAWl9uP2EQt85emS7JT");
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


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
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
