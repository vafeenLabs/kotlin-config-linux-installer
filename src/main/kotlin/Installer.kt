package ru.vafeen

sealed class Installer {
    abstract fun install(applicationID: String): String
    abstract fun remove(applicationID: String): String
    abstract fun refresh(): String

    data object FLATPAK : Installer() {
        override fun install(applicationID: String): String = "flatpak install -y $applicationID"

        override fun remove(applicationID: String): String = "flatpak remove $applicationID"
        override fun refresh(): String = "flatpak update"

    }

    data object SNAP : Installer() {
        override fun install(applicationID: String): String = "snap install $applicationID"
        override fun remove(applicationID: String): String = "snap remove $applicationID"
        override fun refresh(): String = "snap refresh"

    }

    data object DNF : Installer() {
        override fun install(applicationID: String): String = "sudo dnf install -y $applicationID"
        override fun remove(applicationID: String): String = "dnf remove $applicationID"
        override fun refresh(): String = "dnf update"

    }

    companion object {
        fun refreshAll() {
            (FLATPAK::refresh)()
            (SNAP::refresh)()
            (DNF::refresh)()
        }
    }
}