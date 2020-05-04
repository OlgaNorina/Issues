package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class IssuesRepository {

    private List<Issue> items = new ArrayList<>();

    public List<Issue> getAll() {
        return items;
    }

    public boolean add(Issue item) {
        return items.add(item);
    }

    public void openById(int id){
        items.get(id).setOpen(true);
    }

    public void closeById(int id){
        items.get(id).setOpen(false);
    }
}
