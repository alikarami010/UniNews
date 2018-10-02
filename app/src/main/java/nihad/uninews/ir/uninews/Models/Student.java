package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 19/08/2018.
 */

public class Student extends RealmObject {
    @PrimaryKey
    private String _imei;
    private String _iddaneshjo;
    private String _namdaneshjo;
    private String _daneshjodaneshgah;
    private String _daneshjomaqtae;
    private String _daneshjoreshte;
    private String _daneshjopassword;
    private String _namdaneshgah;
    private String _nammaqtae;
    private String _namreshte;


    public String get_imei() {
        return _imei;
    }

    public void set_imei(String _imei) {
        this._imei = _imei;
    }

    public String get_iddaneshjo() {
        return _iddaneshjo;
    }

    public void set_iddaneshjo(String _iddaneshjo) {
        this._iddaneshjo = _iddaneshjo;
    }

    public String get_namdaneshjo() {
        return _namdaneshjo;
    }

    public void set_namdaneshjo(String _namdaneshjo) {
        this._namdaneshjo = _namdaneshjo;
    }

    public String get_daneshjodaneshgah() {
        return _daneshjodaneshgah;
    }

    public void set_daneshjodaneshgah(String _daneshjodaneshgah) {
        this._daneshjodaneshgah = _daneshjodaneshgah;
    }

    public String get_daneshjomaqtae() {
        return _daneshjomaqtae;
    }

    public void set_daneshjomaqtae(String _daneshjomaqtae) {
        this._daneshjomaqtae = _daneshjomaqtae;
    }

    public String get_daneshjoreshte() {
        return _daneshjoreshte;
    }

    public void set_daneshjoreshte(String _daneshjoreshte) {
        this._daneshjoreshte = _daneshjoreshte;
    }

    public String get_daneshjopassword() {
        return _daneshjopassword;
    }

    public void set_daneshjopassword(String _daneshjopassword) {
        this._daneshjopassword = _daneshjopassword;
    }

    public String get_namdaneshgah() {
        return _namdaneshgah;
    }

    public void set_namdaneshgah(String _namdaneshgah) {
        this._namdaneshgah = _namdaneshgah;
    }

    public String get_nammaqtae() {
        return _nammaqtae;
    }

    public void set_nammaqtae(String _nammaqtae) {
        this._nammaqtae = _nammaqtae;
    }

    public String get_namreshte() {
        return _namreshte;
    }

    public void set_namreshte(String _namreshte) {
        this._namreshte = _namreshte;
    }
}
