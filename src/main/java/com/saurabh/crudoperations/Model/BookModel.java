package com.saurabh.crudoperations.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {

    int id;
    String name;
    String authorName;
    int cost;
    // Date publishDate;
    // String publisherName;

}
