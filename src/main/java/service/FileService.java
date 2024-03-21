package service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

import vo.MemberVo;

public class FileService {
	
	private Logger logger = LogManager.getLogger(FileService.class);
	
	public void makeFile(List<MemberVo> fileData) { 
		
		OutputStream out =  null;
		
		try {
		//파일생성 스트림
		out = new BufferedOutputStream(new FileOutputStream("c:/File/test.txt"));
		for(int x=0;x<fileData.size();x++){ //
			
			String writeBuffer = 
					"." + fileData.get(x).getSTUDENT_ID() + "  " +
					"." + fileData.get(x).getGRADE() + "  " +
					"." + fileData.get(x).getNAME() + "  " +
					"." + fileData.get(x).getAGE() + "  "
					+"\n";
			System.out.println(writeBuffer);
			out.write(writeBuffer.getBytes());
		}
		logger.info("파일작성 성공");
		
		}catch(Exception e){
			e.printStackTrace();
			logger.info(e.getMessage() + "  ");
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
	
	public void sftpsend() {
		String host = "localhost"; // 
        String username = "user";
        String password = "pwd";
        int port = 22; // SFTP

        String localFilePath = "c:/File/test.txt";
        String remoteDirectory = "c:/sftp";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, host, port);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect();

            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            channelSftp.put(localFilePath, remoteDirectory);

            channelSftp.disconnect();
            session.disconnect();

            System.out.println("success");
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
            System.err.println("fail");
        }
    }
	

}
