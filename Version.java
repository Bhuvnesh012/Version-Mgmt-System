import java.util.Arrays;

public class Version {
    private String versionNumber;
    private String minSupportedOS;
    private byte[] fileContent;

    public Version(String versionNumber, String minSupportedOS, byte[] fileContent) {
        if (versionNumber == null || minSupportedOS == null || fileContent == null) {
            throw new IllegalArgumentException("Version, OS, and file content cannot be null.");
        }
        this.versionNumber = versionNumber;
        this.minSupportedOS = minSupportedOS;
        this.fileContent = fileContent;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getMinSupportedOS() {
        return minSupportedOS;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    @Override
    public String toString() {
        return "Version: " + versionNumber + ", MinSupportedOS: " + minSupportedOS;
    }
}