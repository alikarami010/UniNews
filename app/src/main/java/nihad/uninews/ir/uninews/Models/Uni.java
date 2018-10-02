package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 19/08/2018.
 */

public class Uni extends RealmObject {
    @PrimaryKey
    private String GId;
    private String GNamDaneshgah;
    private String GRabetNam;
    private String GUsername;
    private String GPass;
    private String GAct;
    private String GImg;
    private String GImgDesc;

    public String getGId() {
        return GId;
    }

    public void setGId(String GId) {
        this.GId = GId;
    }

    public String getGNamDaneshgah() {
        return GNamDaneshgah;
    }

    public void setGNamDaneshgah(String GNamDaneshgah) {
        this.GNamDaneshgah = GNamDaneshgah;
    }

    public String getGRabetNam() {
        return GRabetNam;
    }

    public void setGRabetNam(String GRabetNam) {
        this.GRabetNam = GRabetNam;
    }

    public String getGUsername() {
        return GUsername;
    }

    public void setGUsername(String GUsername) {
        this.GUsername = GUsername;
    }

    public String getGPass() {
        return GPass;
    }

    public void setGPass(String GPass) {
        this.GPass = GPass;
    }

    public String getGAct() {
        return GAct;
    }

    public void setGAct(String GAct) {
        this.GAct = GAct;
    }

    public String getGImg() {
        return GImg;
    }

    public void setGImg(String GImg) {
        this.GImg = GImg;
    }
    public String getGImgDesc() {
        return GImgDesc;
    }

    public void setGImgDesc(String GImgDesc) {
        this.GImgDesc = GImgDesc;
    }
}
