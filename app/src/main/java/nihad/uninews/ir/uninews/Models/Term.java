package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 11/09/2018.
 */

public class Term extends RealmObject {
    @PrimaryKey
    private String TermID;
    private String TermNam;

    public String getTermID() {
        return TermID;
    }

    public void setTermID(String termID) {
        TermID = termID;
    }

    public String getTermNam() {
        return TermNam;
    }

    public void setTermNam(String termNam) {
        TermNam = termNam;
    }



}
