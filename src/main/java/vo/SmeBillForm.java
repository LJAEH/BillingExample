package vo;

public class SmeBillForm implements FormInstance{
	private static int[] info = {44,0x0A};
	private static int[] size = {4,12,6,10,10};
	private static String[] func = {"bytecpy","bytecpy","bytecpy","bytecpyrear","bytecpyrear"}; 
	
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