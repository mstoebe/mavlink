package io.dronefleet.mavlink.icarous;

import io.dronefleet.mavlink.MavlinkDialect;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class IcarousDialect implements MavlinkDialect {
    /**
     * A list of dialects that this dialect depends on.
     */
    private final List<MavlinkDialect> dependencies = Collections.emptyList();

    /**
     * {@inheritDoc}
     */
    @Override
    public final String name() {
        return "icarous";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 42000:
            case 42001:
                return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 42000: return IcarousHeartbeat.class;
            case 42001: return IcarousKinematicBands.class;
        }
        return dependencies.stream()
                .map(d -> d.resolve(messageId))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(getClass().getSimpleName() + " does not support message of ID " + messageId));
    }
}
