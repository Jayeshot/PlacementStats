package com.example.placementstats.HomeScreen.Models;

public class CourseContentItemModel {
    private String id,courseName,courseItemName,courseAbout,thumbnail;

    public CourseContentItemModel() {
    }

    public CourseContentItemModel(String id, String courseName, String courseItemName, String courseAbout, String thumbnail) {
        this.id = id;
        this.courseName = courseName;
        this.courseItemName = courseItemName;
        this.courseAbout = courseAbout;
        this.thumbnail = thumbnail;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseItemName() {
        return courseItemName;
    }

    public void setCourseItemName(String courseItemName) {
        this.courseItemName = courseItemName;
    }

    public String getCourseAbout() {
        return courseAbout;
    }

    public void setCourseAbout(String courseAbout) {
        this.courseAbout = courseAbout;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }


}
