package com.duyhung.service;

import com.duyhung.entity.Favorite;
import com.duyhung.entity.User;

import java.util.List;

public interface IFavoriteService {
    Boolean likeAVideo(Favorite favorite);
    Boolean unlikeAVideo(Favorite favorite);
    List<Favorite> getAllByUser(User user);
    Favorite getOne(Long userId,Long videoId);
}
