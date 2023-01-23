package world.rfch.entity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PostStatus {
    PUBLIC,
    PRIVATE,
    ONLY_FRIENDS,
    SOME_FRIENDS
}
