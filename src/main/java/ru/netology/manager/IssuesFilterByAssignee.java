package ru.netology.manager;

import ru.netology.domain.Issue;

import java.util.function.Predicate;

public class IssuesFilterByAssignee implements Predicate<Issue> {
    public String assignee;

    public IssuesFilterByAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public boolean test(Issue issue) {
        return issue.getAssignee().contains(assignee);
    }
}
