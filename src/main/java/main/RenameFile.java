package main;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import util.ByteUtil;
import vo.FormInstance;


public class RenameFile {
	public static void main(String[] args) {
		//sample ������ �� START
		ArrayList<String[]> sameple = new ArrayList<String[]>();
		String[] s1 = {"no1","id1","flag1","cnt1"};
		sameple.add(s1);
		String[] s2 = {"no2","id2","flag2","cnt2"};
		sameple.add(s2);
		String[] s3 = {"no3","id3","flag3","cnt3"};
		sameple.add(s3);
		
		ArrayList<String[]> sameple2 = new ArrayList<String[]>();
		String[] t1 = {"1535","id1","SME1801","cnt1","200"};
		sameple2.add(t1);
		String[] t2 = {"1535","id2","SME1801","cnt1","200"};
		sameple2.add(t1);
		String[] t3 = {"1535","id3","SME1801","cnt1","200"};
		sameple2.add(t3);
		
		
		OutputStream out =  null;
		try{
		FormInstance form = (FormInstance)Class.forName("vo.SmeBillForm").newInstance();
		int[] info = form.getInfo();
		int[] size = form.getSize();
		String[] func = form.getFunc();

		out = new BufferedOutputStream(new FileOutputStream("c:/File/test.txt"));
		for(int x=0;x<sameple2.size();x++){ //
			String[] target = sameple2.get(x);			
			int start = 0;
			byte []writeBuffer = new byte[info[0]];		
			ByteUtil.bytememset(writeBuffer,(byte)info[1],info[0]);
			
			for(int i=0;i<size.length;i++){
				if(func[i].equals("bytecpy")) ByteUtil.bytecpy(writeBuffer,start,target[i].getBytes("KSC5601"),size[i]);
				else ByteUtil.bytecpyrear(writeBuffer,start,target[i].getBytes("KSC5601"),size[i]);
				start = start+size[i];
			}	
			
			ByteUtil.bytecpy(writeBuffer,start,("\n").getBytes("KSC5601"),1);
			out.write(writeBuffer);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		} finally{
		
			try {
				if(out!=null){
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
		
    }
}


///x9Gx2yDF1726xq4=
///7ZWc6riAIO2FjOyKpO2KuA==
//77+90bHvv70g77+9173vv73Grg==