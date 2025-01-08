import java.util.*;

public class App {
    private String appName;
    private Map<String, Version> versions;
    private Set<String> releasedDevices;

    public App(String appName) {
        if (appName == null) {
            throw new IllegalArgumentException("App name cannot be null.");
        }
        this.appName = appName;
        this.versions = new HashMap<>();
        this.releasedDevices = new HashSet<>();
    }

    public void addVersion(Version version) {
        versions.put(version.getVersionNumber(), version);
    }

    public Version getVersion(String versionNumber) {
        return versions.get(versionNumber);
    }

    public Version getLatestVersion() {
        return versions.values().stream()
                .max(Comparator.comparing(Version::getVersionNumber))
                .orElse(null);
    }

    public void releaseToDevice(String deviceId) {
        releasedDevices.add(deviceId);
    }

    public boolean isDeviceReleased(String deviceId) {
        return releasedDevices.contains(deviceId);
    }

    public String getAppName() {
        return appName;
    }

    public Set<String> getReleasedDevices() {
        return releasedDevices;
    }
}