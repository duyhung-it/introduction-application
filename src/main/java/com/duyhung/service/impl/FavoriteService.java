package com.duyhung.service.impl;

import com.duyhung.entity.Favorite;
import com.duyhung.entity.User;
import com.duyhung.repository.IFavoriteRepository;
import com.duyhung.repository.impl.FavoriteRepository;
import com.duyhung.service.IFavoriteService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FavoriteService implements IFavoriteService {
    private IFavoriteRepository repository;
    public FavoriteService(){
        repository = new FavoriteRepository();
    }
    @Override
    public Boolean likeAVideo(Favorite favorite) {
        Favorite favorite1 = repository.getOne(favorite.getUserId(), favorite.getVideoId());
        if(favorite1 == null)
        {
            return repository.likeAVideo(favorite);
        }
        return false;
    }

    @Override
    public Boolean unlikeAVideo(Favorite favorite) {
        Favorite favorite1 = repository.getOne(favorite.getUserId(), favorite.getVideoId());
        if(favorite1 != null)
            return repository.unlikeAVideo(favorite);
        return false;
    }

    @Override
    public List<Favorite> getAllByUser(User user) {
        if(user != null)
            return repository.getAllByUser(user);
        return new ArrayList<>();
    }

    @Override
    public Favorite getOne(Long userId, Long videoId) {
        return repository.getOne(userId,videoId);
    }
}
