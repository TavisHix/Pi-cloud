import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.ssh.Scp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;  

public class piTran {
	//
	//Enter port number your pi is using
	//
	static int portSSH = 80;
	
	//
	//Enter the IP
	//
	static String srvrSSH = "";
	
	//
	//Enter the username for the pi's SSH
	//
	static String userSSH = ""; 
	
	//
	//Enter the password for the pi's SSH
	//
	static String pswdSSH = "";
	
	 	public void TransferU(String local, String remote) {
	    	org.apache.tools.ant.taskdefs.optional.ssh.Scp scp = new Scp();
	    	String localFile = local;
	    	String remoteDir = remote;

	    	scp.setPort( portSSH );
	    	scp.setLocalFile( localFile );
	    	scp.setTodir( userSSH + ":" + pswdSSH + "@" + srvrSSH + ":" + remoteDir );
	    	scp.setProject( new Project() );
	    	scp.setTrust( true );
	    	scp.execute();
	    }
	 
	 	public static void TransferD(String local, String remote) {
	 		org.apache.tools.ant.taskdefs.optional.ssh.Scp scp = new Scp();
	    	String localDir = local;
	    	String remoteFile = remote;

	    	scp.setPort( portSSH );
	    	scp.setRemoteFile(userSSH + ":" + pswdSSH + "@" + srvrSSH + ":" + remoteFile);
	    	scp.setTodir( localDir );
	    	scp.setProject( new Project() );
	    	scp.setTrust( true );
	    	scp.execute();
	    }
	 	
	 	public void createFolder(String uName){
		    
		    //
	 		//Directory where the users flder is created
	 		//Note: My location /home/pi/Desktop/fold
	 		//
		    String dir = "";

		    Session session = null;
		    Channel channel = null;
		    ChannelSftp channelSftp = null;

		    try{
		            JSch jsch = new JSch();
		            session = jsch.getSession(userSSH,srvrSSH,portSSH);
		            session.setPassword(pswdSSH);
		            java.util.Properties config = new java.util.Properties();
		            config.put("StrictHostKeyChecking", "no");
		            session.setConfig(config);
		            session.connect();
		            channel = session.openChannel("sftp");
		            channel.connect();
		            channelSftp = (ChannelSftp)channel;
		            channelSftp.cd(dir);
		            channelSftp.mkdir(uName);
		        }catch(Exception ex){
		            ex.printStackTrace();
		        } finally {
		            if(session != null) session.disconnect();
		            if(channel != null) channel.disconnect();
		        }
	 	}
	 	
	 	public static String[]  printlist(String user){	 		
	 		    
	 		
	 		 //
	 		 //Directory where the users flder is created
	 		 //Note: My location /home/pi/Desktop/fold
	 		 //
	 		
	 		    String dir = "";
	 		    dir.concat(user);
	 		    dir = user;
	 		    Session session = null;
	 	 	    Channel channel = null;
	 		    ChannelSftp channelSftp = null;

	 		    try{
	 		            JSch jsch = new JSch();
	 		            session = jsch.getSession(userSSH,srvrSSH,portSSH);
	 		            session.setPassword(pswdSSH);
	 		            java.util.Properties config = new java.util.Properties();
	 		            config.put("StrictHostKeyChecking", "no");
	 		            session.setConfig(config);
	 		            session.connect();
	 		            channel = session.openChannel("sftp");
	 		            channel.connect();
	 		            channelSftp = (ChannelSftp)channel;
	 		            channelSftp.cd(dir);
	 		            Vector filelist = channelSftp.ls(dir);
	 		            String[] arr = new String[filelist.size()];
	 		            
	 		            for(int i=0; i<filelist.size();i++){
	 	                    LsEntry entry = (LsEntry) filelist.get(i);
	 	                    if(!entry.getFilename().startsWith("."))
	 	                    {
	 	                    	arr[i] = entry.getFilename();
	 	                        //System.out.println(entry.getFilename());
	 	                    }
	 	                }
	 		            return arr;
	 		        }catch(Exception ex){
	 		            ex.printStackTrace();
	 		        } finally {
	 		            if(session != null) session.disconnect();
	 		            if(channel != null) channel.disconnect();
	 		        }
	 		    return null;
	 	}
	 	
	 	public static void main(String[] args){
	 		TransferD("C:/Users/Tavis' Laptop/Desktop", "/home/pi/Desktop/test.txt");
	 	}
	 	
}
