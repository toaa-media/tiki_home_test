package com.vn.tikihometest.interfaces;

/**
 * Created by namhoainguyen on 11/6/18.
 * <p>
 * The interface for keyword.
 */
public interface IKeyword {

    /**
     * Gets the original name of keyword.
     *
     * @return the original name of keyword.
     */
    String getOriginalName();

    /**
     * Sets the {@link String} instance representing the display name.
     *
     * @param displayName the display name.
     */
    void setDisplayName(String displayName);

    /**
     * Gets the display name of keyword.
     *
     * @return the display name of keyword.
     */
    String getDisplayName();

    /**
     * Gets the color of keyword.
     *
     * @return the color of keyword.
     */
    int getKeywordColor();

}
