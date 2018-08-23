package demoapplication.application.com.statlib;

import android.content.Context;

public class ChangeAppIconAndName {

    public static String KEY_APP_APP1 = "app_one";
    public static String KEY_APP_APP2 = "app_two";
    public static String KEY_APP_APP_NAME_1 = "app_name_one";
    public static String KEY_APP_APP_NAME_2 = "app_name_two";
    public static String KEY_APP_ICON_CHANGE = "icon_change";

    public interface OnUpdateCheckLinstner{
        void OnUpdateCheckListner(String appName);
    }

    public static Builder with(Context context){

        return new Builder(context);

    }

    private OnUpdateCheckLinstner onUpdateCheckLinstner;

    public static class Builder {

        private Context context;
        private OnUpdateCheckLinstner onUpdateCheckLinstner;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder onUpdateCheck(OnUpdateCheckLinstner onUpdateCheckLinstner){
            this.onUpdateCheckLinstner = onUpdateCheckLinstner;
            return this;
        }
    }

}
