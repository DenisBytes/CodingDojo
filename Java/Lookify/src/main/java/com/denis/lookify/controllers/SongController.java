package com.denis.lookify.controllers;

import com.denis.lookify.models.Song;
import com.denis.lookify.services.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongService songService;
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);

        return "dashboard";
    }
    @PostMapping("/dashboard")
    public String postDashboard(@RequestParam("artist") String artist, Model model){
        model.addAttribute("artist", artist);

        return "redirect:/search/"+artist;
    }

    @GetMapping("/search/{artist}")
    public String searchSong(@PathVariable("artist") String artist, Model model){
        model.addAttribute("songs", songService.findByArtist(artist));

        return "search";
    }


    @GetMapping("/songs/new")
    public String addSong(@ModelAttribute("song") Song song){
        return "newsong";
    }

    @PostMapping("/songs/new")
    public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result){
        if(result.hasErrors()){
            return "newsong";
        }
        songService.createSong(song);
        return "redirect:/dashboard";
    }

    @GetMapping("/songs/{id}")
    public String view(@PathVariable("id") Long id, Model model){
        Song song = songService.songById(id);
        model.addAttribute("song", song);

        return "view";
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id){
        songService.deleteSong(id);

        return "redirect:/dashboard";
    }
    @GetMapping("/songs/top")
    public String topTenSong(Model model) {
        List<Song> top10Songs = songService.getTopTen();
        model.addAttribute("songs", top10Songs);
        return "top10";
    }

}
