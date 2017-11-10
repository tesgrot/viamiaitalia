package eu.amdevelop.viamiaitalia.viamiaitalia.Services;

/**
 * Created by terezamadova on 10/11/2017.
 */

class LocalDataManager {
    private static final LocalDataManager ourInstance = new LocalDataManager();

    private LocalDataManager() {
    }

    static LocalDataManager getInstance() {
        return ourInstance;
    }
}
