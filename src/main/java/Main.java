import phone.Phone;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Phone iphone = new Phone();
        iphone.fillingPhoneBook();
        iphone.call("+79113330301");
        iphone.call("+79113320201");
        iphone.call("+79110722554");
        iphone.call("+79110740965");
        iphone.call("+79110722554");
        iphone.call("+79110788806");
        iphone.call("+79110788877");
        iphone.call("+79110788333");
        iphone.call("+79183303011");
        iphone.call("+79110788806");
        iphone.call("+79110721965");
        iphone.call("+79110740965");
        iphone.call("+79110788806");
        iphone.call("+79110788877");
        iphone.call("+79110788333");
        iphone.call("+79183303011");
        iphone.call("+79110788806");
        iphone.call("+79110721965");
        iphone.call("+79110740965");
        iphone.call("+79113330301");
        iphone.call("+79113320201");
        iphone.call("+79110722554");
        iphone.call("+79110740965");
        iphone.call("+79110722554");
        iphone.call("+79110788806");
        iphone.call("+79110788877");
        iphone.call("+79110788333");
        iphone.call("+79183303011");
        iphone.call("+79110788806");
        iphone.call("+79110721965");
        System.out.println();
        iphone.showMissedCallList();
    }
}
