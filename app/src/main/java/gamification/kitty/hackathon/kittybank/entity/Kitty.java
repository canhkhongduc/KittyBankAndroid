package gamification.kitty.hackathon.kittybank.entity;

import java.sql.Date;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class Kitty {
    private int id;
    private int userId;
    private int kittyTypeId;
    private String name;
    private byte gender;
    private String image;
    private int price;
    private int level;
    private int experience;
    private int rank;
    private int duration;
    private int lastFeeded;
    private int lastShowered;
    private byte isDeleted;

    public Kitty() {
    }

    public Kitty(int id, int userId, int kittyTypeId, String name, byte gender, String image, int price, int level, int experience, int rank, int duration, int lastFeeded, int lastShowered, byte isDeleted) {
        this.id = id;
        this.userId = userId;
        this.kittyTypeId = kittyTypeId;
        this.name = name;
        this.gender = gender;
        this.image = image;
        this.price = price;
        this.level = level;
        this.experience = experience;
        this.rank = rank;
        this.duration = duration;
        this.lastFeeded = lastFeeded;
        this.lastShowered = lastShowered;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getKittyTypeId() {
        return kittyTypeId;
    }

    public void setKittyTypeId(int kittyTypeId) {
        this.kittyTypeId = kittyTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getLastFeeded() {
        return lastFeeded;
    }

    public void setLastFeeded(int lastFeeded) {
        this.lastFeeded = lastFeeded;
    }

    public int getLastShowered() {
        return lastShowered;
    }

    public void setLastShowered(int lastShowered) {
        this.lastShowered = lastShowered;
    }

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
