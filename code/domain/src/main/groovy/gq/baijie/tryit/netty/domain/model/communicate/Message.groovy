package gq.baijie.tryit.netty.domain.model.communicate

import groovy.transform.Immutable
import okio.ByteString

@Immutable(knownImmutableClasses = [ByteString])
class Message {

    public static final int MAX_FRAME_LENGTH = 2**16 - 1;
    public static final int LENGTH_FIELD_OFFSET = 1;
    public static final int LENGTH_FIELD_LENGTH = 2;
    public static final int TYPE_FIELD_LENGTH = 1;
    static {
        assert Byte.BYTES == TYPE_FIELD_LENGTH
        assert Short.BYTES == LENGTH_FIELD_LENGTH
    }

    byte type
    ByteString data

    /**
     * the length of {@link #data}
     * @return the length of {@link #data}
     */
    int getLength() {
        data?.size() ?: 0
    }

    int getUnsignedType() {//TODO return short or int?
        return type & 0x00ff
    }

}
