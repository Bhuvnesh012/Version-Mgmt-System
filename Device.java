public class Device {
    private String osVersion;
    private String installedVersion;

    public Device(String osVersion, String installedVersion) {
        this.osVersion = osVersion;
        this.installedVersion = installedVersion;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getInstalledVersion() {
        return installedVersion;
    }

    public void setInstalledVersion(String installedVersion) {
        this.installedVersion = installedVersion;
    }
}