package com.palette.palettepetsback.Article.articleWrite.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Failure implements Result{

    private String msg;
}
