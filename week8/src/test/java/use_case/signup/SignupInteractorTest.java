package use_case.signup;

import data_access.InMemoryUserDataAccessObject;
import entity.UserFactory;
import entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupInteractorTest {

    class OutputRecorder implements SignupOutputBoundary {
        SignupOutputData success;
        String failure;

        @Override
        public void prepareSuccessView(SignupOutputData data) {
            success = data;
        }

        @Override
        public void prepareFailView(String error) {
            failure = error;
        }

        @Override
        public void switchToLoginView() {}
    }

    @Test
    void successTest() {
        SignupInputData inputData = new SignupInputData("Paul", "password", "password");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        OutputRecorder recorder = new OutputRecorder();

        SignupInputBoundary interactor = new SignupInteractor(userRepository, recorder, new UserFactory());
        interactor.execute(inputData);

        assertNotNull(recorder.success);
        assertEquals("Paul", recorder.success.getUsername());
        assertNull(recorder.failure);
        assertTrue(userRepository.existsByName("Paul"));
    }

    @Test
    void failurePasswordMismatchTest() {
        SignupInputData inputData = new SignupInputData("Paul", "password", "wrong");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        OutputRecorder recorder = new OutputRecorder();

        SignupInputBoundary interactor = new SignupInteractor(userRepository, recorder, new UserFactory());
        interactor.execute(inputData);

        assertNull(recorder.success);
        assertNotNull(recorder.failure);
        assertFalse(userRepository.existsByName("Paul"));
    }

    @Test
    void failureUserExistsTest() {
        SignupInputData inputData = new SignupInputData("Paul", "password", "wrong");
        SignupUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // Add Paul to the repo so that when we check later they already exist
        UserFactory factory = new UserFactory();
        User user = factory.create("Paul", "pwd");
        userRepository.save(user);

        OutputRecorder recorder = new OutputRecorder();

        SignupInputBoundary interactor = new SignupInteractor(userRepository, recorder, factory);
        interactor.execute(inputData);

        assertNull(recorder.success);
        assertNotNull(recorder.failure);
        assertTrue(userRepository.existsByName("Paul"));
    }
}