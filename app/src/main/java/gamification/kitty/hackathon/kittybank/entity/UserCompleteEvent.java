package gamification.kitty.hackathon.kittybank.entity;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class UserCompleteEvent {
    private int userId;
    private int eventId;
    private byte isCompleted;

    public UserCompleteEvent(int userId, int eventId, byte isCompleted) {
        this.userId = userId;
        this.eventId = eventId;
        this.isCompleted = isCompleted;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public byte getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(byte isCompleted) {
        this.isCompleted = isCompleted;
    }
}
