import voodoo.data.Side
import voodoo.data.curse.FileType

mcVersion = "1.12.2"
version = "1.0.1"
icon = rootDir.resolve("icon.png")
authors = listOf("NikkyAi")
forge = Forge.recommended
root(CurseProvider) {
    releaseTypes = setOf(FileType.RELEASE, FileType.BETA)

    //TODO: use type URL ?
    metaUrl = "https://curse.nikky.moe/api"
    list {
        +Mod.botania

        +Mod.foamfixForMinecraft
        +Mod.mekanism

        group {
            side = Side.CLIENT
        }.list {
            +Mod.jei
        }

        +Mod.rftools configure {
            fileName = "rftools.jar"
        }

        withProvider(JenkinsProvider) {
            jenkinsUrl = "https://ci.elytradev.com"
            side = Side.SERVER
        }.list {
            +"matterlink" job "elytra/MatterLink/master"
            +"btfu" job "elytra/BTFU/multi-version"
        }

        +Mod.tails
        +Mod.wearableBackpacks
    }
}
