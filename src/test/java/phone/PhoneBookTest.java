package phone;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PhoneBookTest {

    private Phone testPhone;

    @BeforeAll
    public static void init() {
        System.out.println("PhoneBook tests started");
    }

    @AfterAll
    public static void end() {
        System.out.println("PhoneBook tests finished");
    }

    @BeforeEach
    void beforeEach() {
        testPhone = new Phone();
    }

    @AfterEach
    void afterEach() {
        testPhone = null;
    }

    @Test
    void addGroupTest() {
        System.out.println("AddGroup test");
        // given:
        String testNameGroup = "TestGroup";
        // when:
        testPhone.getPhoneBook().addGroup(testNameGroup);
        // then:
        Assertions.assertTrue(testPhone.getPhoneBook().getBook().containsKey(testNameGroup));
        System.out.println("AddGroup test - checked");
    }

    @ParameterizedTest
    @MethodSource("getGroupList")
    public void addContactTest(String group) {
        System.out.println("addContact test");
        // when:
        String name = "Test";
        String number = "0000";
        Contact testContact = new Contact(name, number);
        testPhone.getPhoneBook().addGroup(group);
        testPhone.getPhoneBook().addContact(testContact, group);
        // then:
        Assertions.assertTrue(testPhone.getPhoneBook().getBook().containsKey(group));
        Assertions.assertNotNull(testPhone.getPhoneBook().getСontactByPhone(number));
        System.out.println("addContact test - checked");
    }

    public static String[] getGroupList() {
        String[] groupList = new String[3];
        groupList[0] = "friends";
        groupList[1] = "home";
        groupList[2] = "work";
        return groupList;
    }

    @Test // Test with Hamcrest
    public void PhoneBookCheckContains() {
        System.out.println("PhoneBook contains test (with Hamcrest)");
        // given:
        String groupName = "Семья";
        // when:
        testPhone.fillingPhoneBook();
        // then:
        assertThat(testPhone.getPhoneBook().getBook().keySet(), hasItem(groupName));
        System.out.println("PhoneBook contains test (with Hamcrest)- checked");
    }

}
