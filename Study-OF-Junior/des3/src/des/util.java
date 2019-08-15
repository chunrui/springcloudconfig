package des;

import java.util.HashMap;

/**
 * Created by leif on 2019/5/3.
 */
public class util {
    /**
     *  ������תʮ����
     * @param two ������ string
     * @return ʮ���� int
     */
    public static int two2ten(String two){
        String s = two;
        int x = 0;
        int pow = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            x += Math.pow(2, pow) * (s.charAt(i) == '1' ? 1 : 0);
            pow ++;
        }
        return x;
    }


    /**
     *  ������תʮ������
     * @param two ������ string
     * @return ʮ������ int
     */
    public static String two2hex(String bString){
        if (bString == null || bString.equals("") || bString.length() % 8 != 0)  
            return null;  
        StringBuffer tmp = new StringBuffer();  
        int iTmp = 0;  
        for (int i = 0; i < bString.length(); i += 4)  
        {  
            iTmp = 0;  
            for (int j = 0; j < 4; j++)  
            {  
                iTmp += Integer.parseInt(bString.substring(i + j, i + j + 1)) << (4 - j - 1);  
            }  
            tmp.append(Integer.toHexString(iTmp));  
        }  
        return tmp.toString();  
    }  


    /**
     *  ��64λint����ת��Ϊ64λchar����
     * @param mm int[64]
     * @return char[64]
     */
    public static char[] int64tochar64(int[] mm){
        @SuppressWarnings("unused")
        char[] g = new char[64];
        String gg = new String();
        for (int i = 0; i < 64; i++){
            gg += mm[i];
        }
        return gg.toCharArray();
    }

    public static HashMap<Integer,char[]> preMI(String mmmmmm){
        String lmmmmmm = "";
        for(int i = 0; i < mmmmmm.length(); i++){
            lmmmmmm += Integer.toBinaryString(Integer.parseInt(mmmmmm.substring(i,i+1)));
        }
        HashMap<Integer, char[] > tmmm = new HashMap<>();
        char mmmmm[] = lmmmmmm.toCharArray();
        char rm[] = new char[64];
        int j = 0;
        for(int i = 0; i < lmmmmmm.length(); i++){
            rm[i%64] = mmmmm[i];
            if (i % 64 == 63) {
                tmmm.put(j, rm);
                j++;
            }
        }
        return tmmm;
    }


    /**
     * ���ĳ�ʼ����������ÿһλתΪһ��64bit���ȵ�string
     * @param all
     * @return
     */
    public static String[] all2string(String all)  {
        byte byteall[] = all.getBytes();
        String allstring[] = new String[all.length()];
        for(int i = 0; i < byteall.length; i++){
            allstring[i] =   String.format("%064d", Integer.parseInt(Integer.toBinaryString(byteall[i])));
        }
        return allstring;
    }

    /**
     * ���Ľ���Ԥ������������ÿ64bit��ȡ��һ��string
     * @param all
     * @return
     */
    public static String[] all222string(String all)  {
        String[] allstring = new String[all.length()/64];
        for(int i = 0; i < allstring.length; i++){
            allstring[i] =   all.substring(i*64,(i+1)*64);
        }
        return allstring;
    }

    /**
     * �����ܽ����byteתΪstring����ԭ����
     * @param all
     * @return
     */
    public static String byte2string(String all)  {
        byte[] allstring = new byte[all.length()/64];
        for(int i = 0; i < allstring.length; i++){
            allstring[i] =   (byte) two2ten(all.substring(i*64,(i+1)*64).substring(56, 64));
        }
        return new String(allstring);
    }

    /**
     * �������ʽ����Կ��ȡhashֵ����ʽ��Ϊchar[64]
     * @param k
     * @return
     */
    public static char[] keypre(String k) {
        String ha = String.format("%08d", k.hashCode());
        String kk = "";
        for(int i = 0; i < 8; i++){
            kk += String.format("%08d", Integer.parseInt(Integer.toBinaryString(Integer.parseInt(ha.substring(i, i+1)))));
        }
        return kk.toCharArray();
    }
}