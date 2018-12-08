package com.example.vadim.test_task_inrating.Services;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.vadim.test_task_inrating.AppItems.User;
import com.example.vadim.test_task_inrating.R;
import com.squareup.picasso.Picasso;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.RecyclerViewHolder> {
    private List<User> recyclerItemDataList = new ArrayList<>();

    public void setItems(Collection<User> recyclerItems)
    {
        clearItems();
        recyclerItemDataList.addAll(recyclerItems);
        notifyDataSetChanged();
    }

    public void clearItems()
    {
        recyclerItemDataList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SimpleRecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_layout, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i)
    {
        recyclerViewHolder.bind(recyclerItemDataList.get(i));
        SimpleRecyclerAdapter.OnItemClickListener onItemClickListener = new OnItemClickListener(i);
        recyclerViewHolder.itemView.setOnClickListener(onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return recyclerItemDataList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView userImage;
        private TextView userNickName;

        public RecyclerViewHolder(View itemView)
        {
            super(itemView);
            userImage = itemView.findViewById(R.id.recyclerImage);
            userNickName = itemView.findViewById(R.id.recyclerText);
        }

        public void bind(User recyclerItemData)
        {
            userNickName.setText(recyclerItemData.getNickName());
            Picasso.with(itemView.getContext())
                    .load(recyclerItemData.getPictureURL())
                    .transform(new RoundedCornersTransformation(15,2))
                    .into(userImage);
        }
    }

    private class OnItemClickListener implements View.OnClickListener {
        private int position;

        public OnItemClickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v)
        {}
    }
}
