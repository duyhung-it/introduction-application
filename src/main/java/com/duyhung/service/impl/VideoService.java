package com.duyhung.service.impl;

import com.duyhung.entity.Video;
import com.duyhung.repository.IVideoRepository;
import com.duyhung.repository.impl.VideoRepository;
import com.duyhung.service.IVideoService;

import java.util.List;

public class VideoService implements IVideoService {
    private final IVideoRepository repository;
    public VideoService(){
        repository = new VideoRepository();
    }
    @Override
    public Long save(Video sVideo) {
        return repository.save(sVideo);
    }

    @Override
    public List<Video> getAll() {
        return repository.getAll();
    }

    @Override
    public Video findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Boolean remove(Video video) {
        return repository.remove(video);
    }

    @Override
    public Boolean update(Video video) {
        return repository.update(video);
    }
}
