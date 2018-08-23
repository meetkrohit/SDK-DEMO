package demoapplication.application.com.statlib;

import android.app.Activity;
import android.content.Context;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class FirebaseAPI {


    Context context;

    public FirebaseAPI() {
    }

    private DocumentReference listTeamDocRef;
    private DocumentReference listTeamDoc;

    public void getTeamsByDocumentId(final Activity activity, String collectionName, final String documentId
            , final FirebaseCallBack firebaseCallBack) {
        final String TAG = "Firebase-teamByDocument";

        listTeamDocRef = FirebaseFirestore.getInstance().collection(collectionName).document(documentId);
        listTeamDocRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable
                    FirebaseFirestoreException e) {
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    try {
                            JSONObject jsonObject = new JSONObject(documentSnapshot.getData());
                            Map map = new HashMap();
                            Gson gson = new GsonBuilder().serializeNulls().create();
                            map.put("RESPONSE", gson.fromJson(jsonObject.toString(),
                                    TestDataOne.class));
                            firebaseCallBack.onSuccess("RESPONSE", map);


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }


            }
        });
    }


    public void getTeamsByDocument(String collectionName, final String documentId
            , final FirebaseCallBack firebaseCallBack) {
        final String TAG = "Firebase-teamByDocument";

        listTeamDoc = FirebaseFirestore.getInstance().collection(collectionName).document(documentId);
        listTeamDoc.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable
                    FirebaseFirestoreException e) {
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    try {
                        JSONObject jsonObject = new JSONObject(documentSnapshot.getData());
                        Map map = new HashMap();
                        Gson gson = new GsonBuilder().serializeNulls().create();
                        map.put("RESPONSE", gson.fromJson(jsonObject.toString(),
                                TestDataOne.class));
                        firebaseCallBack.onSuccess("RESPONSE", map);


                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }


            }
        });
    }
}
