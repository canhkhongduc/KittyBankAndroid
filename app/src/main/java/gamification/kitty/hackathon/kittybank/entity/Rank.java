package gamification.kitty.hackathon.kittybank.entity;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class Rank {
    private int rankId;
    private String rankName;
    private int creditPoint;

    public Rank(int rankId, String rankName, int creditPoint) {
        this.rankId = rankId;
        this.rankName = rankName;
        this.creditPoint = creditPoint;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public int getCreditPoint() {
        return creditPoint;
    }

    public void setCreditPoint(int creditPoint) {
        this.creditPoint = creditPoint;
    }
}
