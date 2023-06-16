package com.denis.dojooverflow.services;

import com.denis.dojooverflow.models.Tag;
import com.denis.dojooverflow.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    TagRepository tagRepository;

    public List<Tag> allTags(){
        return tagRepository.findAll();
    }

    public void createTag(Tag tag){
        tagRepository.save(tag);
    }

    public Tag findBySubject(String subject){
        Optional<Tag> optionalTag = tagRepository.findBySubject(subject);
        if(optionalTag.isPresent()){
            return optionalTag.get();
        }

        else{
            return null;
        }
    }
}
