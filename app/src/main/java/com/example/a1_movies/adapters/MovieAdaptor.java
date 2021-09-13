package com.example.a1_movies.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a1_movies.Models.Movie;
import com.example.a1_movies.R;

import java.util.List;

public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.ViewHolder> {
    //Context - where the adapter is being constructed from
    Context context;
    //Actual data - movie list that the adapter needs to hold on to
    List<Movie> movies;

    public MovieAdaptor(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

//ADAPTOR
    //CreateViewHolder inflates a layout (item movie) and it will return it inside the ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewHolder");
        View movie_View = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movie_View);
    }

    //BindViewHolder involves populating data into the view through the ViewHolder
    //takes the data at certain position an put it into view contain inside of the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("MovieAdapter","onBindViewHolder" + position);
        //Get the movie at the position
        Movie movie = movies.get(position);
        //Bind the movie data into the ViewHolder
        //Create a method called bind
        holder.bind(movie);

    }

    //getItemCount returns the total count of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    //Definition of inner new holder class
    public class ViewHolder extends RecyclerView.ViewHolder{
        //View holder is the representation of the title row in the design

        TextView tv_Title;
        TextView tv_Overview;
        ImageView iv_Poster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Define where the texts and images are coming from
            tv_Title = itemView.findViewById(R.id.tv_Title);
            tv_Overview = itemView.findViewById(R.id.tv_Overview);
            iv_Poster = itemView.findViewById(R.id.iv_Poster);

        }

        public void bind(Movie movie) {
            //Use the getter method on the movie and populate each of these views
            tv_Title.setText(movie.getM_title());
            tv_Overview.setText(movie.getM_overview());
            String imageURL;
            //if phone is in landscape - imageURL = back drop image
            //else imageURL = poster image
            if(context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
                imageURL = movie.getM_backdropPath();
            }else{
                imageURL = movie.getM_poster_path();
            }
            Glide.with(context).load(imageURL).into(iv_Poster);
        }
    }
}
