package xol.lostinfinity.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import xol.lostinfinity.LostInfinity;

public final class LostEntityTextures {
    private static final ResourceLocation FALLBACK = new ResourceLocation(LostInfinity.MODID, "textures/entity/deviantbear.png");
    private static final Map<String, ResourceLocation> TEXTURES = new HashMap<>();
    private static final Map<String, ResourceLocation> RESOLVED = new HashMap<>();

    static {
        TEXTURES.put("dimensionalmerchant", new ResourceLocation(LostInfinity.MODID, "textures/entity/dim_merchant/dimensionalmerchant_cellgame.png"));
        TEXTURES.put("deviantbear", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantbear.png"));
        TEXTURES.put("treadmillobstacle", new ResourceLocation(LostInfinity.MODID, "textures/entity/treadmill_obstacle_1.png"));
        TEXTURES.put("deviantghast", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantghast.png"));
        TEXTURES.put("deviantcow", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantcow.png"));
        TEXTURES.put("deviantsheep", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantsheep.png"));
        TEXTURES.put("devianthorse", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/devianthorse.png"));
        TEXTURES.put("deviantpig", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantpig.png"));
        TEXTURES.put("deviantevoker", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantevoker.png"));
        TEXTURES.put("deviantevokervex", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantevoker.png"));
        TEXTURES.put("deviantenderman", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantenderman.png"));
        TEXTURES.put("deviantchicken", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantchicken.png"));
        TEXTURES.put("deviantshulker", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantshulker.png"));
        TEXTURES.put("deviantskyworm", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantskyworm.png"));
        TEXTURES.put("elara", new ResourceLocation(LostInfinity.MODID, "textures/entity/elaraboundless.png"));
        TEXTURES.put("deviantcreeper", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantcreeper.png"));
        TEXTURES.put("deviantskeleton", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantskeleton.png"));
        TEXTURES.put("urogo", new ResourceLocation(LostInfinity.MODID, "textures/entity/urogo.png"));
        TEXTURES.put("droid", new ResourceLocation(LostInfinity.MODID, "textures/entity/droid_mk1_aggressive.png"));
        TEXTURES.put("lostdeviant", new ResourceLocation(LostInfinity.MODID, "textures/entity/lostdeviant.png"));
        TEXTURES.put("arenaevent", new ResourceLocation(LostInfinity.MODID, "textures/entity/arenaevent.png"));
        TEXTURES.put("labwarrior", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/labwarrior.png"));
        TEXTURES.put("labwizard", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/labwizard.png"));
        TEXTURES.put("deviantspider", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantspider.png"));
        TEXTURES.put("aspect", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/aspect_blue.png"));
        TEXTURES.put("slimestrider", new ResourceLocation(LostInfinity.MODID, "textures/entity/slimestrider.png"));
        TEXTURES.put("velo", new ResourceLocation(LostInfinity.MODID, "textures/entity/velo.png"));
        TEXTURES.put("galaxybeast", new ResourceLocation(LostInfinity.MODID, "textures/entity/galaxybeast_blue.png"));
        TEXTURES.put("galaxysorcerer", new ResourceLocation(LostInfinity.MODID, "textures/entity/galaxysorcerer_blue.png"));
        TEXTURES.put("galaxygladiator", new ResourceLocation(LostInfinity.MODID, "textures/entity/galaxygladiator_blue.png"));
        TEXTURES.put("galaxyspire", new ResourceLocation(LostInfinity.MODID, "textures/entity/galaxyspire.png"));
        TEXTURES.put("deviantamalgam", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantamalgam.png"));
        TEXTURES.put("starfiend", new ResourceLocation(LostInfinity.MODID, "textures/entity/starfiend.png"));
        TEXTURES.put("bloodhunter", new ResourceLocation(LostInfinity.MODID, "textures/entity/bloodhunter.png"));
        TEXTURES.put("fungfly", new ResourceLocation(LostInfinity.MODID, "textures/entity/fungal/fungfly_blue.png"));
        TEXTURES.put("rikarus", new ResourceLocation(LostInfinity.MODID, "textures/entity/rikarus.png"));
        TEXTURES.put("deviantwitch", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantwitch.png"));
        TEXTURES.put("mirrorzombie", new ResourceLocation(LostInfinity.MODID, "textures/entity/mirrorzombie.png"));
        TEXTURES.put("deviantslimestrider", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantslimestrider.png"));
        TEXTURES.put("chemist", new ResourceLocation(LostInfinity.MODID, "textures/entity/chemist.png"));
        TEXTURES.put("sandattack", new ResourceLocation(LostInfinity.MODID, "textures/entity/sand_attack.png"));
        TEXTURES.put("deviantblaze", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantblaze.png"));
        TEXTURES.put("trialobserver", new ResourceLocation(LostInfinity.MODID, "textures/entity/trialobserver.png"));
        TEXTURES.put("reflectal", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/reflectal.png"));
        TEXTURES.put("luminousguardian", new ResourceLocation(LostInfinity.MODID, "textures/entity/luminous_guardian.png"));
        TEXTURES.put("hanger", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/hanger.png"));
        TEXTURES.put("acidback", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/acidback.png"));
        TEXTURES.put("gravhead", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/gravhead.png"));
        TEXTURES.put("rockpest", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/rockpest.png"));
        TEXTURES.put("spinovern", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/spinovern.png"));
        TEXTURES.put("hypnosaur", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/hypnosaur.png"));
        TEXTURES.put("chomper", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/chomper.png"));
        TEXTURES.put("ribrex", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/ribrex.png"));
        TEXTURES.put("gnawer", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/gnawer.png"));
        TEXTURES.put("screacher", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/screacher.png"));
        TEXTURES.put("eyeslug", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/eyeslug.png"));
        TEXTURES.put("flutterfyre", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/flutterfyre.png"));
        TEXTURES.put("deviantsnowman", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantsnowman.png"));
        TEXTURES.put("nuxuro", new ResourceLocation(LostInfinity.MODID, "textures/entity/nuxuro.png"));
        TEXTURES.put("clyster", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/clyster.png"));
        TEXTURES.put("crawker", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/crawker.png"));
        TEXTURES.put("dusker", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/dusker.png"));
        TEXTURES.put("explosect", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/explosect.png"));
        TEXTURES.put("flapper", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/flapper.png"));
        TEXTURES.put("flurky", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/flurky.png"));
        TEXTURES.put("fyreweed", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/fyreweed.png"));
        TEXTURES.put("grappler", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/grappler.png"));
        TEXTURES.put("hurler", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/hurler.png"));
        TEXTURES.put("phaser", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/phaser.png"));
        TEXTURES.put("shimmer", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/shimmer.png"));
        TEXTURES.put("spyker", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/spyker.png"));
        TEXTURES.put("deviantmooshroom", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantmooshroom.png"));
        TEXTURES.put("deviantzombie", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantzombie.png"));
        TEXTURES.put("deviantslime", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantslime.png"));
        TEXTURES.put("arash", new ResourceLocation(LostInfinity.MODID, "textures/entity/arash.png"));
        TEXTURES.put("alestria", new ResourceLocation(LostInfinity.MODID, "textures/entity/alestria.png"));
        TEXTURES.put("atlasspire", new ResourceLocation(LostInfinity.MODID, "textures/entity/atlasspire.png"));
        TEXTURES.put("darrio", new ResourceLocation(LostInfinity.MODID, "textures/entity/darrio.png"));
        TEXTURES.put("barul", new ResourceLocation(LostInfinity.MODID, "textures/entity/barul.png"));
        TEXTURES.put("sentrycrystal", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/sentry.png"));
        TEXTURES.put("deviantllama", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantllama.png"));
        TEXTURES.put("deviantmagmacube", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantmagmacube.png"));
        TEXTURES.put("deviantvex", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantvex.png"));
        TEXTURES.put("deviantstray", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantstray.png"));
        TEXTURES.put("deviantpiglin", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantpiglin.png"));
        TEXTURES.put("gloop", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/gloop.png"));
        TEXTURES.put("gloopmother", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/gloopmother.png"));
        TEXTURES.put("cyclos", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/cyclos.png"));
        TEXTURES.put("clinger", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/clinger.png"));
        TEXTURES.put("deviantdimtrader", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantdimtrader.png"));
        TEXTURES.put("skybooster", new ResourceLocation(LostInfinity.MODID, "textures/entity/skybooster.png"));
        TEXTURES.put("spectre", new ResourceLocation(LostInfinity.MODID, "textures/entity/spectre.png"));
        TEXTURES.put("plasmaexplosion", new ResourceLocation(LostInfinity.MODID, "textures/entity/plasma_explosion.png"));
        TEXTURES.put("azross", new ResourceLocation(LostInfinity.MODID, "textures/entity/azross.png"));
        TEXTURES.put("duskerqueen", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/duskerqueen.png"));
        TEXTURES.put("deviant_wither", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant_wither.png"));
        TEXTURES.put("wither_skullling", new ResourceLocation(LostInfinity.MODID, "textures/entity/wither_skullling.png"));
        TEXTURES.put("glangler", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/glangler.png"));
        TEXTURES.put("glochipper", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/glochipper.png"));
        TEXTURES.put("globoon", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/globoon.png"));
        TEXTURES.put("essencedweller", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/essencedweller.png"));
        TEXTURES.put("essenceidol", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/essenceidol.png"));
        TEXTURES.put("globro", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/globro.png"));
        TEXTURES.put("augmenticon", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/augmenticon.png"));
        TEXTURES.put("galaxygulper", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/galaxygulper.png"));
        TEXTURES.put("laserspire", new ResourceLocation(LostInfinity.MODID, "textures/entity/laser_spire.png"));
        TEXTURES.put("giantflapper", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/giantflapper.png"));
        TEXTURES.put("deviantgolem", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantgolem.png"));
        TEXTURES.put("stickybomb", new ResourceLocation(LostInfinity.MODID, "textures/entity/sticky_bomb.png"));
        TEXTURES.put("vectosect", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/vectosect.png"));
        TEXTURES.put("stickler", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/stickler.png"));
        TEXTURES.put("unstablemerchant", new ResourceLocation(LostInfinity.MODID, "textures/entity/unstablemerchant.png"));
        TEXTURES.put("feralmerchant", new ResourceLocation(LostInfinity.MODID, "textures/entity/feralmerchant.png"));
        TEXTURES.put("deviantcavespider", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantcavespider.png"));
        TEXTURES.put("tornindividual", new ResourceLocation(LostInfinity.MODID, "textures/entity/tornindividual.png"));
        TEXTURES.put("ravager", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/ravager.png"));
        TEXTURES.put("vycellia", new ResourceLocation(LostInfinity.MODID, "textures/entity/vycellia.png"));
        TEXTURES.put("puzzlemaster", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/puzzle_master.png"));
        TEXTURES.put("nightshyre", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/nightshyre.png"));
        TEXTURES.put("giantfyreweed", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/giantfyreweed.png"));
        TEXTURES.put("skycrab", new ResourceLocation(LostInfinity.MODID, "textures/entity/skycrab.png"));
        TEXTURES.put("glomite", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/glomite.png"));
        TEXTURES.put("tntzombie", new ResourceLocation(LostInfinity.MODID, "textures/entity/tnt_zombie.png"));
        TEXTURES.put("deviantbat", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantbat.png"));
        TEXTURES.put("rockslug", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/rockslug.png"));
        TEXTURES.put("giant_rockslug", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/giant_rockslug.png"));
        TEXTURES.put("flutterbee", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/flutterbee.png"));
        TEXTURES.put("ozor", new ResourceLocation(LostInfinity.MODID, "textures/entity/ozor.png"));
        TEXTURES.put("ozordecoy", new ResourceLocation(LostInfinity.MODID, "textures/entity/ozor.png"));
        TEXTURES.put("totemmoon", new ResourceLocation(LostInfinity.MODID, "textures/entity/totem/totem_moon.png"));
        TEXTURES.put("totempylon", new ResourceLocation(LostInfinity.MODID, "textures/entity/totem/totem_pylon.png"));
        TEXTURES.put("thundyron", new ResourceLocation(LostInfinity.MODID, "textures/entity/thundyron.png"));
        TEXTURES.put("cryonus", new ResourceLocation(LostInfinity.MODID, "textures/entity/cryonus.png"));
        TEXTURES.put("thunderbomb", new ResourceLocation(LostInfinity.MODID, "textures/entity/thunder_bomb.png"));
        TEXTURES.put("stormbomb", new ResourceLocation(LostInfinity.MODID, "textures/entity/storm_bomb.png"));
        TEXTURES.put("zenon", new ResourceLocation(LostInfinity.MODID, "textures/entity/zenon.png"));
        TEXTURES.put("crusher", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/crusher.png"));
        TEXTURES.put("drippler", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/drippler.png"));
        TEXTURES.put("gorger", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/gorger.png"));
        TEXTURES.put("doublejaw", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/doublejaw.png"));
        TEXTURES.put("minimite", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/minimite.png"));
        TEXTURES.put("clusterweed", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/clusterweed.png"));
        TEXTURES.put("wisp", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/wisp.png"));
        TEXTURES.put("tetherbug", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/tetherbug.png"));
        TEXTURES.put("vilebulb", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/vilebulb.png"));
        TEXTURES.put("sightwalker", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/sightwalker.png"));
        TEXTURES.put("weaver", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/weaver.png"));
        TEXTURES.put("doomdog", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/doomdog.png"));
        TEXTURES.put("blisterweed", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/blisterweed.png"));
        TEXTURES.put("grubber", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/grubber.png"));
        TEXTURES.put("titanopod", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/titanopod.png"));
        TEXTURES.put("snapper", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/snapper.png"));
        TEXTURES.put("flashfly", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/flashfly.png"));
        TEXTURES.put("deviantwitherskeleton", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantwitherskeleton.png"));
        TEXTURES.put("terrorfly", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/terrorfly.png"));
        TEXTURES.put("tentaclon", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/tentaclon.png"));
        TEXTURES.put("galacticterror", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/galacticterror.png"));
        TEXTURES.put("deviantguardian", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantguardian.png"));
        TEXTURES.put("pickleman", new ResourceLocation(LostInfinity.MODID, "textures/entity/pickleman.png"));
        TEXTURES.put("mortarcannon", new ResourceLocation(LostInfinity.MODID, "textures/entity/mortar_cannon.png"));
        TEXTURES.put("clustercannon", new ResourceLocation(LostInfinity.MODID, "textures/entity/cluster_cannon.png"));
        TEXTURES.put("deviantocelote", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantocelote.png"));
        TEXTURES.put("livorax", new ResourceLocation(LostInfinity.MODID, "textures/entity/livorax.png"));
        TEXTURES.put("lurcher", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/lurcher.png"));
        TEXTURES.put("nat", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/nat.png"));
        TEXTURES.put("sentry", new ResourceLocation(LostInfinity.MODID, "textures/entity/labyrinth/sentry.png"));
        TEXTURES.put("caveterror", new ResourceLocation(LostInfinity.MODID, "textures/entity/murk/caveterror.png"));
        TEXTURES.put("whisper", new ResourceLocation(LostInfinity.MODID, "textures/entity/murk/whisper.png"));
        TEXTURES.put("torpedon", new ResourceLocation(LostInfinity.MODID, "textures/entity/murk/torpedon.png"));
        TEXTURES.put("rift", new ResourceLocation(LostInfinity.MODID, "textures/entity/rift/rift1.png"));
        TEXTURES.put("orbiter", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/orbiter.png"));
        TEXTURES.put("totemsplitter", new ResourceLocation(LostInfinity.MODID, "textures/entity/totem/totem_splitter.png"));
        TEXTURES.put("tentacletrap", new ResourceLocation(LostInfinity.MODID, "textures/entity/tentacle_trap.png"));
        TEXTURES.put("scorpwing", new ResourceLocation(LostInfinity.MODID, "textures/entity/murk/scorpwing.png"));
        TEXTURES.put("doomsday", new ResourceLocation(LostInfinity.MODID, "textures/entity/murk/doomsday.png"));
        TEXTURES.put("skyre", new ResourceLocation(LostInfinity.MODID, "textures/entity/murk/skyre.png"));
        TEXTURES.put("rockworm", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/rockworm.png"));
        TEXTURES.put("kalikos", new ResourceLocation(LostInfinity.MODID, "textures/entity/kalikos.png"));
        TEXTURES.put("leer", new ResourceLocation(LostInfinity.MODID, "textures/entity/starforge/leer.png"));
        TEXTURES.put("doublerang", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/doublerang1.png"));
        TEXTURES.put("longfin", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/longfin1.png"));
        TEXTURES.put("octobrella", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/octobrella1.png"));
        TEXTURES.put("rayfish", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/rayfish1.png"));
        TEXTURES.put("glowfish", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/glowfish1.png"));
        TEXTURES.put("deviantsquid", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantsquid.png"));
        TEXTURES.put("underfin", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/underfin1.png"));
        TEXTURES.put("eelshark", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/eelshark1.png"));
        TEXTURES.put("crabulon", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/crabulon1.png"));
        TEXTURES.put("ribshark", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/ribshark1.png"));
        TEXTURES.put("screamer", new ResourceLocation(LostInfinity.MODID, "textures/entity/murk/screamer.png"));
        TEXTURES.put("nebula_grunt", new ResourceLocation(LostInfinity.MODID, "textures/entity/nebula_grunt.png"));
        TEXTURES.put("nebula_wizard", new ResourceLocation(LostInfinity.MODID, "textures/entity/nebula_wizard.png"));
        TEXTURES.put("nebula_giant", new ResourceLocation(LostInfinity.MODID, "textures/entity/nebula_giant.png"));
        TEXTURES.put("archeologist", new ResourceLocation(LostInfinity.MODID, "textures/entity/archeologist.png"));
        TEXTURES.put("risingphantom", new ResourceLocation(LostInfinity.MODID, "textures/entity/rising_phantom.png"));
        TEXTURES.put("tentaclelantern", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/tentacle.png"));
        TEXTURES.put("leviathan", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/leviathan.png"));
        TEXTURES.put("sea_serpent", new ResourceLocation(LostInfinity.MODID, "textures/entity/sea/sea_serpent.png"));
        TEXTURES.put("galaxy_dragon", new ResourceLocation(LostInfinity.MODID, "textures/entity/galaxy_dragon.png"));
        TEXTURES.put("x_screacher", new ResourceLocation(LostInfinity.MODID, "textures/entity/xscreacher.png"));
        TEXTURES.put("lost_blade", new ResourceLocation(LostInfinity.MODID, "textures/entity/lost_blade.png"));
        TEXTURES.put("mushmerra", new ResourceLocation(LostInfinity.MODID, "textures/entity/fungal/mushmerra.png"));
        TEXTURES.put("mushmerra_clone", new ResourceLocation(LostInfinity.MODID, "textures/entity/fungal/mushmerra.png"));
        TEXTURES.put("shroomite", new ResourceLocation(LostInfinity.MODID, "textures/entity/fungal/shroomite.png"));
        TEXTURES.put("supply_trader", new ResourceLocation(LostInfinity.MODID, "textures/entity/supply_trader.png"));
        TEXTURES.put("deviant_wolf", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/deviantwolf.png"));
        TEXTURES.put("deviant_husk", new ResourceLocation(LostInfinity.MODID, "textures/entity/deviant/devianthusk.png"));
        TEXTURES.put("bomb_drone", new ResourceLocation(LostInfinity.MODID, "textures/entity/bomb_drone.png"));
        TEXTURES.put("cthulhu", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_turret", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_cloud", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_tentacle", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_tentacle_persist", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_beam", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("andromeda", new ResourceLocation(LostInfinity.MODID, "textures/entity/andromeda.png"));
        TEXTURES.put("cthulhu_black_hole", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_rift", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_healing_orb", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
        TEXTURES.put("cthulhu_death_fx", new ResourceLocation(LostInfinity.MODID, "textures/entity/cthulhu/cthulhu.png"));
    }

    private LostEntityTextures() {
    }

    public static ResourceLocation textureFor(Entity entity) {
        ResourceLocation key = entity.getType().builtInRegistryHolder().key().location();
        String id = key.getPath();
        ResourceLocation explicit = TEXTURES.get(id);
        if (explicit != null) {
            return explicit;
        }
        return RESOLVED.computeIfAbsent(id, LostEntityTextures::resolveTexture);
    }

    private static ResourceLocation resolveTexture(String id) {
        for (String candidate : candidates(id)) {
            ResourceLocation texture = new ResourceLocation(LostInfinity.MODID, "textures/entity/" + candidate + ".png");
            if (hasTexture(texture)) {
                return texture;
            }
        }
        return FALLBACK;
    }

    private static String[] candidates(String id) {
        String compact = id.replace("_", "");
        String dashless = id.replace("-", "");
        String projectile = projectileTextureName(id);
        return new String[] {
                id,
                compact,
                dashless,
                "deviant/" + id,
                "deviant/" + compact,
                "titan/" + id,
                "titan/" + compact,
                "starforge/" + id,
                "starforge/" + compact,
                "labyrinth/" + id,
                "labyrinth/" + compact,
                "murk/" + id,
                "murk/" + compact,
                "sea/" + id,
                "sea/" + compact,
                "fungal/" + id,
                "fungal/" + compact,
                "totem/" + id,
                "totem/" + compact,
                "rift/" + id,
                "rift/" + compact,
                projectile,
                compact + "1",
                compact + "_1",
                id + "1",
                id + "_1"
        };
    }

    private static String projectileTextureName(String id) {
        if (id.endsWith("mk2")) {
            return id.substring(0, id.length() - 3) + "_mk2";
        }
        if (id.contains("beam") || id.contains("laser")) {
            return "laser_beam";
        }
        if (id.contains("bomb")) {
            return "sticky_bomb";
        }
        if (id.contains("trident")) {
            return id.contains("mk2") ? "infinity_trident_mk2" : "infinity_trident";
        }
        return id;
    }

    private static boolean hasTexture(ResourceLocation texture) {
        return Minecraft.getInstance().getResourceManager().getResource(texture).isPresent();
    }
}
