package gamification.kitty.hackathon.kittybank.entity;

import java.sql.Date;

/**
 * Created by Khổng Cảnh on 4/20/2018.
 */

public class Event {
    private int id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String xmlPath;
    private int experience;
    private byte isDeleted;

    public Event(int id, String name, Date startDate, Date endDate, String xmlPath, int experience, byte isDeleted) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.xmlPath = xmlPath;
        this.experience = experience;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getXmlPath() {
        return xmlPath;
    }

    public void setXmlPath(String xmlPath) {
        this.xmlPath = xmlPath;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
