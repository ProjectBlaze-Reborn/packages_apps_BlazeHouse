/*
 * Copyright (C) 2014-2016 The Dirty Unicorns Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blaze.house.categories;

import android.content.ContentResolver;
import android.os.Bundle;
import com.android.internal.util.blaze.udfps.CustomUdfpsUtils;
import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceCategory;

import com.android.internal.logging.nano.MetricsProto;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class Lockscreen extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private PreferenceCategory mUdfpsCategory;

    private static final String TAG = "Lockscreen";
    private static final String UDFPS_CATEGORY = "udfps_category";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.lockscreen);

        ContentResolver resolver = getActivity().getContentResolver();
	final PreferenceScreen prefScreen = getPreferenceScreen();
	mUdfpsCategory = findPreference(UDFPS_CATEGORY);
	//Handle NPE on UdfpsCategory being null
        if (mUdfpsCategory != null && !CustomUdfpsUtils.hasUdfpsSupport(getContext())) {
            prefScreen.removePreference(mUdfpsCategory);
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.BLAZE_HOUSE;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return true;
    }

}
