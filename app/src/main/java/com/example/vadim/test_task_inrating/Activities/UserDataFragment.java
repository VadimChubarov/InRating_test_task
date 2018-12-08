package com.example.vadim.test_task_inrating.Activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.vadim.test_task_inrating.AppItems.User;
import com.example.vadim.test_task_inrating.R;
import com.example.vadim.test_task_inrating.Services.SimpleRecyclerAdapter;

import java.util.Collection;

public class UserDataFragment extends Fragment
{
    private ImageView icon;
    private TextView header;
    private ProgressBar progressBar;

    private TextView dataQty;
    private TextView more;
    private TextView moreQty;
    private ImageView arrowRight;
    private ImageView arrowLeft;
    private RecyclerView userDataRecycler;
    private SimpleRecyclerAdapter recyclerAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View myFragmentView = inflater.inflate(R.layout.users_data_fragment_layout,
                container, false);
        icon = myFragmentView.findViewById(R.id.data_qty_icon);
        header =  myFragmentView.findViewById(R.id.data_qty_header);
        progressBar = myFragmentView.findViewById(R.id.user_loading_progress);
        dataQty = myFragmentView.findViewById(R.id.data_qty);
        more = myFragmentView.findViewById(R.id.more_header);
        moreQty = myFragmentView.findViewById(R.id.more_qty);
        arrowRight = myFragmentView.findViewById(R.id.arrow_right);
        arrowLeft = myFragmentView.findViewById(R.id.arrow_left);
        userDataRecycler = myFragmentView.findViewById(R.id.users_data_recycler);
        runRecycler();

        return myFragmentView ;
    }

    private void runRecycler()
    {
        recyclerAdapter = new SimpleRecyclerAdapter();
        layoutManager = new LinearLayoutManager(this.getContext(),LinearLayoutManager.HORIZONTAL, false);

        userDataRecycler.setLayoutManager(layoutManager);
        userDataRecycler.setAdapter(recyclerAdapter);

        userDataRecycler.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);

                if(layoutManager.findFirstVisibleItemPosition() !=0){showLeftArrow(true);}
                else{showLeftArrow(false);}

                if(layoutManager.findLastVisibleItemPosition() !=recyclerAdapter.getItemCount()-1){showRightArrow(true);}
                else{showRightArrow(false);}

                if(arrowRight.getVisibility()==View.INVISIBLE && arrowLeft.getVisibility()==View.INVISIBLE)
                {showMore(false);}
                else{showMore(true);}
            }
        });
    }

    public void showRecyclerItems(Collection<User> users)
    {
        recyclerAdapter.clearItems();
        recyclerAdapter.setItems(users);
        showMoreQty();
    }

    public void showDataQty(String qty) {dataQty.setText(qty);}

    public void showMoreQty()
    {
        new Handler().post(new Runnable(){
            @Override
            public void run()
            {
                int qty = recyclerAdapter.getItemCount() - layoutManager.getChildCount();
                moreQty.setText(String.valueOf(qty));
                if(qty>0){more.setVisibility(View.VISIBLE);moreQty.setVisibility(View.VISIBLE);}
            }});
    }

    public void showMore(boolean show)
    {
        if(show){more.setVisibility(View.VISIBLE);}
        else{more.setVisibility(View.INVISIBLE);}
    }

    public void showLeftArrow(boolean show)
    {
        if(show){arrowLeft.setVisibility(View.VISIBLE);}
        else{arrowLeft.setVisibility(View.INVISIBLE);}
    }
    public void showRightArrow(boolean show)
    {
        if(show){arrowRight.setVisibility(View.VISIBLE);}
        else{arrowRight.setVisibility(View.INVISIBLE);}
    }

    public void setQtyIcon(int pictId) {icon.setBackgroundResource(pictId);}
    public void setHeader(int headerId){this.header.setText(headerId);}

    public void showLoadingProgress(boolean show)
    {
        if(show){progressBar.setVisibility(View.VISIBLE);userDataRecycler.setVisibility(View.INVISIBLE);}
        else{progressBar.setVisibility(View.INVISIBLE);userDataRecycler.setVisibility(View.VISIBLE);}
    }
}
