package ru.danilspirin.backend.service.test;

import org.springframework.stereotype.Service;
import ru.danilspirin.backend.exception.test.TestNotFoundException;
import ru.danilspirin.backend.model.Test;
import ru.danilspirin.backend.repository.TestRepository;

import java.util.List;
import java.util.Optional;


@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }


    @Override
    public List<Test> getTestList() {
        return testRepository.findAll();
    }

    @Override
    public Test getTest(Long testId) {
        Optional<Test> findById = testRepository.findById(testId);

        if (findById.isEmpty()) {
            throw new TestNotFoundException(testId);
        }

        return findById.get();
    }

    @Override
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test replaceTest(Long testId, Test testToReplace) {
        testToReplace.setId(testId);
        return testRepository.save(testToReplace);
    }

    @Override
    public void deleteTest(Long testId) {
        if (testRepository.existsById(testId)) {
            testRepository.deleteById(testId);
        } else {
            throw new TestNotFoundException(testId);
        }
    }
}