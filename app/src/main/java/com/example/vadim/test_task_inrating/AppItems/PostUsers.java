package com.example.vadim.test_task_inrating.AppItems;

public class PostUsers
{
    private User[] usersLiked;
    private User[] usersCommented;
    private User[] usersReposted;
    private User[] usersMantioned;
    private int mantions;

    public PostUsers(User[] usersLiked, User[] usersCommented, User[] usersReposted, User[] usersMantioned, int mantions)
    {
        this.usersLiked = usersLiked;
        this.usersCommented = usersCommented;
        this.usersReposted = usersReposted;
        this.usersMantioned = usersMantioned;
        this.mantions = mantions;
    }

    public User[] getUsersLiked() {
        return usersLiked;
    }

    public User[] getUsersCommented() {
        return usersCommented;
    }

    public User[] getUsersReposted() {
        return usersReposted;
    }

    public User[] getUsersMansioned() {
        return usersMantioned;
    }

    public int getMansions() {return mantions;}

    @Override
    public String toString()
    {
        for(User user : usersLiked){System.out.println(user.nickName+"-----"+user.pictureURL);System.out.println("Liked-----------------------------------");}
        for(User user : usersCommented){System.out.println(user.nickName+"-----"+user.pictureURL);System.out.println("Commented----------------------------------");}
        for(User user : usersReposted){System.out.println(user.nickName+"-----"+user.pictureURL);System.out.println("Reposted-----------------------------------");}
        for(User user : usersMantioned){System.out.println(user.nickName+"-----"+user.pictureURL);System.out.println("Mantioned-----------------------------------");}
        System.out.println("mantions "+mantions);
        return null;
    }
}
