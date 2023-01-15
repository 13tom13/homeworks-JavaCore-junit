package phone;

import org.junit.jupiter.api.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PhoneTest {

    static
    Phone testPhone = new Phone();

    @BeforeAll
    public static void init() {
        int random = (int) (Math.random() * 3);
        System.out.println("Phone tests started");
    }

    @AfterAll
    public static void end() {
        System.out.println("Phone tests finished");
    }

    @Test
    public void fillingPhoneBookTest() {
        System.out.println("fillingPhoneBook test");
        // given:
        Phone testPhone2 = new Phone();
        testPhone2.getPhoneBook().addGroup("Друзья");
        testPhone2.getPhoneBook().addGroup("Работа");
        testPhone2.getPhoneBook().addGroup("Одноклассники");
        testPhone2.getPhoneBook().addGroup("Семья");
        // when:
        testPhone.fillingPhoneBook();
        // then:
        Assertions.assertEquals(testPhone.getPhoneBook().getBook().keySet(),
                testPhone2.getPhoneBook().getBook().keySet());
        System.out.println("fillingPhoneBook test - checked");
    }

    @Test // Test with Hamcrest
    public void callAmountTest() {
        System.out.println("callAmount test (with Hamcrest)");
        // given:
        int callСount = 3;
        // when:
        testPhone.call("test");
        testPhone.call("test1");
        testPhone.call("test3");
        // then:
        assertThat(callСount, equalTo(testPhone.callAmount));
        System.out.println("callAmount test (with Hamcrest) - checked");
    }
}
