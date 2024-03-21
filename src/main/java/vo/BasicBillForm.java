package vo;

public class BasicBillForm implements FormInstance{
	private static int[] info = {46,0x0A};
	private static int[] size = {12,20,3,10};
	private static String[] func = {"bytecpy","bytecpy","bytecpyrear","bytecpyrear"}; 
	
	public int[] getInfo(){
		return info;
	}
	public int[] getSize(){
		return size;
	}
	public String[] getFunc(){
		return func;
		
	}
}
