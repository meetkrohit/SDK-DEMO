package demoapplication.application.com.statlib;

import java.util.Map;

public interface FirebaseCallBack {
    public void onSuccess(String success, Map map);
    public void onError(String error);
    public void onResponseCode(int code);
}
