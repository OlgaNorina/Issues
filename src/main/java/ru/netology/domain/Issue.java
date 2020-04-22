package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;

@AllArgsConstructor
@Data
public class Issue {
    private int id;
    private String author;
    private HashSet<String> assignee;
    private String text;
    private HashSet<String> label;
    private boolean open;
    private Date dateOfСhange;
}
