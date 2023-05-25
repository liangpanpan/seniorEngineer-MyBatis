import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2022/12/14       create this file
 * </pre>
 */
public class IpAddress {

    public static void main(String[] args) {
        InetAddress addr;
        try {
            addr = InetAddress.getLocalHost();
            // 获取本机计算机名称
            String hostAddress = addr.getHostAddress();
            System.out.println("hostAddress:" + hostAddress);

            System.out.println("hostName:" + addr.getHostName());

            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();

            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                if (null != networkInterface.getHardwareAddress()) {

                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();
                        if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress() && !inetAddress.getHostAddress().contains(":")) {
                            System.out.println("IP:" + inetAddress.getHostAddress());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
