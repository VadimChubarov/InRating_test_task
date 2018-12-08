package com.example.vadim.test_task_inrating.AppItems;

public class PostData
{
    private int views;
    private int likes;
    private int comments;
    private int reposts;
    private int bookMarks;

    public PostData(int views, int likes, int comments, int reposts, int bookMarks)
    {
        this.views = views;
        this.likes = likes;
        this.comments = comments;
        this.reposts = reposts;
        this.bookMarks = bookMarks;

    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public int getReposts() {
        return reposts;
    }

    public int getBookMarks() {
        return bookMarks;
    }

    @Override
    public String toString()
    {
        return views+"---"+likes+"---"+comments+"---"+reposts+"---"+bookMarks;
    }
}
