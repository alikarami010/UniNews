package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 19/08/2018.
 */

public class Maghta extends RealmObject {
    @PrimaryKey
    private String MaqtaeID;
    private String MaqtaeNam;

    public String getMaqtaeID() {
        return MaqtaeID;
    }

    public void setMaqtaeID(String maqtaeID) {
        MaqtaeID = maqtaeID;
    }

    public String getMaqtaeNam() {
        return MaqtaeNam;
    }

    public void setMaqtaeNam(String maqtaeNam) {
        MaqtaeNam = maqtaeNam;
    }
}
