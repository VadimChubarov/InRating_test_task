package com.example.vadim.test_task_inrating.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vadim.test_task_inrating.R;

public class PostDataFragment extends Fragment
{
    private TextView dataQty;
    private ImageView icon;
    private TextView header;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View myFragmentView = inflater.inflate(R.layout.post_data_fragment_layout,
                container, false);
        dataQty = myFragmentView.findViewById(R.id.post_data_qty);
        icon = myFragmentView.findViewById(R.id.post_data_icon);
        header = myFragmentView.findViewById(R.id.post_data_header);
        return myFragmentView ;
    }
    public void showDataQty(String qty) {dataQty.setText(qty);}

    public void setQtyIcon(int pictId) {icon.setBackgroundResource(pictId);}
    public void setHeader(int headerId){this.header.setText(headerId);}
}
