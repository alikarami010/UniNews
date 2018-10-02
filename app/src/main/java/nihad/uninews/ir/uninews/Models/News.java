package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 19/08/2018.
 */

public class News extends RealmObject {
    @PrimaryKey
    private String NBrife;
    private String NDesc;
    private String NDat;
    private String Nact;
    private String NImg;
    public String getNBrife() {
        return NBrife;
    }

    public void setNBrife(String NBrife) {
        this.NBrife = NBrife;
    }

    public String getNDesc() {
        return NDesc;
    }

    public void setNDesc(String NDesc) {
        this.NDesc = NDesc;
    }

    public String getNDat() {
        return NDat;
    }

    public void setNDat(String NDat) {
        this.NDat = NDat;
    }

    public String getNact() {
        return Nact;
    }

    public void setNact(String nact) {
        Nact = nact;
    }
    public String getNImg() {
        return NImg;
    }

    public void setNImg(String NImg) {
        this.NImg = NImg;
    }
}
