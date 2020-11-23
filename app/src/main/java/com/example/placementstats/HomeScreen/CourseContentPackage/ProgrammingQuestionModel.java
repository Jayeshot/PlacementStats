package com.example.placementstats.HomeScreen.CourseContentPackage;

public class ProgrammingQuestionModel {
    private String question,topicTag,url,solution;

    public ProgrammingQuestionModel() {
    }

    public ProgrammingQuestionModel(String question, String topicTag, String url, String solution) {
        this.question = question;
        this.topicTag = topicTag;
        this.url = url;
        this.solution = solution;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTopicTag() {
        return topicTag;
    }

    public void setTopicTag(String topicTag) {
        this.topicTag = topicTag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
