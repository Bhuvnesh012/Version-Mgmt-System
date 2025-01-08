public interface RolloutStrategy {
    boolean shouldRollout(String deviceId);
}