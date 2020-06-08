package ru.rapidSilver.publisher.domain;

public enum Action {
    PURCHASE,
    SUBSCRIPTION;

    public static Action findByValue(int value) {
        switch (value) {
            case 0:
                return PURCHASE;
            case 1:
                return SUBSCRIPTION;
            default:
                return null;
        }
    }
}
