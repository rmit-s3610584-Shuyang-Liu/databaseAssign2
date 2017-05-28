
public class Util {

    
    public static byte[] intToBytes(int value )
    {
        byte[] src = new byte[4];
        src[3] =  (byte) ((value>>24) & 0xFF);
        src[2] =  (byte) ((value>>16) & 0xFF);
        src[1] =  (byte) ((value>>8) & 0xFF);
        src[0] =  (byte) (value & 0xFF);
        return src;
    }

   
    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset+1] & 0xFF)<<8)
                | ((src[offset+2] & 0xFF)<<16)
                | ((src[offset+3] & 0xFF)<<24));
        return value;
    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;
    }

    public static byte[] charArrayToByte(char[] arr) {
        byte[] bytes = new byte[2 * arr.length];
        for (int i = 0; i < arr.length; i++) {
            bytes[2*i] = (byte) ((arr[i] & 0xFF00) >> 8);
            bytes[2*i+1] = (byte) (arr[i] & 0xFF);
        }
        return bytes;
    }

    public static char[] byteToCharArray(byte[] bytes, int start, int stop) {
        char[] arr = new char[(stop - start)/ 2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (((bytes[start+2*i] & 0xFF) << 8) | (bytes[start+2*i+1] & 0xFF));
        }
        return arr;
    }
}
