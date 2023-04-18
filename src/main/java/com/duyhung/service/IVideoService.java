package com.duyhung.service;

import com.duyhung.entity.Video;

import java.util.List;

public interface IVideoService {
    Long save(Video sVideo);
    List<Video> getAll();
    Video findById(Long id);
    Boolean remove(Video video);
    Boolean update(Video video);
    List<Video> getVideoFavorite(Long userId);
}
