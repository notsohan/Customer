package com.notsohan.customer.jsonplaceholder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@ToString
public class Post {
    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;
}
