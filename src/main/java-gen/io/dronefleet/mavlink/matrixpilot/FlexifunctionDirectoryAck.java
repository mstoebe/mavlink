package io.dronefleet.mavlink.matrixpilot;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import java.lang.Object;
import java.lang.Override;
import java.util.Objects;

/**
 * Acknowldge sucess or failure of a flexifunction command 
 */
@MavlinkMessageInfo(
        id = 156,
        crc = 218
)
public final class FlexifunctionDirectoryAck {
    private final int targetSystem;

    private final int targetComponent;

    private final int directoryType;

    private final int startIndex;

    private final int count;

    private final int result;

    private FlexifunctionDirectoryAck(int targetSystem, int targetComponent, int directoryType,
            int startIndex, int count, int result) {
        this.targetSystem = targetSystem;
        this.targetComponent = targetComponent;
        this.directoryType = directoryType;
        this.startIndex = startIndex;
        this.count = count;
        this.result = result;
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
     * 0=inputs, 1=outputs 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1
    )
    public final int directoryType() {
        return this.directoryType;
    }

    /**
     * index of first directory entry to write 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1
    )
    public final int startIndex() {
        return this.startIndex;
    }

    /**
     * count of directory entries to write 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 1
    )
    public final int count() {
        return this.count;
    }

    /**
     * result of acknowledge, 0=fail, 1=good 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 2
    )
    public final int result() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        FlexifunctionDirectoryAck other = (FlexifunctionDirectoryAck)o;
        if (!Objects.deepEquals(targetSystem, other.targetSystem)) return false;
        if (!Objects.deepEquals(targetComponent, other.targetComponent)) return false;
        if (!Objects.deepEquals(directoryType, other.directoryType)) return false;
        if (!Objects.deepEquals(startIndex, other.startIndex)) return false;
        if (!Objects.deepEquals(count, other.count)) return false;
        if (!Objects.deepEquals(result, other.result)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(targetSystem);
        result = 31 * result + Objects.hashCode(targetComponent);
        result = 31 * result + Objects.hashCode(directoryType);
        result = 31 * result + Objects.hashCode(startIndex);
        result = 31 * result + Objects.hashCode(count);
        result = 31 * result + Objects.hashCode(result);
        return result;
    }

    public static final class Builder {
        private int targetSystem;

        private int targetComponent;

        private int directoryType;

        private int startIndex;

        private int count;

        private int result;

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
         * 0=inputs, 1=outputs 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1
        )
        public final Builder directoryType(int directoryType) {
            this.directoryType = directoryType;
            return this;
        }

        /**
         * index of first directory entry to write 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1
        )
        public final Builder startIndex(int startIndex) {
            this.startIndex = startIndex;
            return this;
        }

        /**
         * count of directory entries to write 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 1
        )
        public final Builder count(int count) {
            this.count = count;
            return this;
        }

        /**
         * result of acknowledge, 0=fail, 1=good 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 2
        )
        public final Builder result(int result) {
            this.result = result;
            return this;
        }

        public final FlexifunctionDirectoryAck build() {
            return new FlexifunctionDirectoryAck(targetSystem, targetComponent, directoryType, startIndex, count, result);
        }
    }
}
