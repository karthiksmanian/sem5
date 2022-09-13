package MyPackage;

public class InsuredPackage extends Package {
    double insuranceCost;

    public InsuredPackage(double wt, char M){
        super(wt,M);
        if(shippingCost>0 && shippingCost<=1){
            insuranceCost=2.45;
            shippingCost+=insuranceCost;
        } else if (shippingCost>1 && shippingCost<=3) {
            insuranceCost=3.95;
            shippingCost+=insuranceCost;
        } else if (shippingCost>3) {
            insuranceCost=5.55;
            shippingCost+=insuranceCost;
        }
    }

    @Override
    public String toString() {
        return "InsuredPackage{" +
                "insuranceCost=" + insuranceCost +
                ", weight=" + weight +
                ", shippingMethod=" + shippingMethod +
                ", shippingCost=" + shippingCost +
                '}';
    }
}