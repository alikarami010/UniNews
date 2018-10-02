package nihad.uninews.ir.uninews.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ali on 30/04/2018.
 */

public class AppSetting extends RealmObject {
    @PrimaryKey
    private int ID;
    private int NewMessageCount;
    private String Today;

    public boolean isReadMessages() {
        return ReadMessages;
    }

    public void setReadMessages(boolean readMessages) {
        ReadMessages = readMessages;
    }

    private boolean ReadMessages;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNewMessageCount() {
        return NewMessageCount;
    }

    public void setNewMessageCount(int newMessageCount) {
        NewMessageCount = newMessageCount;
    }

    public String getToday() {
        return Today;
    }

    public void setToday(String today) {
        Today = today;
    }
}
