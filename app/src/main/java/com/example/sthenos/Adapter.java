package com.example.sthenos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private OnSelectionListener mOnSelectionListener;
    private List<String> titles;
    private List<Integer> images;
    private LayoutInflater inflater;

    public Adapter(Context ctx, List<String> titles, List<Integer> images,
                   OnSelectionListener onSelectionListener ){
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);
        this.mOnSelectionListener = onSelectionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = inflater.inflate(R.layout.custom_grid_layout,parent,false);
        return new ViewHolder(view, mOnSelectionListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.picture.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView picture;
        OnSelectionListener onSelectionListener;

        public ViewHolder(@NonNull View itemView, OnSelectionListener onSelectionListener) {
            super(itemView);
            title = itemView.findViewById(R.id.libraryTextView);
            picture = itemView.findViewById(R.id.libraryImageView);
            this.onSelectionListener = onSelectionListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSelectionListener.onSelectionClick(getAdapterPosition());
        }
    }

    public interface OnSelectionListener{
        void onSelectionClick(int position);
    }
}
