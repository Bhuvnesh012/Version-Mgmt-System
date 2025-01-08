import java.util.Set;

public class BetaRolloutStrategy implements RolloutStrategy {
    private Set<String> betaDevices;

    public BetaRolloutStrategy(Set<String> betaDevices) {
        this.betaDevices = betaDevices;
    }

    @Override
    public boolean shouldRollout(String deviceId) {
        return betaDevices.contains(deviceId);
    }
}