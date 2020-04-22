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

    public Issue getById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public boolean remove(Issue item) {
        return items.remove(item);
    }
}
