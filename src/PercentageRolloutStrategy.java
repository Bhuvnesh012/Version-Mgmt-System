public class PercentageRolloutStrategy implements RolloutStrategy {
    private int percentage;

    public PercentageRolloutStrategy(int percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Percentage must be between 0 and 100.");
        }
        this.percentage = percentage;
    }

    @Override
    public boolean shouldRollout(String deviceId) {
        return deviceId.hashCode() % 100 < percentage;
    }
}