package gamification.kitty.hackathon.kittybank.entity;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class KittyType {
    private int id;
    private String name;
    private byte gender;
    private String image;
    private byte isDeleted;

    public KittyType(int id, String name, byte gender, String image, byte isDeleted) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.image = image;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
