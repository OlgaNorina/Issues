package ru.netology.manager;

import ru.netology.domain.Issue;

import java.util.Comparator;

public class IssuesComparatorByDate implements Comparator<Issue> {
    @Override
    public int compare(Issue o1, Issue o2) {
        return o1.getDateOfСhange().compareTo(o2.getDateOfСhange());
    }
}
