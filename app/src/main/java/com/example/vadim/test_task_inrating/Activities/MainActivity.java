package com.example.vadim.test_task_inrating.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.example.vadim.test_task_inrating.AppInterface;
import com.example.vadim.test_task_inrating.AppItems.PostData;
import com.example.vadim.test_task_inrating.AppItems.PostUsers;
import com.example.vadim.test_task_inrating.AppManager;
import com.example.vadim.test_task_inrating.R;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements AppInterface.View
{
    private PostDataFragment viewsFragment;
    private PostDataFragment bookmarksFragment;
    private UserDataFragment userRepostsFragment;
    private UserDataFragment userLikedFragment;
    private UserDataFragment userCommentedFragment;
    private UserDataFragment userMantionedFragment;
    private ProgressBar progressBar;
    private RelativeLayout fragmentsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null)
        {
            AppManager appManager = new AppManager(this);

            appManager.setSlug("LeBxOWT5zSemiSvkuqBLXFjXlaA0bJlX");
            //appManager.setSlug("qblILAgOuUzhoNY3Oec7G26IGIZHOIGe");
            //appManager.setSlug("fgSap0XgqIpkyFuIZCvgU1GghVs9xdGN");
            //appManager.setSlug("2KLISSh9gRBhRzgQrhiim1cGilGuSZDV");

            initilizeAllViews();
            appManager.initilizePostData();
        }
        else
            {
                AppManager appManager = AppManager.getInstance();
                appManager.setMainActivity(this);
                initilizeAllViews();
                appManager.presentPostData();
                appManager.presentPostUsersData();
            }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void showPostData(PostData postData)
    {
       viewsFragment.showDataQty(String.valueOf(postData.getViews()));
       bookmarksFragment.showDataQty(String.valueOf(postData.getBookMarks()));
       userRepostsFragment.showDataQty(String.valueOf(postData.getReposts()));
       userLikedFragment.showDataQty(String.valueOf(postData.getLikes()));
       userCommentedFragment.showDataQty(String.valueOf(postData.getComments()));
    }

    public void showPostUsersData(PostUsers postUsers)
    {
       userLikedFragment.showRecyclerItems(Arrays.asList(postUsers.getUsersLiked()));
       userCommentedFragment.showRecyclerItems(Arrays.asList(postUsers.getUsersCommented()));
       userRepostsFragment.showRecyclerItems(Arrays.asList(postUsers.getUsersReposted()));
       userMantionedFragment.showDataQty(String.valueOf(postUsers.getMansions()));
       userMantionedFragment.showRecyclerItems(Arrays.asList(postUsers.getUsersMansioned()));
    }

    public void showLoadingProgress(boolean show)
    {
        if(show){progressBar.setVisibility(View.VISIBLE);fragmentsLayout.setVisibility(View.INVISIBLE);}
        else{progressBar.setVisibility(View.INVISIBLE);fragmentsLayout.setVisibility(View.VISIBLE);}
    }

    public void showUsersLoadingProgress(boolean show)
    {
        userLikedFragment.showLoadingProgress(show);
        userRepostsFragment.showLoadingProgress(show);
        userCommentedFragment.showLoadingProgress(show);
        userMantionedFragment.showLoadingProgress(show);
    }

    public void initilizeAllViews()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        progressBar = findViewById(R.id.post_loading_progress);
        fragmentsLayout = findViewById(R.id.fragment_layout);

        viewsFragment = (PostDataFragment) getSupportFragmentManager().findFragmentById(R.id.views_fragment);
        bookmarksFragment = (PostDataFragment) getSupportFragmentManager().findFragmentById(R.id.user_bookmarks_fragment);
        userLikedFragment = (UserDataFragment) getSupportFragmentManager().findFragmentById(R.id.user_likes_fragment);
        userCommentedFragment = (UserDataFragment) getSupportFragmentManager().findFragmentById(R.id.user_commented_fragment);
        userMantionedFragment = (UserDataFragment) getSupportFragmentManager().findFragmentById(R.id.user_mantioned_fragment);
        userRepostsFragment = (UserDataFragment) getSupportFragmentManager().findFragmentById(R.id.user_reposts_fragment);

        userLikedFragment.setQtyIcon(R.drawable.outline_favorite_border_24);
        userLikedFragment.setHeader(R.string.likes_title);

        userCommentedFragment.setQtyIcon(R.drawable.outline_chat_bubble_outline_24);
        userCommentedFragment.setHeader(R.string.comments_title);

        userMantionedFragment.setQtyIcon(R.drawable.profile);
        userMantionedFragment.setHeader(R.string.mantiones_title);

        userRepostsFragment.setQtyIcon(R.drawable.retweet);
        userRepostsFragment.setHeader(R.string.reposts_title);

        viewsFragment.setQtyIcon(R.drawable.outline_visibility_24);
        viewsFragment.setHeader(R.string.views_title);

        bookmarksFragment.setQtyIcon(R.drawable.outline_bookmark_border_24);
        bookmarksFragment.setHeader(R.string.bookmarks_title);

        Button refershButton = findViewById(R.id.toolbar_refresh);
        Button homeButton = findViewById(R.id.button_home);
        AppManager.AppListener appListener = AppManager.getInstance().new AppListener();
        refershButton.setOnClickListener(appListener);
        homeButton.setOnClickListener(appListener);
    }
}
