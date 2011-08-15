
смотри здесь как тесты писать

Apress - Spring Recipes, Second Edition.pdf

================================================================
»спользуемые аннотации:


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/beans.xml")
@Transactional

@Autowired
private AccountService accountService;



@Before

@Test

@After





@Repeat: This indicates that a test method has to run multiple times. The number
of times it will run is specified as the annotation value.

@Timed: This indicates that a test method must complete in a specified time period
(in milliseconds). Otherwise, the test fails. Note that the time period includes the
repetitions of the test method and any initialization and cleanup methods.

@IfProfileValue: This indicates that a test method can only run in a specific
testing environment. This test method will run only when the actual profile value
matches the specified one. You can also specify multiple values so that the test
method will run if any of the values is matched. By default,
SystemProfileValueSource is used to retrieve system properties as profile values,
but you can create your own ProfileValueSource implementation and specify it in
the @ProfileValueSourceConfiguration annotation.


@ExpectedException: This has the same effect as JUnit 4 and TestNGТs expected
exception support. However, as JUnit 3 doesnТt have similar support, this is a good
complement for testing exceptions in JUnit 3.