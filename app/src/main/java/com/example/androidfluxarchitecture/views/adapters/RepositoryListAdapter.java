package com.example.androidfluxarchitecture.views.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androidfluxarchitecture.R;
import com.example.androidfluxarchitecture.models.Repository;

import java.util.List;

/**
 * Created by joanna on 22.06.16.
 */
public class RepositoryListAdapter extends RecyclerView.Adapter<RepositoryListAdapter.RepositoryListViewHolder> {

    private final List<Repository> repositories;
    private final Context mContext;

    public RepositoryListAdapter(List<Repository> repositories, Context mContext) {
        this.repositories = repositories;
        this.mContext = mContext;
    }

    @Override
    public RepositoryListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.repository_list_item, viewGroup, false);
        return new RepositoryListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepositoryListViewHolder holder, int position) {
        Repository repository = repositories.get(position);

        holder.textViewTitle.setText(repository.getFull_name());
        holder.textViewDescription.setText(repository.getDescription());
        holder.textViewStars.setText(String.valueOf(repository.getStargazers_count()));

//        holder.itemView.setOnClickListener(clickListener);
    }

    @Override
    public int getItemCount() {
        return (null != repositories ? repositories.size() : 0);
    }

    class RepositoryListViewHolder extends RecyclerView.ViewHolder {

        public final CardView cardView;
        public final TextView textViewTitle;
        public final TextView textViewDescription;
        public final TextView textViewStars;

        public RepositoryListViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewDescription = (TextView) itemView.findViewById(R.id.textViewDescription);
            textViewStars = (TextView) itemView.findViewById(R.id.textViewStars);
        }
    }
}
