package kr.ac.cnu.games.domain;

import lombok.Data;

/**
 * Created by rokim on 2017. 6. 4..
 */
@Data
public class Greeting {
    private String content;


    public Greeting(String content) {
        this.content = content;
    }
}
