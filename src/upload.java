import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.ssh.Scp;

/** @see https://stackoverflow.com/questions/2914733 */
public class upload {

    public static void main(String[] args) {
    	org.apache.tools.ant.taskdefs.optional.ssh.Scp scp = new Scp();
    	int portSSH = 80;
    	String srvrSSH = "47.37.224.79";
    	String userSSH = "pi"; 
    	String pswdSSH = "project19";
    	String localFile = "C:/Users/Tavis' Laptop/Desktop/john.txt";
    	String remoteDir = "/home/pi/Desktop/fold";

    	scp.setPort( portSSH );
    	scp.setLocalFile( localFile );
    	scp.setTodir( userSSH + ":" + pswdSSH + "@" + srvrSSH + ":" + remoteDir );
    	scp.setProject( new Project() );
    	scp.setTrust( true );
    	scp.execute();
    }
}
   