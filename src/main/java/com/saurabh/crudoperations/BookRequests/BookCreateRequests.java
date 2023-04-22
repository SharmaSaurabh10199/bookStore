package com.saurabh.crudoperations.BookRequests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreateRequests {
    @NotNull
    String name;

    @NotNull
    String authorName;

    @Positive
    int cost;

}
