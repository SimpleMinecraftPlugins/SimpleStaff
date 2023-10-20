package me.corecraft.staffplus.listeners

import me.corecraft.staffplus.StaffPlus

class TestUtil {

    fun send(plugin: StaffPlus) {
        plugin.logger.warning("This is a test!")
    }
}