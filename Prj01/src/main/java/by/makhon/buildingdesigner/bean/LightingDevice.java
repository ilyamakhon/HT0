package by.makhon.buildingdesigner.bean;

import java.util.Objects;

public class LightingDevice {

    private String name;
    private double illuminance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIlluminance() {
        return illuminance;
    }

    public void setIlluminance(double illuminance) {
        this.illuminance = illuminance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightingDevice that = (LightingDevice) o;
        return Double.compare(that.illuminance, illuminance) == 0 &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, illuminance);
    }

    public static class LightingDeviceBuilder {
        private LightingDevice lightingDevice = new LightingDevice();

        public static LightingDeviceBuilder create() {
            return new LightingDeviceBuilder();
        }

        public LightingDeviceBuilder withLightingDeviceName(String lightingDeviceName) {
            lightingDevice.name = lightingDeviceName;
            return this;
        }

        public LightingDeviceBuilder withIlluminanceOfLightingDevice(double illuminanceOfLightingDevice) {
            lightingDevice.illuminance = illuminanceOfLightingDevice;
            return this;
        }

        public LightingDevice build(){
            return lightingDevice;
        }
    }

}
