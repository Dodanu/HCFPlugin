package multiplechoice.hcf.hcf.Claim;

public class Cuboid {

    public double x1;

    public double x2;

    public double z1;

    public double z2;

    public double getX1() { return this.x1; }

    public double getX2() { return this.x2; }

    public double getZ1() { return this.z1; }

    public double getZ2() { return this.z2; }

    public double getSmallerX() {

        if(this.x1 < this.x2) {
            return this.x1;
        }
        return this.x2;

    }

    public double getBiggerX() {

        if(this.x1 > this.x2) {
            return this.x1;
        }
        return this.x2;

    }

    public double getSmallerZ() {

        if(this.z1 < this.z2) {
            return this.z1;
        }
        return this.z2;

    }

    public double getBiggerZ() {

        if(this.z1 > this.z2) {
            return this.z1;
        }
        return this.z2;

    }

    public void setX1(double x1) { this.x1 = x1; }

    public void setX2(double x2) { this.x2 = x2; }

    public void setZ1(double z1) { this.z1 = z1; }

    public void setZ2(double z2) { this.z2 = z2; }

    public double getPrice() {

        double finalDistance = this.z1 - this.x1;

        if(finalDistance < 0)
            finalDistance = finalDistance*-1;

        return finalDistance*100;

    }
}
