package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import java.util.*;
import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
public class IssuesManager {
    private IssuesRepository repository = new IssuesRepository();

    public List<Issue> filterBy(Predicate<Issue> predicate) {
        List<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }  // вызов метода List<Issue> actual = issueManager.filterByAuthor(issue -> issue.getAuthor().equals("vasya"));
}
