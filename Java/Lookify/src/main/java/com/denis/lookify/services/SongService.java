package com.denis.lookify.services;

import com.denis.lookify.models.Song;
import com.denis.lookify.repositories.SongRepository;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class SongService {
    @Autowired
    SongRepository songRepository;

    public List<Song> allSongs(){
        return songRepository.findAll();
    }

    public Song createSong(Song song){
        return songRepository.save(song);
    }

    public Song updateAt(Song song){
        return songRepository.save(song);
    }

    public Song songById (Long id){
        Optional<Song> optionalSong = songRepository.findById(id);
        if(optionalSong.isPresent()){
            return optionalSong.get();
        }
        else {
            return null;
        }
    }
    public List<Song> findByArtist (String artist){
        return songRepository.findByArtistContaining(artist);
    }

    public void deleteSong(Long id){
        songRepository.deleteById(id);

    }
    public List<Song> getTopTen() {
        return songRepository.findTop10ByOrderByRatingDesc();
    }
}
