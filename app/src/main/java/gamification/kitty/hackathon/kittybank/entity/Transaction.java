package gamification.kitty.hackathon.kittybank.entity;

import java.sql.Date;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class Transaction {
    private int id;
    private String senderAccount;
    private String receiverAccount;
    private String receiverName;
    private float balance;
    private Date date;
    private int typeId;
    private String message;
    private int creditPoint;

    public Transaction(int id, String senderAccount, String receiverAccount, String receiverName, float balance, Date date, int typeId, String message, int creditPoint) {
        this.id = id;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.receiverName = receiverName;
        this.balance = balance;
        this.date = date;
        this.typeId = typeId;
        this.message = message;
        this.creditPoint = creditPoint;
    }

    public Transaction(String senderAccount, String receiverAccount, String receiverName, float balance, Date date, int typeId, String message, int creditPoint) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.receiverName = receiverName;
        this.balance = balance;
        this.date = date;
        this.typeId = typeId;
        this.message = message;
        this.creditPoint = creditPoint;
    }

    public int getId() {
        return id;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public void setReceiverAccount(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderId(String senderId) {
        this.senderAccount = senderAccount;
    }

    public String getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverId(String receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
