package com.example.vadim.test_task_inrating;

import android.view.View;
import com.example.vadim.test_task_inrating.Activities.MainActivity;
import com.example.vadim.test_task_inrating.AppItems.PostData;
import com.example.vadim.test_task_inrating.AppItems.PostUsers;
import com.example.vadim.test_task_inrating.POJO.PostInfo;
import com.example.vadim.test_task_inrating.POJO.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppManager implements AppInterface.Presenter
{
    private CoreLogic coreLogic;
    private MainActivity mainActivity;
    private static AppManager appManager;
    private String slug;

    private PostData postData;
    private PostUsers postUsers;

    public  AppManager(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
        this.coreLogic = new CoreLogic();
        appManager = this;
    }

    public static AppManager getInstance() {return appManager;}

    public void setMainActivity(MainActivity mainActivity) {this.mainActivity = mainActivity; System.gc();}

    public CoreLogic getCoreLogic() {return coreLogic;}

    public String getSlug() {return slug;}

    public void setSlug(String slug) {this.slug = slug;}

    public void initilizePostData()
    {
        mainActivity.showLoadingProgress(true);

        Callback<PostInfo> instuction = new Callback<PostInfo>()
        {
            @Override
            public void onResponse(Call<PostInfo> call, Response<PostInfo> response)
            {
                if(response.isSuccessful())
                {
                  coreLogic.setPostInfo(response.body());
                  postData = coreLogic.collectPostData();
                  presentPostData();

                  mainActivity.showLoadingProgress(false);
                  mainActivity.showUsersLoadingProgress(true);

                  int postId = coreLogic.getPostInfo().getId();
                  initilizePostUsers(AppFilter.LIKE,postId,0);
                  initilizePostUsers(AppFilter.REPOST,postId,250);
                  initilizePostUsers(AppFilter.COMMENT,postId,500);
                  initilizePostUsers(AppFilter.MANTION,postId,750);
                }
                else{System.out.println("response code " + response.code()); coreLogic.setError("POST",String.valueOf(response.code()));}
            }
            @Override
            public void onFailure(Call<PostInfo> call, Throwable t){System.out.println("failure " + t);coreLogic.setError("POST",t.toString());}
        };

        coreLogic.requestPostInfo(slug,instuction);
    }

    public void presentPostData() {mainActivity.showPostData(postData);}

    public void initilizePostUsers(final String filter, int postId, int delay)
    {

        Callback<Users> instruction = new Callback<Users>()
        {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response)
            {
                if(response.isSuccessful())
                {
                    switch (filter)
                    {
                        case AppFilter.LIKE : coreLogic.setUsersLiked(response.body());
                                      if(coreLogic.RequestPostUsersReady()){postUsers = coreLogic.collectPostUsers();presentPostUsersData();}break;

                        case AppFilter.REPOST : coreLogic.setUsersReposted(response.body());
                                        if(coreLogic.RequestPostUsersReady()){postUsers = coreLogic.collectPostUsers();presentPostUsersData();}break;

                        case AppFilter.COMMENT : coreLogic.setUsersCommented(response.body());
                                         if(coreLogic.RequestPostUsersReady()){postUsers = coreLogic.collectPostUsers();presentPostUsersData();}break;

                        case AppFilter.MANTION : coreLogic.setUsersMentioned(response.body());
                                         if(coreLogic.RequestPostUsersReady()){postUsers = coreLogic.collectPostUsers();presentPostUsersData();}break;
                    }
                }
                else{System.out.println("response code " + response.code());coreLogic.setError(filter,String.valueOf(response.code()));}
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t)
            {System.out.println("failure " + t);coreLogic.setError(filter,t.toString());}
        };
        coreLogic.requestUsers(filter,instruction,postId,delay);
    }

    public void presentPostUsersData() {mainActivity.showPostUsersData(postUsers);mainActivity.showUsersLoadingProgress(false);}

    public void refreshAllPostData()
    {
        initilizePostData();
    }

    public class AppListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.toolbar_refresh : if (coreLogic.RequestPostInfoReady() && coreLogic.RequestPostUsersReady())
                                            {AppManager.this.refreshAllPostData();}break;

                case R.id.button_home : mainActivity.finish();break;
            }
        }
    }

    public class AppFilter
    {
        public static final String LIKE = "LIKE";
        public static final String REPOST = "REPOST";
        public static final String COMMENT = "COMMENT";
        public static final String MANTION = "MANTION";
        public static final String POST = "POST";
    }

}
