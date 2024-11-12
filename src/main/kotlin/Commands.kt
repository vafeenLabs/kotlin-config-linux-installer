package ru.vafeen

object Commands {
    // removing help on f1
    private val YELP_REMOVE = Command(
        text = "sudo rm /usr/bin/yelp",
        comment = "Removing help",
        sudo = true
    )

    //     enable dark theme
    private val ENABLE_DARK_THEME = Command(
        text = "gsettings set org.gnome.desktop.interface gtk-theme Adwaita-dark",
        comment = "Change theme",
    )

    //autorun for Flameshot, and also put prtscr on this file
    private val flameshotAutoRun = Command(
        text = "chmod +x /home/a/MYSPACE/myBin/flameshot.sh",
        comment = "Make flameshot.sh executable",
    )

    private val GIT_CONFIG = Command(
        text = "git config --global user.name \"Vafeen\"\n" +
                "git config --global user.email \"666av6@gmail.com\"",
        comment = "Update git config",
    )

    private val LANGUAGE_IN_EVERY_WINDOW = Command(
        text = "gsettings set org.gnome.desktop.input-sources per-window true",
        comment = "Add language in every window",
    )
    private val homeDirCall = "\$HOME"
    private val RENAMING_DIRS = Command(
        text = """
        mkdir "\$homeDirCall/Desktop"
        mkdir "$homeDirCall/Downloads"
        mkdir "$homeDirCall/Templates"
        mkdir "$homeDirCall/Public"
        mkdir "$homeDirCall/Documents"
        mkdir "$homeDirCall/Music"
        mkdir "$homeDirCall/Pictures"
        mkdir "$homeDirCall/Videos"

        mv "$homeDirCall/Рабочий стол/*" "$homeDirCall/Desktop/"
        mv "$homeDirCall/Загрузки/*" "$homeDirCall/Downloads/"
        mv "$homeDirCall/Шаблоны/*" "$homeDirCall/Templates/"
        mv "$homeDirCall/Общедоступные/*" "$homeDirCall/Public/"
        mv "$homeDirCall/Документы/*" "$homeDirCall/Documents/"
        mv "$homeDirCall/Музыка/*" "$homeDirCall/Music/"
        mv "$homeDirCall/Изображения/*" "$homeDirCall/Pictures/"
        mv "$homeDirCall/Видео/*" "$homeDirCall/Videos/"

        rmdir "$homeDirCall/Рабочий стол/"
        rmdir "$homeDirCall/Загрузки/"
        rmdir "$homeDirCall/Шаблоны/"
        rmdir "$homeDirCall/Общедоступные/"
        rmdir "$homeDirCall/Документы/"
        rmdir "$homeDirCall/Музыка/"
        rmdir "$homeDirCall/Изображения/"
        rmdir "$homeDirCall/Видео/"

        cat << EOF > ~/.config/user-dirs.dirs
        XDG_DESKTOP_DIR="$homeDirCall/Desktop"
        XDG_DOWNLOAD_DIR="$homeDirCall/Downloads"
        XDG_TEMPLATES_DIR="$homeDirCall/Templates"
        XDG_PUBLICSHARE_DIR="$homeDirCall/Public"
        XDG_DOCUMENTS_DIR="$homeDirCall/Documents"
        XDG_MUSIC_DIR="$homeDirCall/Music"
        XDG_PICTURES_DIR="$homeDirCall/Pictures"
        XDG_VIDEOS_DIR="$homeDirCall/Videos"

        EOF

        code ~/.config/user-dirs.dirs
    """.trimIndent(),
        comment = "Renaming default dirs",
    )

    private val WARP_TERMINAL_AS_DEFAULT_TERMINAL =
        Command(
            text = "gsettings set org.cinnamon.desktop.default-applications.terminal exec warp-terminal",
            comment = "Make warp is default terminal",
        )

    private val WARP_TERMINAL_AS_DEFAULT_TERMINAL2 =
        Command(text = "sudo update-alternatives --config warp-terminal", comment = "Make warp is default terminal")

    private val allCommands = listOf(
        YELP_REMOVE,
        ENABLE_DARK_THEME,
        flameshotAutoRun,
        GIT_CONFIG,
        LANGUAGE_IN_EVERY_WINDOW,
        RENAMING_DIRS,
        WARP_TERMINAL_AS_DEFAULT_TERMINAL,
        WARP_TERMINAL_AS_DEFAULT_TERMINAL2
    )


    fun runAllCommands() {
        for (command in allCommands) {
            command.comment.printComment()
            if (command.sudo) command.text.getSudoCommand()
            else command.text.getUserCommand()
            println("\n")

        }
    }
}