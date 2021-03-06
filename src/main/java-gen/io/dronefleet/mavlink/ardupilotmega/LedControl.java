package io.dronefleet.mavlink.ardupilotmega;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Control vehicle LEDs 
 */
@MavlinkMessageInfo(
        id = 186,
        crc = 72
)
public final class LedControl {
    private final int targetSystem;

    private final int targetComponent;

    private final int instance;

    private final int pattern;

    private final int customLen;

    private final byte[] customBytes;

    private LedControl(int targetSystem, int targetComponent, int instance, int pattern,
            int customLen, byte[] customBytes) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.instance = instance;
        this.pattern = pattern;
        this.customLen = customLen;
        this.customBytes = customBytes;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * System ID 
     */
    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1
    )
    public final int targetSystem() {
        return this.targetSystem;
    }

    /**
     * Component ID 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 1
    )
    public final int targetComponent() {
        return this.targetComponent;
    }

    /**
     * Instance (LED instance to control or 255 for all LEDs) 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int instance() {
        return this.instance;
    }

    /**
     * Pattern (see LED_PATTERN_ENUM) 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int pattern() {
        return this.pattern;
    }

    /**
     * Custom Byte Length 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int customLen() {
        return this.customLen;
    }

    /**
     * Custom Bytes 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 1,
            arraySize = 24
    )
    public final byte[] customBytes() {
        return this.customBytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        LedControl other = (LedControl)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(instance, other.instance)) return false;
        if (!Objects.deepEquals(pattern, other.pattern)) return false;
        if (!Objects.deepEquals(customLen, other.customLen)) return false;
        if (!Objects.deepEquals(customBytes, other.customBytes)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(instance);
        result = 31 * result + Objects.hashCode(pattern);
        result = 31 * result + Objects.hashCode(customLen);
        result = 31 * result + Objects.hashCode(customBytes);
        return result;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int instance;

        private int pattern;

        private int customLen;

        private byte[] customBytes;

        /**
         * System ID 
         */
        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1
        )
        public final Builder targetSystem(int targetSystem) {
            this.targetSystem = targetSystem;
            return this;
        }

        /**
         * Component ID 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 1
        )
        public final Builder targetComponent(int targetComponent) {
            this.targetComponent = targetComponent;
            return this;
        }

        /**
         * Instance (LED instance to control or 255 for all LEDs) 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder instance(int instance) {
            this.instance = instance;
            return this;
        }

        /**
         * Pattern (see LED_PATTERN_ENUM) 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder pattern(int pattern) {
            this.pattern = pattern;
            return this;
        }

        /**
         * Custom Byte Length 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder customLen(int customLen) {
            this.customLen = customLen;
            return this;
        }

        /**
         * Custom Bytes 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 1,
                arraySize = 24
        )
        public final Builder customBytes(byte[] customBytes) {
            this.customBytes = customBytes;
            return this;
        }

        public final LedControl build() {
            return new LedControl(targetSystem, targetComponent, instance, pattern, customLen, customBytes);
        }
    }
}
