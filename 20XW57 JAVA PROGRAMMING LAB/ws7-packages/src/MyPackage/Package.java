package MyPackage;

public class Package {
    double weight;
    char shippingMethod;

    double shippingCost;

    public Package() {
    }
    public void calculateCost(double wt, char M) {
        if (wt >= 1 && wt <= 8) {
            if (M == 'A') {
                shippingCost = 2;
            } else if (M == 'T') {
                shippingCost = 1.5;
            } else if (M == 'M') {
                shippingCost = 0.5;
            } else {
                System.out.println("Wrong Option of shipping.");
            }
        }
        else if (wt >= 9 && wt <= 16) {
            if (M == 'A') {
                shippingCost = 3;
            } else if (M == 'T') {
                shippingCost = 2.35;
            } else if (M == 'M') {
                shippingCost = 1.5;
            } else {
                System.out.println("Wrong Option of shipping.");
            }
        }
        else if (wt >= 17) {
            if (M == 'A') {
                shippingCost = 4.5;
            } else if (M == 'T') {
                shippingCost = 3.25;
            } else if (M == 'M') {
                shippingCost = 2.15;
            } else {
                System.out.println("Wrong Option of shipping.");
            }
        }
    }
    public Package(double weight, char shippingMethod) {
        this.weight = weight;
        this.shippingMethod = shippingMethod;
        calculateCost(weight,shippingMethod);
    }

    @Override
    public String toString() {
        return "Package{" +
                "weight=" + weight +
                ", shippingMethod=" + shippingMethod +
                ", shippingCost=" + shippingCost +
                '}';
    }
}

