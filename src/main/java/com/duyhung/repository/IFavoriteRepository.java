package com.duyhung.repository;

import com.duyhung.entity.Favorite;
import com.duyhung.entity.User;

import java.util.List;

public interface IFavoriteRepository {
    Boolean likeAVideo(Favorite favorite);
    List<Favorite> getAllByUser(User user);
    Boolean unlikeAVideo(Favorite favorite);
    Favorite getOne(Long userId,Long videoId);
}
