package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class IssuesManagerTest {
    IssuesRepository repository = new IssuesRepository();
    IssuesManager manager = new IssuesManager(repository);
    HashSet<String> assignee1 = new HashSet<String>((Arrays.asList("Иванов")));
    HashSet<String> assignee2 = new HashSet<String>((Arrays.asList("Петров")));
    HashSet<String> assignee3 = new HashSet<String>((Arrays.asList("Сидоров")));

    HashSet<String> label1 = new HashSet<>((Arrays.asList("BUG")));
    HashSet<String> label2 = new HashSet<>((Arrays.asList("new feature")));
    HashSet<String> label3 = new HashSet<>((Arrays.asList("task")));

    private Issue first = new Issue(1, "Иванов", assignee1, "Текст1", label1, true, "28/04/2020");
    private Issue second = new Issue(2, "Петров", assignee2, "Текст2", label3, true, "15/04/2020");
    private Issue third = new Issue(3, "Иванов", assignee3, "Текст3", label2, true, "20/04/2020");

    @BeforeEach
    void setUp() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
    }

    @Test
    void shouldfilterByAuthor() {
        assertArrayEquals(new Issue[]{first, third}, manager.filterBy(issue -> issue.getAuthor().equals("Иванов")).toArray());
    }

    @Test
    void shouldfilterByLabel(){
        assertArrayEquals(new Issue[]{third}, manager.filterBy(issue -> issue.getLabel().equals(label2)).toArray());
    }

     @Test
    void shouldfilterByAssignee(){
        assertArrayEquals(new Issue[]{second}, manager.filterBy(issue -> issue.getAssignee().equals(assignee2)).toArray());
    }
}