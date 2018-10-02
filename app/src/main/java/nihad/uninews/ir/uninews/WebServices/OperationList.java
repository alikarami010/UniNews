package nihad.uninews.ir.uninews.WebServices;

public enum OperationList {
    ActiveDaneshgah("ActiveDaneshgah",0),
    ActiveDaneshjoo("ActiveDaneshjoo",1),
    ActiveDars("ActiveDars",2),
    ActiveMaqtae("ActiveMaqtae",3),
    ActiveOstad("ActiveOstad",4),
    ChangeDaneshjoo("ChangeDaneshjoo",5),
    ChangeDars("ChangeDars",6),
    ChangeMaqtae("ChangeMaqtae",7),
    ChangePassDaneshgah("ChangePassDaneshgah",8),
    ChangeTerm("ChangeTerm",9),
    DeActiveDaneshgah("DeActiveDaneshgah",10),
    DeActiveDaneshjoo("DeActiveDaneshjoo",11),
    DeActiveDars("DeActiveDars",12),
    DeActiveMaqtae("DeActiveMaqtae",13),
    DeActiveOstad("DeActiveOstad",14),
    DeleteDaneshjoDars("DeleteDaneshjoDars",15),
    DeleteOstadDars("DeleteOstadDars",16),
    InsertDaneshgah("InsertDaneshgah",17),
    InsertDaneshjoDars("InsertDaneshjoDars",18),
    InsertDaneshjoo("InsertDaneshjoo",19),
    InsertDars("InsertDars",20),
    InsertMaqtae("InsertMaqtae",21),
    InsertOstad("InsertOstad",22),
    InsertOstadDars("InsertOstadDars",23),
    InsertPublicNews("InsertPublicNews",24),
    InsertTerm("InsertTerm",25),
    SelectDaneshgahById("SelectDaneshgahById",26),
    SelectDaneshjoDars("SelectDaneshjoDars",27),
    SelectDaneshjooByDaneshgah("SelectDaneshjooByDaneshgah",28),
    SelectDaneshjooByDars("SelectDaneshjooByDars",29),
    SelectDaneshjooById("SelectDaneshjooById",30),
    SelectDaneshjooByOstad("SelectDaneshjooByOstad",31),
    SelectDaneshjooByReshte("SelectDaneshjooByReshte",32),
    SelectKolDaneshgah("SelectKolDaneshgah",33),
    SelectKolDaneshjoo("SelectKolDaneshjoo",34),
    SelectKolDars("SelectKolDars",35),
    SelectKolOstad("SelectKolOstad",36),
    SelectMaqtae("SelectMaqtae",37),
    SelectOstadByDaneshjoo("SelectOstadByDaneshjoo",38),
    SelectOstadByDars("SelectOstadByDars",39),
    SelectOstadDars("SelectOstadDars",40),
    SelectPublicNews("SelectPublicNews",41),
    SelectZtblReshte("SelectZtblReshte",42),
    SelectTerm("SelectTerm",43);

    private int intValue;
    private String stringValue;

    private OperationList(String toString, int value) {
        this.stringValue = toString;
        this.intValue = value;
    }

    public String toString() {
        return this.stringValue;
    }
}
