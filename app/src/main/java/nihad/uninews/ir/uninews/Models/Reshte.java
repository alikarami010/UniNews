package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 19/08/2018.
 */

public class Reshte extends RealmObject {
    @PrimaryKey
    private String ReshteId;
    private String ReshteNam;
    private String MaqtaeID;

    public String getReshteId() {
        return ReshteId;
    }

    public void setReshteId(String reshteId) {
        ReshteId = reshteId;
    }

    public String getReshteNam() {
        return ReshteNam;
    }

    public void setReshteNam(String reshteNam) {
        ReshteNam = reshteNam;
    }

    public String getMaqtaeID() {
        return MaqtaeID;
    }

    public void setMaqtaeID(String maqtaeID) {
        MaqtaeID = maqtaeID;
    }
}
