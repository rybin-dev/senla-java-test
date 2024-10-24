package exchanger;

public enum Rates {
    RUB(1),
    UAH(0.429074),
    USD(0.01040665),
    EUR(0.009578397);

    final double rate;

    Rates(double rate) {
        this.rate = rate;
    }
}
