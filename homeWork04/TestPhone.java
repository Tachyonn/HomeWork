package homeWork04;

/**
 * Опишите класс Phone (одним из свойств должен быть его номер). Также опишите
 * класс Network (сеть мобильного оператора). Телефон должен иметь метод
 * регистрации в сети мобильного оператора. Также у телефона должен быть метод call
 * (номер другого телефона), который переберет все телефоны, зарегистрированные в
 * сети. Если такой номер найден, то осуществить вызов, если нет - вывести сообщение
 * о неправильности набранного номера.
 */

public class TestPhone {

    public static void main(String[] args) {

        Network kyivstar = new Network("Kyivstar");
        Phone motorola = new Phone(380503835493L, kyivstar, 1234567890, "Motorola");
        Phone samsung = new Phone(380679579577L, kyivstar, 1234567899, "Samsung");
        Phone xiaomi = new Phone(380555555555L, kyivstar, 1234567888, "Xiaomi");

        //kyivstar.getPhonesList();

        System.out.println(motorola.call(samsung.getPhoneNumber()));
        System.out.println(samsung.call(xiaomi.getPhoneNumber()));
        System.out.println(xiaomi.call(380555555544L));
        System.out.println(motorola.call(motorola.getPhoneNumber()));
    }

}
