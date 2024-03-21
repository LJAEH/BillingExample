package util;

public class ByteUtil {
	
	static public byte []byteSiSoRemover (byte[] fb){
		byte []tb = new byte[fb.length];
		for(int i = 0,j = 0 ; i < fb.length; i++){
			if(fb[i] == (byte)0x0e || fb[i] == (byte)0x0f)
				continue;
			else
				tb[j++] = fb[i];
		}
		return tb;
	}
	
	static public byte []bytecpy (byte[] to, byte[] from,int offset){
		int size = from.length;
		for(int i = 0 ; i < size; i++){
			to[i+offset] = from[i];
		}
		return to;
	}

	
	static public byte []bytecpy (byte[] fb, int f ,int d){
		byte []tb = new byte[d];
		for(int i = 0 ; i < d; i++){
			tb[i] = fb[f + i];
		}
		return tb;
	}
	
	static public byte []bytecpy (byte[] tb, int s, byte[] fb ,int d){
		int i;
		for(i = 0 ; (i < d && i < fb.length); i++){
			tb[s + i] = fb[i];
		}
		if(fb.length < d){
			for(; i < d; i++){
				tb[s + i] = (byte)0x20;
			}
		}
		return tb;
	}
	
	static public byte []bytecpy (byte[] tb, int s, byte fb){
		tb[s] = fb;
		return tb;
	}
	
	static public byte []bytecpyrear (byte[] tb, int s, byte[] fb ,int d){
		int i = 0,j = 0;
		for(i = 0; i < (d - fb.length); i++){
			tb[s + i] = (byte)0x20;
		}
		for(j = 0 ; j < fb.length; j++){
			tb[s + (i++)] = fb[j];
		}

		return tb;
	}
	
	
	static public byte []bytememset (byte[] tb, byte c,int d){
		for(int i = 0 ; i < d; i++){
			tb[i] = c; 
		}
		return tb;
	}

	public static String subString(byte[] b1, int startIndex, int length)
	{
		byte[] b2 = new byte[length];
		String ret = null;
		try
		{
			if (length > (b1.length - startIndex)){
				length = b1.length - startIndex;
			}
			System.arraycopy(b1, startIndex, b2, 0, length);
			ret = new String(b2,"KSC5601");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return ret;
	}
}
