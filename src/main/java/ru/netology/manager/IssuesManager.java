package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import java.util.*;
import java.util.function.Predicate;

public class IssuesManager {
    IssuesRepository repository = new IssuesRepository();

    public List<Issue> filterBy (Predicate predicate){
        List<Issue> all = repository.getAll();
        List<Issue> open = new ArrayList<>();
        for (Issue issue : all){
            if (predicate.test(issue)){
                open.add(issue);
            }
        }
        return open;
    }
}
