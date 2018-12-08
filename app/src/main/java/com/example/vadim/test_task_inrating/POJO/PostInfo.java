
package com.example.vadim.test_task_inrating.POJO;

import java.util.List;

import com.example.vadim.test_task_inrating.AppInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostInfo implements AppInterface.ResponcePOJO
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("type")
    @Expose
    private Integer type;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("attachments")
    @Expose
    private Attachments attachments;
    @SerializedName("site_link")
    @Expose
    private String siteLink;
    @SerializedName("intags")
    @Expose
    private List<Intag> intags = null;
    @SerializedName("place")
    @Expose
    private Object place;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("created_at_timestamp")
    @Expose
    private Integer createdAtTimestamp;
    @SerializedName("is_repost")
    @Expose
    private Boolean isRepost;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("attachments_order")
    @Expose
    private List<AttachmentsOrder> attachmentsOrder = null;
    @SerializedName("is_liked")
    @Expose
    private Boolean isLiked;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("likes_count")
    @Expose
    private Integer likesCount;
    @SerializedName("extra")
    @Expose
    private Object extra;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("is_avatar")
    @Expose
    private Boolean isAvatar;
    @SerializedName("is_bookmarked")
    @Expose
    private Boolean isBookmarked;
    @SerializedName("is_reposted")
    @Expose
    private Boolean isReposted;
    @SerializedName("bookmarks_count")
    @Expose
    private Integer bookmarksCount;
    @SerializedName("reposts_count")
    @Expose
    private Integer repostsCount;
    @SerializedName("views_count")
    @Expose
    private Integer viewsCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Attachments getAttachments() {
        return attachments;
    }

    public void setAttachments(Attachments attachments) {
        this.attachments = attachments;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }

    public List<Intag> getIntags() {
        return intags;
    }

    public void setIntags(List<Intag> intags) {
        this.intags = intags;
    }

    public Object getPlace() {
        return place;
    }

    public void setPlace(Object place) {
        this.place = place;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedAtTimestamp() {
        return createdAtTimestamp;
    }

    public void setCreatedAtTimestamp(Integer createdAtTimestamp) {
        this.createdAtTimestamp = createdAtTimestamp;
    }

    public Boolean getIsRepost() {
        return isRepost;
    }

    public void setIsRepost(Boolean isRepost) {
        this.isRepost = isRepost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AttachmentsOrder> getAttachmentsOrder() {
        return attachmentsOrder;
    }

    public void setAttachmentsOrder(List<AttachmentsOrder> attachmentsOrder) {
        this.attachmentsOrder = attachmentsOrder;
    }

    public Boolean getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Boolean isLiked) {
        this.isLiked = isLiked;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Boolean getIsAvatar() {
        return isAvatar;
    }

    public void setIsAvatar(Boolean isAvatar) {
        this.isAvatar = isAvatar;
    }

    public Boolean getIsBookmarked() {
        return isBookmarked;
    }

    public void setIsBookmarked(Boolean isBookmarked) {
        this.isBookmarked = isBookmarked;
    }

    public Boolean getIsReposted() {
        return isReposted;
    }

    public void setIsReposted(Boolean isReposted) {
        this.isReposted = isReposted;
    }

    public Integer getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(Integer bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

    public Integer getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(Integer repostsCount) {
        this.repostsCount = repostsCount;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public class Attachments
    {

        @SerializedName("images")
        @Expose
        private List<Image> images = null;
        @SerializedName("videos")
        @Expose
        private Object videos;
        @SerializedName("posts")
        @Expose
        private Object posts;

        public List<Image> getImages() {
            return images;
        }

        public void setImages(List<Image> images) {
            this.images = images;
        }

        public Object getVideos() {
            return videos;
        }

        public void setVideos(Object videos) {
            this.videos = videos;
        }

        public Object getPosts() {
            return posts;
        }

        public void setPosts(Object posts) {
            this.posts = posts;
        }

    }

    public class AttachmentsOrder
    {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("type")
        @Expose
        private String type;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    public class Author
    {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("avatar_image")
    @Expose
    private AvatarImage avatarImage;
    @SerializedName("active_gift")
    @Expose
    private Object activeGift;
    @SerializedName("off_page")
    @Expose
    private Boolean offPage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("is_subscribed")
    @Expose
    private Boolean isSubscribed;
    @SerializedName("is_online")
    @Expose
    private Boolean isOnline;
    @SerializedName("last_online_timestamp")
    @Expose
    private Integer lastOnlineTimestamp;
    @SerializedName("in_my_blacklist")
    @Expose
    private Boolean inMyBlacklist;
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("contest_entry_instance")
    @Expose
    private Object contestEntryInstance;
    @SerializedName("chat_main_lang")
    @Expose
    private String chatMainLang;
    @SerializedName("is_voted")
    @Expose
    private Boolean isVoted;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(AvatarImage avatarImage) {
        this.avatarImage = avatarImage;
    }

    public Object getActiveGift() {
        return activeGift;
    }

    public void setActiveGift(Object activeGift) {
        this.activeGift = activeGift;
    }

    public Boolean getOffPage() {
        return offPage;
    }

    public void setOffPage(Boolean offPage) {
        this.offPage = offPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public Boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Boolean isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getLastOnlineTimestamp() {
        return lastOnlineTimestamp;
    }

    public void setLastOnlineTimestamp(Integer lastOnlineTimestamp) {
        this.lastOnlineTimestamp = lastOnlineTimestamp;
    }

    public Boolean getInMyBlacklist() {
        return inMyBlacklist;
    }

    public void setInMyBlacklist(Boolean inMyBlacklist) {
        this.inMyBlacklist = inMyBlacklist;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Object getContestEntryInstance() {
        return contestEntryInstance;
    }

    public void setContestEntryInstance(Object contestEntryInstance) {
        this.contestEntryInstance = contestEntryInstance;
    }

    public String getChatMainLang() {
        return chatMainLang;
    }

    public void setChatMainLang(String chatMainLang) {
        this.chatMainLang = chatMainLang;
    }

    public Boolean getIsVoted() {
        return isVoted;
    }

    public void setIsVoted(Boolean isVoted) {
        this.isVoted = isVoted;
    }

}

public class AvatarImage
{

    @SerializedName("url_medium")
    @Expose
    private String urlMedium;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("url_large")
    @Expose
    private String urlLarge;
    @SerializedName("url_small")
    @Expose
    private String urlSmall;
    @SerializedName("mentioned_users_count")
    @Expose
    private Integer mentionedUsersCount;

    public String getUrlMedium() {
        return urlMedium;
    }

    public void setUrlMedium(String urlMedium) {
        this.urlMedium = urlMedium;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlLarge() {
        return urlLarge;
    }

    public void setUrlLarge(String urlLarge) {
        this.urlLarge = urlLarge;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public Integer getMentionedUsersCount() {
        return mentionedUsersCount;
    }

    public void setMentionedUsersCount(Integer mentionedUsersCount) {
        this.mentionedUsersCount = mentionedUsersCount;
    }

}

    public class Image
    {

        @SerializedName("url_medium")
        @Expose
        private String urlMedium;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("url_large")
        @Expose
        private String urlLarge;
        @SerializedName("url_small")
        @Expose
        private String urlSmall;
        @SerializedName("mentioned_users_count")
        @Expose
        private Integer mentionedUsersCount;

        public String getUrlMedium() {
            return urlMedium;
        }

        public void setUrlMedium(String urlMedium) {
            this.urlMedium = urlMedium;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlLarge() {
            return urlLarge;
        }

        public void setUrlLarge(String urlLarge) {
            this.urlLarge = urlLarge;
        }

        public String getUrlSmall() {
            return urlSmall;
        }

        public void setUrlSmall(String urlSmall) {
            this.urlSmall = urlSmall;
        }

        public Integer getMentionedUsersCount() {
            return mentionedUsersCount;
        }

        public void setMentionedUsersCount(Integer mentionedUsersCount) {
            this.mentionedUsersCount = mentionedUsersCount;
        }

    }

    public class Intag
    {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

    public class Rating
    {

        @SerializedName("level")
        @Expose
        private Integer level;
        @SerializedName("value")
        @Expose
        private Integer value;
        @SerializedName("proportion")
        @Expose
        private Float proportion;

        public Integer getLevel() {
            return level;
        }

        public void setLevel(Integer level) {
            this.level = level;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Float getProportion() {
            return proportion;
        }

        public void setProportion(Float proportion) {
            this.proportion = proportion;
        }

    }

    @Override
    public String toString()
    {
        StringBuilder postInfoString = new StringBuilder();

        postInfoString.append(getId());
        postInfoString.append("-id   ");

        postInfoString.append(getSlug());
        postInfoString.append("-slug  ");

        postInfoString.append(getTitle());
        postInfoString.append("-title  ");

        postInfoString.append(getViewsCount());
        postInfoString.append("-views  ");

        return postInfoString.toString();
    }
}
