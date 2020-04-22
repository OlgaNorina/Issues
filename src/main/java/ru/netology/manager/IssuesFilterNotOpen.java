package ru.netology.manager;

import ru.netology.domain.Issue;

import java.util.function.Predicate;

public class IssuesFilterNotOpen implements Predicate<Issue> {

    @Override
    public boolean test(Issue issue) {
        return !issue.open;
    }
}