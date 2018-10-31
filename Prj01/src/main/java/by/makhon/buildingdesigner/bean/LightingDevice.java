package by.makhon.buildingdesigner.bean;

import java.util.Objects;

public class LightingDevice {

    private int lightingDeviceId;
    private String lightingDeviceName;
    private double illuminanceOfLightingDevice;

    public int getLightingDeviceId() {
        return lightingDeviceId;
    }

    public void setLightingDeviceId(int lightingDeviceId) {
        this.lightingDeviceId = lightingDeviceId;
    }

    public String getLightingDeviceName() {
        return lightingDeviceName;
    }

    public void setLightingDeviceName(String lightingDeviceName) {
        this.lightingDeviceName = lightingDeviceName;
    }

    public double getIlluminanceOfLightingDevice() {
        return illuminanceOfLightingDevice;
    }

    public void setIlluminanceOfLightingDevice(double illuminanceOfLightingDevice) {
        this.illuminanceOfLightingDevice = illuminanceOfLightingDevice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightingDevice that = (LightingDevice) o;
        return lightingDeviceId == that.lightingDeviceId &&
                Double.compare(that.illuminanceOfLightingDevice, illuminanceOfLightingDevice) == 0 &&
                Objects.equals(lightingDeviceName, that.lightingDeviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lightingDeviceId, lightingDeviceName, illuminanceOfLightingDevice);
    }

    public static class LightingDeviceBuilder {
        private LightingDevice lightingDevice = new LightingDevice();

        public static LightingDeviceBuilder create() {
            return new LightingDeviceBuilder();
        }

        public LightingDeviceBuilder withLightingDeviceName(String lightingDeviceName) {
            lightingDevice.lightingDeviceName = lightingDeviceName;
            return this;
        }

        public LightingDeviceBuilder withIlluminanceOfLightingDevice(double illuminanceOfLightingDevice) {
            lightingDevice.illuminanceOfLightingDevice = illuminanceOfLightingDevice;
            return this;
        }

        public LightingDevice build(){
            return lightingDevice;
        }
    }

}
