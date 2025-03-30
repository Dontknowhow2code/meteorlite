/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.utils.network;

import net.minecraft.network.packet.BundlePacket;
import net.minecraft.network.packet.BundleSplitterPacket;
import net.minecraft.network.packet.Packet;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class PacketUtilsUtil {
    private PacketUtilsUtil() {
    }

    public static void main(String[] args) {
        try {
            init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void init() throws IOException {
        // Generate PacketUtils.java
        File file = new File("src/main/java/%s/PacketUtils.java".formatted(PacketUtilsUtil.class.getPackageName().replace('.', '/')));
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("/*\n");
            writer.write(" * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).\n");
            writer.write(" * Copyright (c) Meteor Development.\n");
            writer.write(" */\n\n");

            writer.write("package meteordevelopment.meteorclient.utils.network;\n\n");

            //   Write imports
            writer.write("import com.google.common.collect.Sets;\n");
            writer.write("import it.unimi.dsi.fastutil.objects.Object2ReferenceOpenHashMap;\n");
            writer.write("import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;\n");
            writer.write("import net.minecraft.network.packet.Packet;\n\n");

            writer.write("import java.util.Map;\n");
            writer.write("import java.util.Set;\n");

            //   Write class
            writer.write("\npublic class PacketUtils {\n");

            //     Write fields
            writer.write("    private static final Map<Class<? extends Packet<?>>, String> S2C_PACKETS = new Reference2ObjectOpenHashMap<>();\n");
            writer.write("    private static final Map<Class<? extends Packet<?>>, String> C2S_PACKETS = new Reference2ObjectOpenHashMap<>();\n\n");
            writer.write("    private static final Map<String, Class<? extends Packet<?>>> S2C_PACKETS_R = new Object2ReferenceOpenHashMap<>();\n");
            writer.write("    private static final Map<String, Class<? extends Packet<?>>> C2S_PACKETS_R = new Object2ReferenceOpenHashMap<>();\n\n");
            writer.write("    public static final Set<Class<? extends Packet<?>>> PACKETS = Sets.union(getC2SPackets(), getS2CPackets());\n\n");

            //     Write static block
            writer.write("    static {\n");

            Comparator<Class<?>> packetsComparator = Comparator
                .comparing((Class<?> cls) -> cls.getName().substring(cls.getName().lastIndexOf('.') + 1))
                .thenComparing(Class::getName);

            // Client -> Sever Packets
            Reflections c2s = new Reflections("net.minecraft.network.packet.c2s", Scanners.SubTypes);
            Set<Class<? extends Packet>> c2sPackets = c2s.getSubTypesOf(Packet.class);
            SortedSet<Class<? extends Packet>> sortedC2SPackets = new TreeSet<>(packetsComparator);
            sortedC2SPackets.addAll(c2sPackets);

            for (Class<? extends Packet> c2sPacket : sortedC2SPackets) {
                String name = c2sPacket.getName();
                String className = name.substring(name.lastIndexOf('.') + 1).replace('$', '.');
                String fullName = name.replace('$', '.');

                writer.write("        C2S_PACKETS.put(%s.class, \"%s\");%n".formatted(fullName, className));
                writer.write("        C2S_PACKETS_R.put(\"%s\", %s.class);%n".formatted(className, fullName));
            }

            writer.newLine();

            // Server -> Client Packets
            Reflections s2c = new Reflections("net.minecraft.network.packet.s2c", Scanners.SubTypes);
            Set<Class<? extends Packet>> s2cPackets = s2c.getSubTypesOf(Packet.class);
            SortedSet<Class<? extends Packet>> sortedS2CPackets = new TreeSet<>(packetsComparator);
            sortedS2CPackets.addAll(s2cPackets);

            for (Class<? extends Packet> s2cPacket : sortedS2CPackets) {
                if (s2cPacket == BundlePacket.class || s2cPacket == BundleSplitterPacket.class) continue;
                String name = s2cPacket.getName();
                String className = name.substring(name.lastIndexOf('.') + 1).replace('$', '.');
                String fullName = name.replace('$', '.');

                writer.write("        S2C_PACKETS.put(%s.class, \"%s\");%n".formatted(fullName, className));
                writer.write("        S2C_PACKETS_R.put(\"%s\", %s.class);%n".formatted(className, fullName));
            }

            writer.write("    }\n\n");

            writer.write("    private PacketUtils() {\n");
            writer.write("    }\n\n");

            //     Write getName method
            writer.write("    public static String getName(Class<? extends Packet<?>> packetClass) {\n");
            writer.write("        String name = S2C_PACKETS.get(packetClass);\n");
            writer.write("        if (name != null) return name;\n");
            writer.write("        return C2S_PACKETS.get(packetClass);\n");
            writer.write("    }\n\n");

            //     Write getPacket method
            writer.write("    public static Class<? extends Packet<?>> getPacket(String name) {\n");
            writer.write("        Class<? extends Packet<?>> packet = S2C_PACKETS_R.get(name);\n");
            writer.write("        if (packet != null) return packet;\n");
            writer.write("        return C2S_PACKETS_R.get(name);\n");
            writer.write("    }\n\n");

            //     Write getS2CPackets method
            writer.write("    public static Set<Class<? extends Packet<?>>> getS2CPackets() {\n");
            writer.write("        return S2C_PACKETS.keySet();\n");
            writer.write("    }\n\n");

            //     Write getC2SPackets method
            writer.write("    public static Set<Class<? extends Packet<?>>> getC2SPackets() {\n");
            writer.write("        return C2S_PACKETS.keySet();\n");
            writer.write("    }\n");

            //   Write end class
            writer.write("}\n");
        }
    }
}
