package com.teamtreehouse.giflib.controller;

import com.teamtreehouse.giflib.data.GifRepository;
import com.teamtreehouse.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {

    //Assign value ass soon as needed
    //How spring knows if it is valid spring component - @ComponentScan scans all root directory
    //for @Component annotation and makes it valid for spring component
    //Dependency injection DI
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    String listGifs(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllgifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif")
    @ResponseBody
    String gif(){
        return "This will be used for one Gif";
    }

    //Then spring will call this method it will "inject ModelMap object"
    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String favoritesGifs(ModelMap modelMap){
        modelMap.put("favorites", gifRepository.favoritesGifs());
        return "favorites";
    }

    @RequestMapping("/search")
    public String searchRes(@RequestParam String q, ModelMap modelMap){
        modelMap.put("searchRes",gifRepository.getBySearch(q));
        return "search";
    }
}
