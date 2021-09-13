package com.example.a1_movies.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String M_backdropPath;
    String M_poster_path;
    String M_title;
    String M_overview;

    public Movie(JSONObject jsonObject) throws JSONException {
        M_backdropPath = jsonObject.getString("backdrop_path");
        M_poster_path = jsonObject.getString("poster_path"); //(key need has to be exact)
        M_title = jsonObject.getString("title");
        M_overview = jsonObject.getString("overview");
    }

    //Create a method responsible for iterationg through the JSON array and constructing a movie for each element in the JSON array
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        //Add a movie in each position of the array
        for(int i = 0; i < movieJsonArray.length();i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies; //Returns list of movies
    }

    //Generate Getters of the objects to get information from them
    public String getM_poster_path() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",M_poster_path); //%s to indicate what you want to replace with M_poster_path
    }

    public String getM_backdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s",M_backdropPath);
    }

    public String getM_title() {
        return M_title;
    }

    public String getM_overview() {
        return M_overview;
    }
}
