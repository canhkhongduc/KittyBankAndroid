package gamification.kitty.hackathon.kittybank.entity;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class TransactionType {
    private int id;
    private String typeName;
    private Double rewardRate;

    public TransactionType(int id, String typeName, Double rewardRate) {
        this.id = id;
        this.typeName = typeName;
        this.rewardRate = rewardRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(Double rewardRate) {
        this.rewardRate = rewardRate;
    }
}
