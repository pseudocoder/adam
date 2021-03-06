/*****************************************************************************************
 * *** BEGIN LICENSE BLOCK *****
 *
 * echocat Adam, Copyright (c) 2014 echocat
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
 *
 * *** END LICENSE BLOCK *****
 ****************************************************************************************/

package org.echocat.adam.localization;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public abstract class LocalizedSupport implements Localized {

    @Override
    @Nullable
    public Map<Locale, Localization> getLocalizations() {
        final Map<Locale, Localization> result;
        final Collection<org.echocat.adam.configuration.localization.Localization> localizationElements = getConfigurationBasedLocalizations();
        if (localizationElements != null) {
            result = new LinkedHashMap<>(localizationElements.size(), 1f);
            for (final org.echocat.adam.configuration.localization.Localization localizationElement : localizationElements) {
                result.put(localizationElement.getLocale(), localizationElement);
            }
        } else {
            result = null;
        }
        return result;
    }

    @Nullable
    protected Collection<org.echocat.adam.configuration.localization.Localization> getConfigurationBasedLocalizations() {
        return null;
    }

}
