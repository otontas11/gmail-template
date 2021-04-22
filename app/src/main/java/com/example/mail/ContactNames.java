package com.example.mail;

public class ContactNames {
     String fullname;
    String time;
    String title;
    String Des;
    int color;
    int avatarResource;
    boolean isSelected;


    public ContactNames(String fullname, String time, String title, String des, int color, int avatarResource) {
        this.fullname = fullname;
        this.time = time;
        this.title = title;
        Des = des;
        this.color = color;
        this.avatarResource = avatarResource;
        this.isSelected = isSelected;
    }

    public String getTime() {
        return time;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return Des;
    }

    public String getTextRound() {
        return fullname.substring(0, 1);
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public boolean isSelected() {
        return isSelected;
    }


    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}