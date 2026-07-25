public class MyConfigManager {
    private static MyConfigManager INSTANCE;

    private MyConfigManager() {
    }

    public static MyConfigManager getInstance() {
        synchronized (MyConfigManager.class) {
            if (INSTANCE == null) {
                INSTANCE = new MyConfigManager();
            }
        }
        return INSTANCE;
    }
}
