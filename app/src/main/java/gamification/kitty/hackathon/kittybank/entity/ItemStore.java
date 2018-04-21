package gamification.kitty.hackathon.kittybank.entity;

/**
 * Created by User on 4/21/2018.
 */

public class ItemStore {
    private int id;
    private String name;
    private int price;
    private int experience;
    private String image;
    private int energy;
    private byte isDeleted;
    private String description;

    public ItemStore() {
    }

    public ItemStore(int id, String name, int price, String image, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public ItemStore(int id, String name, int price, int experience, String image, int energy, byte isDeleted, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.experience = experience;
        this.image = image;
        this.energy = energy;
        this.isDeleted = isDeleted;
        this.description = description;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
