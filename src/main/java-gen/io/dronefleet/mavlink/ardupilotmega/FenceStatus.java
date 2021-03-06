package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.common.FenceBreach;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Status of geo-fencing. Sent in extended status stream when fencing enabled 
 */
@MavlinkMessageInfo(
        id = 162,
        crc = 189
)
public final class FenceStatus {
    private final int breachStatus;

    private final int breachCount;

    private final FenceBreach breachType;

    private final long breachTime;

    private FenceStatus(int breachStatus, int breachCount, FenceBreach breachType,
            long breachTime) {
        this.breachStatus = breachStatus;
        this.breachCount = breachCount;
        this.breachType = breachType;
        this.breachTime = breachTime;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * 0 if currently inside fence, 1 if outside 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int breachStatus() {
        return this.breachStatus;
    }

    /**
     * number of fence breaches 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 2
    )
    public final int breachCount() {
        return this.breachCount;
    }

    /**
     * last breach type (see FENCE_BREACH_* enum) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final FenceBreach breachType() {
        return this.breachType;
    }

    /**
     * time of last breach in milliseconds since boot 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 4
    )
    public final long breachTime() {
        return this.breachTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FenceStatus other = (FenceStatus)o;
        if (!Objects.deepEquals(breachStatus, other.breachStatus)) return false;
        if (!Objects.deepEquals(breachCount, other.breachCount)) return false;
        if (!Objects.deepEquals(breachType, other.breachType)) return false;
        if (!Objects.deepEquals(breachTime, other.breachTime)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(breachStatus);
        result = 31 * result + Objects.hashCode(breachCount);
        result = 31 * result + Objects.hashCode(breachType);
        result = 31 * result + Objects.hashCode(breachTime);
        return result;
    }

    public static final class Builder {
        private int breachStatus;

        private int breachCount;

        private FenceBreach breachType;

        private long breachTime;

        /**
         * 0 if currently inside fence, 1 if outside 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder breachStatus(int breachStatus) {
            this.breachStatus = breachStatus;
            return this;
        }

        /**
         * number of fence breaches 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 2
        )
        public final Builder breachCount(int breachCount) {
            this.breachCount = breachCount;
            return this;
        }

        /**
         * last breach type (see FENCE_BREACH_* enum) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder breachType(FenceBreach breachType) {
            this.breachType = breachType;
            return this;
        }

        /**
         * time of last breach in milliseconds since boot 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 4
        )
        public final Builder breachTime(long breachTime) {
            this.breachTime = breachTime;
            return this;
        }

        public final FenceStatus build() {
            return new FenceStatus(breachStatus, breachCount, breachType, breachTime);
        }
    }
}
