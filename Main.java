import java.util.Set;

public class Main {
    public static void main(String[] args) {
        VersionManager manager = new VersionManager();
        App phonePe = new App("PhonePe");

        // Create versions
        Version v1 = new Version("1.0", "5.0", new byte[]{1, 2, 3});
        Version v2 = new Version("2.0", "5.0", new byte[]{1, 2, 3, 4});

        // Upload versions
        manager.uploadNewVersion(phonePe, v1);
        manager.uploadNewVersion(phonePe, v2);

        // Create update patch
        byte[] patch = manager.createUpdatePatch(phonePe, "1.0", "2.0");

        // Release version with Beta rollout
        RolloutStrategy betaStrategy = new BetaRolloutStrategy(Set.of("Device1", "Device2"));
        manager.releaseVersion(phonePe, "2.0", betaStrategy);

        // Check for updates
        Device device = new Device("5.0", "1.0");
        boolean updateAvailable = manager.checkForUpdates(phonePe, device);
        System.out.println("Update available: " + updateAvailable);

        // Check for install
        Device newDevice = new Device("5.0", null);
        boolean canInstall = manager.checkForInstall(phonePe, newDevice);
        System.out.println("Can install: " + canInstall);
    }
}