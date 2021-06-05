package me.gadse.multichat2.common;

import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

public class MultiChatRegexUtil {

    private static final Pattern STRIP_COLOR_PATTERN = Pattern.compile("(?i)\u00A7[0-9A-FK-ORX]");

    /**
     * Strips color based off of the regex (?i)§[0-9A-FK-ORX]
     *
     * @param input the string to remove color from.
     * @return null if the input was null, otherwise a color stripped string.
     */
    public static String stripColor(@Nullable final String input) {
        if (input == null) {
            return null;
        }

        return STRIP_COLOR_PATTERN.matcher(input).replaceAll("");
    }
}
