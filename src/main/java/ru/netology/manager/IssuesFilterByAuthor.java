package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Issue;

import java.util.function.Predicate;

public class IssuesFilterByAuthor implements Predicate<Issue> {
    private String author;

    public IssuesFilterByAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean test(Issue issue) {
        return issue.getAuthor().equalsIgnoreCase(author);
    }
}
