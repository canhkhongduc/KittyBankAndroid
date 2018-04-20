package gamification.kitty.hackathon.kittybank.entity;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class Transaction {
    private int id;
    private int senderId;
    private int receiverId;
    private float balance;
    private int date;
    private int typeId;
    private String message;
    private int creditPoint;

    public Transaction(int id, int senderId, int receiverId, float balance, int date, int typeId, String message, int creditPoint) {
        this.id = id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.balance = balance;
        this.date = date;
        this.typeId = typeId;
        this.message = message;
        this.creditPoint = creditPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }
}
