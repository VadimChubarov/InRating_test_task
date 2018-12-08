package com.example.vadim.test_task_inrating.AppItems;

public class User
    {
        String pictureURL;
        String nickName;

        public User(String nickName, String pictureURL)
        {
            this.nickName = nickName;
            this.pictureURL = pictureURL;
        }

        public void setPictureURL(String pictureURL) {
            this.pictureURL = pictureURL;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPictureURL() {return pictureURL;}

        public String getNickName() {return nickName;}
    }