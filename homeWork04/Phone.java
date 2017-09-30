package homeWork04;

/**
 * Опишите класс Phone (одним из свойств должен быть его номер). Также опишите
 * класс Network (сеть мобильного оператора). Телефон должен иметь метод
 * регистрации в сети мобильного оператора. Также у телефона должен быть метод call
 * (номер другого телефона), который переберет все телефоны, зарегистрированные в
 * сети. Если такой номер найден, то осуществить вызов, если нет - вывести сообщение
 * о неправильности набранного номера.
 */

public class Phone {
    private long phoneNumber, imei;
    private Network currentNetwork;
    private String model = "noname";

    public Phone() {
    }

    public Phone(long phoneNumber, Network network, long imei, String model) {
        this.phoneNumber = phoneNumber;
        currentNetwork = network;
        this.imei = imei;
        this.model = model;
        networkRegistration();
    }

    private void networkRegistration() {
        currentNetwork.registerPhone(this);
        System.out.println("Phone " + phoneNumber + " registered in " + currentNetwork.getNetworkName());
    }

    public String call(long phoneNumber) {
        System.out.println(model + " " + phoneNumber + " dialing " + phoneNumber);
        if (this.phoneNumber == phoneNumber) return "Error! It's your own number!";
        if (currentNetwork.searchNumber(phoneNumber)) {
            return "Connected!";
        } else {
            return "Error! Phone number not found!";
        }
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
}
