package com.saurabh.crudoperations.BookRequests;

import com.saurabh.crudoperations.Model.BookModel;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookUpdateRequest {
    @Positive
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String authorName;

    @Positive
    private int cost;

    // public BookModel to() {
    // return
    // BookModel.builder().id(this.id).authorName(this.authorName).cost(this.cost).name(this.authorName).build();
    // }

}
