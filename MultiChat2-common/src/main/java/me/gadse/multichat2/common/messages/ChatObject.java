package me.gadse.multichat2.common.messages;

import me.gadse.multichat2.common.MultiChatChannel;

import java.io.*;
import java.util.UUID;

public class ChatObject {

    private final UUID sender;
    private final String message;
    private final MultiChatChannel multiChatChannel;

    /**
     * Constructs a ChatObject based on the given bytes.
     * This should only be used if receiving a plugin message and being sure that the bytes match.
     * Bytes can be received through the use of {@link #toBytes()}.
     *
     * @param byteObject is an array of bytes that should make up a ChatObject.
     * @throws IllegalArgumentException if the bytes were not valid.
     */
    public ChatObject(byte[] byteObject) throws IllegalArgumentException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteObject);

        try {
            ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = inputStream.readObject();
            if (!(object instanceof ChatObject))
                throw new IllegalArgumentException("Bytes provided were not a ChatObject.");

            ChatObject chatObject = (ChatObject) object;
            this.sender = chatObject.sender;
            this.message = chatObject.message;
            this.multiChatChannel = chatObject.multiChatChannel;
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException("Bytes provided were not a ChatObject.");
        }
    }

    /**
     * Constructs a ChatObject for the global channel.
     *
     * @param sender UUID of the sender of the message.
     * @param message the message.
     */
    public ChatObject(UUID sender, String message) {
        this(sender, message, MultiChatChannel.GLOBAL_CHAT);
    }

    /**
     * Constructs a ChatObject.
     *
     * @param sender UUID of the sender of the message.
     * @param message the message.
     * @param multiChatChannel the channel for the message to be sent in.
     */
    public ChatObject(UUID sender, String message, MultiChatChannel multiChatChannel) {
        this.sender = sender;
        this.message = message;
        this.multiChatChannel = multiChatChannel;
    }

    /**
     * Converts this object into it's bytes, to be sent over the plugin messaging channel.
     *
     * @return the bytes, valid to be passed into the appropriate constructor.
     */
    public byte[] toBytes() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream outputStream =  new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * Gets the sender.
     *
     * @return UUID of the sender of the message.
     */
    public UUID getSender() {
        return sender;
    }

    /**
     * Gets the message.
     *
     * @return the message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the MultiChatChanel for ease of difference between messages.
     *
     * @return the MultiChatChanel.
     */
    public MultiChatChannel getMultiChatChannel() {
        return multiChatChannel;
    }
}
