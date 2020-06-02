package com.example.gameofthrones.presentation.fragment

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.gameofthrones.R

class SettingsFragment: PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

}
