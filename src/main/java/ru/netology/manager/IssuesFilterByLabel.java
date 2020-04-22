package ru.netology.manager;

import ru.netology.domain.Issue;

import java.util.function.Predicate;

public class IssuesFilterByLabel implements Predicate<Issue> {
    public String label;

    public IssuesFilterByLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean test(Issue issue) {
        return issue.label.contains(label);
    }
}
