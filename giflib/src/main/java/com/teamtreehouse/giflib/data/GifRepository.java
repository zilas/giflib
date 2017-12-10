package com.teamtreehouse.giflib.data;

import com.teamtreehouse.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALLGIFS = Arrays.asList(
        new Gif("android-explosion",1, LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
        new Gif("ben-and-mike",2, LocalDate.of(2015,10,30), "Ben Jakuben", true),
        new Gif("book-dominos",3, LocalDate.of(2015,9,15), "Craig Dennis", false),
        new Gif("compiler-bot",3, LocalDate.of(2015,2,13), "Ada Lovelace", true),
        new Gif("cowboy-coder",2, LocalDate.of(2015,2,13), "Grace Hopper", false),
        new Gif("infinite-andrew",1, LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );

    public Gif findByName(String name){
       return ALLGIFS.stream()
               .filter(gif -> name.equals(gif.getName())).findFirst().orElse(null);

    }
    public List<Gif> getAllgifs (){
        return new ArrayList<>(ALLGIFS);
    }

    public List<Gif> findByCategoryId(int id) {
//        return Collections.singletonList((ALLGIFS.stream()
//                .filter(gif -> gif.getCategoryId() == id).findAny().orElse(null))
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : ALLGIFS){
            if (gif.getCategoryId() == id){
                gifs.add(gif);
            }
        }
        return  gifs;
    }

    public List<Gif> favoritesGifs(){
        List<Gif> favoriteGifs = new ArrayList<>();
        for (Gif gif : ALLGIFS){
            if (gif.isFavorite()){
                favoriteGifs.add(gif);
            }
        }
        return favoriteGifs;
    }

    public List<Gif> getBySearch(String q){
        List<Gif> searchRes = new ArrayList<>();
        for (Gif gif:ALLGIFS ){
            if (gif.getName().contains(q)){
                searchRes.add(gif);
            }
        }
        return searchRes;
    }
}
