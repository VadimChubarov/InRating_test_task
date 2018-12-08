package com.example.vadim.test_task_inrating;

import android.os.Handler;
import com.example.vadim.test_task_inrating.AppItems.PostData;
import com.example.vadim.test_task_inrating.AppItems.PostUsers;
import com.example.vadim.test_task_inrating.AppItems.User;
import com.example.vadim.test_task_inrating.POJO.PostInfo;
import com.example.vadim.test_task_inrating.POJO.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.HashMap;
import java.util.Map;

public class CoreLogic implements AppInterface.Model
{
  private AppInterface.API InRatingAPI;
  private PostInfo postInfo;
  private Users usersLiked;
  private Users usersReposted;
  private Users usersCommented;
  private Users usersMentioned;
  private Handler requestLauncher;

  private boolean isRequestInProgress;

  private Map<String,String> requestErrors;

  public CoreLogic ()
  {
      Retrofit downLoader = new Retrofit.Builder()
                .baseUrl("https://api.inrating.top")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

      this.InRatingAPI = downLoader.create(AppInterface.API.class);

      this.requestErrors = new HashMap<>();
      requestErrors.put(AppManager.AppFilter.POST,"No Errors");
      requestErrors.put(AppManager.AppFilter.LIKE,"No Errors");
      requestErrors.put(AppManager.AppFilter.COMMENT,"No Errors");
      requestErrors.put(AppManager.AppFilter.REPOST,"No Errors");
      requestErrors.put(AppManager.AppFilter.MANTION,"No Errors");

      this.requestLauncher = new Handler();
  }

    public PostInfo getPostInfo() {return postInfo;}

    public void setPostInfo(PostInfo postInfo) { this.postInfo = postInfo;}

    public void setUsersLiked(Users usersLiked) {this.usersLiked = usersLiked; }

    public void setUsersReposted(Users usersReposted) {this.usersReposted = usersReposted; }

    public void setUsersCommented(Users usersCommented) {this.usersCommented = usersCommented;}

    public void setUsersMentioned(Users usersMentioned) {this.usersMentioned = usersMentioned;}

    public void setError(String filter, String error){requestErrors.put(filter,error);}

    public String getError(String filter){return requestErrors.get(filter);}

    public boolean isRequestInProgress() {return isRequestInProgress;}

    public void setRequestInProgress(boolean requestInProgress) {isRequestInProgress = requestInProgress;}

    public void requestPostInfo(String slug, Callback<PostInfo> instruction)
  {
      isRequestInProgress = true;
      postInfo = null;
      Call<PostInfo> postInfoCall = InRatingAPI.getPostInfo(slug);
      postInfoCall.enqueue(instruction);
  }

    public void requestUsers(final String filter,final Callback<Users> instruction, Integer id, int delay)
    {
        isRequestInProgress = true;
        final Call<Users> usersCall;
        switch (filter)
        {
            case AppManager.AppFilter.LIKE : usersCall = InRatingAPI.getUsersLiked(id); usersLiked = null; break;
            case AppManager.AppFilter.REPOST : usersCall = InRatingAPI.getUsersReposted(id); usersReposted = null; break;
            case AppManager.AppFilter.COMMENT : usersCall = InRatingAPI.getUsersCommented(id); usersCommented = null; break;
            case AppManager.AppFilter.MANTION : usersCall = InRatingAPI.getUsersMentioned(id); usersMentioned = null ; break;
            default: usersCall = null;
        }

        if (usersCall!=null)
        {
            requestLauncher.postDelayed(new Runnable()
            {@Override public void run() {usersCall.enqueue(instruction);}},delay);  //запуск запросов отдельно от UI потока с задержкой в мсек, на случай лимита на сервере.
                                                                                         //установлено 4 запроса в сек
        }
    }

    public boolean RequestPostInfoReady()
    {
        if(postInfo!=null)
        {return true;}
        else{return false;}
    }

    public boolean RequestPostUsersReady()
    {
        if(usersLiked!=null && usersReposted!=null && usersCommented!=null && usersMentioned!=null)
        {return true;}
        else{return false;}
    }

   public PostData collectPostData()
   {
       if(RequestPostInfoReady())
       {
           int views = postInfo.getViewsCount();
           int likes = postInfo.getLikesCount();
           int reposts = postInfo.getRepostsCount();
           int comments = postInfo.getCommentsCount();
           int bookmarks = postInfo.getBookmarksCount();

           return new PostData(views,likes,comments,reposts,bookmarks);
      }

      return null;
   }

   public PostUsers collectPostUsers()
   {
       if(RequestPostUsersReady())
       {
           User[] usersLiked = collectUsersFrom(this.usersLiked);
           User[] usersReposted = collectUsersFrom(this.usersReposted);
           User[] usersCommented = collectUsersFrom(this.usersCommented);
           User[] usersMentioned = collectUsersFrom(this.usersMentioned);

           return  new PostUsers(usersLiked,usersCommented,usersReposted,usersMentioned,usersMentioned.length);
       }
      return null;
   }

   public User[] collectUsersFrom(Users source)
   {
       User[] users = new User[source.getData().size()];
       for(int i = 0; i < users.length; i++)
       {
           String nickName = source.getData().get(i).getNickname();
           String pictureURL = source.getData().get(i).getAvatarImage().getUrlSmall();
           users[i] = new User(nickName,pictureURL);
       }
       return users;
   }
}
