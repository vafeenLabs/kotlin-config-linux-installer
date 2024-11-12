package ru.vafeen


object Packages {
    private var CODE = Package(name = "code", process = Installer.SNAP::install)
    private var OBSIDIAN = Package(name = "obsidian", process = Installer.SNAP::install)
    private var ANDROID_STUDIO = Package(name = "android-studio", process = Installer.SNAP::install)
    private var P7ZIP_DESKTOP = Package(name = "p7zip-desktop --classic", process = Installer.SNAP::install)
    private var SNAP = Package(
        name = "snap", customCommand = """
            sudo dnf install -y snapd
            sudo ln -s /var/lib/snapd/snap /snap
            sudo systemctl restart snapd.service
        """.trimIndent()
    )
    private var GIT = Package(name = "git", process = Installer.DNF::install)
    private var GPP = Package(name = "g++", process = Installer.DNF::install)
    private var LIBREOFFICE = Package(name = "libreoffice-data", process = Installer.DNF::remove)
    private var FLAMESHOT = Package(name = "flameshot", process = Installer.DNF::install)
    private var DCONF_EDITOR = Package(name = "dconf-editor", process = Installer.DNF::install)
    private var GNOME_TWEAKS = Package(name = "gnome-tweak-tool", process = Installer.DNF::install)
    private var VIRTUALBOX = Package(name = "VirtualBox-7.0", process = Installer.DNF::install)
    private var EDGE = Package(name = "com.microsoft.Edge", process = Installer.FLATPAK::install)
    private var TG_DESKTOP = Package(name = "org.telegram.desktop", process = Installer.FLATPAK::install)
    private var JADX = Package(name = "com.github.skylot.jadx", process = Installer.FLATPAK::install)
    private var RESOURCES = Package(name = "net.nokyan.Resources", process = Installer.FLATPAK::install)
    private var ONLYOFFICE = Package(name = "org.onlyoffice.desktopeditors", process = Installer.FLATPAK::install)
    private var INTELLIJ_IDEA = Package(name = "intellij-idea-community --classic", process = Installer.SNAP::install)
    private val allPackages = listOf(
        CODE,
        OBSIDIAN,
        ANDROID_STUDIO,
        P7ZIP_DESKTOP,
        SNAP,
        GIT,
        GPP,
        LIBREOFFICE,
        FLAMESHOT,
        DCONF_EDITOR,
        GNOME_TWEAKS,
        VIRTUALBOX,
        EDGE,
        TG_DESKTOP,
        JADX,
        RESOURCES,
        ONLYOFFICE,
        INTELLIJ_IDEA,
    )

    fun installAll() {
        for (pack in allPackages) {
            if (pack.process != null) pack.process?.let { it(pack.packageName) }?.getSudoCommand()
            else pack.customCommand?.getSudoCommand()
            println()
        }
    }
}