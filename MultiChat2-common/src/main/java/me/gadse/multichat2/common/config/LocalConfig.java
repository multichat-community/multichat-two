package me.gadse.multichat2.common.config;

import java.util.Set;

public interface LocalConfig {

    // Global settings.
    boolean isOverrideGlobalFormat();
    boolean isPreventGlobalChat();
    String getGlobalFormat();

    // Local settings.
    boolean isSetLocalFormat();
    boolean isPreventLocalChat();
    String getLocalFormat();

    // Regex settings.
    Set<ForceChannelFilter> getForceChannelFilters();
}
