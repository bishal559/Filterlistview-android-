package com.example.filterlistview.Model;

public class ListviewModel {
    private int id;
    private String image;
    private String name;
    private String type;
    private String detail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public ListviewModel(int id, String image, String name, String type, String detail) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.type = type;
        this.detail = detail;
    }
}
