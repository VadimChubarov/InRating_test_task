
package com.example.vadim.test_task_inrating.POJO;

import java.util.List;

import com.example.vadim.test_task_inrating.AppInterface;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Users implements AppInterface.ResponcePOJO
{

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("meta")
    @Expose
    private Meta meta;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
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

    public class Datum {

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
        @SerializedName("multiplier")
        @Expose
        private Integer multiplier;

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

        public Integer getMultiplier() {
            return multiplier;
        }

        public void setMultiplier(Integer multiplier) {
            this.multiplier = multiplier;
        }

    }

    public class Links {

        @SerializedName("first")
        @Expose
        private String first;
        @SerializedName("last")
        @Expose
        private String last;
        @SerializedName("prev")
        @Expose
        private Object prev;
        @SerializedName("next")
        @Expose
        private Object next;

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public Object getPrev() {
            return prev;
        }

        public void setPrev(Object prev) {
            this.prev = prev;
        }

        public Object getNext() {
            return next;
        }

        public void setNext(Object next) {
            this.next = next;
        }

    }

    public class Meta {

        @SerializedName("current_page")
        @Expose
        private Integer currentPage;
        @SerializedName("from")
        @Expose
        private Integer from;
        @SerializedName("last_page")
        @Expose
        private Integer lastPage;
        @SerializedName("path")
        @Expose
        private String path;
        @SerializedName("per_page")
        @Expose
        private Integer perPage;
        @SerializedName("to")
        @Expose
        private Integer to;
        @SerializedName("total")
        @Expose
        private Integer total;

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getFrom() {
            return from;
        }

        public void setFrom(Integer from) {
            this.from = from;
        }

        public Integer getLastPage() {
            return lastPage;
        }

        public void setLastPage(Integer lastPage) {
            this.lastPage = lastPage;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Integer getTo() {
            return to;
        }

        public void setTo(Integer to) {
            this.to = to;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

    }

    @Override
    public String toString()
    {
        StringBuilder postInfoString = new StringBuilder();

        List<Datum> users = getData();
        for(Datum data : users)
        {
            postInfoString.append(data.getId());
            postInfoString.append("-id   ");
            postInfoString.append(data.getNickname());
            postInfoString.append("-NickName   ");
            postInfoString.append("\n");
        }
        if(postInfoString.toString().length()==0){postInfoString.append("no any users found");postInfoString.append(getLinks().getLast());}

        return postInfoString.toString();
    }


}
