package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 19/08/2018.
 */

public class Dars extends RealmObject {
    @PrimaryKey
    private String DarsId;
    private String DarsNam;
    private String ReshteId;
    private String ReshteNam;
    private String MaqtaeID;
    private String MaqtaeNam;

    public String getDarsId() {
        return DarsId;
    }

    public void setDarsId(String darsId) {
        DarsId = darsId;
    }

    public String getDarsNam() {
        return DarsNam;
    }

    public void setDarsNam(String darsNam) {
        DarsNam = darsNam;
    }

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

    public String getMaqtaeNam() {
        return MaqtaeNam;
    }

    public void setMaqtaeNam(String maqtaeNam) {
        MaqtaeNam = maqtaeNam;
    }
}
