package me.gadse.multichat2.common.config;

import me.gadse.multichat2.common.MultiChatChannel;
import me.gadse.multichat2.common.MultiChatRegexUtil;

import java.util.regex.Pattern;

public class ForceChannelFilter {

    private final Pattern pattern;
    private final boolean isIgnoreFormatCodes;
    private final MultiChatChannel multiChatChannel;

    public ForceChannelFilter(Pattern pattern, boolean isIgnoreFormatCodes, MultiChatChannel multiChatChannel) {
        this.pattern = pattern;
        this.isIgnoreFormatCodes = isIgnoreFormatCodes;
        this.multiChatChannel = multiChatChannel;
    }

    public boolean test(String message) {
        if (isIgnoreFormatCodes)
            message = MultiChatRegexUtil.stripColor(message);
        return pattern.matcher(message).find();
    }

    public MultiChatChannel getMultiChatChannel() {
        return multiChatChannel;
    }
}
