package gamification.kitty.hackathon.kittybank.entity;

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
    private boolean isDeleted;
    private int hunger;
    private int hygiene;
    private String lastFeedDate;
    private String lastBathDate;

    public Kitty() {
    }

    public Kitty(int id, int userId, int kittyTypeId, String name, byte gender, String image, int price, int level, int experience, int rank, int duration, int lastFeeded, int lastShowered, boolean isDeleted) {
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
        this.isDeleted = isDeleted;
        this.hunger = hunger;
        this.hygiene = hygiene;
        this.lastFeedDate = lastFeedDate;
        this.lastBathDate = lastBathDate;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public String getLastFeedDate() {
        return lastFeedDate;
    }

    public void setLastFeedDate(String lastFeedDate) {
        this.lastFeedDate = lastFeedDate;
    }

    public String getLastBathDate() {
        return lastBathDate;
    }

    public void setLastBathDate(String lastBathDate) {
        this.lastBathDate = lastBathDate;
    }
}
