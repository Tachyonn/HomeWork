package homeWork06;

public enum Sex {
    MALE, FEMALE;

    @Override
    public String toString() {
        switch (this) {
            case MALE:
                return "мужской";
            case FEMALE:
                return "женский";
            default:
                return super.toString();
        }
    }
}
