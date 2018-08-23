package demoapplication.application.com.statlib;

import android.app.Activity;
import android.content.Context;

import java.util.Map;

public class FirebaseManager {


    private Context context;
    FirebaseAPI firebaseAPI = new FirebaseAPI();
    public FirebaseManager(Context context) {
        this.context = context;
    }



    public void getTeamsByDocumentId(Activity activity, String collectionName, String documentId,
                                     final FirebaseCallBack firebaseCallBack) {
        firebaseAPI.getTeamsByDocumentId(activity, collectionName, documentId, new FirebaseCallBack() {
            @Override
            public void onSuccess(String success, Map map) {
                firebaseCallBack.onSuccess(success, map);
            }

            @Override
            public void onError(String error) {
                firebaseCallBack.onError(error);
            }

            @Override
            public void onResponseCode(int code) {
                firebaseCallBack.onResponseCode(code);
            }
        });
    }


    public void getTeamsByDocument (String collectionName, String documentId,
                                     final FirebaseCallBack firebaseCallBack) {
        firebaseAPI.getTeamsByDocument( collectionName, documentId, new FirebaseCallBack() {
            @Override
            public void onSuccess(String success, Map map) {
                firebaseCallBack.onSuccess(success, map);
            }

            @Override
            public void onError(String error) {
                firebaseCallBack.onError(error);
            }

            @Override
            public void onResponseCode(int code) {
                firebaseCallBack.onResponseCode(code);
            }
        });
    }
}
