package homeWork04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Опишите класс Phone (одним из свойств должен быть его номер). Также опишите
 * класс Network (сеть мобильного оператора). Телефон должен иметь метод
 * регистрации в сети мобильного оператора. Также у телефона должен быть метод call
 * (номер другого телефона), который переберет все телефоны, зарегистрированные в
 * сети. Если такой номер найден, то осуществить вызов, если нет - вывести сообщение
 * о неправильности набранного номера.
 */

public class Network {

    private HashMap<Long, Phone> network;
    private String networkName;

    public Network() {
        initNetwork("default");
    }

    public Network(String networkName) {
        initNetwork(networkName);
    }

    private void initNetwork(String networkName) {
        network = new HashMap<>();
        this.networkName = networkName;
    }

    public void registerPhone(Phone phone) {
        network.put(phone.getPhoneNumber(), phone);
    }

    public boolean searchNumber(long phoneNumber) {
        return network.containsKey(phoneNumber);
    }

    public void getPhonesList() {
        for (Long phoneNumber : network.keySet()) {
            System.out.println(phoneNumber);
        }
    }

    public String getNetworkName() {
        return networkName;
    }

    @Override
    public String toString() {
        return "Network " + networkName;
    }
}
