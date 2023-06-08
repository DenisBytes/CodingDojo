package com.denis.lookify.repositories;

import com.denis.lookify.models.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
    List<Song> findAll();

    @Override
    Optional<Song> findById(Long id);

    List<Song> findByArtistContaining(String artist);

    void deleteById(Long id);

    List<Song> findTop10ByOrderByRatingDesc();
}
