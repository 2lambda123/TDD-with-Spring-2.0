## Documentation

#### Class-level annotations
* `@ExtentWith(MockitoExtension.class)`: Use to add Mockito behaviour into JUnit5 lifecycle. Just an extension to add third-party vendors like Mockito for test classes. We use it when we don't want to involve Spring.
* `@ExtendWith(SpringExtension.class)`: When we want to use `@MockBean` annotation involving Spring. We use this annotation which is replaces deprecated JUnit4 `@RunWith(SpringJUnit4ClassRunner.class)` annotation.

#### Dependency-level annotations
* `@InjectMocks`: It will inject the dependency as well as also constructor-inject all the mocked dependencies (like repository-layer). Those dependencies annotated with `@Mock`.
* `@Mock`: It will mock the class (like repository-layer).

### Behaviours
* #### Mocking
Mocking is the technique to mock (mimic) the data of your repository layer. When writing unit tests, our tests needs to be fast, so if hit the actual database connection it will take much time to run the test as well as we don't want to do testing on our persistance data.

* #### Stubbing
Stubbing is another technique to mimic the data we need to test. Let's say we only want to save a new Todo if already not found in database. How to do testing? Since we have mocked the repository (and we also using H2 in-memory) so there will be no actual data present in database. Since we need to first check if Todo already exists, it won't be possible because of absence of any data. Stubbing allows us to stub the mock repository which means before assertion we will tell the repository to return _newTodoToSave_ so when invoking _addNewTodo_ method of your service it will throw exception since new Todo already found in database.
