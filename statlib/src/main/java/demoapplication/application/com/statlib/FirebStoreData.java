package demoapplication.application.com.statlib;

public class FirebStoreData {
    private static FirebStoreData INSTANCE = null;
    private FirebStoreData() {};

    public static FirebStoreData getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FirebStoreData();
        }
        return(INSTANCE);
    }

    private int themes;
    private String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getThemes() {
        return themes;
    }

    public void setThemes(int themes) {
        this.themes = themes;
    }
}
