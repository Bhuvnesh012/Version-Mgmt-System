public class VersionManager {

    public void uploadNewVersion(App app, Version version) {
        if (app == null || version == null) {
            throw new IllegalArgumentException("App or Version cannot be null");
        }
        app.addVersion(version);
        Logger.log("Uploaded new version: " + version);
    }

    public byte[] createUpdatePatch(App app, String fromVersion, String toVersion) {
        if (app == null || fromVersion == null || toVersion == null) {
            throw new IllegalArgumentException("Invalid arguments for patch creation");
        }
        Version from = app.getVersion(fromVersion);
        Version to = app.getVersion(toVersion);
        if (from == null || to == null) {
            throw new IllegalArgumentException("Version not found");
        }
        return ExternalServiceMock.createDiffPack(from.getFileContent(), to.getFileContent());
    }

    public void releaseVersion(App app, String version, RolloutStrategy strategy) {
        if (app == null || version == null || strategy == null) {
            throw new IllegalArgumentException("Invalid arguments for releaseVersion");
        }
        for (String deviceId : app.getReleasedDevices()) {
            if (strategy.shouldRollout(deviceId)) {
                app.releaseToDevice(deviceId);
            }
        }
        Logger.log("Released version: " + version + " using strategy: " + strategy.getClass().getSimpleName());
    }

    public boolean checkForUpdates(App app, Device device) {
        if (app == null || device == null) {
            throw new IllegalArgumentException("App or Device cannot be null");
        }
        String installedVersion = device.getInstalledVersion();
        return installedVersion != null && !installedVersion.equals(app.getLatestVersion().getVersionNumber());
    }

    public boolean checkForInstall(App app, Device device) {
        if (app == null || device == null) {
            throw new IllegalArgumentException("App or Device cannot be null");
        }
        return app.getLatestVersion().getMinSupportedOS().compareTo(device.getOsVersion()) <= 0;
    }
}