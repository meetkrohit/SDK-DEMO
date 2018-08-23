package demoapplication.application.com.statlib;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class FirebaseCloudMessaging extends AppCompatActivity {

    private static final String TAG = "FirebaseCloudMessaging";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_cloud_messaging);

        pushNotification();
    }

    private void pushNotification(){

        try {
            message = "";

            Intent intent = getIntent();
            message = intent.getExtras().getString("ms");
            if(!message.equals("") || !message.isEmpty()) {

                new AlertDialog.Builder(this)
                        .setTitle("Firebase test")
                        .setMessage(message)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setIcon(R.drawable.ic_launcher_round)
                        .show();

            }else {

                Log.e("Message", "No Message To Display");

            }


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
