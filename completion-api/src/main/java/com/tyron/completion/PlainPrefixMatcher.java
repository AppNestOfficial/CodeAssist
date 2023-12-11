package com.tyron.completion;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.com.intellij.openapi.util.text.StringUtil;


public class PlainPrefixMatcher extends PrefixMatcher {

  private final boolean myPrefixMatchesOnly;

  public PlainPrefixMatcher(@NotNull String prefix) {
    this(prefix, false);
  }

  public PlainPrefixMatcher(@NotNull String prefix, boolean prefixMatchesOnly) {
    super(prefix);
    myPrefixMatchesOnly = prefixMatchesOnly;
  }

  @Override
  public boolean isStartMatch(@NotNull String name) {
    return StringUtil.startsWithIgnoreCase(name, getPrefix());
  }

  @Override
  public boolean prefixMatches(@NotNull String name) {
    if (myPrefixMatchesOnly) {
      return isStartMatch(name);
    }
    return StringUtil.containsIgnoreCase(name, getPrefix());
  }

  @NotNull
  @Override
  public PrefixMatcher cloneWithPrefix(@NotNull String prefix) {
    return new PlainPrefixMatcher(prefix, myPrefixMatchesOnly);
  }
}