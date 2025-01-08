public class ExternalServiceMock {

    public static void installApp(String appFile) {
        Logger.log("Installing app with file: " + appFile);
    }

    public static void updateApp(byte[] patch) {
        Logger.log("Updating app with patch of size: " + patch.length);
    }

    public static byte[] createDiffPack(byte[] fromFile, byte[] toFile) {
        // Simple mock implementation
        return new byte[]{(byte) (toFile.length - fromFile.length)};
    }
}