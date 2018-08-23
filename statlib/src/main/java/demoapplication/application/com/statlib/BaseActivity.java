package demoapplication.application.com.statlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import javax.annotation.Nullable;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateTheme();

    }

    private void updateTheme() {
        switch (FirebStoreData.getInstance().getAppName()) {
            case "AVALOQ":
                setTheme(R.style.AppTheme_Base_Green_Dark);
                break;
            case "NBL":
                setTheme(R.style.AppTheme_Base_Purple_Dark);
                break;
            case "FAN":
                setTheme(R.style.NewTheme);
                break;
            default:
                setTheme(R.style.AppTheme);
                break;
        }

    }


}
