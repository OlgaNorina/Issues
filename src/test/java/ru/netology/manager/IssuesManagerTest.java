package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssuesRepository;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class IssuesManagerTest {
    private IssuesRepository repository = new IssuesRepository();
    private IssuesManager manager = new IssuesManager(repository);
    HashSet<String> assignee1 = new HashSet<String>((Arrays.asList("Иванов")));
    HashSet<String> assignee2 = new HashSet<String>((Arrays.asList("Петров")));
    HashSet<String> assignee3 = new HashSet<String>((Arrays.asList("Сидоров")));

    HashSet<String> label1 = new HashSet<>((Arrays.asList("BUG")));
    HashSet<String> label2 = new HashSet<>((Arrays.asList("new feature")));
    HashSet<String> label3 = new HashSet<>((Arrays.asList("task")));

    private Issue first = new Issue(1, "Иванов", assignee1, "Текст1", label1, true, "2020/04/28");
    private Issue second = new Issue(2, "Петров", assignee2, "Текст2", label3, true, "2020/04/15");
    private Issue third = new Issue(3, "Иванов", assignee3, "Текст3", label2, false, "2020/04/20");

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
    void shouldfilterByAuthorNotExist() {
        assertArrayEquals(new Issue[]{}, manager.filterBy(issue -> issue.getAuthor().equals("Черный")).toArray());
    }

    @Test
    void shouldfilterByLabel() {
        assertArrayEquals(new Issue[]{third}, manager.filterBy(issue -> issue.getLabel().equals(label2)).toArray());
    }

    @Test
    void shouldfilterByLabelNotExist() {
        assertArrayEquals(new Issue[]{}, manager.filterBy(issue -> issue.getLabel().equals(new HashSet<>())).toArray());
    }

    @Test
    void shouldfilterByAssignee() {
        assertArrayEquals(new Issue[]{second}, manager.filterBy(issue -> issue.getAssignee().equals(assignee2)).toArray());
    }

    @Test
    void shouldfilterByOpen() {
        assertArrayEquals(new Issue[]{first, second}, manager.filterBy(issue -> issue.isOpen()).toArray());
    }

    @Test
    void shouldfilterByClose() {
        assertArrayEquals(new Issue[]{third}, manager.filterBy(issue -> !issue.isOpen()).toArray());
    }

    @Test
    void shouldCreate() {
        Issue fourth = new Issue(4, "Иванов", assignee3, "Текст4", label2, false, "2020/05/01");
        repository.add(fourth);
        assertArrayEquals(new Issue[]{fourth, first, third, second}, manager.filterBy(issue -> true).toArray());
    }
}