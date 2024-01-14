package ru.danilspirin.backend.service.test;

import ru.danilspirin.backend.model.enitiy.TestModel;

import java.util.List;

public interface TestService {

    List<TestModel> getTestList();

    TestModel getTest(Long testId);

    TestModel createTest(TestModel test);

    TestModel replaceTest(Long testId, TestModel testToReplace);

    void deleteTest(Long testId);
}