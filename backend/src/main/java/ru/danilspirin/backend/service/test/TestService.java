package ru.danilspirin.backend.service.test;

import ru.danilspirin.backend.model.Test;

import java.util.List;

public interface TestService {

    List<Test> getTestList();

    Test getTest(Long testId);

    Test createTest(Test test);

    Test replaceTest(Long testId, Test testToReplace);

    void deleteTest(Long testId);
}